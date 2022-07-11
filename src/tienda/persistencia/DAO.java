/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Juan
 */
public abstract class DAO {

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    protected void ConectarBase() throws ClassNotFoundException, SQLException {

        try {
            Class.forName(DRIVER);
            String urlBaseDedatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection( urlBaseDedatos, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    protected void DesconectarBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    protected void insertModificarElim(String sql) throws Exception{
        try {
            ConectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);

        } catch (SQLException | ClassNotFoundException ex) {
            conexion.rollback();
            /*  Descomentar la linea anterior si desean tener en cuenta el rollback.
                Correr el siguiente script en Workbench
            
                SET autocommit=1;
                COMMIT;
            
                **Sin rollback igual anda */
            throw ex;
        } finally{
            DesconectarBase();
        }
    }
    
    protected void consultarBase(String sql) throws Exception{
        try {
            ConectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
