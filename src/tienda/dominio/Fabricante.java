/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.dominio;

/**
 *
 * @author Juan
 */
public class Fabricante {

    private int codigo;
    private String nombreFabricante;

    public Fabricante() {
    }

    public Fabricante(int codigo, String nombreFabricante) {
        this.codigo = codigo;
        this.nombreFabricante = nombreFabricante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getnombreFabricante() {
        return nombreFabricante;
    }

    public void setnombreFabricante(String nombreFabricante) {
        this.nombreFabricante = nombreFabricante;
    }

    @Override
    public String toString() {
        return "Fabricante{" + "codigo=" + codigo + ", nombre del Fabricante=" + nombreFabricante + '}';
    }
    
    
}
