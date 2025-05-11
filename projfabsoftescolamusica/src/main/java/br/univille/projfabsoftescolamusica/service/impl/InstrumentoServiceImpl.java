package br.univille.projfabsoftescolamusica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.univille.projfabsoftescolamusica.entity.Instrumento;
import br.univille.projfabsoftescolamusica.repository.InstrumentoRepository;
import br.univille.projfabsoftescolamusica.service.InstrumentoService;

@Service
public class InstrumentoServiceImpl 
    implements InstrumentoService {

        @Autowired
        private InstrumentoRepository repository;

        @Override
        public Instrumento save(Instrumento instrumento) {
            repository.save(instrumento); // INSERT
            return instrumento; // UPDATE
        }

        @Override
        public List<Instrumento> getAll() {
            return repository.findAll(); // SELECT * FROM emprestimo
        }

        @Override
        public Instrumento getByID(Long id) {
            var retorno = repository.findById(id);
            if(retorno.isPresent())
                return retorno.get();
            return null;
        }

        @Override
        public Instrumento delete(Long id) {
            var instrumento = getByID(id);
            if(instrumento != null)
                repository.deleteById(id); // apaga no BD
            return instrumento;
        }
}
