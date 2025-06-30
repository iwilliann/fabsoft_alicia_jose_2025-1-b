import { Component, ElementRef, ViewChild  } from '@angular/core';
import * as bootstrap from 'bootstrap';
import { Aluno } from '../model/aluno';
import { AlunoService } from '../service/aluno.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router} from '@angular/router'; 


@Component({
  selector: 'app-aluno',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './aluno.component.html',
  styleUrl: './aluno.component.css',
  providers: [AlunoService, Router]
})
export class AlunoComponent {
  // umaluno: Aluno;
  listaAluno: Aluno[] = [];

  @ViewChild('myModal') modalElement!: ElementRef;
    private modal!: bootstrap.Modal;

    private alunoSelecionado!: Aluno;

  constructor(
    private alunoService: AlunoService,
    private router: Router
  ) {}

  novo(){
    this.router.navigate(['/alunos/novo']);
  }

  ngOnInit() {
    console.log("Carregando alunos...");
    this.alunoService.getAluno().subscribe(
      alunos =>{
        this.listaAluno = alunos;
      }
    );
  }
  alterar(aluno: Aluno) {
    this.router.navigate(['/alunos/alterar', aluno.id]);
  }
  abrirConfirmacao(aluno: Aluno) {
    this.alunoSelecionado = aluno;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }
  fecharConfirmacao() {
    this.modal.hide();
  }
  confirmarExclusao() { 
    this.alunoService.excluirAluno(this.alunoSelecionado.id).subscribe(
      () => {
        this.fecharConfirmacao();
        this.alunoService.getAluno().subscribe(
          alunos => {
            this.listaAluno = alunos;
          }
        );
      },
      error => {
        console.error('Erro ao excluir aluno:', error);
      }
    );
  }
}
