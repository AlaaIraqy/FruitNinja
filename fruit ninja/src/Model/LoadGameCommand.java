package Model;

public class LoadGameCommand implements Command {

	Load Load;
	public  LoadGameCommand(Load newLoad) {
	this.Load=newLoad;
		
	}
	
	
		@Override
		public void execute() {
			Load.loadProgress();
			
		}

	
}
