/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author maxni
 */
public class Alcantarillado {
    
    private StringProperty cod_permiso;
    private Año año;
    private IntegerProperty personasAlcantarillado;
    private Proyecto proyecto;
    private StringProperty nombre;
    private StringProperty expediente;
    private StringProperty codigoCat;
    private StringProperty direccion;
    private Urbanizacion urbanizacion;
    private StringProperty dni;
    private Date fecha;
    private StringProperty manzana;
    private StringProperty lote;
    private StringProperty tiempoVigencia;
    private StringProperty descripcion;
    private Autorizacion_Proceso autorizacion_proceso;
    
    
    String SQL1=null,SQL2=null;

    public Alcantarillado(String cod_permiso, Año año, int personasAlcantarillado, 
        Proyecto proyecto, String nombre, String expediente, String codigoCat, 
        String direccion, Urbanizacion urbanizacion, String dni, Date fecha, 
        String manzana, String lote, String tiempoVigencia, String descripcion, 
        Autorizacion_Proceso autorizacion_proceso)
    {
        this.cod_permiso = new SimpleStringProperty(cod_permiso);
        this.año = año;
        this.personasAlcantarillado = new SimpleIntegerProperty(personasAlcantarillado);
        this.proyecto = proyecto;
        this.nombre = new SimpleStringProperty(nombre);
        this.expediente = new SimpleStringProperty(expediente);
        this.codigoCat = new SimpleStringProperty(codigoCat);
        this.direccion = new SimpleStringProperty(direccion);
        this.urbanizacion = urbanizacion;
        this.dni = new SimpleStringProperty(dni);
        this.fecha = fecha;
        this.manzana = new SimpleStringProperty(manzana);
        this.lote = new SimpleStringProperty(lote);
        this.tiempoVigencia = new SimpleStringProperty(tiempoVigencia);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.autorizacion_proceso = autorizacion_proceso;
    }

