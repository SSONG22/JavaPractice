package effective_java.item53;

public class GoodPattern {
    public void foo(){}
    public void foo(int a1){}
    public void foo(int a1, int a2){}
    public void foo(int a1, int a2, int a3){} // 여기까지 95 % 담당
    public void foo(int a1, int a2, int a3, int ...rest){} // 나머지 5% 담당

}
