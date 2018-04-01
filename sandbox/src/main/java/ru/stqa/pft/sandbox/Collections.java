package ru.stqa.pft.sandbox;

import java.util.*;

public class Collections
{
    public static void main(String[] args)
    {
        String[] langs = {"Java", "C", "C++", "Perl", "Assembler"};

        for(int i = 0; i < langs.length; i ++)
        {
            System.out.println("I want to learn " + langs[i]);
        }

        System.out.println();

        for(String e: langs)
        {
            System.out.println("I want to learn " + e);
        }

        List<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("C++");
        list.add("Assembler");

        System.out.println();

        for( String element: list)
        {
            System.out.println("i Like Fedora Linux and Space and Exploring :)");
        }

        List langsAsList = Arrays.asList(langs);

        List list2 = new ArrayList<>(langsAsList);

        System.out.println();

        for(Object element: langsAsList)
        {
            System.out.println(element);
        }


    }
}