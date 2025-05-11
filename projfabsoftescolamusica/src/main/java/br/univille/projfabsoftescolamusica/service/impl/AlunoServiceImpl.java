package br.univille.projfabsoftescolamusica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.projfabsoftescolamusica.entity.Aluno;
import br.univille.projfabsoftescolamusica.repository.AlunoRepository;
import br.univille.projfabsoftescolamusica.service.AlunoService;

@Service
// nesse que vamos programar -> PARTE DO JOSÉ ;)

public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Override
    public Aluno save(Aluno aluno) {
        repository.save(aluno);
        return aluno;
    }

    @Override
    public List<Aluno> getAll() {
        return repository.findAll();
    }

    @Override
    public Aluno getByID(Long id) {
        
         var retorno = repository.findById(id);
         if (retorno.isPresent()) 
           return retorno.get();
        return null;

         }
    @Override
    public Aluno delete(Long id) {
        var aluno = getByID(id);
        if (aluno != null)
            repository.deleteById(id);
        return aluno;    
    }
}
