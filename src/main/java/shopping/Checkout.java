package shopping;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
        List<String> items = basket.getItems();

        long total = basket.getItemTotal(costing);

        // this could do with more SRP
        long discount = offers
                .stream()
                .map(offer -> {
                    return offer.appliedTo(basket, costing);
                })
                .reduce(0L, (a, b) -> a + b);

        return Receipt.create(total,discount);
    }
}
