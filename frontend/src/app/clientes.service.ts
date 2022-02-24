import { Injectable } from '@angular/core';
import { Cliente } from './clientes/cliente';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  private http: HttpClient

  apiURL: string = environment.apiURLBase + '/api/clientes';

  constructor(http: HttpClient ) {
     this.http = http
  }

  public salvar(cliente: Cliente ) : Observable<Cliente> {
      return this.http.post<Cliente>(`${ this.apiURL }`, cliente);
  }

  public atualizar(cliente: Cliente ) : Observable<any> {
    return this.http.put<Cliente>(`${ this.apiURL }/${cliente.id}`, cliente);
  }

  getClientes() : Observable<Cliente[]> {
    return this.http.get<Cliente[]>(`${ this.apiURL }`);
  }

  getCliente(id: number) : Observable<Cliente> {
    return this.http.get<any>(`${ this.apiURL }/${id}`);
  }

  public excluir(cliente: Cliente ) : Observable<any> {
    return this.http.delete<Cliente>(`${ this.apiURL }/${cliente.id}`);
  }
}
