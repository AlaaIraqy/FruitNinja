package View;
import javafx.application.Application;
import javafx.stage.Stage;

public  class Main extends Application{


	@Override
	public void start(Stage primaryStage) throws Exception {
		   
		MainMenu mainmenu = new MainMenu(primaryStage);
		NewGame newGame = new NewGame(primaryStage);
		ClassicMode classicGame = new ClassicMode(primaryStage);
		GameGui gamegui = new GameGui(primaryStage);
		
		mainmenu.setNewGame(newGame);
		newGame.SetMainMenu(mainmenu);
		newGame.SetArcadeGame(classicGame);
		classicGame.SetNewGame(newGame);
		
		gamegui.setClassicMode(classicGame);
		classicGame.setGamegui(gamegui);
		
		mainmenu.PrepareScene();
		
	
		
		primaryStage.setScene(mainmenu.getScene());
		primaryStage.show();
		
		
	}
	
	public static void main(String[]args) {
		launch(args);
	}



	
	
	
}
