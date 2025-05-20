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
}
