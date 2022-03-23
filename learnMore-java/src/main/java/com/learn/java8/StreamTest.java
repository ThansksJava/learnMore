package com.learn.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * @author Feng Jie
 * @date 2021/12/27 14:27
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);
    }
    @Test
    public void flatMapTest(){
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        pairs.stream().forEach(a -> {
            System.out.println(a[0]+""+a[1]);
        });
    }

    @Test
    public void reduceTest(){
        List<Integer> numbers = Arrays.asList(3,4,5,1,2);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        int sum1 = numbers.stream().reduce(0, Integer :: sum);
        System.out.println("sum="+sum);
        System.out.println("sum1="+sum1);

//        int sum2 = numbers.stream().reduce(0, Integer::sum);
//        System.out.println(sum2);
//
//        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
//        System.out.println(max);
//
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);

//
//        int calories = Dish.menu.stream()
//                .map(Dish::getCalories)
//                .reduce(0, Integer::sum);
//        System.out.println("Number of calories:" + calories);
    }


    @Test
    public void test(){
        String fileType = "blob".substring("blob".lastIndexOf(".")+1);
        System.out.println(fileType);
    }
    @Test
    public void practiceTest(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> collect = transactions.stream().filter(transaction -> 2011 == transaction.getYear()).
                sorted(comparing(Transaction::getValue)).collect(toList());
//        collect.stream().forEach(transaction -> System.out.println(transaction));
        collect.stream().forEach(System.out::println);

        List<String> collect1 = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(toList());

        System.out.println(collect1);

    }
}
