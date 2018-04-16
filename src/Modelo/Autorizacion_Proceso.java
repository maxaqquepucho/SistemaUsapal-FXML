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
public class Autorizacion_Proceso {
        private IntegerProperty idAutorizacion_proceso;
	private StringProperty proceso;

	public Autorizacion_Proceso(int idAutorizacion_proceso, String proceso) { 
		this.idAutorizacion_proceso = new SimpleIntegerProperty(idAutorizacion_proceso);
		this.proceso = new SimpleStringProperty(proceso);
	}

	//Metodos atributo: idAutorizacion_proceso
	public int getIdAutorizacion_proceso() {
		return idAutorizacion_proceso.get();
	}
	public void setIdAutorizacion_proceso(int idAutorizacion_proceso) {
		this.idAutorizacion_proceso = new SimpleIntegerProperty(idAutorizacion_proceso);
	}
	public IntegerProperty IdAutorizacion_procesoProperty() {
		return idAutorizacion_proceso;
	}
	//Metodos atributo: proceso
	public String getProceso() {
		return proceso.get();
	}
	public void setProceso(String proceso) {
		this.proceso = new SimpleStringProperty(proceso);
	}
	public StringProperty ProcesoProperty() {
		return proceso;
	}
        
        public static void llenarInformacion(Connection connection, ObservableList<Autorizacion_Proceso> lista){
            String SQL = "SELECT * FROM Autorizacion_proceso";
            try {
                Statement statement = connection.createStatement();
                ResultSet resultado = statement.executeQuery(SQL);
                while (resultado.next()) {                    
                    lista.add(new Autorizacion_Proceso(resultado.getInt("idAutorizacion_proceso"), 
                                                       resultado.getString("proceso"))
                    );
                }
            } catch (SQLException e) {
                System.out.println("Error en la Clase Modelo.Autorizacion_Proceso.llenarInformacion()");
                e.printStackTrace();
            }
        }
        
        @Override
        public String toString(){
            return proceso.get();
        }
}
