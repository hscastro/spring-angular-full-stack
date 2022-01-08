import { Injectable } from '@angular/core';
import { Cliente } from './clientes/cliente';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  private http: HttpClient


  constructor(http: HttpClient ) {
     this.http = http
  }


  public salvar(cliente: Cliente ) : Observable<Cliente> {
      return this.http.post<Cliente>('http://localhost:8080/api/clientes', cliente);
  }

  public atualizar(cliente: Cliente ) : Observable<any> {
    return this.http.put<Cliente>(`http://localhost:8080/api/clientes/${cliente.id}`, cliente);
  }

  getClientes() : Observable<Cliente[]> {
    return this.http.get<Cliente[]>('http://localhost:8080/api/clientes');
  }

  getCliente(id: number) : Observable<Cliente> {
    return this.http.get<any>(`http://localhost:8080/api/clientes/${id}`);
  }
}
