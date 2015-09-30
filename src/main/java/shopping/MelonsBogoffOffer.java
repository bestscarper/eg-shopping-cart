package shopping;

import java.util.Map;

public class MelonsBogoffOffer implements Offer {

    private static final MelonsBogoffOffer INSTANCE = new MelonsBogoffOffer();
    public static final String MELON = "Melon";

    private MelonsBogoffOffer() {}

    public static MelonsBogoffOffer getInstance() {
        return INSTANCE;
    }

    @Override
    public long appliedTo(Basket basket, Map<String, Long> costing) {
        long count = basket.getItems().stream().filter(MELON::equals).count();
        return count/2 * costing.get(MELON);
    }
}
