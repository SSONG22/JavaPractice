package design_pattern.proxy_pattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Thumbnail> thumbnailList = new ArrayList<>();
        thumbnailList.add(new ProxyThumbnail("video1", "/video1.mp4"));
        thumbnailList.add(new ProxyThumbnail("video2", "/video2.mp4"));
        thumbnailList.add(new ProxyThumbnail("video3", "/video3.mp4"));
        thumbnailList.forEach(thumbnail -> thumbnail.showTitle());

        thumbnailList.get(2).showPreview();
        thumbnailList.get(1).showPreview();
        thumbnailList.get(1).showPreview();
//        download video3from /video3.mp4
//        video3 preview
//        download video2from /video2.mp4
//        video2 preview
//        video2 preview
    }
}
