package shopping;

/**
 * Created by ashley on 30/09/2015.
 */
public class MelonsBogoffOffer implements Offer {

    private static final MelonsBogoffOffer INSTANCE = new MelonsBogoffOffer();

    private MelonsBogoffOffer() {}

    public static MelonsBogoffOffer getInstance() {
        return INSTANCE;
    }

}
