package shopping;

import java.util.List;
import java.util.Map;

public class MelonsBogoffOffer implements Offer {

    private static final MelonsBogoffOffer INSTANCE = new MelonsBogoffOffer();

    private MelonsBogoffOffer() {}

    public static MelonsBogoffOffer getInstance() {
        return INSTANCE;
    }

    @Override
    public long appliedTo(List<String> belt, Map<String, Long> costing) {
        long count = belt.stream().filter( item -> "Melon".equals(item) ).count();
        return count/2 * costing.get("Melon");
    }
}
