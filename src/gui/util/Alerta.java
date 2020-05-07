package gui.util;
/**
 * Classe utilitaria chamada alerts
 */
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerta {
	/**
	 * Fun��o static para gera o Alert
	 * @param title
	 * @param header
	 * @param content
	 * @param type
	 */
	public static void showAlert(String title, String header, String content, AlertType type) {
		Alert alert = new Alert(type);//Instanciando Alert
		alert.setTitle(title);//Titulo
		alert.setHeaderText(header);//Cabe�alho	
		alert.setContentText(content);//Conteudo
		alert.show();//Mostrar Alerta
		
	}
}