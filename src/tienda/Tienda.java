package tienda;

import java.util.Scanner;
import tienda.persistencia.ProductoDAO;
import tienda.servicio.FabricanteServicio;
import tienda.servicio.ProductoServicio;

public class Tienda {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        FabricanteServicio fs = new FabricanteServicio();
        ProductoServicio ps = new ProductoServicio();
        ProductoDAO pdao = new ProductoDAO();

        //CREACION MENU
        System.out.println("Elija algunas de las siguientes opciones:");
        System.out.println("");

        //OPCIONES
        System.out.println("-------------------MENU---------------------");
        System.out.println("1) Lista el nombre de todos los productos que hay en la tabla producto.");
        System.out.println("2) Lista los nombres y los precios de todos los productos de la tabla producto.");
        System.out.println("3) Listar aquellos productos que su precio esté entre 120 y 202.");
        System.out.println("4) Buscar y listar todos los Portátiles de la tabla producto. ");
        System.out.println("5) Listar el nombre y el precio del producto más barato.");
        System.out.println("6) Ingresar un producto a la base de datos.");
        System.out.println("7) Ingresar un fabricante a la base de datos.");
        System.out.println("8) Editar un producto con datos a elección.");

        System.out.println("INGRESE EL NÚMERO: ");
        //HACEMOS ELEGIR LA OPCION POR TECLADO
        int rta = leer.nextInt();

        //FUNCIONES
        switch (rta) {
            case 1:
                try {
                    ps.listarProductos();
                    ps.imprimirProductos();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                break;
            case 2:
                try {
                    ps.listarProductos();
                    ps.imprimirNomYPrecios();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                break;
            case 3:
                try {
                    ps.listarProductos();
                    ps.prodEntre120y202();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                break;
            case 4:
                try {
                    ps.listarProductos();
                    ps.listarPortatiles();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                break;
            case 5:
                try {
                    ps.listarProductos();
                    ps.prodMasBarato();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                break;
            case 6:
                try {
                    System.out.println("Ingrese los datos en el siguiente orden: Codigo, Nombre, Precio, Código del fabricante");
                    ps.crearProducto(leer.nextInt(), leer.next(), leer.nextDouble(), leer.nextInt());
                    ps.prodMasBarato();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                break;
            case 7:
                try {
                    System.out.println("Ingrese los datos en el siguiente orden: Codigo, Nombre");
                    fs.crearFabricante(10, "Razer");
                    fs.imprimirFabricantes();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                break;
            case 8:
                try {
                    //Modificamos un producto
                    ps.modificarProducto(12, "Monitor Raze 188", 800.00, 23);
                    fs.imprimirFabricantes();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                break;
        }

//creamos fabricante

//        try {
//            fs.crearFabricante(10, "Razer");
//            fs.imprimirFabricantes();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Error del sistema por \n" + e.getMessage());
//        }

    }

}
