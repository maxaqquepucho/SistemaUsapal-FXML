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
public class Urbanizacion {
    
	private IntegerProperty Id_urbanizacion;
	private StringProperty urbanizaciones;

	public Urbanizacion(int Id_urbanizacion, String urbanizaciones) { 
		this.Id_urbanizacion = new SimpleIntegerProperty(Id_urbanizacion);
		this.urbanizaciones = new SimpleStringProperty(urbanizaciones);
	}

	//Metodos atributo: Id_urbanizacion
	public int getId_urbanizacion() {
		return Id_urbanizacion.get();
	}
	public void setId_urbanizacion(int Id_urbanizacion) {
		this.Id_urbanizacion = new SimpleIntegerProperty(Id_urbanizacion);
	}
	public IntegerProperty Id_urbanizacionProperty() {
		return Id_urbanizacion;
	}
	//Metodos atributo: urbanizaciones
	public String getUrbanizaciones() {
		return urbanizaciones.get();
	}
	public void setUrbanizaciones(String urbanizaciones) {
		this.urbanizaciones = new SimpleStringProperty(urbanizaciones);
	}
	public StringProperty UrbanizacionesProperty() {
		return urbanizaciones;
	}
        
        public static void llegarInformacion(Connection connection, ObservableList<Urbanizacion> lista){
            try {
                String SQL = "SELECT * FROM urbanizacion";
                Statement statement = connection.createStatement();
                ResultSet resultado = statement.executeQuery(SQL);
                
                while (resultado.next()) {                    
                    lista.add(new Urbanizacion(resultado.getInt("id_urbanizacion"), 
                                               resultado.getString("urbanizaciones"))
                    );
                }
                
            } catch (SQLException e) {
                System.out.println("Error en la clase Modelo.Urbanizacion.llegarInformacion()");
                e.printStackTrace();
            }
            
        }
        
        @Override
        public String toString(){
            return urbanizaciones.get();
        }
}
