package design_pattern.chain;

import util.PrintUtils;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainTest {

    public static void main(String[] args) {
        HeaderTextProcessing headerTextProcessing = new HeaderTextProcessing();
        SpellProcessing spellProcessing = new SpellProcessing();
        headerTextProcessing.setSuccessor(spellProcessing);

        String s = headerTextProcessing.handle("I'm scjn, and I like the lamb expression ");
        System.out.println(s);


        PrintUtils.println();

        UnaryOperator<String> first =
                (input) -> "hello, " + input;
        UnaryOperator<String> second = (input) -> input.replaceAll("lamb", "lambda");
        Function<String, String> chain = first.andThen(second);
        String out = chain.apply("I'm scjn, and I like the lamb expression ");
        System.out.println(out);

    }
}
