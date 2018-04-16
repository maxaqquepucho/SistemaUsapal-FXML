/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author maxni
 */
public class Personas {
        private Proyecto proyecto;
	private StringProperty nombre;
	private StringProperty expediente;
	private StringProperty codigoCat;
	private StringProperty direccion;
	private Urbanizacion urbanizacion;
	private StringProperty DNI;
	private Date fecha;
	private StringProperty manzana;
	private StringProperty lote;
	private StringProperty tiempoVigencia;
	private StringProperty descripcion;
	private Autorizacion_Proceso autorizacion_proceso;
	

	public Personas(Proyecto proyecto, String nombre, String expediente, 
                        String codigoCat, String direccion, Urbanizacion urbanizacion, 
                        String DNI, Date fecha, String manzana, 
                        String lote, String tiempoVigencia, String descripcion, 
                        Autorizacion_Proceso autorizacion_proceso)
        { 
		this.proyecto = proyecto;
		this.nombre = new SimpleStringProperty(nombre);
		this.expediente = new SimpleStringProperty(expediente);
		this.codigoCat = new SimpleStringProperty(codigoCat);
		this.direccion = new SimpleStringProperty(direccion);
		this.urbanizacion = urbanizacion;
		this.DNI = new SimpleStringProperty(DNI);
		this.fecha = fecha;
		this.manzana = new SimpleStringProperty(manzana);
		this.lote = new SimpleStringProperty(lote);
		this.tiempoVigencia = new SimpleStringProperty(tiempoVigencia);
		this.descripcion = new SimpleStringProperty(descripcion);
		this.autorizacion_proceso = autorizacion_proceso;
		
	}

	//Metodos atributo: proyecto
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	//Metodos atributo: nombre
	public String getNombre() {
		return nombre.get();
	}
	public void setNombre(String nombre) {
		this.nombre = new SimpleStringProperty(nombre);
	}
	public StringProperty NombreProperty() {
		return nombre;
	}
	//Metodos atributo: expediente
	public String getExpediente() {
		return expediente.get();
	}
	public void setExpediente(String expediente) {
		this.expediente = new SimpleStringProperty(expediente);
	}
	public StringProperty ExpedienteProperty() {
		return expediente;
	}
	//Metodos atributo: codigoCat
	public String getCodigoCat() {
		return codigoCat.get();
	}
	public void setCodigoCat(String codigoCat) {
		this.codigoCat = new SimpleStringProperty(codigoCat);
	}
	public StringProperty CodigoCatProperty() {
		return codigoCat;
	}
	//Metodos atributo: direccion
	public String getDireccion() {
		return direccion.get();
	}
	public void setDireccion(String direccion) {
		this.direccion = new SimpleStringProperty(direccion);
	}
	public StringProperty DireccionProperty() {
		return direccion;
	}
	//Metodos atributo: urbanizacion
	public Urbanizacion getUrbanizacion() {
		return urbanizacion;
	}
	public void setUrbanizacion(Urbanizacion urbanizacion) {
		this.urbanizacion = urbanizacion;
	}
	//Metodos atributo: DNI
	public String getDNI() {
		return DNI.get();
	}
	public void setDNI(String DNI) {
		this.DNI = new SimpleStringProperty(DNI);
	}
	public StringProperty DNIProperty() {
		return DNI;
	}
	//Metodos atributo: fecha
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	//Metodos atributo: manzana
	public String getManzana() {
		return manzana.get();
	}
	public void setManzana(String manzana) {
		this.manzana = new SimpleStringProperty(manzana);
	}
	public StringProperty ManzanaProperty() {
		return manzana;
	}
	//Metodos atributo: lote
	public String getLote() {
		return lote.get();
	}
	public void setLote(String lote) {
		this.lote = new SimpleStringProperty(lote);
	}
	public StringProperty LoteProperty() {
		return lote;
	}
	//Metodos atributo: tiempoVigencia
	public String getTiempoVigencia() {
		return tiempoVigencia.get();
	}
	public void setTiempoVigencia(String tiempoVigencia) {
		this.tiempoVigencia = new SimpleStringProperty(tiempoVigencia);
	}
	public StringProperty TiempoVigenciaProperty() {
		return tiempoVigencia;
	}
	//Metodos atributo: descripcion
	public String getDescripcion() {
		return descripcion.get();
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = new SimpleStringProperty(descripcion);
	}
	public StringProperty DescripcionProperty() {
		return descripcion;
	}
	//Metodos atributo: autorizacion_proceso
	public Autorizacion_Proceso getAutorizacion_proceso() {
		return autorizacion_proceso;
	}
	public void setAutorizacion_proceso(Autorizacion_Proceso autorizacion_proceso) {
		this.autorizacion_proceso = autorizacion_proceso;
	}
	
}
