package effective_java.item42;

import java.util.function.DoubleBinaryOperator;

public enum OperationLambda {

    PLUS("+", (x, y) -> {
//        System.out.println(symbol); // cant
        return x + y;
    });
    protected final String symbol;
    private final DoubleBinaryOperator operator;

    OperationLambda(String symbol, DoubleBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public double apply(double x, double y) {
        return operator.applyAsDouble(x, y);
    }
}
