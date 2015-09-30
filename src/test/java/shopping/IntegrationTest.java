package shopping;

import com.google.common.collect.ImmutableMap;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class IntegrationTest {

    private final String[] emptyList = new String[]{};

    @Test
    public void emptyBasketNoOffers() throws Exception {

        List<Offer> offers = Lists.emptyList();
        Map<String,Long> costing = ImmutableMap.of();

        Checkout checkout = Checkout.init(offers, costing);

        Basket basket = Basket.fromList(emptyList);
        Receipt receipt = checkout.shop(basket);

        assertEquals(receipt.totalCost(), 0);
    }

    @Test
    public void simpleBasketNoOffers() throws Exception {
        String[] simpleList = {"Apple", "Apple", "Banana"};

        List<Offer> offers = Lists.emptyList();
        Map<String,Long> costing = ImmutableMap.of("Apple", 35L, "Banana", 20L);

        Checkout checkout = Checkout.init(offers, costing);

        Basket basket = Basket.fromList(simpleList);
        Receipt receipt = checkout.shop(basket);
        assertEquals(receipt.totalCost(), 90);

    }

}