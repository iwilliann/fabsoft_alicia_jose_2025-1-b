import { Component } from '@angular/core';
import { Aluno } from '../model/aluno';
import { AlunoService } from '../service/aluno.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-aluno',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './aluno.component.html',
  styleUrl: './aluno.component.css',
  providers: [AlunoService]
})
export class AlunoComponent {
  listaAluno: Aluno[] = [];

  constructor(private alunoService: AlunoService) {}

  ngOnInit() {
    console.log("Carregando alunos...");
    this.alunoService.getAluno().subscribe(
      alunos =>{
        this.listaAluno = alunos;
      }
    );
  }
}
