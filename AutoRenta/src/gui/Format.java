/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.text.DecimalFormat;

/**
 *
 * @author Tux
 */
    class Format {

    static String Mxn (double x){

    DecimalFormat MXN = new DecimalFormat("#.##");
    String cant = "$"+MXN.format(x);
    return cant;
    }
    
    static String Folio (int x){
    String formatString = String.format("%010d", x); 
    return formatString;
    }
    
    static String Porcentaje (double x){

    DecimalFormat cent = new DecimalFormat("#.##");
    String cant = cent.format(x)+"%";
    return cant;
    }
    
}
