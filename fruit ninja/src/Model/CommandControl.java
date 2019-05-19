package Model;

public class CommandControl {

	Command slot;
    public void setCommand(Command command){

        slot=command;
     
    }
    
	public void  buttonWasPressed(){

        slot.execute();

    }

	}


