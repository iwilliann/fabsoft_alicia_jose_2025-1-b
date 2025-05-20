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

import br.univille.projfabsoftescolamusica.entity.Emprestimo;
import br.univille.projfabsoftescolamusica.service.EmprestimoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

public class EmprestimoController {
    @Autowired
    private EmprestimoService service;

    @GetMapping
    public ResponseEntity<List<Emprestimo>> getEmprestimo(){
        var listaEmprestimo = service.getAll();
        return new ResponseEntity<List<Emprestimo>>(listaEmprestimo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Emprestimo> postEmprestimo(@RequestBody Emprestimo emprestimo){
        if(emprestimo == null){
            return ResponseEntity.badRequest().build();
        }
        if (emprestimo.getId() == 0){
            service.save(emprestimo);
            return new ResponseEntity<Emprestimo>(emprestimo, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> 
        putEmprestimo(@PathVariable long id, @RequestBody Emprestimo emprestimo){
        if (id <= 0 || emprestimo == null){ 
            return ResponseEntity.badRequest().build();
        }

        var emprestimoAntigo = service.getByID(id); 
        if (emprestimoAntigo == null){
            return ResponseEntity.badRequest().build();
        }

        emprestimoAntigo.setDataInicio(emprestimo.getDataInicio());
        emprestimoAntigo.setDataFim(emprestimo.getDataFim());

        service.save(emprestimo);
        return new ResponseEntity<Emprestimo>(emprestimo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Emprestimo> deleteEmprestimo(@PathVariable long id){
        if (id <= 0){ 
            return ResponseEntity.badRequest().build();
        }

        var emprestimoExcluido = service.getByID(id); 
        if (emprestimoExcluido == null){
            return ResponseEntity.badRequest().build();
        }

        service.delete(id);
        return new ResponseEntity<Emprestimo>(emprestimoExcluido, HttpStatus.OK);
    }

}
