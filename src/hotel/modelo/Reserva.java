package hotel.modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Reserva {
    private int nroReserva;
    private int cantidadDePersonas;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private double importeTotal;
    private Huesped huesped;
    private Habitacion habitacion;
    private boolean estado;

    public Reserva(int nroReserva, int cantidadDePersonas, LocalDate fechaEntrada, LocalDate fechaSalida, double importeTotal, Huesped huesped, Habitacion habitacion, boolean estado) {
        this.nroReserva = nroReserva;
        this.cantidadDePersonas = cantidadDePersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.importeTotal = importeTotal;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.estado = estado;
    }

    public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida, Huesped huesped, Habitacion habitacion) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.huesped = huesped;
        this.habitacion = habitacion;
    }

    public Reserva(int cantidadDePersonas, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.cantidadDePersonas = cantidadDePersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public Reserva() {
    }

    public int getNroReserva() {
        return nroReserva;
    }

    public void setNroReserva(int nroReserva) {
        this.nroReserva = nroReserva;
    }

    public int getCantidadDePersonas() {
        return cantidadDePersonas;
    }

    public void setCantidadDePersonas(int cantidadDePersonas) {
        this.cantidadDePersonas = cantidadDePersonas;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public void setImporteTotal(double importeTotal){
        this.importeTotal = importeTotal;
    }

    public double getImporteTotal() {
        return importeTotal;
    }
}
