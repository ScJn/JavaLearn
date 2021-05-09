package design_pattern.chain;

public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return "hello, " + input;
    }
}
