import java.util.Objects;

public class PaqueteEnvio {

    private String numeroGuia;
    private String remitente;
    private String destinatario;
    private String direccionDestino;
    private String descripcion;
    private String estado;

    public PaqueteEnvio(String numeroGuia, String remitente, String destinatario,
                        String direccionDestino, String descripcion, String estado) {
        this.numeroGuia = numeroGuia;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.direccionDestino = direccionDestino;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
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
                ", remitente='" + remitente + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", direccionDestino='" + direccionDestino + '\'' +
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
        return Objects.hash(numeroGuia == null ? "" : numeroGuia.toLowerCase());
    }
}