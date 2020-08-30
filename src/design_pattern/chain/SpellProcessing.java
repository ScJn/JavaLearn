package design_pattern.chain;

public class SpellProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return input.replaceAll("lamb", "lambda");
    }
}
