package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {
	/**
	 * Atributo
	 */
	private static Scene mainScene;

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));// Instanciando o FXMLLoader passando o aminho da MainView
			ScrollPane scrollPane = loader.load();	
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			
			mainScene = new Scene(scrollPane);// Criação do objeto Scene, que é a cena principal
			primaryStage.setScene(mainScene);// Palco da cena ira setar a sena como principal
			primaryStage.setTitle("Nasc01");// Passando um titulo para esse palco
			primaryStage.show();// Mostra o palco
			primaryStage.setResizable(false);// faz com que a janela fique fixa
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Boa pratica, quando é privado criar get e set
	 * @return mainScene
	 */
	public static Scene getMainScene() {
		return mainScene;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
