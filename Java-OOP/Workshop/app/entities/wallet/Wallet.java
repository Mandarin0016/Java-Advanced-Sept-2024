package entities.wallet;

import java.util.Currency;
import java.util.UUID;

import static common.SystemErrors.INSUFFICIENT_FUNDS_IN_WALLET;
import static common.SystemErrors.NO_OPERATIONS_ALLOWED_FOR_NON_ACTIVE_WALLET;

public abstract class Wallet {

    private final UUID id;
    private final UUID ownerId;
    private final String ownerUsername;
    private final Currency currency;
    private double balance;
    private WalletStatus status;

    public Wallet(UUID ownerId, String ownerUsername, Currency currency, double initialBalance) {
        this.id = UUID.randomUUID();
        this.ownerId = ownerId;
        this.ownerUsername = ownerUsername;
        this.currency = currency;
        this.balance = initialBalance;
        this.status = WalletStatus.ACTIVE;
    }

    public UUID getId() {
        return id;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public WalletStatus getStatus() {
        return status;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setStatus(WalletStatus status) {
        this.status = status;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void deposit(double amount) {

        if (this.status == WalletStatus.INACTIVE) {
            throw new IllegalStateException(NO_OPERATIONS_ALLOWED_FOR_NON_ACTIVE_WALLET);
        }

        double currentBalance = getBalance();
        setBalance(currentBalance + amount);
    }

    public void withdraw(double amount) {

        if (this.status == WalletStatus.INACTIVE) {
            throw new IllegalStateException(NO_OPERATIONS_ALLOWED_FOR_NON_ACTIVE_WALLET);
        }

        double currentBalance = getBalance();
        if (currentBalance < amount) {
            throw new IllegalStateException(INSUFFICIENT_FUNDS_IN_WALLET);
        }
        setBalance(currentBalance - amount);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Wallet [%s][%s]:".formatted(id, this.getClass().getSimpleName())).append(System.lineSeparator());
        stringBuilder.append("Owner: ").append(ownerUsername).append(System.lineSeparator());
        stringBuilder.append("Currency: ").append(currency).append(System.lineSeparator());
        stringBuilder.append("Balance: ").append(balance).append(System.lineSeparator());
        stringBuilder.append("Status: ").append(status);
        return stringBuilder.toString();
    }
}
