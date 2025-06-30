import { Injectable } from '@angular/core';
import { Aluno } from '../model/aluno';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {
  apiURL = "http://localhost:8080/api/v1/aluno";


  constructor(private http:HttpClient) { }

  getAluno(){
    return this.http.get<Aluno[]>(this.apiURL);
  }

  saveAluno(aluno: Aluno){
    if(aluno.id){
      return this.http.put(this.apiURL + '/' + aluno.id, aluno); // Atualiza um aluno pelo ID, no caminho PUT localhost:8080/api/v1/aluno/{id}
    }
      return this.http.post(this.apiURL, aluno);
  }

  getAlunoById(id: any){
    return this.http.get<Aluno>(this.apiURL + '/' + id); // Retorna um aluno pelo ID, no caminho GET localhost:8080/api/v1/aluno/{id}?
  }

  excluirAluno(id: any){
  return this.http.delete<Aluno>(this.apiURL + '/' + id);
  }
}
