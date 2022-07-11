package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.dominio.Fabricante;

public final class FabricanteDAO extends DAO {

    public void guardarFabricante(Fabricante fabricante) throws Exception {

        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante");
            }

            //IMPORTANTE: Despues del "INSERT INTO Fabricante" agregar las columnas tal cual salen en la tabla de SQL,
            // de lo contrario agrega a tablas inexistentes
           
            String sql =  "INSERT INTO Fabricante (codigo, nombre)" + "VALUES ( '" 
                    + fabricante.getCodigo() + "' , '" + fabricante.getnombreFabricante() + "' );";

            insertModificarElim(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante que desea modificar");
            }

            String sql = "UPDATE Usuario SET "
                    + "codigo = '" + fabricante.getCodigo() + "' WHERE nombre = '" + fabricante.getnombreFabricante() + "'";

            insertModificarElim(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarFabricante(String nombreFabricante) throws Exception {
        try {

            String sql = "DELETE FROM Fabricante WHERE nombreFabricante = '" + nombreFabricante + "'";

            insertModificarElim(sql);

        } catch (Exception e) {
            throw e;
        } finally {
            DesconectarBase();
        }
    }

    public Fabricante buscarFabricantePorNombre(String nombreFabricante) throws Exception {
        try {
            String sql = "SELECT * FROM Fabricante "
                    + " WHERE nombreFabricante = '" + nombreFabricante + "'";

            consultarBase(sql);

            Fabricante fabricante = null;

            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setnombreFabricante(resultado.getString(2));
            }

            DesconectarBase();
            return fabricante;

        } catch (Exception e) {
            DesconectarBase();
            throw e;
        }
    }
    
    public Collection<Fabricante> listarFabricantes() throws Exception {
        try {
            String sql = "SELECT codigo, nombre FROM Fabricante ";

            consultarBase(sql);

            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();
            
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setnombreFabricante(resultado.getString(2));
                fabricantes.add(fabricante);
            }
            DesconectarBase();
            return fabricantes;
            
        } catch (Exception e) {
            e.printStackTrace();
            DesconectarBase();
            throw new Exception("Error de sistema");
        }
    }
}
