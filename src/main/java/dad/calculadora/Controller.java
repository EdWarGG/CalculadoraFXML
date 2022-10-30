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
	Calculadora model = new Calculadora();
	
	public static final char IGUAL = '='; 
	public static final char SUMAR = '+'; 
	public static final char RESTAR = '-'; 
	public static final char DIVIDIR = '/'; 
	public static final char MULTIPLICAR = '*';
	
	private static final char COMA = '.'; 
	
	private Double operando;
	private char operador;
	private Boolean nuevoOperando;
	
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
	 
	 @FXML
	    void onBorrarAction(ActionEvent event) {
		 operando = 0.0;
			operador = '=';
			onBorrarTodoAction(event);
	    }

	    @FXML
	    void onBorrarTodoAction(ActionEvent event) {
	    	nuevoOperando = true;
			pantalla.setText("0.0");
	    }

	    
	    @FXML
	    void onInsertarAction(ActionEvent event) {
		    insertar(((Button) event.getSource()).getText().charAt(0));
	    }
	    public void insertar(char digito) {
			if (digito >= '0' && digito <= '9') {
				if (nuevoOperando) {
					nuevoOperando = false;
					pantalla.setText("");;
				}
				pantalla.setText(pantalla.getText().concat(String.valueOf(digito)));
			} else if (digito == COMA) {
				insertarComa(COMA);
			}
		}

	    @FXML
	    void onInsertarComaAction(ActionEvent event) {
	    	insertarComa(((Button) event.getSource()).getText().charAt(0));

	    }
	    private void insertarComa(char coma) {
	    	if (!pantalla.getText().contains("" + COMA)) {
				pantalla.setText(pantalla.getText() + COMA);
			}
	    }


	    @FXML
	    void onOperarAction(ActionEvent event) {
		    operar(((Button) event.getSource()).getText().charAt(0));

	    }
	    public void operar(char operador) {
			nuevoOperando = true;
			double operando2 = Double.parseDouble(pantalla.getText());
			switch (this.operador) {
				case SUMAR: operando += operando2; break;
				case RESTAR: operando -= operando2; break;
				case MULTIPLICAR: operando *= operando2; break;
				case DIVIDIR: operando /= operando2; break;
				case IGUAL: operando = operando2; break;
			}
			this.operador = operador;
			pantalla.setText("" + operando.toString());
		}


}
