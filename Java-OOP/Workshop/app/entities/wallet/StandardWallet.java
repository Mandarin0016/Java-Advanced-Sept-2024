package entities.wallet;

import java.util.Currency;
import java.util.UUID;

public class StandardWallet extends Wallet {

    private static final double INITIAL_WALLET_BALANCE = 20.00;

    public StandardWallet(UUID ownerId, String ownerUsername, Currency currency) {
        super(ownerId, ownerUsername, currency, INITIAL_WALLET_BALANCE);
    }
}
