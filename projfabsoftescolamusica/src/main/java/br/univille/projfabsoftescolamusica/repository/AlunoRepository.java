package br.univille.projfabsoftescolamusica.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsoftescolamusica.entity.Aluno;

//importar entity Aluno

@Repository
public interface AlunoRepository 
        extends JpaRepository<Aluno, Long> {


}
    
