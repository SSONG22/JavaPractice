package effective_java.item36;

import java.util.Set;

public class Text {
    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    private Set<Style> texts;

    public Set<Style> getTexts() {
        return texts;
    }

    public void applyStyle(Set<Style> styles){
        texts = styles;
    }
}
