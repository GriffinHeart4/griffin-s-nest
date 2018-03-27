package ru.stqa.pft.sandbox;

public class MyFirstProgram
{
	public static void main(String[] args)
	{
		hello("where is my bottle of rum?");

		double l = 5;
		System.out.println("square's area with side " + l + " = " + area(l));

		double a = 4;
		double b = 6;
		System.out.println("rectangle's area with side " + a + " and " + b + " = " + area(a, b));
	}

	public static void hello(String somebody)
	{
		System.out.println("Hello, " + somebody);
	}

	public static double area(double l)
	{
		return l * l;
	}

	public static double area(double a, double b)
	{
		return a * b;
	}
}

