package com.ejercicio1.service.impl;

import com.ejercicio1.domain.Reserva;
import com.ejercicio1.repository.ReservaRepository;
import com.ejercicio1.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Reserva getReserva(Reserva reserva) {
        return reservaRepository.findById(reserva.getIdReserva()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    @Override
    @Transactional
    public void delete(Reserva reserva) {
        reservaRepository.delete(reserva);
    }
}
