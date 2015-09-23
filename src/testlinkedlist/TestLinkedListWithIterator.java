/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlinkedlist;

public class TestLinkedListWithIterator
  {
    public static void main(String[] args)
      {
        LinkedList<String> names = new LinkedList<>();

        System.out.println(names.isEmpty() ? "The list is empty." : "The list is not empty.");
        System.out.println(names);
        System.out.println();

        names.add("John");
        names.add("Elvis");
        names.add("Mick");
        names.add("Curly");
        names.add("Larry");
        names.add("Moe");
        names.add("Diana");

        for (String s : names)
            System.out.println(s);
        System.out.println();

        // Note that you get a forEach() method for free
        // (default method in interface Iterable) that
        // allows a lambda expressions as the parameter.
        names.forEach(name -> System.out.println(name));
        System.out.println();
      }
  }