package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.Persona;
import vista.ControladorVEdicion;
import vista.ControladorVNueva;
import vista.ControladorVPrincipal;


public class Main extends Application {
	
	private static Stage stagePrincipal;
	private AnchorPane rootPane;
	private ControladorVPrincipal controllerVprincipal;
	private ControladorVNueva controllerVnueva;
	private ControladorVEdicion controllerVeditar;
	private int index;
	
	@Override
	public void start(Stage stagePrincipal) throws Exception {
		Main.stagePrincipal = stagePrincipal;
		mostrarVentanaPrincipal();

	}

	/*
	 * En un proyecto JavaFX el main llama al launch que a su vez llama a start
	 */
	public static void main(String[] args) {
		launch(args);

	}

	/*
	 * cargamos la ventana principal
	 */
	public void mostrarVentanaPrincipal() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/vistaPrincipal.fxml"));
			rootPane = (AnchorPane) loader.load();
			Scene scene = new Scene(rootPane);
			stagePrincipal.setTitle("Ventana Principal");
			stagePrincipal.setScene(scene);

			/*
			 * A�adidos las llamadas del main al Controlador y del controlador
			 * al main
			 ***/
			controllerVprincipal = loader.getController();
			controllerVprincipal.setProgramaPrincipal(this);
			controllerVprincipal.setVistaEdicion(controllerVnueva);
			controllerVprincipal.setVistaEdicion2(controllerVeditar);
			stagePrincipal.show();
		} catch (IOException e) {
			// tratar la excepci�n.
		}
	}

	/*
	 * Este m�todo es llamado cuando se presiona el bot�n de la ventana
	 * principal Lo llama el controlador de la vista principal
	 */
	public void mostrarVentanaNueva() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/vistaNueva.fxml"));
			AnchorPane ventanaDos = (AnchorPane) loader.load();
			/* Creamos la segunda ventana como otro stage */
			Stage ventana = new Stage();
			ventana.setTitle("Venta Dos");
			/* Le decimos a la ventana qui�n es la ventana original */
			ventana.initOwner(stagePrincipal);
			Scene scene = new Scene(ventanaDos);
			ventana.setScene(scene);

			controllerVnueva = loader.getController();
			controllerVnueva.setStagePrincipal(ventana);
			controllerVnueva.setVistaPrincipal(controllerVprincipal);
			controllerVnueva.setPrincipalStage(this);
			ventana.show();

		} catch (Exception e) {
			// tratar la excepci�n
		}
	}

	public void mostrarVentanaEdicion() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/vistaEdicion.fxml"));
			AnchorPane ventanaDos = (AnchorPane) loader.load();
			/* Creamos la segunda ventana como otro stage */
			Stage ventana = new Stage();
			ventana.setTitle("Venta Dos");
			/* Le decimos a la ventana qui�n es la ventana original */
			ventana.initOwner(stagePrincipal);
			Scene scene = new Scene(ventanaDos);
			ventana.setScene(scene);

			controllerVeditar = loader.getController();
			controllerVeditar.setStagePrincipal(ventana);
			controllerVeditar.setVistaPrincipal(controllerVprincipal);
			controllerVeditar.setPrincipalStage(this);
			ventana.show();

		} catch (Exception e) {
			// tratar la excepci�n
		}
	}

	public void borrarFila() {
		Persona selectedItem = controllerVprincipal.getListAgenda().getSelectionModel().getSelectedItem();
		controllerVprincipal.getListAgenda().getItems().remove(selectedItem);

	}

	public void nuevaPersona() {
		controllerVprincipal.getData().add(new Persona(controllerVnueva.getTxtNombre().getText(),
				controllerVnueva.getTxtApellido().getText(), controllerVnueva.getTxtTelefono().getText()));
		controllerVprincipal.getListAgenda().setItems(controllerVprincipal.getData());
		controllerVprincipal.getNombre().setCellValueFactory(new PropertyValueFactory<Persona, String>("Nombre"));
		controllerVprincipal.getApellido().setCellValueFactory(new PropertyValueFactory<Persona, String>("Apellido"));
		controllerVprincipal.getTelefono().setCellValueFactory(new PropertyValueFactory<Persona, String>("Telefono"));
		controllerVnueva.closeWindow();
	}

	public void mostrarPersona() {
		Persona persona = controllerVprincipal.getListAgenda().getSelectionModel().getSelectedItem();
		if (persona != null) {
			controllerVeditar.getTxtNombre().setText(persona.getNombre());
			controllerVeditar.getTxtApellido().setText(persona.getApellido());
			controllerVeditar.getTxtTelefono().setText(persona.getTelefono());
		}

	}

	public void editarPersona() {
		index = controllerVprincipal.getListAgenda().getSelectionModel().getSelectedIndex();
		Persona persona = controllerVprincipal.getListAgenda().getSelectionModel().getSelectedItem();
		persona.setNombre(controllerVeditar.getTxtNombre().getText());
		persona.setApellido(controllerVeditar.getTxtApellido().getText());
		persona.setTelefono(controllerVeditar.getTxtTelefono().getText());
		controllerVprincipal.getData().set(index, persona);
		controllerVeditar.closeWindow();
	}
}
