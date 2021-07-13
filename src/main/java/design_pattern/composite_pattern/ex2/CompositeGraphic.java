package design_pattern.composite_pattern.ex2;

import java.util.ArrayList;
import java.util.List;

// Composite
class CompositeGraphic implements Graphic {
    //Collection of child graphics.
    private final List<Graphic> childGraphics = new ArrayList<>();

    //Adds the graphic to the composition.
    public void add(Graphic graphic) {
        childGraphics.add(graphic);
    }

    // This is only shallowCopy
    public void add(List<Graphic> compositGraphic) {
        childGraphics.addAll(compositGraphic);
    }

    //Prints the graphic.
    @Override
    public void print() {
        for (Graphic graphic : childGraphics) {
            graphic.print();  //Delegation
        }
    }
}