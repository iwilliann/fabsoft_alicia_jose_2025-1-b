package br.univille.projfabsoftescolamusica.service;

import java.util.List;

import br.univille.projfabsoftescolamusica.entity.Emprestimo;

public interface EmprestimoService {
    Emprestimo save(Emprestimo emprestimo);
    List<Emprestimo> getAll();
    Emprestimo getByID(Long id);
    Emprestimo delete(Long id);
}
