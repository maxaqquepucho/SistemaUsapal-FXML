/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author maxni
 */
public class Año {
    private IntegerProperty id_año;
    private StringProperty año;

    public Año(int id_año, String año) { 
            this.id_año = new SimpleIntegerProperty(id_año);
            this.año = new SimpleStringProperty(año);
    }

    //Metodos atributo: id_año
    public int getId_año() {
            return id_año.get();
    }
    public void setId_año(int id_año) {
            this.id_año = new SimpleIntegerProperty(id_año);
    }
    public IntegerProperty Id_añoProperty() {
            return id_año;
    }
    //Metodos atributo: año
    public String getAño() {
            return año.get();
    }
    public void setAño(String año) {
            this.año = new SimpleStringProperty(año);
    }
    public StringProperty AñoProperty() {
            return año;
    }
    
    public static void llenarInformacion(Connection connection, ObservableList<Año> lista){
        String SQL = "SELECT * FROM año";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(SQL);
            while (resultado.next()) {                
                lista.add(new Año(resultado.getInt("id_año"),
                                  resultado.getString("año"))
                );
            }
        } catch (SQLException e) {
            System.out.println("Error en la Clase Modelo.Año.llenarInformacion()");
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString(){
        return año.get();
    }
}
