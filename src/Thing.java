
public class Thing {
    private final int price;
    private final int weight;
    private final String name;

    Thing(String name, int price, int weight) {
        this.price = price;
        this.weight = weight;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        return "Thing{" +
                name +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}