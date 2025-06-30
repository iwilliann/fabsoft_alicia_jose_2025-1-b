import { Component } from '@angular/core';
import { Aluno } from '../model/aluno';
import { AlunoService } from '../service/aluno.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule} from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-form-aluno',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-aluno.component.html',
  styleUrl: './form-aluno.component.css',
  providers: [AlunoService, Router]
})
export class FormAlunoComponent {
abrirConfirmacao(arg0: any) {
throw new Error('Method not implemented.');
}
umAluno: any;
alterar(arg0: any) {
throw new Error('Method not implemented.');
}
confirmarExclusao() {
throw new Error('Method not implemented.');
}
fecharConfirmacao() {
throw new Error('Method not implemented.');
}
  aluno: Aluno = new Aluno();

  constructor(
    private alunoService: AlunoService,
    private router: Router,
    private activedRoute: ActivatedRoute
  ){
    const id = this.activedRoute.snapshot.paramMap.get('id');
    if (id) {
      this.alunoService.getAlunoById(id).subscribe(aluno => {
          this.aluno = aluno;
        });
    }
  }

  salvar(){
    this.alunoService.saveAluno(this.aluno)
    .subscribe(resultado => {
      this.router.navigate(["/alunos"]);
    });
  }
}
