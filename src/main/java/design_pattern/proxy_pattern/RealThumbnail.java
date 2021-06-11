package design_pattern.proxy_pattern;

public class RealThumbnail implements Thumbnail {
    private String title;
    private String movieUrl;

    public RealThumbnail(String title, String movieUrl) {
        this.title = title;
        this.movieUrl = movieUrl;
        System.out.println("download " + title + "from " + movieUrl);
    }

    @Override
    public void showTitle() {
        System.out.println("title: " + title);
    }

    @Override
    public void showPreview() {
        System.out.println(title + " preview");
    }
}
