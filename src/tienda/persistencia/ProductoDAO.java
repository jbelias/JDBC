package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.dominio.Producto;

public final class ProductoDAO extends DAO {

    public void guardarProducto(Producto producto) throws Exception {

        try {
            if (producto == null) {
                throw new Exception("Debe indicar el fabricante");
            }

            //IMPORTANTE: Despues del "INSERT INTO Fabricante" agregar las columnas tal cual salen en la tabla de SQL,
            // de lo contrario agrega a tablas inexistentes
            String sql = "INSERT INTO Producto (codigo, nombre, precio, codigo_fabricante)" + "VALUES ( '"
                    + producto.getCodigo() + "' , '" + producto.getNombre() + "' , '" + producto.getPrecio()
                    + "' , '" + producto.getCodigoFabricante() + "' );";

            insertModificarElim(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }

            String sql = "UPDATE Usuario SET "
                    + "nombre = '" + producto.getNombre() + "' WHERE codigo = '" + producto.getCodigo() + "'";

            insertModificarElim(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProducto(String nombre) throws Exception {
        try {

            String sql = "DELETE FROM Producto WHERE nombre= '" + nombre + "'";

            insertModificarElim(sql);

        } catch (Exception e) {
            throw e;
        } finally {
            DesconectarBase();
        }
    }

    public Producto buscarProductoPorNombre(String nombre) throws Exception {
        try {
            String sql = "SELECT * FROM Producto "
                    + " WHERE nombre = '" + nombre + "'";

            consultarBase(sql);

            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
            }

            DesconectarBase();
            return producto;

        } catch (Exception e) {
            DesconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {
        try {
            String sql = "SELECT * FROM Producto";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));

                productos.add(producto);
            }
            DesconectarBase();
            return productos;

        } catch (Exception e) {
            e.printStackTrace();
            DesconectarBase();
            throw new Exception("Error de sistema");
        }
    }

//a) Lista el nombre de todos los productos que hay en la tabla producto.
    //realizado en funcion listarProductos()
//b) Lista los nombres y los precios de todos los productos de la tabla producto.
    public Collection<Producto> traerNombresYPrecios() throws Exception {
        try {
            String sql = "SELECT nombre, precio" + " FROM Producto";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));

                productos.add(producto);
            }
            DesconectarBase();
            return productos;

        } catch (Exception e) {
            e.printStackTrace();
            DesconectarBase();
            throw new Exception("Error de sistema");
        }
    }
//c) Listar aquellos productos que su precio esté entre 120 y 202.

    public Collection<Producto> productosPrecio120y202() throws Exception {
        try {
            String sql = "SELECT * FROM Producto "
                    + " WHERE precio BETWEEN 120 AND 202 ";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));

                productos.add(producto);
            }
            DesconectarBase();
            return productos;

        } catch (Exception e) {
            e.printStackTrace();
            DesconectarBase();
            throw new Exception("Error de sistema");
        }
    }

//d) Buscar y listar todos los Portátiles de la tabla producto.
    public Collection<Producto> listarPortatiles() throws Exception {
        try {
            String sql = "SELECT * FROM Producto "
                    + " WHERE nombre LIKE '%portatil%'| ";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));

                productos.add(producto);
            }
            DesconectarBase();
            return productos;

        } catch (Exception e) {
            e.printStackTrace();
            DesconectarBase();
            throw new Exception("Error de sistema");
        }
    }

//e) Listar el nombre y el precio del producto más barato.
    public Collection<Producto> prodBarato() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM Producto "
                    + " ORDER BY precio ASC LIMIT 1 ";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));

                productos.add(producto);
            }
            DesconectarBase();
            return productos;

        } catch (Exception e) {
            e.printStackTrace();
            DesconectarBase();
            throw new Exception("Error de sistema");
        }
    }
//f) Ingresar un producto a la base de datos.
    //HECHO EN MAIN

//g) Ingresar un fabricante a la base de datos
    //HECHO EN MAIN

//h) Editar un producto con datos a elección.
    //PRIMERO HACEMOS UN METODO PARA BUSCAR PRODUCTOS POR CODIGO
    public Producto buscarProductoPorCodigo(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM Producto WHERE codigo = " + codigo + "";
            consultarBase(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            
            DesconectarBase();
            return producto;
        } catch (Exception e) {
            DesconectarBase();
            throw e;
        }
    }

}
