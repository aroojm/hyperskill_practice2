class Calculator {
    private CalculatorEngine engine;

    public Calculator(CalculatorEngine engine) {
        this.engine = engine;
    }

    public String divide(int a, int b) {
        try {
            int ans = engine.divide(a, b);
            String result = String.format("Division of %s by %s = %d", a, b, ans);
            return result;

        } catch (ArithmeticException e) {
            return "Division by zero is prohibited";
        }
    }
}