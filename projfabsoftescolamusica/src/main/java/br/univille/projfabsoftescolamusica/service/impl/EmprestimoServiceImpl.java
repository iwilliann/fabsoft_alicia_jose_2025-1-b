package br.univille.projfabsoftescolamusica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftescolamusica.entity.Emprestimo;
import br.univille.projfabsoftescolamusica.repository.EmprestimoRepository;
import br.univille.projfabsoftescolamusica.service.EmprestimoService;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {
    @Autowired
    private EmprestimoRepository repository;

    @Override
    public Emprestimo save(Emprestimo emprestimo) {
        repository.save(emprestimo);
        return emprestimo;
    }

    @Override
    public List<Emprestimo> getAll() {
        return repository.findAll();
    }

    @Override
    public Emprestimo getByID(Long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Emprestimo delete(Long id) {
        var emprestimo = getByID(id);
        if (emprestimo != null)
            repository.deleteById(id);
        return emprestimo;
    }
}
