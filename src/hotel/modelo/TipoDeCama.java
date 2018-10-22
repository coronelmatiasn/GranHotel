package hotel.modelo;

 public class TipoDeCama {
    private int id_tipo_cama;
    private String categoria;

    public TipoDeCama(int id_tipo_cama, String categoria) {
        this.id_tipo_cama = id_tipo_cama;
        this.categoria = categoria;
    }

    public TipoDeCama(String categoria) {
        this.categoria = categoria;
    }
    public TipoDeCama() {
    }

    public int getId_tipo_cama() {
        return id_tipo_cama;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setId_tipo_cama(int id_tipo_cama) {
        this.id_tipo_cama = id_tipo_cama;
    }
    
}
