package effective_java.item36;

import java.util.EnumSet;

public class Main {

    public static void main(String[] args) {
        Text text = new Text();
        // text.applyStyles(STYLED_BOLD | STYLE_ITALIC); 대체
        text.applyStyle(EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC));

        System.out.println(text.getTexts());
    }
}
