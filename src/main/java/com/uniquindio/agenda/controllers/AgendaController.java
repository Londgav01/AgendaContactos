/**
 * Sample Skeleton for 'VentanaAgenda.fxml' Controller Class
 */

package com.uniquindio.agenda.controllers;

import com.uniquindio.agenda.models.Agenda;
import com.uniquindio.agenda.models.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AgendaController implements Initializable {

    Agenda agenda = new Agenda("Agenda Contactos");

    @FXML // fx:id="BotonActualizar"
    private Button BotonActualizar; // Value injected by FXMLLoader

    @FXML // fx:id="addGrupos"
    private ChoiceBox<?> addGrupos; // Value injected by FXMLLoader

    @FXML // fx:id="addReuniones"
    private ComboBox<?> addReuniones; // Value injected by FXMLLoader

    @FXML // fx:id="alias"
    private TableColumn<Contacto, String> alias; // Value injected by FXMLLoader

    @FXML // fx:id="botonAdd"
    private Button botonAdd; // Value injected by FXMLLoader

    @FXML // fx:id="botonAddGrupos"
    private Button botonAddGrupos; // Value injected by FXMLLoader

    @FXML // fx:id="botonAgregarReu"
    private Button botonAgregarReu; // Value injected by FXMLLoader

    @FXML // fx:id="contactosEliminar"
    private ChoiceBox<?> contactosEliminar; // Value injected by FXMLLoader

    @FXML // fx:id="direcciones"
    private TableColumn<Contacto, String> direcciones; // Value injected by FXMLLoader

    @FXML // fx:id="eliminarContacto"
    private Button eliminarContacto; // Value injected by FXMLLoader

    @FXML // fx:id="grupos"
    private TableColumn<?, ?> grupos; // Value injected by FXMLLoader

    @FXML // fx:id="listaContAdd"
    private ComboBox<?> listaContAdd; // Value injected by FXMLLoader

    @FXML // fx:id="mails"
    private TableColumn<Contacto, String> mails; // Value injected by FXMLLoader

    @FXML // fx:id="nombres"
    private TableColumn<Contacto, String> nombres; // Value injected by FXMLLoader

    @FXML // fx:id="nuevaDireccionC"
    private TextField nuevaDireccionC; // Value injected by FXMLLoader

    @FXML // fx:id="nuevaReunionC"
    private ComboBox<?> nuevaReunionC; // Value injected by FXMLLoader

    @FXML // fx:id="nuevoAliasC"
    private TextField nuevoAliasC; // Value injected by FXMLLoader

    @FXML // fx:id="nuevoGrupoC"
    private ComboBox<?> nuevoGrupoC; // Value injected by FXMLLoader

    @FXML // fx:id="nuevoMailC"
    private TextField nuevoMailC; // Value injected by FXMLLoader

    @FXML // fx:id="nuevoNombreC"
    private TextField nuevoNombreC; // Value injected by FXMLLoader

    @FXML // fx:id="nuevoTelC"
    private TextField nuevoTelC; // Value injected by FXMLLoader

    @FXML // fx:id="reuniones"
    private TableColumn<?, ?> reuniones; // Value injected by FXMLLoader

    @FXML // fx:id="telefonos"
    private TableColumn<Contacto, String> telefonos; // Value injected by FXMLLoader

    @FXML // fx:id="tabla"
    private TableView<String> tabla; // Value injected by FXMLLoader

    private ObservableList<String> nombresContactos = FXCollections.observableArrayList();
    private ObservableList<String> aliasContactos = FXCollections.observableArrayList();
    private ObservableList<String> telefonosContactos = FXCollections.observableArrayList();
    private ObservableList<String> mailsContactos = FXCollections.observableArrayList();
    private ObservableList<String> direccionContactos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        llenarTabla();
    }

    public void llenarTabla(){
        Contacto[] contactos = Agenda.getListaContactos();

        // Agregar los nombres de los contactos a la lista observable
        for (Contacto c : contactos) {
            nombresContactos.add(c.getNombre());
            aliasContactos.add(c.getAlias());
            telefonosContactos.add(c.getTelefono());
            mailsContactos.add(c.getEmail());
            direccionContactos.add(c.getDireccion());
        }

        // Enlazar la columna con la lista observable de nombres de contactos
        nombres.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        alias.setCellValueFactory(cellData -> cellData.getValue().aliasProperty());
        telefonos.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());
        mails.setCellValueFactory(cellData -> cellData.getValue().mailProperty());
        direcciones.setCellValueFactory(cellData -> cellData.getValue().direccionProperty());
        tabla.setItems(nombresContactos);
        tabla.setItems(aliasContactos);
        tabla.setItems(telefonosContactos);
        tabla.setItems(mailsContactos);
        tabla.setItems(direccionContactos);
    }
    @FXML
    void AgregarOtraReunion(ActionEvent event) {

    }

    @FXML
    void actualizarContacto(ActionEvent event) {

    }

    @FXML
    void addNuevoGruposToContact(ActionEvent event) {

    }

    @FXML
    void agregarNuevoContacto(ActionEvent event) {

    }

    @FXML
    void eliminarContacto(ActionEvent event) {

    }


}

