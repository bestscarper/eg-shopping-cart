package shopping;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
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
        Basket basket = Basket.fromList(ImmutableList.of());

        assertEquals(0L, offer.appliedTo(basket, costing));
    }

    @Test
    public void shouldDiscountOneIfGivenFive() throws Exception {
        Basket basket = Basket.fromList(ImmutableList.of(LIME, LIME, LIME, LIME, LIME));

        assertEquals(15L, offer.appliedTo(basket, costing));
    }

    @Test
    public void shouldDiscountOnTwoIfGivenSix() throws Exception {
        Basket basket = Basket.fromList(ImmutableList.of(LIME, LIME, LIME, LIME, LIME, LIME));

        assertEquals(30L, offer.appliedTo(basket, costing));
    }

    @Test
    public void shouldNotDiscountOtherItems() throws Exception {
        Basket basket = Basket.fromList(ImmutableList.of(APPLE, APPLE));

        assertEquals(0L, offer.appliedTo(basket, costing));
    }

}