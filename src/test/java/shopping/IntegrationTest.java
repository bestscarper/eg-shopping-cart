package shopping;

import com.google.common.collect.ImmutableMap;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class IntegrationTest {

    @Test
    public void emptyBasketNoOffers() throws Exception {
        String[] emptyList = {};

        List<Offer> offers = Lists.emptyList();
        Map<String,Long> costing = ImmutableMap.of();

        Checkout checkout = Checkout.init(offers, costing);

        Basket basket = Basket.fromList(emptyList);
        Receipt receipt = Checkout.shop(basket);

        assertEquals(receipt.totalCost(), 0);
    }


}