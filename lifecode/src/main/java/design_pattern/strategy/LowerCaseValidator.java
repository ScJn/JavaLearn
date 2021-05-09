package design_pattern.strategy;

public class LowerCaseValidator implements Validator {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
