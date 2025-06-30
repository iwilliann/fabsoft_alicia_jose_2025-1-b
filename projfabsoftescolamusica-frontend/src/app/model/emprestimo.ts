import { Aluno } from "./aluno";
import { Instrumento } from "./instrumento";

export class Emprestimo {
    id: number;
    dataEmprestimo: string;
    dataDevolucao: string;
    aluno: Aluno;
    instrumento: Instrumento;
    status: string; // "pendente", "devolvido", "atrasado"
    dataInicio: string; 
    dataFim: string; 
    
    constructor(
        id: number,
        dataEmprestimo: string,
        dataDevolucao: string,
        aluno: Aluno,
        instrumento: Instrumento,
        status: string
    ) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.aluno = aluno;
        this.instrumento = instrumento;
        this.status = status;

        this.dataInicio = ''; // <- inicialização
        this.dataFim = '';
    }
}
