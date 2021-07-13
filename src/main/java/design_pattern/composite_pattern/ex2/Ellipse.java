package design_pattern.composite_pattern.ex2;

// Leaf
class Ellipse implements Graphic {
    //Prints the graphic.
    @Override
    public void print() {
        System.out.println("Ellipse");
    }
}