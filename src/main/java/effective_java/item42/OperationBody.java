package effective_java.item42;

public enum OperationBody {
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            System.out.println(this.symbol);
            return x + y;
        }
    };
    protected final String symbol;

    OperationBody(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);
}

