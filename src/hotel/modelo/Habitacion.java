package hotel.modelo;

public class Habitacion {
    private int nHabitacion;
    private int piso;
    private boolean estado;
    private TipoHabitacion tipoHabitacion;
    
    public Habitacion(int nHabitacion, int piso, TipoHabitacion tipoHabitacion) {
        this.estado = false;
        this.nHabitacion = nHabitacion;
        this.piso = piso;
        this.tipoHabitacion = tipoHabitacion;
    }
    
    public Habitacion() {
        this.estado = false;
    }

    public int getnHabitacion() {
        return nHabitacion;
    }

    public void setnHabitacion(int nHabitacion) {
        this.nHabitacion = nHabitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
}
