package com.homework.exercises;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // System.out.println(CrazyLambdas.isEmptyPredicate.test(""));
        List<String> stringList = new ArrayList<>();
        stringList.add("add");
        stringList.add("nnn");
        stringList.add("bb");
        stringList.add("");

        //CrazyLambdas.stringMultiplier.apply(5, "Good");

        List<BigDecimal> bigDecimals = new ArrayList<>();
        bigDecimals.add(new BigDecimal("0.22"));
        bigDecimals.add(new BigDecimal("0.33"));
        bigDecimals.add(new BigDecimal("0.04"));
        bigDecimals.add(new BigDecimal("10"));
        bigDecimals.add(new BigDecimal("88.888888888"));

        //System.out.println(mapAndCreateStringListFromDecimals(bigDecimals,CrazyLambdas.toDollarStringFunction));
        //System.out.println(CrazyLambdas.toDollarStringFunction.apply(new BigDecimal("0.2222")));
        System.out.println(CrazyLambdas.lengthInRangePredicate(2, 4).test("h"));
        System.out.println(CrazyLambdas.randomIntSupplier.getAsInt());
        System.out.println(CrazyLambdas.boundedRandomIntSupplier.applyAsInt(100));
        System.out.println(CrazyLambdas.intSquareOperation().applyAsInt(10));
        System.out.println(CrazyLambdas.longSumOperation().applyAsLong(10, 20));
        try {
            System.out.println(CrazyLambdas.stringToIntConverter().applyAsInt("bbbb"));
        } catch (NumberFormatException e) {
            System.out.println("This is not a number format. Try again");
        }
        System.out.println(CrazyLambdas.nMultiplyFunctionSupplier(10).get().applyAsInt(10));
        System.out.println(CrazyLambdas.composeWithTrimFunction().apply(Function.identity()).apply("Success"));
        System.out.println(CrazyLambdas.stringMultiplier().apply("good", 2));
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Runnable task = new Runnable() {
            @Override
            public void run() {
            }
        };
        CrazyLambdas.runningThreadSupplier(task).get().start();
        CrazyLambdas.newThreadRunnableConsumer().accept(task);
        CrazyLambdas.runnableToThreadSupplierFunction().apply(task).get().start();
        IntUnaryOperator intUnaryOperator = x -> x *1000;
        IntUnaryOperator intUnaryOperator1 = x -> x *2;
        IntUnaryOperator intUnaryOperator2 = x -> x *3;
        Map<String, IntUnaryOperator> functionalMap = new HashMap<>();
        functionalMap.put("firstFunctional", intUnaryOperator);
        functionalMap.put("secondFunctional", intUnaryOperator1);
        functionalMap.put("thirdFunctional", intUnaryOperator2);
        System.out.println(CrazyLambdas.functionLoader().apply(functionalMap, "firstFunctional").applyAsInt(10));
        System.out.println(CrazyLambdas.functionLoader().apply(functionalMap, "secondFunctional").applyAsInt(1000));
        System.out.println(CrazyLambdas.functionLoader().apply(functionalMap, "thirdFunctiona").applyAsInt(1000));
        Supplier<Supplier<Supplier<String>>> supplier = () -> ()->()->"Well Done";
        System.out.println(CrazyLambdas.trickyWellDoneSupplier().get().get().get());

    }

    private static List<String> mapAndCreateStringListFromDecimals(List<BigDecimal> bigDecimals, Function<BigDecimal, String> toDollarString) {
        return bigDecimals
                .stream()
                .map(toDollarString)
                .collect(Collectors.toList());
    }
}