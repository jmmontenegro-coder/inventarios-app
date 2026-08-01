import { Routes } from '@angular/router';
import { ProductoLista } from './producto-lista/producto-lista';

export const routes: Routes = [
    { path: 'productos', component: ProductoLista },
    {path: '', redirectTo: '/productos', pathMatch: 'full'}
];
