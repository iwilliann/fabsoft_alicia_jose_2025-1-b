import { Component,ElementRef,ViewChild } from '@angular/core';
import { Emprestimo } from '../model/emprestimo';
import { EmprestimoService } from '../service/emprestimo.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router,ActivatedRoute, ParamMap } from '@angular/router';


import { Aluno } from '../model/aluno';
import { AlunoService } from '../service/aluno.service';

import { Instrumento } from '../model/instrumento';
import { InstrumentoService } from '../service/instrumento.service';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-form-emprestimo',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-emprestimo.component.html',
  styleUrl: './form-emprestimo.component.css',
  providers: [EmprestimoService, AlunoService, InstrumentoService, Router]
})
export class FormEmprestimoComponent {
  emprestimo: Emprestimo = new Emprestimo(0, '', '', new Aluno(), new Instrumento());
  public listaEmprestimos: Emprestimo[] = [];

  aluno: Aluno = new Aluno();
  public listaAluno: Aluno[] = [];

  instrumento: Instrumento = new Instrumento();
  public listaInstrumento: Instrumento[] = [];

  
  // @ViewChild('myModalEmprestimo') modalElementEmprestimo!: ElementRef;
  //   private modalEmprestimo!: bootstrap.Modal; // Não vai ter essa parte


    constructor(
      private emprestimoService: EmprestimoService,
      private alunoService: AlunoService,
      private instrumentoService: InstrumentoService,
      private router: Router,
      private activeRouter: ActivatedRoute
    ){
      const id = this.activeRouter.snapshot.paramMap.get('id');
      this.emprestimoService.getAlunos().subscribe((alunos: Aluno[]) => {
        this.listaAluno = alunos;
      });
      
       if (id) {
        this.emprestimoService.getEmprestimoById(id).subscribe(emprestimo => {
          this.emprestimo = emprestimo;
        });
      }

         // Inicialização segura para evitar erros de argumentos
      this.emprestimo = new Emprestimo(
        0,
        '',  // dataInicio
        '',  // dataFim
        new Aluno(),
        new Instrumento()
      );  
      
      
      this.alunoService.getAluno().subscribe( alunos => {
        this.listaAluno = alunos;
      });
      this.instrumentoService.getInstrumento().subscribe(instrumentos => {
        this.listaInstrumento = instrumentos;
      });
    
    }
    salvar(){
      this.emprestimoService.saveEmprestimo(this.emprestimo)
          .subscribe( res => {
            this.router.navigate(['emprestimo']);
          });
    }

    comparaAlunos(obj1: Aluno, obj2: Aluno): boolean {
      return obj1 && obj2 ? obj1.id === obj2.id : obj1 === obj2;
    }

    comparaInstrumentos(obj1: Instrumento, obj2: Instrumento): boolean {
      return obj1 && obj2 ? obj1.id === obj2.id : obj1 === obj2;
    }

}
