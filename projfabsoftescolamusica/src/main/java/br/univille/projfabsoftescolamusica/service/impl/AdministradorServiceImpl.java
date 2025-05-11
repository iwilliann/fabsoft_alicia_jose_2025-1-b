package br.univille.projfabsoftescolamusica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftescolamusica.entity.Administrador;
import br.univille.projfabsoftescolamusica.repository.AdministradorRepository;
import br.univille.projfabsoftescolamusica.service.AdministradorService;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private AdministradorRepository repository;
    
    @Override
    public Administrador save(Administrador administrador) {
        return repository.save(administrador);
    }

    @Override
    public List<Administrador> getAll() {
        return repository.findAll();
    }

    @Override
    public Administrador getByID(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Administrador delete(Long id) {
        Administrador administrador = getByID(id);
        if (administrador != null) {
            repository.delete(administrador);
        }
        return administrador;

    }
}
