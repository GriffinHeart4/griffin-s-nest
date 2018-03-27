package ru.stqa.pft.sandbox;

public class Rectangle
{
    double sideA;
    double sideB;

    public Rectangle(double sideA, double sideB)
    {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double area()
    {
        return this.sideA * this.sideB;
    }
}
