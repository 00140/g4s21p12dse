/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacen;

import com.google.gson.Gson;
import informacion.Datos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ideapad 330
 */
public class Archivo {
    public void agregausuario(Datos datos){
        String cadena;
        cadena = convjson(datos);
        grabar(cadena);
        
    }
    public List<Datos> leerinfo(){
        List<Datos>listadatos=new ArrayList<>();
        String cadena;
        try{
            FileReader archivo = new FileReader("datos.txt");
            BufferedReader br = new BufferedReader(archivo);
            while((cadena = br.readLine())!=null){
                listadatos.add(convDatos(cadena));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return listadatos;
    }
    private void grabar(String cadena){
        try{
            FileWriter archivo = new FileWriter("datos.txt",true);
            BufferedWriter bw = new BufferedWriter(archivo);
            archivo.write(cadena + "\n");
            archivo.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private String convjson(Datos datos){
        String cadena;
        Gson gson = new Gson();
        cadena = gson.toJson(datos);
        return cadena;
    }
    private Datos convDatos(String cadena){
        Datos datos = new Datos();
        Gson gson = new Gson();
        datos = gson.fromJson(cadena, Datos.class);
        return datos;
    }
}
