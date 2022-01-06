package effective_java.item2;

import java.util.Objects;

public class NyPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;
    public static class  Builder extends Pizza.Builder<Builder>{
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() { // 클라이언트에서 타입을 캐스팅할 필요가 없어진다. (Covariant 리턴 타이핑)
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }
}
