import { Component,ElementRef,ViewChild } from '@angular/core';
import * as bootstrap from 'bootstrap';
import { Instrumento} from '../model/instrumento';
import { InstrumentoService } from '../service/instrumento.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';


@Component({
  selector: 'app-instrumento',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './instrumento.component.html',
  styleUrl: './instrumento.component.css',
  providers: [InstrumentoService,Router]
})
export class InstrumentoComponent {
  sobressalente: boolean;

  public listaInstrumento: Instrumento[] = [];

  @ViewChild('myModal') modalElement!: ElementRef;
    private modal!: bootstrap.Modal;

    private instrumentoSelecionado!: Instrumento;

  constructor(
    private instrumentoService: InstrumentoService,
    private router: Router
  ) {}

  ngOnInit(): void {
      this.instrumentoService.getInstrumento().subscribe(resposta => {
        this.listaInstrumento = resposta;
    })
  }
  novo(){
    this.router.navigate(['instrumento/novo'])
  }
  alterar(instrumento: Instrumento) {
    this.router.navigate([`/instrumento/alterar/`, instrumento.id]);
  }

  abrirConfirmacao(instrumento: Instrumento) {
    this.instrumentoSelecionado = instrumento;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);  
    this.modal.show();
  }
  fecharConfirmacao(){
    this.modal.hide();
  }
  

  confirmarExclusao() {
    this.instrumentoService.excluirInstrumento(this.instrumentoSelecionado.id).subscribe(
      () => {
        this.fecharConfirmacao();
        this.instrumentoService.getInstrumento().subscribe(
          Instrumento => {
            this.listaInstrumento = Instrumento;
          }
        );
      },
      ( error: any) => {
        console.error('Erro ao excluir instrumento:', error);
      }
    );
  }

}

