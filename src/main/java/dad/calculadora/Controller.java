package dad.calculadora;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable{

	//model
	Model model = new Model();
	
	public static final char IGUAL = '='; 
	public static final char SUMAR = '+'; 
	public static final char RESTAR = '-'; 
	public static final char DIVIDIR = '/'; 
	public static final char MULTIPLICAR = '*';
	
	private char operador;
	private Boolean operacionOn;
	private double num1;
	private double num2;
	private double result;

	
	//view
	@FXML
	private GridPane view;
	@FXML
	private TextField pantalla;
	@FXML
	private Button button7, button8, button9, buttonCE, buttonC, button4, button5, button6, buttonMult, buttonDiv;
	@FXML
	private Button button1, button2, button3, buttonMenos, button0, buttonComa, buttonMas, buttonIgual;
	
	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	 public void initialize(URL location, ResourceBundle resources) {  
		 
		//bindings
		model.pantallaProperty().bind(pantalla.textProperty());
	}
	 
	 public GridPane getView() {
	    	return view;
	    }
	 
	 //metodos
	 @FXML
	    void onBorrarAction(ActionEvent event) {
		 	if (pantalla.getText().length() != 0) {
		 		pantalla.setText(pantalla.getText().substring(0, pantalla.getText().length() - 1));
		 	}
	    }

	    @FXML
	    void onBorrarTodoAction(ActionEvent event) {
			pantalla.setText("");
	 		operacionOn = true;

	    }

	    
	    @FXML
	    void onInsertarAction(ActionEvent event) {
	    	pantalla.setText(pantalla.getText() + ((Button) event.getSource()).getText()); 	    	
	 		operacionOn = true;
	    }

	    @FXML
	    void onInsertarComaAction(ActionEvent event) {
	    	pantalla.setText(pantalla.getText() + ((Button) event.getSource()).getText()); 
	 		operacionOn = true;
	    }

	    @FXML
	    void onOperarAction(ActionEvent event) {
	    	if (operacionOn) {
	    		num1 = Double.parseDouble(pantalla.getText());
	    		pantalla.setText("");
	    		operador = ((Button) event.getSource()).getText().charAt(0);
		 		operacionOn = false;
	    	}
	    	
	    }
	    
	    public void onHacerOperacionAction() {
    		num2 = Double.parseDouble(pantalla.getText());

			switch (this.operador) {
				case SUMAR: result = num1 += num2; pantalla.setText("" + result); break;
				case RESTAR: result = num1 -= num2; pantalla.setText("" + result);  break;
				case MULTIPLICAR: result = num1 *= num2; pantalla.setText("" + result);  break;
				case DIVIDIR: result = num1 /= num2; pantalla.setText("" + result);  break;
				case IGUAL: result = num1 = num2; pantalla.setText("" + result);  break;
			}

		}


}
