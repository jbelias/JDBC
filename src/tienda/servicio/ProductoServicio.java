package tienda.servicio;

import java.util.Collection;
import java.util.Scanner;
import tienda.dominio.Producto;
import tienda.persistencia.DAO;
import tienda.persistencia.ProductoDAO;

public class ProductoServicio {

    private ProductoDAO dao;
    DAO d = new DAO() {
    };

    public ProductoServicio() {
        this.dao = new ProductoDAO();
    }

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void crearProducto(int codigo, String nombre, Double precio, int codigoFabricante) throws Exception {
        try {
            //Validamos
            if (codigo <= 0) {
                throw new Exception("Debe indicar el codigo");
            }

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe el nombre del fabricante");
            }

            if (precio <= 0) {
                throw new Exception("Debe indicar el precio");
            }

            if (codigoFabricante <= 0) {
                throw new Exception("Debe indicar el codigo");
            }
            //Creamos el producto
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);

            dao.guardarProducto(producto);

        } catch (Exception e) {
        }
    }

    public Collection<Producto> listarProductos() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductos() throws Exception {

        try {
            //Listamos los productos
            Collection<Producto> productos = listarProductos();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirNomYPrecios() throws Exception {

        try {
            //Listamos los productos
            Collection<Producto> productos = dao.traerNombresYPrecios();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void prodEntre120y202() throws Exception {

        try {
            //Listamos los productos
            Collection<Producto> productos = dao.productosPrecio120y202();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listarPortatiles() throws Exception {

        try {
            //Listamos los productos
            Collection<Producto> productos = dao.listarPortatiles();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void prodMasBarato() throws Exception {

        try {
            //Listamos los productos
            Collection<Producto> productos = dao.prodBarato();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Producto buscarProductoPorCodigo(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            Producto producto = dao.buscarProductoPorCodigo(codigo);
            //Verificamos
            if (producto == null) {
                throw new Exception("No se econtró mascota para el correo electrónico indicado");
            }

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    
    public void modificarProducto(int codigo, String nombre, Double precio, int codigoFabricante) throws Exception {

        try {

            //Validamos
            if (codigo > 0)  {
                throw new Exception("Debe indicar el codigo");
            }

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            if (precio > 0) {
                throw new Exception("Debe indicar el precio");
            }

            if (codigoFabricante < 0) {
                throw new Exception("Debe indicar el Codigo del Fabricante");
            }

            //Buscamos
            Producto producto = buscarProductoPorCodigo(codigo);

            dao.modificarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }
//    public void menuProductos(String nombre) throws Exception {
//
//            System.out.println("Elija algunas de las siguientes opciones:");
//            System.out.println("");
//            System.out.println("-------------------MENU---------------------");
//            System.out.println("1) Lista el nombre de todos los productos que hay en la tabla producto.");
//            System.out.println("2) Lista los nombres y los precios de todos los productos de la tabla producto.");
//            System.out.println("3) Listar aquellos productos que su precio esté entre 120 y 202.");
//            System.out.println("4) Buscar y listar todos los Portátiles de la tabla producto. ");
//            System.out.println("5) Listar el nombre y el precio del producto más barato.");
//            System.out.println("6) Ingresar un producto a la base de datos.");
//            System.out.println("7) Ingresar un fabricante a la base de datos.");
//            System.out.println("8) Editar un producto con datos a elección.");
//            
//            int rta = leer.nextInt();
//            switch (rta) {
//                case 1:
//                    imprimirProductos();
//                case 2:
//                    dao.buscarNombresYPrecios(nombre);
//                case 3:
//                    dao.productosPrecio120y202(nombre);
//            }
//    }
//
//  
}
