package br.univille.projfabsoftescolamusica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsoftescolamusica.entity.Emprestimo;

@Repository
public interface EmprestimoRepository 
        extends JpaRepository<Emprestimo, Long> {
    
}
