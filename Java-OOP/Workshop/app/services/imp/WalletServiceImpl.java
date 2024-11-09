package services.imp;

import core.SessionManager;
import entities.user.User;
import entities.wallet.*;
import repositories.WalletRepository;
import services.WalletService;

import java.util.Currency;
import java.util.List;
import java.util.UUID;

import static common.LogMessages.*;
import static common.SystemErrors.*;

public class WalletServiceImpl implements WalletService {

    private static final int MAX_COUNT_OF_STANDARD_WALLETS = 1;

    private SessionManager sessionManager;
    private WalletRepository walletRepository;

    public WalletServiceImpl(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        this.walletRepository = new WalletRepository();
    }

    @Override
    public String createNewWallet(Currency currency, String walletType) {

        validateActiveSessionExist();
        User activeUser = sessionManager.getActiveUser();

        Wallet wallet;
        switch (walletType) {
            case "Standard" -> wallet = new StandardWallet(activeUser.getId(), activeUser.getUsername(), currency);
            case "Savings" -> wallet = new SavingsWallet(activeUser.getId(), activeUser.getUsername(), currency);
            case "Disposable" -> wallet = new DisposableWallet(activeUser.getId(), activeUser.getUsername(), currency);
            default -> throw new IllegalArgumentException(INCORRECT_WALLET_TYPE);
        }

        // Validation that user has only 1 standard wallet
        if (wallet instanceof StandardWallet) {
            long numberOfStandardWallets = walletRepository.getAll().stream()
                    .filter(w -> w.getOwnerId().equals(activeUser.getId()))
                    .filter(w -> w instanceof StandardWallet)
                    .count();

            if (numberOfStandardWallets > 0) {
                throw new IllegalStateException(STANDARD_WALLET_COUNT_LIMIT_REACHED.formatted(MAX_COUNT_OF_STANDARD_WALLETS));
            }
        }

        walletRepository.save(wallet.getId(), wallet);

        return wallet.toString().trim();
    }

    private void validateActiveSessionExist() {

        if (!sessionManager.hasActiveSession()) {
            throw new IllegalStateException(NO_ACTIVE_USER_SESSION_FOUND);
        }
    }

    @Override
    public String getMyWallets() {

        validateActiveSessionExist();
        User activeUser = sessionManager.getActiveUser();

        List<Wallet> userWallets = walletRepository.getAll().stream()
                .filter(w -> w.getOwnerId().equals(activeUser.getId()))
                .toList();

        if (userWallets.isEmpty()) {
            return ZERO_WALLETS;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Wallet wallet : userWallets) {
            stringBuilder.append(wallet.toString().trim()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public String deposit(UUID walletId, double amount) {

        Wallet wallet = getUserWallet(walletId);

        wallet.deposit(amount);

        return SUCCESSFULLY_DEPOSITED_AMOUNT.formatted(wallet.getBalance(), wallet.getCurrency());
    }

    @Override
    public String transfer(UUID walletId, String receiverUsername, double amount) {

        Wallet senderWaller = getUserWallet(walletId);
        Wallet receiverWallet = walletRepository.getAll().stream()
                .filter(w -> w.getOwnerUsername().equals(receiverUsername))
                .filter(w -> w instanceof StandardWallet)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(NO_WALLET_FOUND_FOR_RECEIVER.formatted(receiverUsername)));

        boolean isSenderWalletActive = senderWaller.getStatus() == WalletStatus.ACTIVE;
        boolean isReceiverWalletActive = receiverWallet.getStatus() == WalletStatus.ACTIVE;
        boolean isCurrencySame = senderWaller.getCurrency().equals(receiverWallet.getCurrency());

        if (!isSenderWalletActive || !isReceiverWalletActive || !isCurrencySame) {
            throw new IllegalStateException(TRANSFER_CRITERIA_NOT_MET);
        }

        senderWaller.withdraw(amount);
        receiverWallet.deposit(amount);

        return SUCCESSFUL_FUNDS_TRANSFER.formatted(senderWaller.getOwnerUsername(), amount, receiverUsername, senderWaller.getBalance());
    }

    @Override
    public String changeWalletStatus(UUID walletId, String newStatus) {

        Wallet wallet = getUserWallet(walletId);

        WalletStatus status = switch (newStatus) {
            case "ACTIVE" -> WalletStatus.ACTIVE;
            case "INACTIVE" -> WalletStatus.INACTIVE;
            default -> throw new IllegalArgumentException(INCORRECT_WALLET_STATUS);
        };

        wallet.setStatus(status);

        return SUCCESSFULLY_CHANGED_WALLET_STATUS.formatted(status);
    }

    private Wallet getUserWallet(UUID walletId) {

        validateActiveSessionExist();
        User activeUser = sessionManager.getActiveUser();

        Wallet wallet = walletRepository.getById(walletId);
        if (wallet == null || !wallet.getOwnerId().equals(activeUser.getId())) {
            throw new IllegalStateException(WALLET_NOT_ASSOCIATED_WITH_THIS_USER.formatted(activeUser.getUsername()));
        }
        return wallet;
    }
}
