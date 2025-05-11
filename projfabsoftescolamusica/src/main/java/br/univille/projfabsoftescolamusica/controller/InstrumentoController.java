package br.univille.projfabsoftescolamusica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoftescolamusica.entity.Instrumento;
import br.univille.projfabsoftescolamusica.service.InstrumentoService;

@RestController
@RequestMapping("/api/v1/instrumento")
public class InstrumentoController {
    @Autowired
    private InstrumentoService service;

    @GetMapping
    public ResponseEntity<List<Instrumento>> getInstrumento() {
        var listaInstrumentos = service.getAll();
        return new ResponseEntity<List<Instrumento>>(listaInstrumentos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Instrumento> postInstrumento(@RequestBody Instrumento instrumento){
        if(instrumento == null){
            return ResponseEntity.badRequest().build();
        }
        if (instrumento.getId() == 0){
            service.save(instrumento);
            return new ResponseEntity<Instrumento>(instrumento, HttpStatus.OK);
        } 
        if (instrumento.getId() == 0){
            service.save(instrumento);
            return new ResponseEntity<Instrumento>(instrumento, HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instrumento> 
        putInstrumento(@PathVariable long id, @RequestBody Instrumento instrumento){
            if(id <= 0|| instrumento == null){
                return ResponseEntity.badRequest().build();
            }

            var instrumentoAntigo = service.getByID(id);
            if(instrumentoAntigo == null){
                return ResponseEntity.notFound().build();
            }

            instrumentoAntigo.setNome(instrumento.getNome());
            instrumentoAntigo.setTipo(instrumento.getTipo());
            instrumentoAntigo.setCodigo(instrumento.getCodigo());
            instrumentoAntigo.setSobressalentes(instrumento.isSobressalentes());

            service.save(instrumentoAntigo);
            return new ResponseEntity<Instrumento>(instrumentoAntigo, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Instrumento> deleteINstrumento(@PathVariable long id){
            if(id <= 0){
                return ResponseEntity.badRequest().build();
            }

            var instrumentoExcluido = service.getByID(id);
            if(instrumentoExcluido == null){
                return ResponseEntity.badRequest().build();
            }

            service.delete(id);
            return new ResponseEntity<Instrumento>(instrumentoExcluido, HttpStatus.OK);
        }
}
