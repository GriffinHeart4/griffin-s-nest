package ru.stqa.pft.sandbox;

public class MyFirstProgram
{
	public static void main(String[] args)
	{
		// test function

		hello("where is my bottle of rum?");

		// few objects

		Square square = new Square(5);
		Rectangle rectangle = new Rectangle(4, 6);

		// test functions output

		System.out.println("square's area with side " + square.side + " = " + area(square));
		System.out.println("rectangle's area with side " + rectangle.sideA + " and " + rectangle.sideB + " = " + area(rectangle));
	}

	// test functions

	public static void hello(String somebody)
	{
		System.out.println("Hello, " + somebody);
	}

	public static double area(Square square)
	{
		return square.side * square.side;
	}

	public static double area(Rectangle rectangle)
	{
		return rectangle.sideA * rectangle.sideB;
	}
}

