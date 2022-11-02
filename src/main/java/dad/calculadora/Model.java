package dad.calculadora;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
	
	private StringProperty pantallaProp = new SimpleStringProperty();

	public final StringProperty pantallaProperty() {
		return this.pantallaProp;
	}
	public final String getPantalla() {
		return pantallaProperty().get();
	}
	public void setPantallaProp(String pantallaProp) {
		this.pantallaProperty().set(pantallaProp);
	}
}
