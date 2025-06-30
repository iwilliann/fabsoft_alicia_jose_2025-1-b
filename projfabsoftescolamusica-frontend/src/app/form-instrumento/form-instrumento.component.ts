import { Component } from '@angular/core';
import { Instrumento } from '../model/instrumento';
import { InstrumentoService } from '../service/instrumento.service';
import { HttpClientModule } from '@angular/common/http';  
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Aluno } from '../model/aluno'; 
import { AlunoService } from '../service/aluno.service';

@Component({
  selector: 'app-form-instrumento',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-instrumento.component.html',
  styleUrl: './form-instrumento.component.css',
  providers: [InstrumentoService, AlunoService, Router]
})
export class FormInstrumentoComponent {
  instrumento: Instrumento = new Instrumento();

  public listaAluno: Aluno[] = [];

  constructor(
    private instrumentoService: InstrumentoService,
    private alunoService: AlunoService,
    private router: Router,
    private activedRoute: ActivatedRoute
  ){
    const id = this.activedRoute.snapshot.paramMap.get('id');
    
    this.alunoService.getAluno().subscribe(alunos => {
      this.listaAluno = alunos;
    });
    if (id) {
      this.instrumentoService.getInstrumentoById(id).subscribe(instrumento => {
          this.instrumento = instrumento;
        });
    }
  }
  salvar(){
    this.instrumentoService.saveInstrumento(this.instrumento)
    .subscribe(res => {
      this.router.navigate(["instrumento"]);
    });
  }

  comparaAlunos(obj1: Aluno, obj2: Aluno): boolean {
    return obj1 && obj2 ? obj1.id === obj2.id : obj1 === obj2;
  }

    onFileSelected(event: Event): void {
        const input = event.target as HTMLInputElement;
        if (input.files && input.files.length > 0) {
            const file = input.files[0];
            const reader = new FileReader();
            reader.onload = () => {
              const base64String = reader.result as string;
              this.instrumento.foto = base64String.split(',')[1]; 
              this.instrumento.arquivoFoto = file.name; 
              this.instrumento.mimeType = file.type;
            };
            reader.readAsDataURL(file);
        }
    }
}
