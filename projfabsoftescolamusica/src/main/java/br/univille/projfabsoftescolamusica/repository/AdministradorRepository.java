package br.univille.projfabsoftescolamusica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsoftescolamusica.entity.Administrador;

@Repository
public interface AdministradorRepository 
            extends JpaRepository<Administrador, Long> {
}
    