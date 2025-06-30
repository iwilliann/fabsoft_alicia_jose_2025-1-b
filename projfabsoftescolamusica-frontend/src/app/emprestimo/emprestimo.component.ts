import { Component,ElementRef,ViewChild } from '@angular/core';
import { Emprestimo } from '../model/emprestimo';
import { EmprestimoService } from '../service/emprestimo.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-emprestimo',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './emprestimo.component.html',
  styleUrl: './emprestimo.component.css',
  providers: [EmprestimoService, Router]
})
export class EmprestimoComponent {
  public listaEmprestimos: Emprestimo[] = [];

  @ViewChild('myModal') modalElement!: ElementRef;
    private modal!: bootstrap.Modal;

  private emprestimoSelecionado!: Emprestimo;

  constructor(
    private emprestimoService: EmprestimoService,
    private router: Router
  ) {}

  ngOnInit(): void{
    this.emprestimoService.getEmprestimo().subscribe(resposta => {
      this.listaEmprestimos = resposta;
    })
  }
  novo(){
    this.router.navigate(['/emprestimo/novo']);
  }
  alterar(emprestimo: Emprestimo) {
    this.router.navigate(['/emprestimo/alterar', emprestimo.id]);
  }
  abrirConfirmacao(emprestimo: Emprestimo) {
    this.emprestimoSelecionado = emprestimo;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }
  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.emprestimoService.excluirEmprestimo(this.emprestimoSelecionado.id).subscribe(
      () => {
        this.fecharConfirmacao();
        this.emprestimoService.getEmprestimo().subscribe(
          emprestimo => { //talvez seja a variavel "resposta"
            this.listaEmprestimos = emprestimo;
        }
    );
  },
      error => {
        console.error('Erro ao excluir o empréstimo:', error);
      }
    );
  }
}
