package View;
import javafx.application.Application;
import javafx.stage.Stage;

public  class Main extends Application{


	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Fruit Ninja");   
		MainMenu mainmenu = new MainMenu(primaryStage);
		NewGame newGame = new NewGame(primaryStage);
		ClassicMode classicGame = new ClassicMode(primaryStage);
		GameGui gamegui = new GameGui(primaryStage);
		LoadGui loadgui = new LoadGui(primaryStage);
		Instruction instruction=new Instruction(primaryStage);
		mainmenu.setInstruction(instruction);
		mainmenu.setNewGame(newGame);
		mainmenu.setLoadgui(loadgui);
		newGame.SetMainMenu(mainmenu);
		newGame.SetArcadeGame(classicGame);
		newGame.setGameGui(gamegui);
		classicGame.SetNewGame(newGame);
		loadgui.setGamegui(gamegui);
		loadgui.setMainmenu(mainmenu);
		gamegui.setClassicMode(classicGame);
	     gamegui.setNewgame(newGame);
	     classicGame.setGamegui(gamegui);
		instruction.setMainmenu(mainmenu);
//		instruction.PrepareScene();
		mainmenu.PrepareScene();
		
	
		
		primaryStage.setScene(mainmenu.getScene());
		primaryStage.show();
		
		
	}
	
	public static void main(String[]args) {
		launch(args);
	}



	
	
	
}
