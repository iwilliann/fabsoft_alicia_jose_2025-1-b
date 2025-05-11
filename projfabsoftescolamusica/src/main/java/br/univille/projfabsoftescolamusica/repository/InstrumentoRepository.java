package br.univille.projfabsoftescolamusica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsoftescolamusica.entity.Instrumento;

@Repository
public interface InstrumentoRepository 
        extends JpaRepository<Instrumento, Long> {
}
