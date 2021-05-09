package java8.parallel.split;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCountWords {
    public static void main(String[] args) {
        streamCountWords("das das dsad d    d d    ");
    }
    public static void streamCountWords(String sentence){
        Stream<Character> characterStream = IntStream.range(0, sentence.length()).mapToObj(sentence::charAt);
        boolean isSpace = false;
        AtomicInteger count = new AtomicInteger();
        Character reduce = characterStream.parallel()
                .reduce(' ', (a, b) -> {
                    if (b != ' ') {
                        if (a == ' ') {
                            count.getAndIncrement();
                        }
                    }
                    return b;
                });

        System.out.println(count);
    }
}
