package com.homework.exercises;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product {
    private String name;
    private int price;
    private String category;

    public Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class StreamDemo {
    public static void main(String[] args) {
        /*List<Integer> numbers = List.of(23, 17, 4, 32, 9, 10, 15, 16, 153);*/

        /* Stream<Integer> data = numbers.stream();*/

        //Creaza un stream gol
        Stream.empty();

        int[] arr = new int[3];
        Stream.of(arr, 10, 7, 4, 5);
        Arrays.stream(arr);


//        List<Integer> data2 = data.peek(System.out::println)
//                .collect(Collectors.toList());

//        numbers.stream()
//                .filter(n -> n % 2 == 0)
//                .forEach(System.out::println);

//        numbers.stream()
//                .filter(n -> n % 2 == 0)
//                .peek(System.out::println)
//                .map(n -> n + "a")
//                .forEach(System.out::println);

//        numbers.stream()
//                .limit(3)
//                .forEach(System.out::println);

//        numbers.stream()
//                .skip(3)
//                .forEach(System.out::println);

//        numbers.stream()
//                .sorted((a, b) -> a - b)
//                .forEach(System.out::println);

//        System.out.println(numbers.stream().count());
//
//        int minNumber = numbers.stream()
//                .filter(n -> n % 2 == 0)
//                .min((a, b) -> a - b).orElse(0);
//        System.out.println(minNumber);

//        int maxNumber = numbers.stream()
//                .filter(n -> n % 2 == 0)
//                .max((a, b) -> a - b).orElse(0);
//        System.out.println(maxNumber);

//        numbers.forEach(n -> //sss);

//        System.out.println(numbers.stream()
//                .filter(n -> n == 50)
//                .findFirst().orElse(-1));

//        System.out.println(numbers.stream()
//                .filter(n -> n == 50)
//                .findAny().orElse(-1));

//       boolean flag =  numbers.stream()
//                .anyMatch(n -> n >= 10);
//        System.out.println(flag);

//       boolean flag =  numbers.stream()
//                .allMatch(n -> n >= 10);
//        System.out.println(flag);
//
//        boolean flag =  numbers.stream()
//                .noneMatch(n -> n >= 1000);
//        System.out.println(flag);

//        System.out.println(IntStream.range(1, 10).sum());

//        int value = Stream.of(10, 5, 3)
//                .reduce(15, (a, b) -> a + b, (a, b) -> {
//                    System.out.println("Fac suma");
//                    return a + b;
//                });
//        System.out.println(value);

//        System.out.println(Stream.of(10, 5, 3).collect(Collectors.toList()));
//        System.out.println(Stream.of(10, 5, 3, 5).collect(Collectors.toSet()));
//        System.out.println(numbers.stream().collect(Collectors.toCollection(() -> new LinkedList<>())));
//        System.out.println((Long) numbers.stream().count());
//        System.out.println(numbers.stream().map(n -> n + "").collect(Collectors.joining()));
//
        List<Product> products = new ArrayList<>();
        products.add(new Product("Telefon", 1000, "Device"));
        products.add(new Product("Frigider", 5000, "Electrocasnic"));
        products.add(new Product("Pizza", 10, "Consumabil"));
        products.add(new Product("Paine", 1, "Consumabil"));

     /*   Map<String, Product> myMap = products.stream()
                .collect(Collectors.toMap(Product::getCategory, Function.identity(), (existent, copy) -> copy));
        System.out.println(myMap);*/

        Map<Integer, Set<Product>> myMap = products.stream()
                .collect(Collectors.groupingBy(product -> product.getName().length(), Collectors.toSet()));
        System.out.println(myMap);

//          Map<Boolean, List<Product>> productsMap = products.stream()
//                  .collect(Collectors.partitioningBy(product -> product.getPrice() >= 50));
//        System.out.println(productsMap);

//        List<User> users = List.of(new User("Ion", 50), new User("Alex", 25), new User("Maria", 20));
//        System.out.println(users.stream().reduce(0, (intermediate, user) -> intermediate + user.getAge(), Integer::sum));
    }
}