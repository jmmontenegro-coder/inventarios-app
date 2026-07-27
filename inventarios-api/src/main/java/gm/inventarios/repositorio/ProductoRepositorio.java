package gm.inventarios.repositorio;

import gm.inventarios.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

//modelo y llave primaria
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
