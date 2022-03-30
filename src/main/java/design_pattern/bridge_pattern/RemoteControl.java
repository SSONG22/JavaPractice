package design_pattern.bridge_pattern;

public abstract class RemoteControl {
    final TV tv;

    protected RemoteControl(TV tv) {
        this.tv = tv;
    }

    abstract void on();

    abstract void off();

    void setChannel(int channel) {
        // 추상화된 부분에 들어있는 메소드는 구현 클래스에 있는 메소드를 통해 구현된다.
        tv.tuneChannel(channel);
    }
}
