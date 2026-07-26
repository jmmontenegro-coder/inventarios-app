package gm.inventarios.controlador;

import gm.inventarios.modelo.Producto;
import gm.inventarios.servicio.IProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario-app")
@CrossOrigin(origins = "http://localhost:4200") // conexion desde angular
public class ProductoControlador {

    private final IProductoServicio productoServicio;

    private  static  final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    public ProductoControlador(IProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    //Listar todos los productos
    @GetMapping
    public List<Producto> listarProducto() {
        List<Producto> productos = productoServicio.listarProducto();
        logger.info("Productos obtenidos");
        productos.forEach((producto -> logger.info(producto.toString())));
        return productos;
    }

    //Buscar producto por id
    @GetMapping("/{id}")
    public Producto buscarPorductoXId(@PathVariable Integer id) {
        return productoServicio.buscarProductoXId(id);
    }

    //Crear Producto
    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto){
        return productoServicio.guardarProducto(producto);
    }

    //Actualizar un producto existente
    @PutMapping("/{id}")
    public  Producto actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto){
        producto.setIdProducto(id);
        return productoServicio.guardarProducto(producto);
    }

    //Eliminar prodcuto por id
    @DeleteMapping("/{id}")
    public  void EliminarProducto(@PathVariable Integer id){
        productoServicio.eliminarProductoXId(id);
    }
}
