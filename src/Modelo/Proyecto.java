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
public class Proyecto {
        private IntegerProperty id_proyecto;
	private StringProperty tipoProyecto;

	public Proyecto(int id_proyecto, String tipoProyecto) { 
		this.id_proyecto = new SimpleIntegerProperty(id_proyecto);
		this.tipoProyecto = new SimpleStringProperty(tipoProyecto);
	}

	//Metodos atributo: id_proyecto
	public int getId_proyecto() {
		return id_proyecto.get();
	}
	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = new SimpleIntegerProperty(id_proyecto);
	}
	public IntegerProperty Id_proyectoProperty() {
		return id_proyecto;
	}
	//Metodos atributo: tipoProyecto
	public String getTipoProyecto() {
		return tipoProyecto.get();
	}
	public void setTipoProyecto(String tipoProyecto) {
		this.tipoProyecto = new SimpleStringProperty(tipoProyecto);
	}
	public StringProperty TipoProyectoProperty() {
		return tipoProyecto;
        }
        
        public static void llenarInformacion(Connection connection, ObservableList<Proyecto> lista){
            String SQL = "SELECT * FROM proyecto";
            try {
                Statement statement = connection.createStatement();
                ResultSet resultado = statement.executeQuery(SQL);
                
                while (resultado.next()) {                    
                    lista.add(new Proyecto(resultado.getInt("id_proyecto"),
                                           resultado.getString("tipoProyecto"))
                    );
                }
            } catch (SQLException e) {
                System.out.println("Error en la clse Modelo.Proyecto.llenarInformacion()");
                e.printStackTrace();
            }
        }
        
        @Override
        public String toString(){
            return tipoProyecto.get();
        }
}
