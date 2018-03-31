package ru.stqa.pft.sandbox;

public class Primes
{
    public static Boolean isPrime(int n)
    {
        for (int i = 2; i < Math.abs(n); i++)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static Boolean isPrimeFast(int n)
    {
        int m = (int) Math.sqrt(n);
        for (int i = 2; i < m; i++)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static Boolean isPrimeWhile(int n)
    {
        int i = 2;
        while (i < n && n % i != 0)
        {
            i++;
        }
        return i == n;
    }

    public static Boolean isPrime(long n)
    {
        for (long i = 2; i < Math.abs(n); i++)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        isPrimeFast(10);
    }
}
