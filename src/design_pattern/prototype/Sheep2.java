package design_pattern.prototype;

import java.util.Date;

public class Sheep2 implements Cloneable {

    private String name;
    private Date date;

    public Sheep2() {
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
        Object obj=super.clone();
        Sheep2 sheep= (Sheep2) obj;
        sheep.date= (Date) date.clone();
        return obj;
    }
}
