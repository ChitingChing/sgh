package controllers;

import Dao.Otros;
import entities.Canton;
import entities.Provincia;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import utilidades.ConnectionInfo;
import utilidades.Formularios;
import utilidades.FxDialogs;

import java.io.IOException;


public class InicioController {

    public static ObservableList<Provincia> provincias ;
    public static ObservableList<Canton> cantonesLosRios;
    public static ObservableList<String> estudios;
    public static ObservableList<String> estadoCiviles;

    @FXML
    private Label lblConnectioninfo;

    @FXML
    public void initialize(){
        try {

            Package p = getClass().getPackage();
            String v = p.getImplementationVersion();
            ConnectionInfo connectionInfo = Otros.getInfoConnection();
            String info = "Conexión: " + connectionInfo.dataBaseUrl + " User: " + connectionInfo.getUsername();
            lblConnectioninfo.setText(info + " version " + v);

            cargarDatos();
        }catch (Exception ex){
            FxDialogs.showException("Error","No se ha podido iniciar la aplicacion",ex);
        }
    }

    public void showBusquedaPaciente() throws IOException {
        //Formularios f = new Formularios(this);
        //f.showBusquedaPaciente();
    }

    public void showPaciente()  {
        try {
            Formularios f = new Formularios();
            f.showPaciente();
        }catch (Exception ex){
            FxDialogs.showException("Error","Ha ocurrido un error al abrir el formulario",ex);
        }

    }
    public void showNuevoFichaPrenatal() {
        try {
            Formularios f = new Formularios();
            f.showNuevoFichaPrenatal();
        } catch (Exception ex) {
            FxDialogs.showException("Error", "Ha ocurrido un error al abrir el formulario", ex);
        }
    }

    public void showEmpresa() {
        try {
            Formularios f = new Formularios();
            f.showEmpresa();
        } catch (Exception ex) {
            FxDialogs.showException("Error", "Ha ocurrido un error al abrir el formulario", ex);
        }
    }
    public void showMedicinas() {
        try {
            Formularios f = new Formularios();
            f.showMedicina();
        } catch (Exception ex) {
            FxDialogs.showException("Error", "Ha ocurrido un error al abrir el formulario", ex);
        }
    }

    private void cargarDatos() {
        try {
            provincias = Otros.getProvincias();
            estadoCiviles = Otros.getEstadoCiviles();
            estudios = Otros.getEstudios();
            cantonesLosRios = Otros.getCantones("12");
        } catch (Exception ex) {
            FxDialogs.showException("Error", "No se ha podido iniciar la aplicacion", ex);
        }

    }

}
