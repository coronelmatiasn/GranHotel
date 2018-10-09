package hotel.modelo;

class TipoHabitacion {
    private int nro_habitacion;
    private String categoria;
    private int cantidadMaxPersonas;
    private double precioXNoche;
    private TipoDeCama tipoCama;

    public TipoHabitacion(int nro_habitacion, String categoria, int cantidadMaxPersonas, double precioXNoche, TipoDeCama tipoCama) {
        this.nro_habitacion = nro_habitacion;
        this.categoria = categoria;
        this.cantidadMaxPersonas = cantidadMaxPersonas;
        this.precioXNoche = precioXNoche;
        this.tipoCama = tipoCama;
    }

    public TipoHabitacion(String categoria, int cantidadMaxPersonas, double precioXNoche, TipoDeCama tipoCama) {
        this.categoria = categoria;
        this.cantidadMaxPersonas = cantidadMaxPersonas;
        this.precioXNoche = precioXNoche;
        this.tipoCama = tipoCama;
    }

    public TipoHabitacion() {
    }

    public int getNro_habitacion() {
        return nro_habitacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidadMaxPersonas() {
        return cantidadMaxPersonas;
    }

    public void setCantidadMaxPersonas(int cantidadMaxPersonas) {
        this.cantidadMaxPersonas = cantidadMaxPersonas;
    }

    public double getPrecioXNoche() {
        return precioXNoche;
    }

    public void setPrecioXNoche(double precioXNoche) {
        this.precioXNoche = precioXNoche;
    }

    public TipoDeCama getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(TipoDeCama tipoCama) {
        this.tipoCama = tipoCama;
    }

    public void setNro_habitacion(int nro_habitacion) {
        this.nro_habitacion = nro_habitacion;
    }
    
}
