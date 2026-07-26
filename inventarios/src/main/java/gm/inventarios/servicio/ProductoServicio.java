package gm.inventarios.servicio;

import gm.inventarios.modelo.Producto;
import gm.inventarios.repositorio.ProductoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ProductoServicio implements IProductoServicio{

    private final ProductoRepositorio productoRepositorio;

    public  ProductoServicio(ProductoRepositorio productoRepositorio){
        this.productoRepositorio = productoRepositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProducto(){
        //equivalente a una consulta en sql : SELECT * FROM producto;
        return productoRepositorio.findAll();
    }

    @Override
    //solo va leer
    @Transactional(readOnly = true)
    public Producto buscarProductoXId(Integer idProducto){
        return productoRepositorio.findById(idProducto).orElse(null);
    }

    @Override
    public  Producto  guardarProducto(Producto producto){
        return productoRepositorio.save(producto);
    }

    @Override
    public  void  eliminarProductoXId(Integer idProducto){
        if (!productoRepositorio.existsById(idProducto)){
            throw  new NoSuchElementException("No existe producto con id: " + idProducto);
        }
        productoRepositorio.deleteById(idProducto);
    }
}
