package design_pattern.adapter_pattern;

public class VlcPlayer implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // do nothing
    }
}
