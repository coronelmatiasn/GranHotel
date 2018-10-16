package hotel.modelo;

class TipoDeCama {
    private int id;
    private String categoria;

    public TipoDeCama() {
    }
    
    public TipoDeCama(int id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public TipoDeCama(String categoria) {
        this.categoria = categoria;
    }
    
    public void setId(int id) {
        this.id = id;
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
}
