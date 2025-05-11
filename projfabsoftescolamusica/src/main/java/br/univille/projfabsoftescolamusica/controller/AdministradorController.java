package br.univille.projfabsoftescolamusica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoftescolamusica.entity.Administrador;
import br.univille.projfabsoftescolamusica.service.AdministradorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService service;

    @GetMapping
    public ResponseEntity<List<Administrador>> getAdminstrador(){
        var listaAdministrador = service.getAll();
        return new ResponseEntity<List<Administrador>>(listaAdministrador, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Administrador> 
        postAdministrador(@RequestBody Administrador administrador){
        if(administrador == null){
            return ResponseEntity.badRequest().build();
        }
        if (administrador.getId() == 0){
            service.save(administrador);
            return new ResponseEntity<Administrador>(administrador, HttpStatus.OK);
        }
        
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrador> 
        putAdministrador(@PathVariable long id,@RequestBody Administrador administrador){
            if (id <= 0 || administrador == null){ // identificação do aluno não pode ser 0 ou menor,
                // e aluno não pode estar em branco(null)
                    return ResponseEntity.badRequest().build();
                }

        var administradorAntigo = service.getByID(id); // procura se informação do administrador no banco está no banco
        if (administradorAntigo == null){
            return ResponseEntity.badRequest().build();
        }

        administradorAntigo.setNome(administrador.getNome());
        administradorAntigo.setEmail(administrador.getEmail());
        administradorAntigo.setMatriculaADM(administrador.getMatriculaADM());
        
        service.save(administradorAntigo);
        return new ResponseEntity<Administrador>(administrador, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Administrador> 
        deleteAdministrador(@PathVariable long id,@RequestBody Administrador administrador){
                if (id <= 0){ 
            return ResponseEntity.badRequest().build();
            }

        var administradorExcluido = service.getByID(id); // procura se informação do administrador no banco está no banco
        if (administradorExcluido == null){
            return ResponseEntity.badRequest().build();
        }

        service.delete(id);
        return new ResponseEntity<Administrador>(administradorExcluido, HttpStatus.OK);
    }
}
