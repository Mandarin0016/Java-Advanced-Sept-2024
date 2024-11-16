package entities.wallet;

import java.util.Currency;
import java.util.UUID;

public class StandardWallet extends Wallet {

    public StandardWallet(UUID ownerId, String ownerUsername, Currency currency) {
        super(ownerId, ownerUsername, currency, 20.00);
    }
}
