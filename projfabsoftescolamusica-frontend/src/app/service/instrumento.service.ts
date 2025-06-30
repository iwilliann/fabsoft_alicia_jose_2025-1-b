import { Injectable } from '@angular/core';
import { Instrumento} from '../model/instrumento';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class InstrumentoService {
  apiURL = "http://localhost:8080/api/v1/instrumento";

  constructor(private http:HttpClient) { }

  getInstrumento() {
    return this.http.get<Instrumento[]>(this.apiURL);
  }
  saveInstrumento(instrumento: Instrumento) {
    if(instrumento.id){
      return this.http.put(this.apiURL + '/' + instrumento.id, instrumento);
    }
    return this.http.post(this.apiURL, instrumento);
  }
  getInstrumentoById(id: any) {
    return this.http.get<Instrumento>(this.apiURL + '/' + id);
  }
  excluirInstrumento(id: any) {
    return this.http.delete(this.apiURL + '/' + id);
  }
}
