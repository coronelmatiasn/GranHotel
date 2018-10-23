package hotel.modelo;

public class Habitacion {
    private int nHabitacion;
    private int piso;
    private boolean estado;
    private TipoHabitacion tipohabitacion;
           
    public Habitacion() {
        this.estado = false;
    }
    
    public Habitacion(int nHabitacion, int piso,boolean estado, TipoHabitacion  tipohabitacion) {
        this.estado = false;
        this.nHabitacion = nHabitacion;
        this.piso = piso;
        this.tipohabitacion = tipohabitacion;
    } 
    
    public Habitacion(int piso, boolean estado, TipoHabitacion tipohabitacion) {
        this.estado = estado;
        this.piso = piso;
        this.tipohabitacion = tipohabitacion;
    }
    
    public int getNHabitacion() {
        return nHabitacion;
    }

    public void setNHabitacion(int nHabitacion) {
        this.nHabitacion = nHabitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipohabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }   
}
