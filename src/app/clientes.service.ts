import { Injectable } from '@angular/core';
import { Cliente } from './clientes/cliente';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor(private http: HttpClient ) { }


  salvar(cliente: Cliente ) : Observable<Cliente> {
      return this.http.post<Cliente>('http://localhost:8080/api/clientes', cliente);
  }

  getClientes() : Cliente {
    let cliente: Cliente = new Cliente();
    cliente.nome = 'Antonio Halyson';
    cliente.cpf = '92873719901';
    
    return cliente;
  }
}
