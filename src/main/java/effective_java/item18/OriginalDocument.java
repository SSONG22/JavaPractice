package effective_java.item18;

public class OriginalDocument {
    public int length(){
        return this.content().length();
    }
    public String content(){
        return "abc";
    }
}
