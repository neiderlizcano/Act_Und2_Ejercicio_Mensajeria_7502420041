public class Lista {

    private Nodo inicio;
    private Nodo fin;
    private int tamanio;

    public Lista() {
        this.inicio = null;
        this.fin = null;
        this.tamanio = 0;
    }

    public void agregar(Object dato) {
        Nodo nuevo = new Nodo(dato);

        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }

        tamanio++;
    }

    public void agregarAlInicio(Object dato) {
        Nodo nuevo = new Nodo(dato);

        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            nuevo.setSiguiente(inicio);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }

        tamanio++;
    }

    public void agregarEnPosicion(int indice, Object dato) {
        if (indice < 0 || indice > tamanio) {
            System.out.println("Indice invalido.");
            return;
        }

        if (indice == 0) {
            agregarAlInicio(dato);
            return;
        }

        if (indice == tamanio) {
            agregar(dato);
            return;
        }

        Nodo nuevo = new Nodo(dato);
        Nodo actual = inicio;

        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }

        Nodo anterior = actual.getAnterior();

        anterior.setSiguiente(nuevo);
        nuevo.setAnterior(anterior);

        nuevo.setSiguiente(actual);
        actual.setAnterior(nuevo);

        tamanio++;
    }

    public Object eliminarPrimero() {
        if (inicio == null) {
            System.out.println("La lista esta vacia.");
            return null;
        }

        Object datoEliminado = inicio.getDato();

        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            inicio = inicio.getSiguiente();
            inicio.setAnterior(null);
        }

        tamanio--;
        return datoEliminado;
    }

    public Object eliminarUltimo() {
        if (fin == null) {
            System.out.println("La lista esta vacia.");
            return null;
        }

        Object datoEliminado = fin.getDato();

        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            fin = fin.getAnterior();
            fin.setSiguiente(null);
        }

        tamanio--;
        return datoEliminado;
    }

    public Object eliminarEnPosicion(int indice) {
        if (indice < 0 || indice >= tamanio) {
            System.out.println("Indice invalido.");
            return null;
        }

        if (indice == 0) {
            return eliminarPrimero();
        }

        if (indice == tamanio - 1) {
            return eliminarUltimo();
        }

        Nodo actual = inicio;

        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }

        Nodo anterior = actual.getAnterior();
        Nodo siguiente = actual.getSiguiente();

        anterior.setSiguiente(siguiente);
        siguiente.setAnterior(anterior);

        tamanio--;
        return actual.getDato();
    }

    public Object buscarDato(int indice) {
        if (indice < 0 || indice >= tamanio) {
            System.out.println("Indice invalido.");
            return null;
        }

        Nodo actual = inicio;

        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }

        return actual.getDato();
    }

    public Object buscarDato(Object dato) {
        Nodo actual = inicio;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return actual.getDato();
            }

            actual = actual.getSiguiente();
        }

        return null;
    }

    public boolean contiene(Object dato) {
        return buscarDato(dato) != null;
    }

    public int cuentaElementos() {
        return tamanio;
    }

    public void limpiar() {
        inicio = null;
        fin = null;
        tamanio = 0;
    }

    public void mostrarAdelante() {
        if (inicio == null) {
            System.out.println("No hay elementos registrados.");
            return;
        }

        Nodo actual = inicio;

        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    public void mostrarAtras() {
        if (fin == null) {
            System.out.println("No hay elementos registrados.");
            return;
        }

        Nodo actual = fin;

        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getAnterior();
        }
    }

    public boolean esVacia() {
        return tamanio == 0;
    }
}