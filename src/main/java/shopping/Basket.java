package shopping;

/**
 * Created by ashley on 29/09/2015.
 */
public class Basket {

    private final String[] items;

    public Basket(String[] items) {
        this.items = items;
    }

    public static Basket fromList(String[] items) {
        return new Basket(items);
    }

    public String[] getItems() {
        return items;
    }
}
