package java8.future;

import util.TimeUtils;

public class ExchangeRateService {

    public static double getExchangeRate(String baseCur, String quoteCur){

        TimeUtils.delay();
        return Math.abs(baseCur.charAt(0) - quoteCur.charAt(0));
    }
}
