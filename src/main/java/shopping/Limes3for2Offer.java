package shopping;

import java.util.Map;

public class Limes3for2Offer implements Offer {

    private static final Limes3for2Offer INSTANCE = new Limes3for2Offer();
    public static final String LIME = "Lime";

    private Limes3for2Offer() {}

    public static Limes3for2Offer getInstance() {
        return INSTANCE;
    }

    @Override
    public long appliedTo(Basket basket, Map<String, Long> costing) {
        long count = basket.getItems().stream().filter(LIME::equals).count();
        return count / 3 * costing.get(LIME);
    }
}
