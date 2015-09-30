package shopping;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Limes3for2OfferTest {

    public static final String LIME = "Lime";
    public static final String APPLE = "Apple";

    private final Map<String, Long> costing = ImmutableMap.of(LIME, 15L);
    private final Limes3for2Offer offer = Limes3for2Offer.getInstance();

    @Test
    public void testEmpty() throws Exception {
        List<String> items = Lists.emptyList();

        assertEquals(0L, offer.appliedTo(items, costing));
    }

    @Test
    public void shouldDiscountOneIfGivenFive() throws Exception {
        List<String> items = ImmutableList.of(LIME, LIME, LIME, LIME, LIME);

        assertEquals(15L, offer.appliedTo(items, costing));
    }

    @Test
    public void shouldDiscountTwoIfGivenSix() throws Exception {
        List<String> items = ImmutableList.of(LIME, LIME, LIME, LIME);

        assertEquals(30L, offer.appliedTo(items, costing));
    }

    @Test
    public void shouldNotDiscountOtherItems() throws Exception {
        List<String> items = ImmutableList.of(APPLE, APPLE);

        assertEquals(0L, offer.appliedTo(items, costing));
    }

}