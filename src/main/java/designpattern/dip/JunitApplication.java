package designpattern.dip;

import java.util.ArrayList;
import java.util.List;

public class JunitApplication {
	private static final List<TestCase> list = new ArrayList<>();

	public static void register(TestCase testCase) {
		list.add(testCase);
	}

	public static void main(String[] args) {
		for (TestCase testCase : list) {
			testCase.run();
		}
	}
}
