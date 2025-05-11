package br.univille.projfabsoftescolamusica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.projfabsoftescolamusica.entity.Administrador;


public interface AdministradorService {
    Administrador save(Administrador administrador);
    List<Administrador> getAll();
    Administrador getByID(Long id);
    Administrador delete(Long id);
}
