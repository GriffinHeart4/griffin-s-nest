package ru.stqa.pft.sandbox;

public class Launcher
{
	public static void main(String[] args)
	{
		// test function

		hello("where is my bottle of rum?");

		// few objects

		Square square = new Square(7);
		Rectangle rectangle = new Rectangle(4, 98);
		Point p1 = new Point(4, 3);
		Point p2 = new Point(2, 1);
		PointImproved p3 = new PointImproved(4, 2, 3, 1);

		// test methods output

		System.out.println("square's area with side " + square.side + " = " + square.area());
		System.out.println("rectangle's area with side " + rectangle.sideA + " and " + rectangle.sideB + " = " + rectangle.area() + "\n");
		System.out.println("according to method the distance is " + p1.distance(p2));
		System.out.println("according PointImproved's method distance is " + p3.distance());

		// test functions output

		System.out.println("according to function distance is " + distance(p1, p2));


	}

	// test functions

	public static void hello(String somebody)
	{
		System.out.println("Hello, " + somebody);
	}

	public static double distance(Point p2, Point p1)
	{
		return Math.sqrt( (Math.pow(p2.x - p1.x, 2)) + (Math.pow(p2.y - p1.y, 2)) );
	}
}

