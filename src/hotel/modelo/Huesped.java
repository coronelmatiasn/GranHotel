package hotel.modelo;

public class Huesped {
    private int dni;
    private String nombre;
    private String domicilio;
    private String celular;
    private String correo;

    public Huesped(int dni, String nombre, String domicilio, String celular, String correo) {
        this.dni = dni;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.celular = celular;
        this.correo = correo;
    }

    public Huesped() {
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
