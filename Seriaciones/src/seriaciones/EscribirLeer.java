package seriaciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */

import java.io.*;
public class EscribirLeer implements Serializable{
    public String mensaje;
    public String leer ="";
    public EscribirLeer(String mensaje){
        this.mensaje = mensaje;
    }
    
    public String Escrbir(){
        String resultado;
        try{
            
           File f = new File("/root/Exploiter/datos.lps");
           FileOutputStream fos = new FileOutputStream(f,true);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(mensaje);
           oos.close();
           
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        resultado = "Mensaje creado";
        return resultado;
        
    }
    public String Leer() throws FileNotFoundException, IOException, ClassNotFoundException{
        String salto ="\n";
        try{
        
        File f = new File("/root/Exploiter/datos.lps");
        if(f.exists()){
            
        FileInputStream fis = new FileInputStream(f);
        while(true)  {
            ObjectInputStream ois = new ObjectInputStream(fis);
             String mensaje = (String) ois.readObject();
                //System.out.println(mensaje);
             leer = "    "+leer +mensaje+salto;   
                 //mensaje="vamos";
            }
        
        }else{
            leer="No se poudo leer el archivo";
        }
        }catch(Exception e) {
            
        }
        System.out.println(leer);
        return leer;   
    }
    
    
}
