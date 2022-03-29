package design_pattern.composite_pattern.ex3;

public class File extends Component{
    Object data;

    public File(String name) {
        super(name);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
