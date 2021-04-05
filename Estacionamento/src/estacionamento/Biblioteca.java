/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estacionamento;

/**
 *
 * @author Vinícius Amirat
 */
public class Biblioteca {
    public static Boolean Disponivel(String s){
        return s == null;
    }
    
    public static void separador(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    public static int pesquisa(String placa1, String placa2){
        int total = 0;
        if (placa1 == null ? placa2 == null : placa1.equals(placa2)){
            total++;
        }
        return total;
    }
}
