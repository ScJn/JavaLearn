package design_pattern.prototype;

import java.util.Date;

public class Sheep implements Cloneable {

    private String name;
    private Date date;

    public Sheep() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
