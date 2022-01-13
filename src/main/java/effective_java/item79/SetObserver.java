package effective_java.item79;

// Set obeserver callback interface - Page 266
public interface SetObserver<E> {
    /**
     * BiConsumer<ObservableSet<E>,E>와 똑같다.
     * 그럼에도 커스텀 함수형 인터페이스를 정의한 이유는 더 직관적이고 다중 콜백을 지원하도록 확장할 수 있기 때문
     * */
    // Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}
