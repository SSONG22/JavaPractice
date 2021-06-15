package effective_java.item41.example1;

public class ShapeDao2 {
    // marker interface Deletable 를 상속한 객체만 삭제할 수 있도록 method 작성
    public boolean delete(Object object) {
        // shape 유형 외에 person 유형도 제거하려고 할 때
        // 1. 삭제할 객체가 Person 의 인스턴스 인지 여부를 확인하기 위해 이전 delete() 메서드에 추가 검사를 추가(object instanceof Person)
        if (!(object instanceof Shape || object instanceof Person)) {
            return false;
        }
        // DB 에도 제거할 유형이 더 있다면 -> 새로운 유형마다 메소드를 변경해야 하기 때문에 좋은 옵션이 아니다

        // 2. Person 을 상속하는 Shape 인터페이스를 만드는 것이다. 하지만 Person 이 Shape 는 아니기 때문에 올바르지 않다.
        // 일반적인 인터페이스를 사용하면 디자인이 좋지 않다.
        return true;
    }
}
