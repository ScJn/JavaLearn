package java8;

/**
 * @author scjn
 * @date 2020/6/25 16:48
 */
public class Banana {
    int size;
    int weight;

    public Banana(){
        this.size = 0;
        this.weight = 0;
    }

    public Banana(int size){
        this.size = size;
        this.weight = 0;
    }

    public Banana(int size, int weight) {
        this.size = size;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Apple{" +
                "size=" + size +
                ", weight=" + weight +
                '}';
    }

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }
}
