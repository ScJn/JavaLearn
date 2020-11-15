package java8.future;

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

        ExecutorService executorService = Executors.newFixedThreadPool(40, r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });

//        List<Double> collect = TimeUtils.printCosts(() -> getPrices(shops));
//        List<Double> collect1 = TimeUtils.printCosts(() -> getPricesWithCF(shops, executorService));
//        List<Double> doubles = TimeUtils.printCosts(() -> getPricesParallel(shops));

//        TimeUtils.printCosts(() -> getPricesAfterDiscount(shops));
//        TimeUtils.printCosts(() -> getPricesAfterDiscountParallel(shops));
//        TimeUtils.printCosts(() -> getPricesAfterDiscountWithCF(shops, executorService));
//        TimeUtils.printCosts(() -> getPricesAfterDiscountWithCF2(shops, executorService));

//        TimeUtils.printCosts(() -> getPricesAfterDiscountAndExchangeParallel(shops));
//        TimeUtils.printCosts(() -> getPricesAfterDiscountAndExchangeCF(shops, executorService));

        CompletableFuture[] completableFutures = findPricesStream(shops, executorService)
                .map(future -> future.thenAccept(System.out::println))
                .toArray(CompletableFuture[]::new);
        Void join = CompletableFuture.allOf(completableFutures).join();


        Thread.sleep(5000);
        System.out.println("end");

    }

    public static Stream<CompletableFuture<Double>> findPricesStream(List<Shop> shops, ExecutorService e) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> Shop.calculatePrice(shop.name), e))
                .map(future -> future.thenApply(price -> Discount.getDiscountPrice(price)))
                .map(future -> future.thenCombine(CompletableFuture.supplyAsync(() -> ExchangeRateService.getExchangeRate("USD", "EUR")),
                        (price, rate) -> price * rate));
    }

    private static List<Double> getPricesAfterDiscountAndExchangeParallel(List<Shop> shops) {
        return shops.stream()
                .parallel()
                .map(shop -> Shop.calculatePrice(shop.name))
                .map(Discount::getDiscountPrice)
                .map(price -> price * ExchangeRateService.getExchangeRate("USD", "EUR"))
                .collect(Collectors.toList());
    }

    private static List<Double> getPricesAfterDiscountAndExchangeCF(List<Shop> shops, ExecutorService e) {
        List<CompletableFuture<Double>> collect = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> Shop.calculatePrice(shop.name), e))
                .map(future -> future.thenApply(price -> Discount.getDiscountPrice(price)))
                .map(future -> future.thenCombine(CompletableFuture.supplyAsync(() -> ExchangeRateService.getExchangeRate("USD", "EUR")),
                        (price, rate) -> price * rate))
                .collect(Collectors.toList());

        return collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    /**
     * pipeline of time-consuming invoke
     * calculate and get discount both cost 1s to complete
     * <p>
     * but we don't need to wait all price be calculated then to get discount
     * we actually can get one price's discount while get other price simultaneously
     *
     * @param shops shops
     * @return list of price after discount
     */
    private static List<Double> getPricesAfterDiscount(List<Shop> shops) {
        return shops.stream()
                .map(shop -> Shop.calculatePrice(shop.name))
                .map(Discount::getDiscountPrice)
                .collect(Collectors.toList());
    }

    private static List<Double> getPricesAfterDiscountParallel(List<Shop> shops) {
        return shops.stream()
                .parallel()
                .map(shop -> Shop.calculatePrice(shop.name))
                .map(Discount::getDiscountPrice)
                .collect(Collectors.toList());
    }

    /**
     * pay attention, we need to map first, then use join to return Double
     * price, the para of thenCompose, is the result of future
     *
     * @param shops
     * @param e
     * @return
     */
    private static List<Double> getPricesAfterDiscountWithCF(List<Shop> shops, ExecutorService e) {
        List<CompletableFuture<Double>> collect = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> Shop.calculatePrice(shop.name), e))
                .map(future -> future.thenCompose(price -> CompletableFuture.supplyAsync(() -> Discount.getDiscountPrice(price), e)))
                .collect(Collectors.toList());

        return collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    private static List<Double> getPricesAfterDiscountWithCF2(List<Shop> shops, ExecutorService e) {
        List<CompletableFuture<Double>> collect = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> Shop.calculatePrice(shop.name), e))
                .map(future -> future.thenApply(price -> Discount.getDiscountPrice(price)))
                .collect(Collectors.toList());

        return collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
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
     *
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
    public static List<Double> getPricesParallel(List<Shop> shops) {
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


    private static List<Shop> getShops(int size) {
        List<Shop> shops = new ArrayList<>();
        CollectionUtils.adds(shops, size, () -> new Shop("dada"));
        return shops;
    }

    public static double calculatePrice(String product) {

        TimeUtils.delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0);

    }
}
