package design_pattern.composite_pattern.ex3;

public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        Folder home = new Folder("home");
        Folder garam = new Folder("garam");
        Folder music = new Folder("music");
        Folder doc = new Folder("doc");
        Folder picture = new Folder("picture");
        Folder usr = new Folder("usr");
        File track1 = new File("track1"),
                track2 = new File("track2"),
                pic1 = new File("pic1"),
                doc1 = new File("doc1"),
                java = new File("java");

        root.addComponent(home);
        home.addComponent(garam);
        garam.addComponent(music);
        music.addComponent(track1);
        music.addComponent(track2);
        garam.addComponent(picture);
        picture.addComponent(pic1);
        garam.addComponent(doc);
        doc.addComponent(doc1);

        root.addComponent(usr);
        usr.addComponent(java);

        show(root);
    }

    private static void show(Component component) {
        System.out.println(component.getClass().getName() + "|" + component.getName());
        if (component instanceof Folder) {
            for (Component c : ((Folder) component).getChildren()) {
                show(c);
            }
        }
    }


}
