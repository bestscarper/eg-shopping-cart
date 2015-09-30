package shopping;

public class Receipt {
    private long total;
    private long discount;

    public Receipt(long total, long discount) {
        this.total = total;
        this.discount = discount;
    }

    public static Receipt create(long total, long discount) {

        return new Receipt(total,discount);
    }

    public long totalCost() {

        return this.total - this.discount;
    }
}
