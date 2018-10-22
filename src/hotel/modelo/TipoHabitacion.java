package hotel.modelo;

public class TipoHabitacion {
    private int id;
    private String categoria;
    private int cantidadMaxPersonas;
    private double precioXNoche;
    private TipoDeCama tipoCama;

    public TipoHabitacion(int id, String categoria, int cantidadMaxPersonas, double precioXNoche,TipoDeCama tipoCama) {
        this.id = id;
        this.categoria = categoria;
        this.cantidadMaxPersonas = cantidadMaxPersonas;
        this.precioXNoche = precioXNoche;
        this.tipoCama = tipoCama;
    }

    public TipoHabitacion(String categoria, int cantidadMaxPersonas, double precioXNoche,TipoDeCama tipoCama) {
        this.categoria = categoria;
        this.cantidadMaxPersonas = cantidadMaxPersonas;
        this.precioXNoche = precioXNoche;
        this.tipoCama = tipoCama;
    }
    
    
    public TipoHabitacion(int id){
        this.id=id;
    }

    public TipoHabitacion() {
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
    }
    
}
