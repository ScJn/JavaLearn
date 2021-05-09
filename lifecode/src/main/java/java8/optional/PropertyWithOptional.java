package java8.optional;

import java.util.Optional;
import java.util.Properties;

public class PropertyWithOptional {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("a", "1");
        properties.setProperty("b", "2f");
        properties.setProperty("c", "-12");

        System.out.println(readInt(properties, "b"));
        System.out.println(readIntWithOptional(properties, "sss"));

    }

    private static int readIntWithOptional(Properties properties, String name){
        return Optional.ofNullable(properties.getProperty(name))
                .map(Integer::parseInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

    private static int readInt(Properties properties, String name) {
        String property = properties.getProperty(name);
        if (property != null) {
            try {
                int i = Integer.parseInt(property);
                if (i > 0){
                    return i;
                }
            } catch (Exception e) {
            }
        }
        return 0;
    }
}
