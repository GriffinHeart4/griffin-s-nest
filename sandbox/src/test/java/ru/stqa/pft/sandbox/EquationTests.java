package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests
{
    @Test
    void test0()
    {
        Equation eq = new Equation(1, 1, 1);
        Assert.assertEquals(eq.rootNumber(), 0);
    }

    @Test
    void test1()
    {
        Equation eq = new Equation(1, 2, 1);
        Assert.assertEquals(eq.rootNumber(), 1);
    }

    @Test
    void test2()
    {
        Equation eq = new Equation(1, 5, 6);
        Assert.assertEquals(eq.rootNumber(), 2);
    }

    @Test
    void testLinear()
    {
        Equation eq = new Equation(0, 1, 1);
        Assert.assertEquals(eq.rootNumber(), 1);
    }

    @Test
    void testConstant()
    {
        Equation eq = new Equation(0, 0, 1);
        Assert.assertEquals(eq.rootNumber(), 0);
    }

    @Test
    void testZero()
    {
        Equation eq = new Equation(0, 0, 1);
        Assert.assertEquals(eq.rootNumber(), 0);
    }
}
