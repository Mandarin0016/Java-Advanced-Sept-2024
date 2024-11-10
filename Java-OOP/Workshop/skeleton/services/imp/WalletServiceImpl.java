package services.imp;

import services.WalletService;

import java.util.Currency;
import java.util.UUID;

// TODO:
// 1. Implement all methods
// 2. Make sure this service implementation has dependency a SessionManager
// so you can determine which is the currently logged in user.
public class WalletServiceImpl implements WalletService {


    @Override
    public String createNewWallet(Currency currency, String walletType) {
        return "";
    }

    @Override
    public String getMyWallets() {
        return "";
    }

    @Override
    public String deposit(UUID walletId, double amount) {
        return "";
    }

    @Override
    public String transfer(UUID walletId, String receiverUsername, double amount) {
        return "";
    }

    @Override
    public String changeWalletStatus(UUID walletId, String newStatus) {
        return "";
    }
}
