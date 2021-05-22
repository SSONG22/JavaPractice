package effective_java.item15;

class Child extends Parent {
    @Override
    public void accessModifier() {
        System.out.println("modifier child : " + this.getClass().getModifiers());
    }
}
