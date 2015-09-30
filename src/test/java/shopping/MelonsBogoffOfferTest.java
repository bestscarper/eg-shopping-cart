package shopping;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MelonsBogoffOfferTest {

    private final Map<String, Long> costing = ImmutableMap.of("Melon", 50L);
    private final MelonsBogoffOffer offer = MelonsBogoffOffer.getInstance();

    @Test
    public void shouldActAsSingleton() {
        assertEquals("MelonsBogoffOffer", offer.getClass().getSimpleName());
    }

    @Test
    public void testEmpty() throws Exception {
        Basket basket = Basket.fromList(ImmutableList.of());

        assertEquals(0L, offer.appliedTo(basket, costing));
    }

    @Test
    public void shouldDiscountOneIfGivenThree() throws Exception {
        Basket basket = Basket.fromList(ImmutableList.of("Melon", "Melon", "Melon"));

        assertEquals(50L, offer.appliedTo(basket, costing));
    }

    @Test
    public void shouldDiscountTwoIfGivenFour() throws Exception {
        Basket basket = Basket.fromList(ImmutableList.of("Melon", "Melon", "Melon", "Melon"));

        assertEquals(100L, offer.appliedTo(basket, costing));
    }

    @Test
    public void shouldNotDiscountOtherItems() throws Exception {
        Basket basket = Basket.fromList(ImmutableList.of("Apple", "Apple"));

        assertEquals(0L, offer.appliedTo(basket, costing));
    }
}