package effective_java.item15;

class ArrayIs {

    public static final int[] VALUES = {1, 2, 3, 4, 5};
    int p;

    public static void main(String[] args) {
        for(int i=0; i<VALUES.length; i++){
            VALUES[i] = VALUES[i]*10;
            System.out.println(VALUES[i]);
        }
    }
}
