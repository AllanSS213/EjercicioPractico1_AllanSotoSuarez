package com.ejercicio1.service;

import com.ejercicio1.domain.Servicio;
import java.util.List;

public interface ServicioService {

    List<Servicio> getServicios(boolean activos);

    Servicio getServicio(Servicio servicio);

    void save(Servicio servicio);

    void delete(Servicio servicio);
}
