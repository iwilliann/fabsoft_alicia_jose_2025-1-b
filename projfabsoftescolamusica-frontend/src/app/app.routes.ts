import { Routes } from '@angular/router';
import { AlunoComponent } from './aluno/aluno.component';
import { FormAlunoComponent } from './form-aluno/form-aluno.component';
import { InstrumentoComponent } from './instrumento/instrumento.component';
import { FormInstrumentoComponent } from './form-instrumento/form-instrumento.component';
import { EmprestimoComponent } from './emprestimo/emprestimo.component';
import { FormEmprestimoComponent } from './form-emprestimo/form-emprestimo.component';


export const routes: Routes = [
    {path: "alunos", component: AlunoComponent},
    {path: "alunos/novo", component: FormAlunoComponent},
    {path: "alunos/alterar/:id", component: FormAlunoComponent},

    {path: "instrumento",component: InstrumentoComponent},
    {path: "instrumento/novo", component: FormInstrumentoComponent},
    {path: "instrumento/alterar/:id", component: FormInstrumentoComponent},

    {path: "emprestimo", component: EmprestimoComponent},  
    {path: "emprestimo/novo", component: FormEmprestimoComponent},
    {path: "emprestimo/alterar/:id", component: FormEmprestimoComponent},  

    
];

