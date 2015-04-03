package com.ej.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {

    public void printCollection(List<String> names){
        names.forEach(name -> System.out.println(name));
        names.forEach(System.out::println);
    }
 
    public void toUpperCase(List<String> names){
        names.stream().map(name -> name.toUpperCase()).forEach(System.out::println);
        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }
    
    public void countLength(List<String> names){
        names.stream().map(name -> name.length()).forEach(System.out::println);
        names.stream().map(String::length).forEach(System.out::println);
    }
    
    public void filterNames(List<String> names){
        names.stream().filter(name -> name.startsWith("T")).forEach(System.out::println);
        List<String> filteredNames = names.stream().filter(name -> name.length() > 4).collect(Collectors.toList());
        filteredNames.forEach(System.out::println);
    }
    
    public static void main(String args[]){
        System.out.println("------PrintList-----");
        List<String> names = Arrays.asList("Tush", "Ani", "Donner", "Jabber", "Tany");
        StreamsExample se = new StreamsExample();
        se.printCollection(names);
        System.out.println("----Upper case-----");
        se.toUpperCase(names);
        System.out.println("----Word length-----");
        se.countLength(names);
        System.out.println("----Filter words-----");
        se.filterNames(names);
        
    }
    
}
