package shopping;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CheckoutTest {

    private static final String ITEM = "item";
    private static final Long ITEM_COST = 5L;
    private static final String[] ITEMS = {ITEM};
    private static final java.lang.Long DISCOUNT = 3L;

    @Test
    public void testShop() throws Exception {
        Map<String,Long> costing = ImmutableMap.of(ITEM, ITEM_COST);

        Basket basket = Basket.fromList(ITEMS);

        Offer offer = mock(Offer.class);
        when(offer.appliedTo(basket,costing)).thenReturn(DISCOUNT);
        List<Offer> offers = ImmutableList.of(offer);

        Checkout subject = new Checkout(offers,costing);

        Receipt receipt = subject.shop(basket);
    }
}