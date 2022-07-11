package tienda.servicio;

import java.util.Collection;
import tienda.dominio.Fabricante;
import tienda.persistencia.FabricanteDAO;

public class FabricanteServicio {

    private FabricanteDAO dao;

    public FabricanteServicio() {
        this.dao = new FabricanteDAO();
    }

    public void crearFabricante(int codigo, String nombreFabricante) throws Exception {
        try {
            //Validamos
            if (codigo <= 0) {
                throw new Exception("Debe indicar el codigo");
            }

            if (nombreFabricante == null || nombreFabricante.trim().isEmpty()) {
                throw new Exception("Debe el nombre del fabricante");
            }

            //Creamos el fabricante
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(codigo);
            fabricante.setnombreFabricante(nombreFabricante);

            dao.guardarFabricante(fabricante);

        } catch (Exception e) {
        }
    }

    public Collection<Fabricante> listarFabricantes() throws Exception {

        try {

            Collection<Fabricante> usuarios = dao.listarFabricantes();

            return usuarios;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirFabricantes() throws Exception {

        try {
            //Listamos los usuarios
            Collection<Fabricante> fabricantes = listarFabricantes();

            //Imprimimos los usuarios
            if (fabricantes.isEmpty()) {
                throw new Exception("No existen usuarios para imprimir");
            } else {
                for (Fabricante f : fabricantes) {
                    System.out.println(f);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    
}
