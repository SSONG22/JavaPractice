package whiteship.generic1;

public class Play<T> {
    public static void main(String[] args) {
        Play<?> lolPlay = new Play<>();
        lolPlay.doSomething(new Play<LoL>());
        lolPlay.doSomething(new Play<Game>());
        lolPlay.doSomething(new Play<RankGame>()); // super 도 interface 를 지원한다.
    }
    // LoL의 상위 타입인 Play 를 파라미터에 받는다.
    public void doSomething(Play<? super LoL> play){
        System.out.println(play);
    }
}
