package Model;

public class SaveGameCommand implements Command {

	
	Save save;
	 
	 public  SaveGameCommand(Save save){

	     this.save=save;
	 }

	     @Override
	     public void execute() {
	         save.saveProgress();

	     }
	     
}
