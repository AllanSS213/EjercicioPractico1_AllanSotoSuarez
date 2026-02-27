package com.ejercicio1.service;

import com.ejercicio1.domain.Reserva;
import java.util.List;

public interface ReservaService {

    List<Reserva> getReservas();

    Reserva getReserva(Reserva reserva);

    void save(Reserva reserva);

    void delete(Reserva reserva);
}
