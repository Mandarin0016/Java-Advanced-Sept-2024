package entities.wallet;

import java.util.Currency;
import java.util.UUID;

import static common.SystemErrors.WITHDRAWAL_LIMIT_REACHED_FOR_DISPOSABLE_WALLET;

public class DisposableWallet extends Wallet {

    private static final double INITIAL_WALLET_BALANCE = 0.00;
    private static final int WITHDRAWS_LIMIT = 2;

    private int withdrawAttempts;

    public DisposableWallet(UUID ownerId, String ownerUsername, Currency currency) {
        super(ownerId, ownerUsername, currency, INITIAL_WALLET_BALANCE);
        this.withdrawAttempts = 0;
    }

    @Override
    public void withdraw(double amount) {
        if (withdrawAttempts == WITHDRAWS_LIMIT) {
            setStatus(WalletStatus.INACTIVE);
            throw new IllegalStateException(WITHDRAWAL_LIMIT_REACHED_FOR_DISPOSABLE_WALLET);
        }
        super.withdraw(amount);
        withdrawAttempts++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("Max withdrawals: ").append(WITHDRAWS_LIMIT).append(System.lineSeparator());
        stringBuilder.append("Current withdrawals: ").append(withdrawAttempts);
        return stringBuilder.toString();
    }
}
