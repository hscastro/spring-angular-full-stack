import { ClientesService } from './../../clientes.service';
import { Cliente } from './../cliente';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clientes-lista',
  templateUrl: './clientes-lista.component.html',
  styleUrls: ['./clientes-lista.component.css']
})
export class ClientesListaComponent implements OnInit {

  clientes: Cliente[] = [];
  clienteSelecionado: Cliente;
  mensagemSucesso: string;
  mensagemErro: string;

  constructor(
    private service: ClientesService,
    private router: Router) {  }

  ngOnInit() {
    this.service
    .getClientes()
    .subscribe(resposta => this.clientes = resposta );
  }

  novoCadastro(){
    this.router.navigate(['/clientes-form']);
  }

  preparaExclusao(cliente : Cliente){
    this.clienteSelecionado = cliente;
  }

  excluirCliente(){
    this.service.excluir(this.clienteSelecionado)
      .subscribe( response => {
          this.mensagemSucesso = 'Cliente excluído com sucesso!';
          this.ngOnInit();
        },
        erro => this.mensagemErro = 'Ocorreu um erro ao excluir o cliente.')
  }

}
