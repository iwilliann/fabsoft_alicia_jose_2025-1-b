import { Routes } from '@angular/router';
import { AlunoComponent } from './aluno/aluno.component';
import { FormAlunoComponent } from './form-aluno/form-aluno.component';


export const routes: Routes = [
    {path: "alunos", component: AlunoComponent},
    {path: "alunos/novo", component: FormAlunoComponent},
];
