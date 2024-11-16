package entities.wallet;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

import static common.SystemErrors.SAVINGS_PERIOD_NOT_CONCLUDED_YET;

public class SavingsWallet extends Wallet {

    private LocalDateTime savingPeriodEnd;

    public SavingsWallet(UUID ownerId, String ownerUsername, Currency currency) {
        super(ownerId, ownerUsername, currency, 10.00);
        this.savingPeriodEnd = LocalDateTime.now().plusMinutes(2);
    }

    @Override
    public void withdraw(double amount) {

        //LocalDateTime.now() - сегашно време (дата и час)
        if (LocalDateTime.now().isBefore(savingPeriodEnd)) {
            long leftSecond = Duration.between(LocalDateTime.now(), savingPeriodEnd).toSeconds();
            throw new IllegalStateException(SAVINGS_PERIOD_NOT_CONCLUDED_YET.formatted(leftSecond));
        }

        super.withdraw(amount);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        long seconds = Duration.between(LocalDateTime.now(), savingPeriodEnd).toSeconds();
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("Saving period ends within: ").append(Math.max(0, seconds)).append(" seconds");
        return stringBuilder.toString();
    }
}
