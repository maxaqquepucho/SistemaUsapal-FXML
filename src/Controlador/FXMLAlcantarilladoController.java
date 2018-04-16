/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alcantarillado;
import Modelo.Autorizacion_Proceso;
import Modelo.Año;
import Modelo.Conexion;
import Modelo.Proyecto;
import Modelo.Urbanizacion;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Date;
import java.time.format.FormatStyle;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.LocalDateStringConverter;

/**
 * FXML Controller class
 *
 * @author maxni
 */
public class FXMLAlcantarilladoController implements Initializable {
    //Componetes GUI
    @FXML private Label labelCodPermiso;
    @FXML private JFXTextField textNombre;
    @FXML private JFXTextField textExpediente;
    @FXML private JFXTextField textCodigoCat;
    @FXML private JFXTextField textDireccion;
    @FXML private JFXTextField textDNI;
    @FXML private JFXDatePicker datePickerFecha;
    @FXML private JFXTextField textManzana;
    @FXML private JFXTextField textLote;
    @FXML private JFXTextField textBuscar;
    @FXML private TextArea textDescripcion;
    @FXML private ComboBox<Urbanizacion> cmbUrbanizaciones;
    @FXML private ComboBox<Proyecto> cmbProyectos;
    @FXML private ComboBox<Autorizacion_Proceso> cmbAutorizacionProcesos;
    @FXML private ComboBox<Año> cmbAño;
    @FXML private TableView<Alcantarillado> tablaAlcantarillado;
    @FXML private JFXButton botonAgregar;
    @FXML private JFXButton botonEditar;
    @FXML private JFXButton botonEliminar;
    @FXML private JFXButton botonLimpiar;
    
    
    
    //Columnas de la tablaAlcantarillado
    @FXML private TableColumn<Alcantarillado, Number> columnaCodigoPermiso;
    @FXML private TableColumn<Alcantarillado, Proyecto> columnaProyecto;
    @FXML private TableColumn<Alcantarillado, String> columnaNombre;
    @FXML private TableColumn<Alcantarillado, String> columnaExpediente;
    @FXML private TableColumn<Alcantarillado, String> columnaCodigoCat;
    @FXML private TableColumn<Alcantarillado, String> columnaDireccion;
    @FXML private TableColumn<Alcantarillado, Urbanizacion> columnaUrbanizacion;
    @FXML private TableColumn<Alcantarillado, String> columnaDni;
    @FXML private TableColumn<Alcantarillado, Date> columnaFecha;
    @FXML private TableColumn<Alcantarillado, String> columnaManzana;
    @FXML private TableColumn<Alcantarillado, String> columnaLote;
    @FXML private TableColumn<Alcantarillado, String> columnaDescripcion;
    @FXML private TableColumn<Alcantarillado, Autorizacion_Proceso> columnaAutorizacionProceso;
    
    
    
    //Colecciones
    private ObservableList<Urbanizacion> listaUrbanizaciones;
    private ObservableList<Proyecto> listaProyectos;
    private ObservableList<Autorizacion_Proceso> listaAutorizaciones;
    private ObservableList<Año> listaAños;
    private ObservableList<Alcantarillado> listaAlcantarillado;
    private ObservableList<Alcantarillado> listaAlcantarilladoYear;
    private Conexion conexion;
    int clickComboBox = 0;
    FilteredList<Alcantarillado> filtrarDatos;
    SortedList<Alcantarillado> ordenandoDatos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conexion = new Conexion();
        conexion.establecerConexion();
        
        datePickerFecha.setConverter(new LocalDateStringConverter(FormatStyle.FULL));
        
        //Inicializar Listas
        listaUrbanizaciones = FXCollections.observableArrayList();
        listaProyectos = FXCollections.observableArrayList();
        listaAutorizaciones = FXCollections.observableArrayList();
        listaAños = FXCollections.observableArrayList();
        listaAlcantarillado = FXCollections.observableArrayList();
        listaAlcantarilladoYear = FXCollections.observableArrayList();
        //Llenar listas
        Urbanizacion.llegarInformacion(conexion.getConnection(), listaUrbanizaciones);
        Proyecto.llenarInformacion(conexion.getConnection(), listaProyectos);
        Autorizacion_Proceso.llenarInformacion(conexion.getConnection(), listaAutorizaciones);
        Año.llenarInformacion(conexion.getConnection(), listaAños);
        Alcantarillado.llenarInformacion(conexion.getConnection(), listaAlcantarillado);
    
