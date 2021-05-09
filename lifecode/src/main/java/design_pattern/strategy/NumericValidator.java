package design_pattern.strategy;

public class NumericValidator implements Validator {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
