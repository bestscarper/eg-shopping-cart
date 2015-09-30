package shopping;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReceiptTest {

    @Test
    public void testTotalCost() throws Exception {
        Receipt subject = Receipt.create(30,10);
        assertEquals(subject.totalCost(),20);
    }
}