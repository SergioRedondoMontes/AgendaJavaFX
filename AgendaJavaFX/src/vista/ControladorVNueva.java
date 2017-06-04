package vista;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorVNueva {
	
	private Main principalStage;
	private ControladorVPrincipal vistaPrincipal;
	
	private Stage ventana;
	@FXML
	private Button btnAceptar;
	@FXML
	private Button btnCancelar;

	@FXML
	private TextField txtNombre;
	
	@FXML
	private TextField txtApellido;
	@FXML
	private TextField txtTelefono;
	
	private String nombre,apellido,telefono;
	
	
	
	public void setStagePrincipal(Stage ventana) {
		this.ventana = ventana;
	}
	
	public void closeWindow(){
		this.ventana.close();
	}
	
	public void nuevaPersona(){

		principalStage.nuevaPersona();		
		
	}

	public Main getPrincipalStage() {
		return principalStage;
	}
	

	public void setPrincipalStage(Main principalStage) {
		this.principalStage = principalStage;
	}

	public void setVistaPrincipal(ControladorVPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
	}

	public TextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(TextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public TextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(TextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public TextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(TextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}
}
