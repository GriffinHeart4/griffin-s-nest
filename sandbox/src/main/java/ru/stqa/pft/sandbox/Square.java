package ru.stqa.pft.sandbox;

public class Square
{
    double side;

    public Square(double side)
    {
        this.side = side;
    }

    public double area()
    {
        return this.side * this.side;
    }
}
