package services.imp;

import core.UserSessionManager;
import entities.user.User;
import entities.wallet.*;
import repositories.WalletRepository;
import services.WalletService;

import java.util.Currency;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static common.LogMessages.*;
import static common.SystemErrors.*;

// TODO:
// 1. Implement all methods
// 2. Make sure this service implementation has dependency a SessionManager
// so you can determine which is the currently logged in user.
public class WalletServiceImpl implements WalletService {

    private UserSessionManager sessionManager;
    private WalletRepository walletRepository;

    public WalletServiceImpl(UserSessionManager sessionManager) {
        this.sessionManager = sessionManager;
        this.walletRepository = new WalletRepository();
    }

    @Override
    public String createNewWallet(Currency currency, String walletType) {

        validActiveSession();

        User activeUser = sessionManager.getActiveSession();

        //Standard, Disposable, Savings
        Wallet wallet;
        switch (walletType) {
            case "Standard" -> wallet = new StandardWallet(activeUser.getId(), activeUser.getUsername(), currency);
            case "Disposable" -> wallet = new DisposableWallet(activeUser.getId(), activeUser.getUsername(), currency);
            case "Savings" -> wallet = new SavingsWallet(activeUser.getId(), activeUser.getUsername(), currency);
            default -> throw new IllegalArgumentException(INCORRECT_WALLET_TYPE);
        }

        if (walletType.equals("Standard")) {
            List<Wallet> activeUserWallets = walletRepository.getAll()
                    .stream()
                    .filter(w -> w.getOwnerId().equals(activeUser.getId()))
                    .toList();
            for (Wallet currentWallet : activeUserWallets) {
                if (currentWallet instanceof StandardWallet) {
                    throw new IllegalStateException(STANDARD_WALLET_COUNT_LIMIT_REACHED);
                }
            }
        }

        walletRepository.save(wallet.getId(), wallet);

        return wallet.toString();
    }

    @Override
    public String getMyWallets() {

        validActiveSession();
        User activeUser = sessionManager.getActiveSession();

        List<Wallet> userWallets = walletRepository.getAll().stream()
                .filter(wallet -> wallet.getOwnerId().equals(activeUser.getId()))
                .toList();

        if (userWallets.isEmpty()){
            return ZERO_WALLETS;
        }

        return userWallets.stream().map(Wallet::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String deposit(UUID walletId, double amount) {

        Wallet wallet = getCurrentlyActiveUserWallet(walletId);

        wallet.deposit(amount);

        return SUCCESSFULLY_DEPOSITED_AMOUNT.formatted(wallet.getBalance(), wallet.getCurrency());
    }

    @Override
    public String transfer(UUID walletId, String receiverUsername, double amount) {

        Wallet senderWallet = getCurrentlyActiveUserWallet(walletId);
        Wallet receiverWallet = walletRepository.getAll().stream()
                .filter(w -> w.getOwnerUsername().equals(receiverUsername) && w instanceof StandardWallet)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(NO_WALLET_FOUND_FOR_RECEIVER.formatted(receiverUsername)));

        boolean isSenderWalletActive = senderWallet.getStatus() == WalletStatus.ACTIVE;
        boolean isReceiverWalletActive = receiverWallet.getStatus() == WalletStatus.ACTIVE;
        boolean isSameCurrency = senderWallet.getCurrency().equals(receiverWallet.getCurrency());

        if (!isSenderWalletActive || !isReceiverWalletActive || !isSameCurrency) {
            throw new IllegalStateException(TRANSFER_CRITERIA_NOT_MET);
        }

        senderWallet.withdraw(amount);
        receiverWallet.deposit(amount);

        return SUCCESSFUL_FUNDS_TRANSFER.formatted(senderWallet.getOwnerUsername(), amount, receiverUsername, senderWallet.getBalance());
    }

    @Override
    public String changeWalletStatus(UUID walletId, String newStatus) {

        Wallet wallet = getCurrentlyActiveUserWallet(walletId);

        WalletStatus status;
        switch (newStatus) {
            case "ACTIVE" -> status = WalletStatus.ACTIVE;
            case "INACTIVE" -> status = WalletStatus.INACTIVE;
            default -> throw new IllegalArgumentException(INCORRECT_WALLET_STATUS);
        }

        wallet.setStatus(status);

        return SUCCESSFULLY_CHANGED_WALLET_STATUS.formatted(status);
    }

    private Wallet getCurrentlyActiveUserWallet(UUID walletId) {

        validActiveSession();
        User activeUser = sessionManager.getActiveSession();

        return walletRepository.getAll().stream()
                .filter(w -> w.getId().equals(walletId) && w.getOwnerId().equals(activeUser.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(WALLET_NOT_ASSOCIATED_WITH_THIS_USER.formatted(activeUser.getUsername())));
    }

    private void validActiveSession() {

        if (!sessionManager.hasActiveSession()) {
            throw new IllegalStateException(NO_ACTIVE_USER_SESSION_FOUND);
        }
    }
}
