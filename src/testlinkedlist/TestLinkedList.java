/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlinkedlist;

/**
 *
 * @author clintonmedbery
 */
public class TestLinkedList
  {
    public static void main(String[] args)
      {
        LinkedList<String> l = new LinkedList<>();

        System.out.println(l.isEmpty() ? "The list is empty." : "The list is not empty.");
        System.out.println(l);
        System.out.println();

        l.add(0, "John");
        l.add(0, "Elvis");
        System.out.println(l);
        System.out.println();

        System.out.println(l.isEmpty() ? "The list is empty." : "The list is not empty.");
        System.out.println();

        LinkedList<String> l2 = new LinkedList<String>();
        l2.add("Elvis");
        l2.add("John");
        System.out.println("l.equals(l2) is " + l.equals(l2));
        System.out.println();

        l.add("Mick");
        System.out.println(l);
        System.out.println();

        l.add(0, "Curly");
        l.add(3, "Larry");
        l.add(2, "Diana");

        System.out.println(l);
        System.out.println();

        l.add(0, "Moe");
        l.set(4, "Bruce");
        System.out.println(l);
        System.out.println("size = " + l.size());
        System.out.println("index of \"Curly\" = " + l.indexOf("Curly"));
        System.out.println("index of \"Larry\" = " + l.indexOf("Larry"));
        System.out.println("index of \"Moe\" = " + l.indexOf("Moe"));
        System.out.println("index of \"Mick\" = " + l.indexOf("Mick"));
        System.out.println();

        // remove first and last elements plus an element in the middle
        System.out.println("Removing " + l.remove(0));
        System.out.println("Removing " + l.remove(l.size() - 1));
        System.out.println("Removing " + l.remove(3));
        System.out.println(l);
        System.out.println("size = " + l.size());
        System.out.println("index of \"Diana\" = " + l.indexOf("Diana"));
        System.out.println("index of \"Bruce\" = " + l.indexOf("Bruce"));
        System.out.println();

        for (int i = 1;  i <= 2;  ++i)
            System.out.println(l.remove(0));
        System.out.println(l);
        System.out.println();

        l.add(1, "Angela");
        l.add(l.size(), "Robert");
        System.out.println(l);
        System.out.println("size = " + l.size());
        System.out.println();

        // add a null data value and see if the list can be printed
        l.add(null);
        System.out.println(l);
        System.out.println("size = " + l.size());
        System.out.println();


        l.clear();
        System.out.println("The list has been cleared.");
        System.out.println(l.isEmpty() ? "The list is empty." : "The list is not empty.");
        System.out.println("index of \"Larry\" = " + l.indexOf("Larry"));
        System.out.println();

        try
          {
            l.remove(0);   // should throw an exception
          }
        catch (Exception e)
          {
            System.out.println("Exception information to follow:");
            e.printStackTrace(System.out);
          }
      }
  }