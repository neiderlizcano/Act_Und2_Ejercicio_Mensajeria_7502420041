import java.util.Scanner;

public class SistemaPaqueteEnvio {

    private static final Scanner scanner = new Scanner(System.in);

    private static final Lista listaGeneral = new Lista();
    private static final Cola colaPendientes = new Cola();
    private static final Pila historialProcesados = new Pila();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    registrarPaquete();
                    break;
                case 2:
                    verTodosLosPaquetes();
                    break;
                case 3:
                    verPaquetesPendientes();
                    break;
                case 4:
                    procesarSiguientePaquete();
                    break;
                case 5:
                    verHistorialProcesados();
                    break;
                case 6:
                    buscarPaquetePorGuia();
                    break;
                case 7:
                    cancelarPaquetePendiente();
                    break;
                case 8:
                    deshacerUltimoProcesamiento();
                    break;
                case 9:
                    verCantidadElementos();
                    break;
                case 10:
                    System.out.println("Saliendo del sistema de mensajeria...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }

            System.out.println();

        } while (opcion != 10);
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("Sistema de gestion de paquetes de mensajeria");
        System.out.println();
        System.out.println("1. Registrar paquete");
        System.out.println("2. Ver todos los paquetes registrados");
        System.out.println("3. Ver paquetes pendientes");
        System.out.println("4. Procesar siguiente paquete");
        System.out.println("5. Ver historial de paquetes procesados");
        System.out.println("6. Buscar paquete por numero de guia");
        System.out.println("7. Cancelar paquete pendiente");
        System.out.println("8. Deshacer ultimo procesamiento");
        System.out.println("9. Ver cantidad de paquetes");
        System.out.println("10. Salir");
        System.out.println();
    }

    private static void registrarPaquete() {
        System.out.println("Registrar paquete");

        String numeroGuia = leerTextoObligatorio("Numero de guia: ");

        PaqueteEnvio paqueteBuscado = new PaqueteEnvio(
                numeroGuia, "", "", "", "", ""
        );

        if (listaGeneral.contiene(paqueteBuscado)) {
            System.out.println("Ya existe un paquete registrado con ese numero de guia.");
            return;
        }

        String remitente = leerTextoObligatorio("Remitente: ");
        String destinatario = leerTextoObligatorio("Destinatario: ");
        String direccionDestino = leerTextoObligatorio("Direccion de destino: ");
        String descripcion = leerTextoObligatorio("Descripcion del paquete: ");

        PaqueteEnvio paquete = new PaqueteEnvio(
                numeroGuia,
                remitente,
                destinatario,
                direccionDestino,
                descripcion,
                "PENDIENTE"
        );

        listaGeneral.agregar(paquete);
        colaPendientes.encolar(paquete);

        System.out.println("Paquete registrado correctamente.");
        System.out.println("El paquete fue agregado a la lista general y a la cola de pendientes.");
    }

    private static void verTodosLosPaquetes() {
        System.out.println("Todos los paquetes registrados");
        listaGeneral.mostrarAdelante();
    }

    private static void verPaquetesPendientes() {
        System.out.println("Paquetes pendientes");
        colaPendientes.mostrar();
    }

    private static void procesarSiguientePaquete() {
        System.out.println("Procesar siguiente paquete");

        if (colaPendientes.esVacia()) {
            System.out.println("No hay paquetes pendientes para procesar.");
            return;
        }

        PaqueteEnvio paqueteProcesado = (PaqueteEnvio) colaPendientes.desencolar();
        paqueteProcesado.setEstado("PROCESADO");
        historialProcesados.apilar(paqueteProcesado);

        System.out.println("Paquete procesado correctamente:");
        System.out.println(paqueteProcesado);
    }

    private static void verHistorialProcesados() {
        System.out.println("Historial de paquetes procesados");
        historialProcesados.mostrar();
    }

    private static void buscarPaquetePorGuia() {
        System.out.println("Buscar paquete por numero de guia");

        String numeroGuia = leerTextoObligatorio("Digite el numero de guia: ");

        PaqueteEnvio paqueteBuscado = new PaqueteEnvio(
                numeroGuia, "", "", "", "", ""
        );

        Object resultado = listaGeneral.buscarDato(paqueteBuscado);

        if (resultado == null) {
            System.out.println("No se encontro ningun paquete con ese numero de guia.");
        } else {
            System.out.println("Paquete encontrado:");
            System.out.println(resultado);
        }
    }

    private static void cancelarPaquetePendiente() {
        System.out.println("Cancelar paquete pendiente");

        if (colaPendientes.esVacia()) {
            System.out.println("No hay paquetes pendientes para cancelar.");
            return;
        }

        String numeroGuia = leerTextoObligatorio("Digite el numero de guia del paquete a cancelar: ");

        Cola colaAuxiliar = new Cola();
        boolean encontrado = false;

        while (!colaPendientes.esVacia()) {
            PaqueteEnvio paqueteActual = (PaqueteEnvio) colaPendientes.desencolar();

            if (paqueteActual.getNumeroGuia().equalsIgnoreCase(numeroGuia)) {
                paqueteActual.setEstado("CANCELADO");
                encontrado = true;
                System.out.println("Paquete cancelado correctamente:");
                System.out.println(paqueteActual);
            } else {
                colaAuxiliar.encolar(paqueteActual);
            }
        }

        while (!colaAuxiliar.esVacia()) {
            colaPendientes.encolar(colaAuxiliar.desencolar());
        }

        if (!encontrado) {
            System.out.println("No se encontro un paquete pendiente con ese numero de guia.");
        }
    }

    private static void deshacerUltimoProcesamiento() {
        System.out.println("Deshacer ultimo procesamiento");

        if (historialProcesados.esVacia()) {
            System.out.println("No hay paquetes procesados para deshacer.");
            return;
        }

        PaqueteEnvio ultimoProcesado = (PaqueteEnvio) historialProcesados.desapilar();
        ultimoProcesado.setEstado("PENDIENTE");
        colaPendientes.encolar(ultimoProcesado);

        System.out.println("Se deshizo el ultimo procesamiento.");
        System.out.println("El paquete regreso a la cola de pendientes:");
        System.out.println(ultimoProcesado);
    }

    private static void verCantidadElementos() {
        System.out.println("Cantidad de elementos");
        System.out.println("Total de paquetes registrados: " + listaGeneral.cuentaElementos());
        System.out.println("Paquetes pendientes: " + colaPendientes.tamanio());
        System.out.println("Paquetes procesados en historial: " + historialProcesados.tamanio());
    }

    private static String leerTextoObligatorio(String mensaje) {
        String texto;

        do {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();

            if (texto.isEmpty()) {
                System.out.println("Este campo no puede estar vacio.");
            }

        } while (texto.isEmpty());

        return texto;
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String entrada = scanner.nextLine().trim();
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
    }
}