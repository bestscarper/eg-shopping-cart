package shopping;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by ashley on 30/09/2015.
 */
public interface Offer {
    long appliedTo(Basket basket, Map<String, Long> costing);
}
