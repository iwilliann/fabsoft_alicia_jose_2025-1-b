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
import br.univille.projfabsoftescolamusica.entity.Aluno;
import br.univille.projfabsoftescolamusica.service.AlunoService;

@RestController // envia JSON e recebe JSON, pra fazer uma API
@RequestMapping("/api/v1/aluno") //talvez falte um s no alunos / levar o endereço para buscar no navegador
public class AlunoController {

    // no controlller, coloca váriavel de AlunoService
    @Autowired
    private AlunoService service;

    //GET
    @GetMapping
    public ResponseEntity<List<Aluno>> getAluno(){
        var listaAluno = service.getAll();
        return new ResponseEntity<List<Aluno>>(listaAluno, HttpStatus.OK);
        
    }


    //POST
    @PostMapping
    public ResponseEntity<Aluno> postAluno(@RequestBody Aluno aluno){
        if(aluno == null){
            return ResponseEntity.badRequest().build();
        }
        if (aluno.getId() == 0){
            service.save(aluno);
            return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
        }
        
        return ResponseEntity.badRequest().build();
    }


    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> putAluno(@PathVariable long id, @RequestBody Aluno aluno){
        if (id <= 0 || aluno == null){ // identificação do aluno não pode ser 0 ou menor,
        // e aluno não pode estar em branco(null)
            return ResponseEntity.badRequest().build();
        }

        var alunoAntigo = service.getByID(id); // procura se informação do aluno no banco está no banco
        if (alunoAntigo == null){
            return ResponseEntity.badRequest().build();
        }

        // pode utilizar a biblioteca Mapper, pra ser mais prático
        alunoAntigo.setNome(aluno.getNome());
        alunoAntigo.setEndereco(aluno.getEndereco());
        alunoAntigo.setTelefone(aluno.getTelefone());
        alunoAntigo.setEmail(aluno.getEmail());
        alunoAntigo.setDataNascimento(aluno.getDataNascimento());
        alunoAntigo.setCpf(aluno.getCpf());
        alunoAntigo.setSexo(aluno.getSexo());

        service.save(alunoAntigo);
        return new ResponseEntity<Aluno>(alunoAntigo, HttpStatus.OK);
    }

    //DELETE    
    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> deleteAluno(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }

        var alunoExcluido = service.getByID(id);
        if(alunoExcluido == null){
            return ResponseEntity.badRequest().build();
        }

        service.delete(id);
        return new ResponseEntity<Aluno> (alunoExcluido, HttpStatus.OK);
    }
}
