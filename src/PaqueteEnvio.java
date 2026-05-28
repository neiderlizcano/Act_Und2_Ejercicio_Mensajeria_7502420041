import java.util.Objects;

public class PaqueteEnvio {

    private String numeroGuia;
    private String nombre;
    private String apellido;
    private String numeroCedula;
    private String ciudad;
    private String direccion;
    private String descripcion;
    private String estado;

    public PaqueteEnvio(String numeroGuia, String nombre, String apellido,
                        String numeroCedula, String ciudad, String direccion,
                        String descripcion, String estado) {
        this.numeroGuia = numeroGuia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCedula = numeroCedula;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "PaqueteEnvio{" +
                "numeroGuia='" + numeroGuia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroCedula='" + numeroCedula + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PaqueteEnvio)) {
            return false;
        }

        PaqueteEnvio otro = (PaqueteEnvio) obj;

        if (this.numeroGuia == null || otro.numeroGuia == null) {
            return false;
        }

        return this.numeroGuia.equalsIgnoreCase(otro.numeroGuia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroGuia == null ? "" : numeroGuia.toUpperCase());
    }
}