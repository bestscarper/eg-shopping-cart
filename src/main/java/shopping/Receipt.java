package shopping;

/**
 * Created by ashley on 30/09/2015.
 */
public class Receipt {
    private long total;

    public Receipt(long total) {
        this.total = total;
    }

    public static Receipt create(long total) {

        return new Receipt(total);
    }

    public long totalCost() {

        return this.total;
    }
}
