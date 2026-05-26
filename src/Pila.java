public class Pila {

    private Nodo cima;
    private int tamanio;

    public Pila() {
        this.cima = null;
        this.tamanio = 0;
    }

    public void apilar(Object dato) {
        Nodo nuevo = new Nodo(dato);

        if (esVacia()) {
            cima = nuevo;
        } else {
            nuevo.setSiguiente(cima);
            cima.setAnterior(nuevo);
            cima = nuevo;
        }

        tamanio++;
    }

    public Object desapilar() {
        if (esVacia()) {
            System.out.println("La pila esta vacia. No hay elementos para desapilar.");
            return null;
        }

        Object dato = cima.getDato();

        if (cima.getSiguiente() == null) {
            cima = null;
        } else {
            cima = cima.getSiguiente();
            cima.setAnterior(null);
        }

        tamanio--;
        return dato;
    }

    public Object peek() {
        if (esVacia()) {
            System.out.println("La pila esta vacia. No hay elementos para consultar.");
            return null;
        }

        return cima.getDato();
    }

    public int tamanio() {
        return tamanio;
    }

    public boolean esVacia() {
        return tamanio == 0;
    }

    public boolean contiene(Object dato) {
        return buscar(dato) != null;
    }

    public void limpiar() {
        cima = null;
        tamanio = 0;
    }

    public void mostrar() {
        if (esVacia()) {
            System.out.println("No hay elementos en el historial.");
            return;
        }

        Nodo actual = cima;

        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    public Object buscar(Object dato) {
        Nodo actual = cima;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return actual.getDato();
            }

            actual = actual.getSiguiente();
        }

        return null;
    }
}