package shopping;

import java.util.List;
import java.util.Map;

/**
 * Created by ashley on 30/09/2015.
 */
public class Checkout {
    public static Checkout init(List<Offer> offers, Map<String, Long> costing) {
        return new Checkout();
    }

    public static Receipt shop(Basket basket) {
        return Receipt.create();
    }
}