        //Enlazar listas ComboBox
        cmbUrbanizaciones.setItems(listaUrbanizaciones);
        cmbProyectos.setItems(listaProyectos);
        cmbAutorizacionProcesos.setItems(listaAutorizaciones);
        cmbAño.setItems(listaAños);
        tablaAlcantarillado.setItems(listaAlcantarillado);
        
        //Enlazar ComboBox para que sea autocompletable
        ComboBoxAutoComplete<Urbanizacion> comboBoxAutoComplete = new ComboBoxAutoComplete<>(cmbUrbanizaciones);
        
        //Enlazar columnas con atributos
        columnaCodigoPermiso.setCellValueFactory(new PropertyValueFactory<> ("cod_permiso"));
        columnaProyecto.setCellValueFactory(new PropertyValueFactory<>("proyecto"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaExpediente.setCellValueFactory(new PropertyValueFactory<>("expediente"));
        columnaCodigoCat.setCellValueFactory(new PropertyValueFactory<>("codigoCat"));
        columnaDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        columnaUrbanizacion.setCellValueFactory(new PropertyValueFactory<>("urbanizacion"));
        columnaDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columnaManzana.setCellValueFactory(new PropertyValueFactory<>("manzana"));
        columnaLote.setCellValueFactory(new PropertyValueFactory<>("lote"));
        columnaDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        columnaAutorizacionProceso.setCellValueFactory(new PropertyValueFactory<>("Autorizacion_proceso"));
        gestionarEventos();
            
        buscarElementos();
        
        filtrarDatos = new FilteredList<>(listaAlcantarillado,p -> true);
            ordenandoDatos = new SortedList<>(filtrarDatos);
            ordenandoDatos.comparatorProperty().bind(tablaAlcantarillado.comparatorProperty());
            tablaAlcantarillado.setItems(ordenandoDatos);
        conexion.cerrarConexion();
    }
    
    public void gestionarEventos(){
        clickComboBox = 1;
        tablaAlcantarillado.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Alcantarillado>() {
            @Override
            public void changed(ObservableValue<? extends Alcantarillado> observable, Alcantarillado valorAnterior, Alcantarillado valorSeleccionado) {
                //To change body of generated methods, choose Tools | Templates.
                if (valorSeleccionado != null) {
                    labelCodPermiso.setText(valorSeleccionado.getCod_permiso());
                    cmbProyectos.setValue(valorSeleccionado.getProyecto());
                    textNombre.setText(valorSeleccionado.getNombre());
                    textExpediente.setText(valorSeleccionado.getExpediente());
                    textCodigoCat.setText(valorSeleccionado.getCodigoCat());
                    textDireccion.setText(valorSeleccionado.getDireccion());
                    cmbUrbanizaciones.setValue(valorSeleccionado.getUrbanizacion());
                    textDNI.setText(valorSeleccionado.getDni());
                    textManzana.setText(valorSeleccionado.getManzana());
                    datePickerFecha.setValue(valorSeleccionado.getFecha().toLocalDate());
                    textLote.setText(valorSeleccionado.getLote());
                    textDescripcion.setText(valorSeleccionado.getDescripcion());
                    cmbAutorizacionProcesos.setValue(valorSeleccionado.getAutorizacion_proceso());
                    cmbAño.setValue(valorSeleccionado.getAño());
                    
                    botonAgregar.setDisable(true);
                    botonEditar.setDisable(false);
                    botonEliminar.setDisable(false);
                    
                }else{
                    System.out.println("Seleccione una fila");
                }
            }
        });
    }

