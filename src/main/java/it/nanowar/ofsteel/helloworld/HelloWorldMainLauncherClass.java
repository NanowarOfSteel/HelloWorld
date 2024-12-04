package it.nanowar.ofsteel.helloworld;

public class HelloWorldMainLauncherClass {

	private Integer foo;

	public HelloWorldMainLauncherClass(int foo) {
		this.foo = foo;
	}

	public int getFoo() {
		return foo;
	}

	public void songRefrain() {
		printHelloWorldMultipleTimes(foo);
		printHelloWorldMultipleTimesWhile(foo);
	}

	private void printHelloWorldMultipleTimes(int times) {
		for (int i = 0; i < times; i++) {
			System.out.println("Hello World!");
		}
	}

	private void printHelloWorldMultipleTimesWhile(int times) {
		int pippo = 0;
		while (pippo < times) {
			System.out.println("Hello World!");
			pippo++;
		}
	}

	public static void main(String[] args) {
		System.out.println("Hello World Programmer Start");
		HelloWorldMainLauncherClass tizio = new HelloWorldMainLauncherClass(2);
		tizio.songRefrain();
		System.out.println("Program Finished!");
		tizio.falseMethod();
	}

	/**
	 * If I may introduce a bug, the JVM will manage it for me
	 * ensuring both security and portability
	 * Then I'll write my code once, and run it everywhere!
	 * With Static and Strong Typing, will let my programs be type safe!
	 */
	public void falseMethod() {
		boolean metal = false;
		if (metal == false) {
			String joeyDeCaio = null;
			joeyDeCaio.length();
		}
	}
}
