package com.ejercicio1.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idReserva;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    public Reserva() {
    }

    public Reserva(String nombreCliente, LocalDate fecha, Servicio servicio) {
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.servicio = servicio;
    }
}
