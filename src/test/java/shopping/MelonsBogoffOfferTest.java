package shopping;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MelonsBogoffOfferTest {

    private final Map<String, Long> costing = ImmutableMap.of("Melon", 50L);
    private final MelonsBogoffOffer offer = MelonsBogoffOffer.getInstance();

    @Test
    public void shouldActAsSingleton() {
        assertEquals(offer.getClass().getName(),"MelonsBogoffOfferTest");
    }

    @Test
    public void testEmpty() throws Exception {
        List<String> items = Lists.emptyList();

        assertEquals(0L, offer.appliedTo(items, costing));
    }
}