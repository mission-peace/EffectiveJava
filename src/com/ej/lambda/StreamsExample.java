package com.ej.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
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
    
    public void countLengthWithFunction(List<String> names){
        Function<String, Integer> function = new Function<String, Integer>() {
            
            @Override
            public Integer apply(String t) {
                return t.length();
            }
        };
        
        Function<String, Integer> function1 = name -> name.length();
        names.stream().map(function).forEach(System.out::println);
        names.stream().map(function1).forEach(System.out::println);
    }
    
    public void filterNames(List<String> names){
        names.stream().filter(name -> name.startsWith("T")).forEach(System.out::println);
        List<String> filteredNames = names.stream().filter(name -> name.length() > 4).collect(Collectors.toList());
        filteredNames.forEach(System.out::println);
    }
    
    public void filterWithPredicate(List<String> names){
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String str){
                return str.startsWith("T");
            }
        };
        
        Predicate<String> predicate1 = name -> name.startsWith("T");
        
        names.stream().filter(predicate).forEach(System.out::println);;
        names.stream().filter(predicate1).forEach(System.out::println);;
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
        System.out.println("----Word length With Function-----");
        se.countLengthWithFunction(names);
        System.out.println("----Filter words-----");
        se.filterNames(names);
        System.out.println("----Filter With Predicate----");
        se.filterWithPredicate(names);
    }
    
}
