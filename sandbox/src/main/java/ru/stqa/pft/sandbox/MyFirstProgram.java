package ru.stqa.pft.sandbox;

public class MyFirstProgram
{
	public static void main(String[] args)
	{
		// test function

		hello("where is my bottle of rum?");

		// few objects

		Square square = new Square(7);
		Rectangle rectangle = new Rectangle(4, 98);

		// test methods output

		System.out.println("square's area with side " + square.side + " = " + square.area());
		System.out.println("rectangle's area with side " + rectangle.sideA + " and " + rectangle.sideB + " = " + rectangle.area());
	}

	// test functions

	public static void hello(String somebody)
	{
		System.out.println("Hello, " + somebody);
	}
}

