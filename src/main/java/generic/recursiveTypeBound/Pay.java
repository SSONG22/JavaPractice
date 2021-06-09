package generic.recursiveTypeBound;

class Pay implements Comparable<Pay> {
    public int discount;

    @Override
    public String toString() {
        return "Pay{" +
                "discount=" + discount +
                '}';
    }

    public Pay(int discount) {
        this.discount = discount;
    }

    @Override
    public int compareTo(Pay o) {
        return this.discount - o.discount;
    }
}
