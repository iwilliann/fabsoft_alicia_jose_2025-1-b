import { Component } from '@angular/core';
import { Aluno } from '../model/aluno';
import { AlunoService } from '../service/aluno.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-aluno',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-aluno.component.html',
  styleUrl: './form-aluno.component.css',
  providers: [AlunoService, Router]
})
export class FormAlunoComponent {
  aluno: Aluno = new Aluno();

  constructor(
    private alunoService: AlunoService,
    private router: Router
  ){}

  salvar(){
    this.alunoService.saveAluno(this.aluno)
    .subscribe(resultado => {
      this.router.navigate(["/alunos"]);
    });
  }
}
