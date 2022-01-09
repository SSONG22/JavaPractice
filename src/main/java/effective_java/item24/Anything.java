package effective_java.item24;

public class Anything {
    private int number = 0;
    static Operator operator = new Operator() {

        @Override
        public double plus() {
//            return number + 1; // 컴파일 에러
            return 0;
        }

    };

    // 비정적 메서드
    void test(){
        Operator operator = new Operator() {

            @Override
            public double plus() {
                return number + 1;
            }

        };

        operator = () -> this.number + 1;
    }

    // 정적 메서드
    static void test2(){
        Operator operator = new Operator() {

            @Override
            public double plus() {
                // 초기화 안된 number 를 가져올 수 없다.
//                return number + 1;
                return 0;
            }
        };
    }

    // 지역 클래스
    class Local{
        void local(){
            System.out.println(number); // 비정적 문맥에서 바깥 인스턴스를 참조할 수 있다.
        }
    }
}

interface Operator {
    double plus();
}