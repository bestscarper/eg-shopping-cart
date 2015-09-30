package shopping;

import com.google.common.collect.Lists;

import java.util.List;

public class Basket {

    private final String[] items;

    public Basket(String[] items) {
        this.items = items;
    }

    public static Basket fromList(String[] items) {
        return new Basket(items);
    }

    public List<String> getItems() {
        return Lists.newArrayList(items);
    }
}
