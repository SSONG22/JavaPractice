package effective_java.item41.example1;

public class ShapeDao {
    // marker interface Deletable 를 상속한 객체만 삭제할 수 있도록 method 작성
    public boolean delete(Object object) {
        if (!(object instanceof String)) {
                return false;
        }
        // delete implementation details
        return true;
    }
}
