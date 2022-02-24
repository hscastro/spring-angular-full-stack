import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { ServicoPrestado } from './servico-prestado/servicoPrestado';

@Injectable({
  providedIn: 'root'
})
export class ServicoPrestadoService {

  apiURL: string = environment.apiURLBase + '/api/service-prestados';   
  
  constructor(private http: HttpClient) { }

  salvar(serviceoPrestado: ServicoPrestado){
    return this.http.post(this.apiURL, serviceoPrestado);
  }

}
