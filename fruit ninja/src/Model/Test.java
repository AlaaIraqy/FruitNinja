package Model;

public class Test {
public static void main(String args[]) {
	ENUM[] allDays = ENUM.values();
	 
    for (ENUM day : allDays) {
        System.out.println("Day: " + day);
    }
}
}
