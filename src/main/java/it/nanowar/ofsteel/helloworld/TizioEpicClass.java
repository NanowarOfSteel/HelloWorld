package it.nanowar.ofsteel.helloworld;

public class TizioEpicClass {

	private final Integer foo;
	public TizioEpicClass(int foo) {

		super();
		this.foo=foo;
	}

	public void songRefrain() {

		for (int i = 0; i < foo; i++) {
			System.out.println("Hello World!");

		}

		int pippo = 0;
		while (pippo < foo) {
			System.out.println("Hello World!");
			pippo++;
		}
	}

	/*
	 * If I may introduce a bug, the JVM will manage it for me
	 * ensuring both security and portability
	 * Then I'll write my code once, and run it everywhere!
	 * With Static and Strong Typing, will let my programs be type safe!
	 */

	public void falseMethod () {
		boolean metal = false;
		if (metal == false) {
			String joeyDeCaio = null;
			joeyDeCaio.length();
		}
	}
}
