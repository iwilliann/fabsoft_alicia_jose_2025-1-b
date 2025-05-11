package br.univille.projfabsoftescolamusica.service;

import java.util.List;

import br.univille.projfabsoftescolamusica.entity.Instrumento;

public interface InstrumentoService {
    Instrumento save(Instrumento instrumento);
    List<Instrumento> getAll();
    Instrumento getByID(Long id);
    Instrumento delete(Long id);
}
