package shopping;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class IntegrationTest {

    private final String[] emptyList = new String[]{};
    private final Map<String, Long> costing = ImmutableMap.of("Apple", 35L, "Banana", 20L, "Melon", 50L, "Lime", 15L);

    @Test
    public void emptyBasketNoOffers() throws Exception {

        List<Offer> offers = ImmutableList.of();
        Map<String,Long> costing = ImmutableMap.of();

        Checkout checkout = Checkout.init(offers, costing);

        Basket basket = Basket.fromList(emptyList);
        Receipt receipt = checkout.shop(basket);

        assertEquals(receipt.totalCost(), 0);
    }

    @Test
    public void simpleBasketNoOffers() throws Exception {
        String[] simpleList = {"Apple", "Apple", "Banana"};

        List<Offer> offers = ImmutableList.of();
        Map<String,Long> costing = ImmutableMap.of("Apple", 35L, "Banana", 20L);

        Checkout checkout = Checkout.init(offers, costing);

        Basket basket = Basket.fromList(simpleList);
        Receipt receipt = checkout.shop(basket);
        assertEquals(receipt.totalCost(), 90);
    }

    // Melons are 50p each, but are available as "buy one get one free"
    @Test
    public void melonsBogoff() throws Exception {
        String[] melons = {"Apple", "Apple", "Melon", "Melon", "Melon"};

        List<Offer> offers = ImmutableList.of(MelonsBogoffOffer.getInstance());

        Checkout checkout = Checkout.init(offers, costing);

        Basket basket = Basket.fromList(melons);
        Receipt receipt = checkout.shop(basket);
        assertEquals(receipt.totalCost(), 170);
    }

    //  - Limes are 15p each, but are available in a "three for the price [of] two" offer
    @Test
    public void multipleDiscounts() throws Exception {
        String[] melons = {"Lime", "Melon", "Lime", "Melon", "Lime"};

        List<Offer> offers = ImmutableList.of(MelonsBogoffOffer.getInstance(), Limes3for2Offer.getInstance());

        Checkout checkout = Checkout.init(offers, costing);

        Basket basket = Basket.fromList(melons);
        Receipt receipt = checkout.shop(basket);
        assertEquals(receipt.totalCost(), 50L + 30L); // 2 melons + 3 limes
    }
}