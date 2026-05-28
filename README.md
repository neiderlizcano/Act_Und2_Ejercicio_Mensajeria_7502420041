# Sistema de Gestión de Paquetes de Envío

## Descripción

Este proyecto corresponde a la Actividad Unidad 2 de la asignatura Estructuras de Datos.  
El caso asignado es el número 17: Mensajería.

El sistema permite registrar paquetes de envío, almacenarlos en una lista general, enviarlos a una cola de pendientes, procesarlos en orden de llegada y guardar los paquetes procesados en una pila de historial.

## Caso asignado

- Caso: Mensajería
- Entidad principal: PaqueteEnvio
- Identificador principal: numeroGuia

## Estructuras utilizadas

### Lista

La lista se utiliza para guardar todos los paquetes registrados en el sistema.

### Cola

La cola se utiliza para manejar los paquetes pendientes por procesar.  
Funciona con el principio FIFO: primero en entrar, primero en salir.

### Pila

La pila se utiliza para guardar el historial de paquetes procesados.  
Funciona con el principio LIFO: último en entrar, primero en salir.

## Clases del proyecto

- Nodo.java: representa cada nodo enlazado.
- Lista.java: implementa la lista doblemente enlazada.
- Cola.java: implementa la cola de paquetes pendientes.
- Pila.java: implementa la pila de historial.
- PaqueteEnvio.java: representa la entidad principal del sistema.
- SistemaPaqueteEnvio.java: contiene el menú y la lógica del sistema.
- Main.java: ejecuta la aplicación.

## Funcionalidades

El sistema permite:

1. Registrar paquete
2. Ver todos los paquetes registrados
3. Ver paquetes pendientes
4. Procesar siguiente paquete
5. Ver historial de paquetes procesados
6. Buscar paquete por número de guía
7. Cancelar paquete pendiente
8. Deshacer último procesamiento
9. Ver cantidad de paquetes
10. Salir

## Validaciones

El sistema valida que:

- No se ingresen campos vacíos.
- Los datos se conviertan automáticamente a mayúscula.
- No se registren paquetes con el mismo número de guía.
- No se procese un paquete si la cola está vacía.
- No se deshaga un procesamiento si la pila está vacía.
- No se cancele un paquete si no está pendiente.

## Autor

Nombre: Neider Lizcano  
Programa: Ingeniería de Software  
Asignatura: Estructuras de Datos  
Universidad de Cartagena