package services;

import java.util.Currency;
import java.util.UUID;

public interface WalletService {

    String createNewWallet(Currency currency, String walletType);

    String getMyWallets();

    String deposit(UUID walletId, double amount);

    String transfer(UUID walletId, String receiverUsername, double amount);

    String changeWalletStatus(UUID walletId, String newStatus);
}
