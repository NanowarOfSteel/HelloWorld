package it.nanowar.ofsteel.helloworld;

public class HelloWorldMainLauncherClass {
	
	public HelloWorldMainLauncherClass() {
		super();
	}

	public static void main (String [] args) {
		System.out.println("Hello World Programmer Start");
		TizioEpicClass tizio = new TizioEpicClass(2);
		tizio.songRefrain();
		System.out.println("Program Finished!");
		tizio.falseMethod();
	}
}