package practice;

public class MyClass {
	public static class superclass {
		static void print()
		{
			System.out.println("print in superclass.");
		}
	}
	public static class subclass extends superclass {
		static void print()
		{
			System.out.println("print in subclass.");
		}
	}

	public static void main(String[] args)
	{
		superclass A = new superclass();
		subclass B = new subclass();
		A.print();
		B.print();
	}
}