    @FXML
    public void guardarRegistro(){
        conexion.establecerConexion();
        
        
        Alcantarillado a = new Alcantarillado(
        // estas dos lineas de codigo son el primer parametro de constructor Alcantarillado.
                      /**/  Alcantarillado.codigoPermiso(conexion.getConnection(),     /**/
                      /**/  cmbAño.getSelectionModel().getSelectedItem().toString()),  /**/ 
                cmbAño.getSelectionModel().getSelectedItem(), 
                0, 
                cmbProyectos.getSelectionModel().getSelectedItem(), 
                textNombre.getText(), 
                textExpediente.getText(), 
                textCodigoCat.getText(), 
                textDireccion.getText(), 
                cmbUrbanizaciones.getSelectionModel().getSelectedItem(), 
                textDNI.getText(), 
                Date.valueOf(datePickerFecha.getValue()), 
                textManzana.getText(), 
                textLote.getText(), 
                tiempoVigenciaFecha(), 
                textDescripcion.getText(), 
                cmbAutorizacionProcesos.getSelectionModel().getSelectedItem()
        );
        
        int resultado = a.guargarRegistro(conexion.getConnection());
        if (resultado == 1) {
            System.out.println("Se guardo Exitosamente el registro");
            
            listaAlcantarilladoYear.add(a);
            //JDK 8u>40
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("REGISTRO AGREGADO");
            mensaje.setContentText("El registro ha sido guardado exitosamente");
            mensaje.setHeaderText("Resultados");
            mensaje.show();
            limpiarComponentes();
        }else {
            System.out.println("No se pudo editar el registro");
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("ERROR AL GUARDAR");
            mensaje.setContentText("El registro no se pudo guardar satisfactoriamente");
            mensaje.setHeaderText("Resultados");
            mensaje.show();
        }
        conexion.cerrarConexion();
    }
    
    @FXML
    public void editarRegistro(){
        Alcantarillado a = new Alcantarillado(
                labelCodPermiso.getText(), 
                cmbAño.getSelectionModel().getSelectedItem(), 
                0, 
                cmbProyectos.getSelectionModel().getSelectedItem(), 
                textNombre.getText(), 
                textExpediente.getText(), 
                textCodigoCat.getText(), 
                textDireccion.getText(), 
                cmbUrbanizaciones.getSelectionModel().getSelectedItem(), 
                textDNI.getText(), 
                Date.valueOf(datePickerFecha.getValue()), 
                textManzana.getText(), 
                textLote.getText(), 
                tiempoVigenciaFecha(), 
                textDescripcion.getText(), 
                cmbAutorizacionProcesos.getSelectionModel().getSelectedItem()
        );
        conexion.establecerConexion();
        int resultado = a.editarRegistro( conexion.getConnection(),
                                          labelCodPermiso.getText(),
                                          cmbAño.getSelectionModel().getSelectedItem().toString()
                                        );
        
        if (resultado == 1) {
            listaAlcantarilladoYear.set(tablaAlcantarillado.getSelectionModel().getSelectedIndex(),a);
            System.out.println(cmbAño.getSelectionModel().getSelectedIndex()+1);
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("REGISTRO ACTUALIZADO");
            mensaje.setContentText("El registro ha sido actualizado exitosamente");
            mensaje.setHeaderText("Resultados");
            mensaje.show();
            limpiarComponentes();
        }else {
            System.out.println("No se pudo editar el registro");
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("ERROR AL EDITAR");
            mensaje.setContentText("El registro no se pudo actualizar satisfactoriamente");
            mensaje.setHeaderText("Resultados");
            mensaje.show();
        }
        conexion.cerrarConexion();
    }
    
