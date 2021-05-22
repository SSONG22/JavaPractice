package effective_java.item15;

class Parent {
    protected void accessModifier() {
        System.out.println("Class Modifier " +this.getClass().getModifiers());
    }
}
