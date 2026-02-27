package com.ejercicio1.service;

import com.ejercicio1.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    List<Categoria> getCategorias(boolean activos);

    Categoria getCategoria(Categoria categoria);

    void save(Categoria categoria);

    void delete(Categoria categoria);
}
