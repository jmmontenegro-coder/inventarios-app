import { Component, inject } from '@angular/core';
import { Producto } from '../model/producto.Model';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductoServicio } from '../servicios/producto.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar-producto',
  imports: [FormsModule],
  templateUrl: './editar-producto.html',
})
export class EditarProducto {
  id!: number;
  producto: Producto = new Producto();
  private ruta = inject(ActivatedRoute);
  private productoServicio = inject(ProductoServicio);
  private enrutador = inject(Router);

  ngOnInit() {
    this.id = this.ruta.snapshot.params['id'];
    this.productoServicio.obtenerProductoPorId(this.id).subscribe({
      next: (datos) => this.producto = datos,
      error: (error) => console.log("error al obtener producto por id", error)
    });
  }

  onSubmit() {
    this.productoServicio.actualizarProducto(this.id, this.producto).subscribe({
      next: () => this.enrutador.navigate(['/productos']),
      error: (error) => console.error("Error al actualizar producto: ", error)
    });
  }
  guardarProducto(){
    this.productoServicio.editarProducto(this.id, this.producto).subscribe({
      next: (datos) => this.irAListaProductos(),
      error: (error) => console.log("error al editar producto", error)
    });
  }

  irAListaProductos(){
    this.enrutador.navigate(['/productos']);
  }
}
