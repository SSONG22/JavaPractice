package design_pattern.composite_pattern.ex2;

class CompositeDemo {
    public static void main(String[] args) {
        //Initialize four ellipses
        Ellipse ellipse1 = new Ellipse(); // leaf
        Ellipse ellipse2 = new Ellipse();
        Ellipse ellipse3 = new Ellipse();
        Ellipse ellipse4 = new Ellipse();

        //Creates two composites containing the ellipses
        CompositeGraphic compositGraphic2 = new CompositeGraphic();
        compositGraphic2.add(ellipse1); // children.add(leaf)
        compositGraphic2.add(ellipse2);
        compositGraphic2.add(ellipse3);

        CompositeGraphic compositGraphic3 = new CompositeGraphic();
        compositGraphic3.add(ellipse4);

        //Create another graphics that contains two graphics
        CompositeGraphic compositGraphic = new CompositeGraphic();
        compositGraphic.add(compositGraphic2);
        compositGraphic.add(compositGraphic3);

        //Prints the complete graphic (Four times the string "Ellipse").
        compositGraphic.print();
    }
}