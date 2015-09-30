package shopping;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

public class Basket {

    private final List<String> items;

    public Basket(String[] items) {
        this.items = Lists.newArrayList(items);
    }

    public Basket(List<String> items) {
        this.items = items;
    }

    public static Basket fromList(String[] items) {
        return new Basket(items);
    }


    public List<String> getItems() {
        return Lists.newArrayList(items);
    }

    public long getItemTotal(Map<String, Long> costing) {
        return getItems()
            .stream()
            .map(costing::get)
            .reduce(0L, (a, b) -> a + b);

    }

    public static Basket fromList(List<String> ts) {
        return new Basket(ts);
    }
}
