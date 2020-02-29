package designpattern.dip;

public abstract class TestCase {
	public void run() {
		if (doTest()) {
			System.out.println("Test succeed");
		} else {
			System.out.println("Test failed");
		}
	}

	public abstract boolean doTest();

}
