package ru.stqa.pft.sandbox;

public class PointImproved
{
    double x1;
    double x2;
    double y1;
    double y2;

    public PointImproved(double x1, double x2, double y1, double y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double distance()
    {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
