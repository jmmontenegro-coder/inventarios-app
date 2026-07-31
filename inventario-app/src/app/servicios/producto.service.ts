import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from '../model/producto.Model';

@Injectable({
  providedIn: 'root',
})
export class ProductoServicio {
  private urlBase = "http://localhost:8080/inventario-app";

  constructor(private clienteHttp: HttpClient){}

  obtenerProductosLista(): Observable<Producto[]>{
    return this.clienteHttp.get<Producto[]>(this.urlBase);
  }
  
  
}
