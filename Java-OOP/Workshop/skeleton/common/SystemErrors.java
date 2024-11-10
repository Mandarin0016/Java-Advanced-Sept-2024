package common;

public final class SystemErrors {

    public static final String INVALID_USERNAME = "Error: Invalid username, make sure the length is bigger than 4 and contains at least 1 digit.";

    public static final String INVALID_PASSWORD = "Error: Invalid password, make sure the length is exactly 6 and contains only digits.";

    public static final String USER_ALREADY_LOGGED_IN = "Error: User %s is already logged in.";

    public static final String INCORRECT_LOGIN_CREDENTIALS = "Error: Incorrect username/password.";

    public static final String SUCH_USERNAME_ALREADY_EXIST = "Error: Username %s is already in use.";

    public static final String NO_ACTIVE_USER_SESSION_FOUND = "Error: No active user session found. Please log in first.";

    public static final String INSUFFICIENT_FUNDS_IN_WALLET = "Error: Insufficient funds in wallet.";

    public static final String NO_OPERATIONS_ALLOWED_FOR_NON_ACTIVE_WALLET = "Error: This wallet is non-active and cannot process transactions. No operations allowed for this wallet.";

    public static final String WITHDRAWAL_LIMIT_REACHED_FOR_DISPOSABLE_WALLET = "Error: Withdrawal limit reached. This disposable wallet is now inactive and cannot process further transactions.";

    public static final String SAVINGS_PERIOD_NOT_CONCLUDED_YET = "Error: Withdrawals are not permitted until the savings period has concluded. %d seconds left.";

    public static final String INCORRECT_WALLET_TYPE = "Error: Invalid wallet type. Please choose from [Standard, Savings, Disposable].";

    public static final String STANDARD_WALLET_COUNT_LIMIT_REACHED = "Error: Maximum limit of standard wallets reached. You are allowed to have only 1 standard wallets.";

    public static final String WALLET_NOT_ASSOCIATED_WITH_THIS_USER = "Error: User %s is not associated with such wallet.";

    public static final String INCORRECT_WALLET_STATUS = "Error: Invalid wallet status. Please choose from [ACTIVE, INACTIVE].";

    public static final String NO_WALLET_FOUND_FOR_RECEIVER = "Error: Receiver %s has no Standard wallet. Can't initiate transfer.";

    public static final String TRANSFER_CRITERIA_NOT_MET = "Error: You won't be able to initiate this transfer due to criteria not met.";

}

