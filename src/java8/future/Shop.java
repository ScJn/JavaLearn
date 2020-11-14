package java8.future;

import java8.stream.collect.Collect;
import util.CollectionUtils;
import util.TimeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Shop {

    private String name;
    private double price;

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public static void main(String[] args) throws Exception {

        System.out.println(Runtime.getRuntime().availableProcessors());

        List<Shop> shops = getShops(40);

        ExecutorService executorService = Executors.newFixedThreadPool(100, r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });

//        List<Double> collect = TimeUtils.printCosts(() -> getPrices(shops));
//        List<Double> collect1 = TimeUtils.printCosts(() -> getPricesWithCF(shops, executorService));
//        List<Double> doubles = TimeUtils.printCosts(() -> getPricesParallel(shops));

        TimeUtils.printCosts(() -> getPricesAfterDiscount(shops));
        TimeUtils.printCosts(() -> getPricesAfterDiscountParallel(shops));
        TimeUtils.printCosts(() -> getPricesAfterDiscountWithCF(shops,executorService));
    }

    private static List<Shop> getShops(int size) {
        List<Shop> shops = new ArrayList<>();
        CollectionUtils.adds(shops, size, ()->new Shop("dada"));
        return shops;
    }

    /**
     * pipeline of time-consuming invoke
     * calculate and get discount both cost 1s to complete
     *
     * but we don't need to wait all price be calculated then to get discount
     * we actually can get one price's discount while get other price simultaneously
     * @param shops shops
     * @return list of price after discount
     */
    private static List<Double> getPricesAfterDiscount(List<Shop> shops){
        return shops.stream()
                .map(shop -> Shop.calculatePrice(shop.name))
                .map(Discount::getDiscountPrice)
                .collect(Collectors.toList());
    }

    private static List<Double> getPricesAfterDiscountParallel(List<Shop> shops){
        return shops.stream()
                .parallel()
                .map(shop -> Shop.calculatePrice(shop.name))
                .map(Discount::getDiscountPrice)
                .collect(Collectors.toList());
    }

    private static List<Double> getPricesAfterDiscountWithCF(List<Shop> shops, ExecutorService e){
        Stream<CompletableFuture<Double>> completableFutureStream = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> Shop.calculatePrice(shop.name),e));
        List<Double> collect = completableFutureStream
                .map(CompletableFuture::join).collect(Collectors.toList());
        Stream<CompletableFuture<Double>> completableFutureStream1 = collect.stream()
                .map(price -> CompletableFuture.supplyAsync(() -> Discount.getDiscountPrice(price),e));
        return completableFutureStream1
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    /**
     * normal one
     */
    private static List<Double> getPrices(List<Shop> shops) {
        return shops.stream().map(shop1 -> calculatePrice(shop1.name)).collect(Collectors.toList());
    }
    /**
     * use completableFuture to get prices
     * CF and parallel they both internally use the same common pool that by default has
     * a fixed number of threads equals to your machine's core
     * but CF can set the size
     * @param shops shops
     * @return prices
     */
    private static List<Double> getPricesWithCF(List<Shop> shops, ExecutorService e) {
        List<CompletableFuture<Double>> collect = shops.stream().map(shop1 ->
                CompletableFuture.supplyAsync(() -> calculatePrice(shop1.name), e)).collect(Collectors.toList());
        return collect.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    /**
     * parallel one
     */
    public static List<Double> getPricesParallel(List<Shop> shops){
       return shops.stream().parallel()
                .map(shop1 -> calculatePrice(shop1.name))
                .collect(Collectors.toList());
    }



    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product) {
        //
        return Executors.newFixedThreadPool(1).submit(() -> calculatePrice(product));
    }

    public Future<Double> getPriceAsync3(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public Future<Double> getPriceAsync2(String product) {
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                future.complete(calculatePrice(product));
            } catch (Exception e) {
                future.completeExceptionally(e);
                e.printStackTrace();
            }
        }).start();
        return future;
    }

    public static double calculatePrice(String product) {

        TimeUtils.delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0);

    }
}
