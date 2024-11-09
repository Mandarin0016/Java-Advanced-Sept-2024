package entities.wallet;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

import static common.SystemErrors.SAVINGS_PERIOD_NOT_CONCLUDED_YET;

public class SavingsWallet extends Wallet {

    private static final double INITIAL_WALLET_BALANCE = 10.00;
    private static final long SAVING_PERIOD_MINUTES = 2;

    private final LocalDateTime savingPeriodEnd;

    public SavingsWallet(UUID ownerId, String ownerUsername, Currency currency) {
        super(ownerId, ownerUsername, currency, INITIAL_WALLET_BALANCE);
        this.savingPeriodEnd = LocalDateTime.now().plusMinutes(SAVING_PERIOD_MINUTES);
    }

    @Override
    public void withdraw(double amount) {
        if (LocalDateTime.now().isBefore(savingPeriodEnd)) {
            long seconds = Duration.between(LocalDateTime.now(), savingPeriodEnd).toSeconds();
            throw new IllegalStateException(SAVINGS_PERIOD_NOT_CONCLUDED_YET.formatted(Math.max(0, seconds)));
        }
        super.withdraw(amount);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        long seconds = Duration.between(LocalDateTime.now(), savingPeriodEnd).toSeconds();
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("Saving period ends within: ").append(Math.max(0, seconds)).append(" seconds");
        return stringBuilder.toString().trim();
    }
}