    @FXML
    public void eliminarRegistro(){
        conexion.establecerConexion();
        int resultado = tablaAlcantarillado.getSelectionModel().getSelectedItem().eliminarRegistro(
                                                                                    conexion.getConnection(), 
                                                                                    labelCodPermiso.getText(),
                                                                                    cmbAño.getSelectionModel().getSelectedItem().toString()
                                                                                    );
        conexion.cerrarConexion();
        if (resultado == 1) {
            listaAlcantarilladoYear.remove(tablaAlcantarillado.getSelectionModel().getSelectedIndex());
            //JDK 8u>40
            Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);
            mensaje.setTitle("REGISTRO ELIMINADO");
            mensaje.setContentText("El registro ha sido eliminado exitosamente");
            mensaje.setHeaderText("Resultados");
            mensaje.show();
            limpiarComponentes();
        }else {
            System.out.println("No se pudo eliminar el registro");
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("ERROR AL ELIMINAR");
            mensaje.setContentText("El registro no se pudo Eliminar satisfactoriamente");
            mensaje.setHeaderText("Resultados");
            mensaje.show();
        }
    }
    
    
    public String tiempoVigenciaFecha(){
        int year;
        String month;
        int mes;
        String mensaje = "";
        
        year = datePickerFecha.getValue().getYear();
        mes = datePickerFecha.getValue().getMonthValue();
       // DayOfWeek day = datePickerFecha.getValue().getDayOfWeek();
      
        switch(mes)
        {
                case 1: month = "junio";
                         mensaje = "Autorización Vigente hasta "+month+" del "+ year; break;
                case 2: month = "julio";
                         mensaje = "Autorización Vigente hasta "+month+" del "+ year; break;
                case 3: month = "agosto";
                         mensaje = "Autorización Vigente hasta "+month+" del "+ year; break;
                case 4: month = "setiembre";
                         mensaje = "Autorización Vigente hasta "+month+" del "+ year; break;
                case 5: month = "octubre";
                         mensaje = "Autorización Vigente hasta "+month+" del "+ year; break;
                case 06: month = "noviembre";
                         mensaje = "Autorización Vigente hasta "+month+" del "+ year; break;
                case 07: month = "diciembre";
                         mensaje = "Autorización Vigente hasta "+month+" del "+ year; break;
                case 8: month = "enero";
                            year++;
                         mensaje = "Autorización Vigente hasta "+month+" del "+ year; break;
                case 9: month = "febrero";
                        year++;
                         mensaje = "Autorización Vigente hasta "+month+" del "+ year; break;
                case 10: month = "marzo";
                        year++;
                         mensaje = "Autorización Vigente hasta "+month+" del "+ year; break;
                case 11: month = "abril";
                        year++;
                         mensaje = "Autorización Vigente hasta "+month+" del "+ year; break;
                case 12: month = "mayo";
                        year++;
                         mensaje = "Autorización Vigente hasta "+month+" del "+ year; break;
        }
        
        return mensaje;
    }
    
    @FXML
    public void filtrarComboYear(){
            listaAlcantarilladoYear.removeAll(tablaAlcantarillado.getItems());
            System.out.println("item " + cmbAño.getSelectionModel().getSelectedItem().toString());
            System.out.println("Item clicked");
            //llenando informacion por cada anio
            conexion.establecerConexion();
            Alcantarillado.llenarInformacionYear(conexion.getConnection(), 
                                                listaAlcantarilladoYear, 
                                                cmbAño.getSelectionModel().getSelectedItem().toString()
                );
                
            tablaAlcantarillado.setItems(listaAlcantarilladoYear);
            
            filtrarDatos = new FilteredList<>(listaAlcantarilladoYear,p -> true);
            ordenandoDatos = new SortedList<>(filtrarDatos);
            ordenandoDatos.comparatorProperty().bind(tablaAlcantarillado.comparatorProperty());
            tablaAlcantarillado.setItems(ordenandoDatos);
            conexion.cerrarConexion();
            
            
    }
    
    public void buscarElementos(){
        textBuscar.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            filtrarDatos.setPredicate((Alcantarillado personas) ->{
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String name = personas.getNombre().toLowerCase();
                
                return name.contains(newValue.toLowerCase());
                
            });
        });
        
        
    }
    
    @FXML
    public void limpiarComponentes(){
        cmbProyectos.setValue(null);
        textNombre.setText(null);
        textExpediente.setText(null);
        textCodigoCat.setText(null);
        textDireccion.setText(null);
        cmbUrbanizaciones.setValue(null);
        textDNI.setText(null);
        datePickerFecha.setValue(null);
        textManzana.setText(null);
        textLote.setText(null);
        textDescripcion.setText(null);
        cmbAutorizacionProcesos.setValue(null);
        
        //Botones
        botonAgregar.setDisable(false);
        botonEditar.setDisable(true);
        botonEliminar.setDisable(true);
    }
    
    
    @FXML 
    public void itemClick(){
        /*cmbAño.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });*/
        
        /*
        if (clickComboBox == 1) {
            clickComboBox = 0;
            
        } else if (clickComboBox == 0) {
            tablaAlcantarillado.getItems().clear();
            System.out.println("item " + cmbAño.getSelectionModel().getSelectedItem().toString());
            System.out.println("Item clicked");
            //llenando informacion por cada anio
            Alcantarillado.llenarInformacionYear(conexion.getConnection(), 
                                                listaAlcantarilladoYear, 
                                                cmbAño.getSelectionModel().getSelectedItem().toString()
                );
                
                tablaAlcantarillado.setItems(listaAlcantarilladoYear);
                cmbAño.setEditable(false);
        }
        
        
                        //gestionarEventos();*/
                        
    }
}

