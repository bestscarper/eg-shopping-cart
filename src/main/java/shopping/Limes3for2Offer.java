package shopping;

import java.util.List;
import java.util.Map;

import static java.lang.Math.floor;

public class Limes3for2Offer implements Offer {

    private static final Limes3for2Offer INSTANCE = new Limes3for2Offer();
    public static final String LIME = "Lime";

    private Limes3for2Offer() {}

    public static Limes3for2Offer getInstance() {
        return INSTANCE;
    }

    @Override
    public long appliedTo(List<String> belt, Map<String, Long> costing) {
        long count = belt.stream().filter(LIME::equals).count();
        return count / 3 * costing.get(LIME);
    }
}
