/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 
    public boolean isEmail(String email) {
        Pattern pat = null;
        Matcher mat = null;        
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(email);
        if (mat.find()) 
        {
            System.out.println("[" + mat.group() + "]");
            return true;
        }
        else
        {
            return false;
        }        
    }
}
