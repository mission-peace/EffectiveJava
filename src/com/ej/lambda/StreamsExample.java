package com.ej.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.StringTokenizer;
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
                return str.startsWith("T") || str.startsWith("A");
            }
        };
        
        Predicate<String> predicate1 = name -> name.startsWith("T") || name.startsWith("A");
        
        names.stream().filter(predicate).forEach(System.out::println);;
        names.stream().filter(predicate1).forEach(System.out::println);;
    }
    
    public void filterMultiplePredicate(List<String> names){
        names.stream().filter(checkWithCharacter("T")).forEach(System.out::println);;
        names.stream().filter(checkWithCharacter("A")).forEach(System.out::println);;
    }
    
    final Function<String, Predicate<String>> filterFunction = letter -> name -> name.startsWith(letter);
    
    public void filterMultiplePredicateWithFunction(List<String> names){
        names.stream().filter(filterFunction.apply("A")).forEach(System.out::println);
        names.stream().filter(filterFunction.apply("T")).forEach(System.out::println);
    }
    
    private Predicate<String> checkWithCharacter(String prefix){
        return name -> name.startsWith(prefix);
    }
    
    public void findFirstName(List<String> names){
        Optional<String> firstName = names.stream().filter(filterFunction.apply("T")).findFirst();
        System.out.println(firstName.orElse("No name found"));
        firstName.ifPresent(System.out::println);
        firstName = names.stream().filter(filterFunction.apply("G")).findFirst();
        System.out.println(firstName.orElse("No name found"));
    }
    
    public void totalCharacters(List<String> names){
        int totalCharacters = names.stream().mapToInt(name -> name.length()).sum();
        System.out.println(totalCharacters);
    }
    
    public void maxMinSize(List<String> names){
        OptionalInt max = names.stream().mapToInt(name -> name.length()).max();
        OptionalInt min = names.stream().mapToInt(name -> name.length()).min();
        max.ifPresent(System.out::println);
        min.ifPresent(System.out::println);
    }
    
    public void maxMinNames(List<String> names){
        Optional<String> longestName = names.stream().reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
        longestName.ifPresent(System.out::println);
        Optional<String> smallestName = names.stream().reduce((name1, name2) -> name1.length() <= name2.length() ? name1 : name2);
        smallestName.ifPresent(System.out::println);
        
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
        System.out.println("----Filter With Mutliple Predicate----");
        se.filterMultiplePredicate(names);
        System.out.println("----Filter with Multiple Predicate Function-----");
        se.filterMultiplePredicateWithFunction(names);
        System.out.println("----First Name with T-----");
        se.findFirstName(names);
        System.out.println("----Total characters in list----");
        se.totalCharacters(names);
        System.out.println("----Max min length in list-----");
        se.maxMinSize(names);
        System.out.println("----Max min length strings in list-----");
        se.maxMinNames(names);
    }
    
}
