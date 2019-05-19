package Model;

public class SaveGameCommand implements Command {

	
	Save Save;
	 
	 public  SaveGameCommand(Save newSave){

	     this.Save=newSave;
	 }

	     @Override
	     public void execute() {
	         Save.saveProgress();

	     }
	     
}
