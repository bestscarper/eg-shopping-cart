package shopping;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.stream.Stream;

/**
 * Created by ashley on 30/09/2015.
 */
public class Checkout {

    private List<Offer> offers;
    private Map<String, Long> costing;

    public Checkout(List<Offer> offers, Map<String,Long> costing) {
        this.costing = costing;
        this.offers = offers;
    }

    public static Checkout init(List<Offer> offers, Map<String, Long> costing) {
        return new Checkout(offers,costing);
    }

    public Receipt shop(Basket basket) {
        String[] items = basket.getItems();
        Stream<String> belt = Lists.newArrayList(items).stream();

        long total = belt.map(item -> costing.get(item)).reduce(0L,(a,b) -> a+b);
        return Receipt.create(total);
    }
}
