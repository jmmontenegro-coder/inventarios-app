import { Component, Inject, inject } from '@angular/core';
import { Producto } from '../model/producto.Model';
import { ProductoServicio } from '../servicios/producto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-producto-lista',
  imports: [],
  templateUrl: './producto-lista.html'
})
export class ProductoLista {
  productos!: Producto[];

  private productoServicio = inject(ProductoServicio);
  private enrutador = inject(Router);

  ngOnInit(){
    //Cargamos los productos
    this.obtenerProductos();

  }

  private obtenerProductos(): void{
    this.productoServicio.obtenerProductosLista().subscribe({
      next: (datos) => {
        this.productos = datos;
      },
      error: (error) => console.error("Errror al obtener los productos", error)
    });
  }

  editarProducto(id: number){
    this.enrutador.navigate([`editar-producto`, id]);
  }
}
