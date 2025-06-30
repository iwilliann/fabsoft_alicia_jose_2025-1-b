import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Emprestimo} from '../model/emprestimo';
import { Aluno } from '../model/aluno';
import { Instrumento } from '../model/instrumento';


@Injectable({
  providedIn: 'root'
})
export class EmprestimoService {


  apiURL = "http://localhost:8080/api/v1/emprestimo";

  constructor(private http:HttpClient) { }
  getAlunos() {
    return this.http.get<Aluno[]>('http://localhost:8080/api/v1/aluno');
  }
   getInstrumentos() {
    return this.http.get<Instrumento[]>('http://localhost:8080/api/v1/instrumento');
  }
  getEmprestimo() {
    return this.http.get<Emprestimo[]>(this.apiURL);
  }
  saveEmprestimo(emprestimo: Emprestimo) {
    if(emprestimo.id){
      return this.http.put(this.apiURL + '/' + emprestimo.id, emprestimo);
    }
    return this.http.post(this.apiURL, emprestimo);
  }
  getEmprestimoById(id: any) {
    return this.http.get<Emprestimo>(this.apiURL + '/' + id);
  }
  excluirEmprestimo(id: any) {
    return this.http.delete(this.apiURL + '/' + id);
  }
}
