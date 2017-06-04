package vista;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Persona;

public class ControladorVPrincipal {
	
	private Main mainPrincipal;
	private ControladorVNueva vistaNueva;
	private ControladorVEdicion vistaEdicion;
	

	public void setStagePrincipal(Stage ventana) {
		vistaEdicion.setStagePrincipal(ventana);
	}

	public void closeWindow() {
		vistaEdicion.closeWindow();
	}

	public boolean equals(Object obj) {
		return vistaEdicion.equals(obj);
	}

	public int hashCode() {
		return vistaEdicion.hashCode();
	}

	public void nuevaPersona() {
		vistaEdicion.nuevaPersona();
	}

	public Main getPrincipalStage() {
		return vistaEdicion.getPrincipalStage();
	}

	public void editarPersona() {
		vistaEdicion.editarPersona();
	}



	@FXML
	private TableView<Persona> listAgenda;

	@FXML
	private TableColumn<Persona, String> Nombre;

	@FXML
	private TableColumn<Persona, String> Apellido;

	@FXML
	private TableColumn<Persona, String> Telefono;
	@FXML
	private ObservableList<Persona> data;
	@FXML
	private Button btnNuevo;
	@FXML
	private Button btnEditar;
	@FXML
	private Button btnBorrar;

	public void initialize() {
		data = FXCollections.observableArrayList();
		
	}

	@FXML
	private void nuevaVentana() {
		
		this.mainPrincipal.mostrarVentanaNueva();
	}
	
	@FXML
	private void nuevaVentanaEditar() {
		this.mainPrincipal.mostrarVentanaEdicion();
		this.mainPrincipal.mostrarPersona();
	}
	@FXML
	private void borrarFila() {
		
		
		mainPrincipal.borrarFila();
		
	}
	
	

	public TableView<Persona> getListAgenda() {
		return listAgenda;
	}

	public void setListAgenda(TableView<Persona> listAgenda) {
		this.listAgenda = listAgenda;
	}

	public void setProgramaPrincipal(Main ProgramaPrincipal) {
		this.mainPrincipal = ProgramaPrincipal;
	}

	public void setVistaEdicion(ControladorVNueva vistaNueva) {
		this.vistaNueva = vistaNueva;
	}
	

	public void setVistaEdicion2(ControladorVEdicion vistaEdicion) {
		this.vistaEdicion = vistaEdicion;
	}

	public TableColumn<Persona, String> getNombre() {
		return Nombre;
	}

	public void setNombre(TableColumn<Persona, String> nombre) {
		Nombre = nombre;
	}

	public TableColumn<Persona, String> getApellido() {
		return Apellido;
	}

	public void setApellido(TableColumn<Persona, String> apellido) {
		Apellido = apellido;
	}

	public TableColumn<Persona, String> getTelefono() {
		return Telefono;
	}

	public void setTelefono(TableColumn<Persona, String> telefono) {
		Telefono = telefono;
	}
	
	public ObservableList<Persona> getData() {
		return data;
	}

	public void setData(ObservableList<Persona> data) {
		this.data = data;
	}
	public void setPrincipalStage(Main principalStage) {
		vistaEdicion.setPrincipalStage(principalStage);
	}

	public void setVistaPrincipal(ControladorVPrincipal vistaPrincipal) {
		vistaEdicion.setVistaPrincipal(vistaPrincipal);
	}

	public TextField getTxtNombre() {
		return vistaEdicion.getTxtNombre();
	}

	public void setTxtNombre(TextField txtNombre) {
		vistaEdicion.setTxtNombre(txtNombre);
	}

	public TextField getTxtApellido() {
		return vistaEdicion.getTxtApellido();
	}

	public void setTxtApellido(TextField txtApellido) {
		vistaEdicion.setTxtApellido(txtApellido);
	}

	public TextField getTxtTelefono() {
		return vistaEdicion.getTxtTelefono();
	}

	public void setTxtTelefono(TextField txtTelefono) {
		vistaEdicion.setTxtTelefono(txtTelefono);
	}

	public String toString() {
		return vistaEdicion.toString();
	}
}