	//Metodos atributo: cod_permiso
    public String getCod_permiso() {
            return cod_permiso.get();
    }
    public void setCod_permiso(String cod_permiso) {
            this.cod_permiso = new SimpleStringProperty(cod_permiso);
    }
    public StringProperty Cod_permisoProperty() {
            return cod_permiso;
    }
    //Metodos atributo: año
    public Año getAño() {
            return año;
    }
    public void setAño(Año año) {
            this.año = año;
    }
    //Metodos atributo: personasAlcantarillado
    public int getPersonasAlcantarillado() {
            return personasAlcantarillado.get();
    }
    public void setPersonasAlcantarillado(int personasAlcantarillado) {
            this.personasAlcantarillado = new SimpleIntegerProperty(personasAlcantarillado);
    }
    public IntegerProperty PersonasAlcantarilladoProperty() {
            return personasAlcantarillado;
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
    public String getDni() {
            return dni.get();
    }
    public void setDni(String dni) {
            this.dni = new SimpleStringProperty(dni);
    }
    public StringProperty DniProperty() {
            return dni;
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
    
   public int guargarRegistro(Connection connection){
       SQL1 = "INSERT INTO personas (proyecto, nombre, expediente, codigoCat, direccion, "
               + "urbanizacion, dni, fecha, manzana, lote, tiempoVigencia, descripcion,"
               + " Autorizacion_proceso) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
       
       SQL2 = "INSERT INTO alcantarillado (cod_permiso, id_año, personasAlcantarillado) "
               + "VALUES (?, ?, (SELECT idpersona FROM personas ORDER BY idpersona DESC LIMIT 1))";
        try {
            PreparedStatement instruccion1 = connection.prepareStatement(SQL1);
            PreparedStatement instruccion2 = connection.prepareStatement(SQL2);
            
            instruccion1.setInt(1, proyecto.getId_proyecto());
            instruccion1.setString(2, nombre.get());
            instruccion1.setString(3, expediente.get());
            instruccion1.setString(4, codigoCat.get());
            instruccion1.setString(5, direccion.get());
            instruccion1.setInt(6, urbanizacion.getId_urbanizacion());
            instruccion1.setString(7, dni.get());
            instruccion1.setDate(8, fecha);
            instruccion1.setString(9, manzana.get());
            instruccion1.setString(10, lote.get());
            instruccion1.setString(11, tiempoVigencia.get());
            instruccion1.setString(12, descripcion.get());
            instruccion1.setInt(13, autorizacion_proceso.getIdAutorizacion_proceso());
            
            instruccion2.setString(1, cod_permiso.get());
            instruccion2.setInt(2, año.getId_año());
            
            int n = instruccion1.executeUpdate();
            if (n == 1) {
                int n2 = instruccion2.executeUpdate();
                if (n2 == 1) {
                    return n2;
                }else{
                    return 0;
                }
            } else {
                return 0;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Alcantarillado.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en la clase Modelo.Alcantarillado.guargarRegistro()");
            return 0;
        }
   }
   
   public int editarRegistro(Connection connection, String codigo, String idYear){
        
    SQL1 =  "    UPDATE personas" +
            "            SET proyecto = ?," +
            "            nombre = ?," +
            "            expediente = ?," +
            "            codigoCat = ?," +
            "            direccion = ?," +
            "            urbanizacion = ?," +
            "            DNI = ?," +
            "            fecha = ?," +
            "            manzana = ?, " +
            "            lote = ?," +
            "            tiempovigencia = ?," +
            "            descripcion = ?," +
            "            Autorizacion_proceso = ?" +
            "    WHERE idpersona = (select personasAlcantarillado" +
            "                        from alcantarillado A " +
            "                        INNER JOIN año B ON (A.id_año = B.id_año)" +
            "                        where A.cod_permiso = '"+codigo+"'" +
            "                        and B.año = '"+idYear+"')";
       
      
       
        try {
            PreparedStatement instruccion1 = connection.prepareStatement(SQL1);
           
            instruccion1.setInt(1, proyecto.getId_proyecto());
            instruccion1.setString(2, nombre.get());
            instruccion1.setString(3, expediente.get());
            instruccion1.setString(4, codigoCat.get());
            instruccion1.setString(5, direccion.get());
            instruccion1.setInt(6, urbanizacion.getId_urbanizacion());
            instruccion1.setString(7, dni.get());
            instruccion1.setDate(8, fecha);
            instruccion1.setString(9, manzana.get());
            instruccion1.setString(10, lote.get());
            instruccion1.setString(11, tiempoVigencia.get());
            instruccion1.setString(12, descripcion.get());
            instruccion1.setInt(13, autorizacion_proceso.getIdAutorizacion_proceso());
            
            
            
            int n = instruccion1.executeUpdate();
            if (n == 1) {
               return 1;
            } else {
                return 0;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Alcantarillado.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en la clase Modelo.Alcantarillado.editarRegistro()");
            return 0;
        }
   }
   
   public int eliminarRegistro(Connection connection,String codigo, String year){
       int id_persona = 0;
       SQL1 =
            "    SELECT A.personasAlcantarillado" +
            "    FROM alcantarillado A INNER JOIN año B ON (A.id_año = B.id_año)" +
            "    WHERE A.cod_permiso = '"+codigo+"' AND B.año = '"+year+"' ";
       
       SQL2 = "delete from alcantarillado where cod_permiso = ? and id_año = ?;";
       
       String SQL3 = "delete from personas where idpersona = ?";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(SQL1);
            while (resultado.next()) {                
                id_persona = resultado.getInt("personasAlcantarillado");
            }
            
            PreparedStatement instruccion1 = connection.prepareCall(SQL2);
            PreparedStatement instruccion2 = connection.prepareCall(SQL3);
            
            instruccion1.setString(1, cod_permiso.get());
            instruccion1.setInt(2, año.getId_año());
            
            instruccion2.setInt(1, id_persona);
            
            int n = instruccion1.executeUpdate();
            if (n == 1) {
                int n2 = instruccion2.executeUpdate();
                if (n2 == 1) {
                    return n2;
                }else{
                    return 0;
                }
            } else {
                return 0;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Alcantarillado.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return 0;
            
        }
        
        
   }
   
   public static void llenarInformacion(Connection connection, ObservableList<Alcantarillado> lista){
       String SQL = 
                    " select A.cod_permiso," +
                    "        A.id_año," +
                    "        A.personasAlcantarillado," +
                    "        B.año," +
                    "        C.proyecto," +
                    "        C.nombre," +
                    "        C.expediente," +
                    "        C.codigoCat," +
                    "        C.direccion," +
                    "        C.urbanizacion," +
                    "        C.dni," +
                    "        C.fecha," +
                    "        C.manzana," +
                    "        C.lote," +
                    "        C.tiempovigencia," +
                    "        C.Autorizacion_proceso," +
                    "        C.descripcion," +
                    "        D.tipoProyecto," +
                    "        E.urbanizaciones," +
                    "        F.proceso" +
                    "        from alcantarillado A inner join  año B on (A.id_año = B.id_año) inner join" +
                    "        personas C on (A.personasAlcantarillado = C.idpersona) inner join" +
                    "        proyecto D on (C.proyecto = D.id_proyecto) inner join" +
                    "        urbanizacion E on (C.urbanizacion = E.id_urbanizacion) inner join" +
                    "        autorizacion_proceso F on (C.Autorizacion_proceso = F.idAutorizacion_proceso)";
       
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(SQL);
            
            while (resultado.next()) {                
                lista.add(new Alcantarillado(
                        resultado.getString("cod_permiso"), 
                        new Año(resultado.getInt("id_año"), resultado.getString("año")), 
                        resultado.getInt("personasAlcantarillado"), 
                        new Proyecto(resultado.getInt("proyecto"), resultado.getString("tipoProyecto")), 
                        resultado.getString("nombre"), 
                        resultado.getString("expediente"), 
                        resultado.getString("codigoCat"), 
                        resultado.getString("direccion"), 
                        new Urbanizacion(resultado.getInt("urbanizacion"), resultado.getString("urbanizaciones")), 
                        resultado.getString("dni"), 
                        resultado.getDate("fecha"), 
                        resultado.getString("manzana"), 
                        resultado.getString("lote"), 
                        resultado.getString("tiempoVigencia"), 
                        resultado.getString("descripcion"), 
                        new Autorizacion_Proceso(resultado.getInt("Autorizacion_proceso"), resultado.getString("proceso")))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Alcantarillado.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
   }
   
   public static void llenarInformacionYear(Connection connection, ObservableList<Alcantarillado> lista, String year){
       String SQL = 
                    " select A.cod_permiso," +
                    "        A.id_año," +
                    "        A.personasAlcantarillado," +
                    "        B.año," +
                    "        C.proyecto," +
                    "        C.nombre," +
                    "        C.expediente," +
                    "        C.codigoCat," +
                    "        C.direccion," +
                    "        C.urbanizacion," +
                    "        C.dni," +
                    "        C.fecha," +
                    "        C.manzana," +
                    "        C.lote," +
                    "        C.tiempovigencia," +
                    "        C.Autorizacion_proceso," +
                    "        C.descripcion," +
                    "        D.tipoProyecto," +
                    "        E.urbanizaciones," +
                    "        F.proceso" +
                    "        from alcantarillado A inner join  año B on (A.id_año = B.id_año) inner join" +
                    "        personas C on (A.personasAlcantarillado = C.idpersona) inner join" +
                    "        proyecto D on (C.proyecto = D.id_proyecto) inner join" +
                    "        urbanizacion E on (C.urbanizacion = E.id_urbanizacion) inner join" +
                    "        autorizacion_proceso F on (C.Autorizacion_proceso = F.idAutorizacion_proceso)" +
                    "        WHERE B.año = '"+year+"' ";
       
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(SQL);
            
            while (resultado.next()) {                
                lista.add(new Alcantarillado(
                        resultado.getString("cod_permiso"), 
                        new Año(resultado.getInt("id_año"), resultado.getString("año")), 
                        resultado.getInt("personasAlcantarillado"), 
                        new Proyecto(resultado.getInt("proyecto"), resultado.getString("tipoProyecto")), 
                        resultado.getString("nombre"), 
                        resultado.getString("expediente"), 
                        resultado.getString("codigoCat"), 
                        resultado.getString("direccion"), 
                        new Urbanizacion(resultado.getInt("urbanizacion"), resultado.getString("urbanizaciones")), 
                        resultado.getString("dni"), 
                        resultado.getDate("fecha"), 
                        resultado.getString("manzana"), 
                        resultado.getString("lote"), 
                        resultado.getString("tiempoVigencia"), 
                        resultado.getString("descripcion"), 
                        new Autorizacion_Proceso(resultado.getInt("Autorizacion_proceso"), resultado.getString("proceso")))
                );
            }
            
            System.out.println("ejecucion exitosa en llenarInformacionYear");
        } catch (SQLException ex) {
            Logger.getLogger(Alcantarillado.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
   }

    
   
   //Metodo que sirve para crear los codigos de caga anio 
   public static String codigoPermiso(Connection connection,String year)
   {
        String codigo = "";
        String num1 = "00000";
        String num2 ="";
        String num4 = "";
        int codNumero = 0;
        int mayor = 0;
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(
                    "SELECT A.cod_permiso, " +
                    "            A.id_año," +
                    "            B.año " +
                    "            FROM alcantarillado A INNER JOIN año B on " +
                    "            (A.id_año = B.id_año) where B.año = '"+ year+"' ");
            while (resultado.next()) 
            {
                codigo = resultado.getString("cod_permiso");
                for (int i = 0; i < codigo.length(); i++) 
                {
                    if (codigo.substring(i,i+1).equals("0")) {
                        
                    }else{
                        System.out.println(codigo.substring(i));
                        codNumero = Integer.parseInt(codigo.substring(i));
                        if (codNumero > mayor) {
                            mayor = codNumero;
                        }
                        break;
                    }
                }
                
            }
            int mayorNumero = mayor +1;
                
                num2 = mayorNumero+"";
                int tamaño1 = num1.length();
                int tamaño2 = num2.length();
                String num3 = num1.substring(0, tamaño1-tamaño2);
                 num4 = num3+num2;

                System.out.println(num4);
            return num4;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
   }
}


