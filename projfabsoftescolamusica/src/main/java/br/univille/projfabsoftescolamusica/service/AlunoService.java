package br.univille.projfabsoftescolamusica.service;

import java.util.List;

import br.univille.projfabsoftescolamusica.entity.Aluno;

public interface AlunoService {
    Aluno save(Aluno aluno);
    List<Aluno> getAll();
    Aluno getByID(Long id);
    Aluno delete(Long id);   
}