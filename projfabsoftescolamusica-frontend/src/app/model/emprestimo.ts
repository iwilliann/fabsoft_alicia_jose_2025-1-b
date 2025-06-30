import { Aluno } from "./aluno";
import { Instrumento } from "./instrumento";

export class Emprestimo {
  id: number;
  dataInicio: string;
  dataFim: string;
  aluno: Aluno;
  instrumento: Instrumento;

  constructor(
    id: number,
    dataInicio: string,
    dataFim: string,
    aluno: Aluno,
    instrumentos: Instrumento
  ) {
    this.id = id;
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
    this.aluno = aluno;
    this.instrumento = instrumentos;
  }
}