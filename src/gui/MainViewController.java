package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {
	/*
	 * Declarando itens de tela que correspondem aos itens do MainView
	 */
	@FXML
	private MenuItem menuItemFuncao;
	@FXML
	private MenuItem menuItemFuncionario;
	@FXML
	private MenuItem menuItemSobre;

	/*
	 * Declaração do metodo menuItemSeller
	 */
	@FXML
	public void onMenuItemFuncaoAction() {
		System.out.println("Funcao");
	}

	/*
	 * Declaração do metodo menuItemDepartment
	 */
	@FXML
	public void onMenuItemFuncionarioAction() {
		System.out.println("Funcionario");
		
	}

	/*
	 * Declaração do metodo menuItemAbout
	 */
	@FXML
	public void onMenuItemSobreAction() {
		loadView("/gui/Sobre.fxml", x -> {
		});
	}

	/**
	 * implements Initializable
	 */
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}

	/**
	 * 
	 * @param <T>
	 * @loader é o nome dado ao FXMLoader
	 * @param absoluteName       = Ao nome da view completo gui/Abou t.fxml
	 * @param initializingAction
	 */
	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();// objeto do tipo VBox com o nome de newVbox recebendo o loader
			/**
			 * Mostandro a view dentro da janela principal
			 */
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());

			T controller = loader.getController();
			initializingAction.accept(controller);

		} catch (IOException e) {
			Alerta.showAlert("IOException", "Erro ao carregar a view", e.getMessage(), AlertType.ERROR);
		}
	}

}
