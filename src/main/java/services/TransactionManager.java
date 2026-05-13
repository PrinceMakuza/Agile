package services;

import models.Transaction;
import models.Account;
import exceptions.*;
import utils.ApplicationLogger;
import utils.ValidationUtils;

/**
 * Manages transaction recording, retrieval, and processing.
 */
public class TransactionManager {
  private final Transaction[] transactions;
  private int transactionCount;
  private static final int MAX_TRANSACTIONS = 200;

  /**
   * Constructs a new TransactionManager.
   */
  public TransactionManager() {
    this.transactions = new Transaction[MAX_TRANSACTIONS];
    this.transactionCount = 0;
  }

  /**
   * Records a new transaction in the system.
   *
   * @param transaction The transaction to add.
   * @return true if successful, false if capacity reached.
   */
  public boolean addTransaction(Transaction transaction) {
    if (transactionCount < MAX_TRANSACTIONS) {
      transactions[transactionCount] = transaction;
      transactionCount++;
      ApplicationLogger.info(String.format("Transaction recorded: [%s] %s | $%.2f",
          transaction.getAccountNumber(), transaction.getType(), transaction.getAmount()));
      return true;
    }
    ApplicationLogger.warn("Transaction capacity reached. Could not record transaction.");
    return false;
  }

  /**
   * Performs a transfer between two accounts.
   *
   * @param fromAccount The source account.
   * @param toAccount The destination account.
   * @param amount The amount to transfer.
   * @throws InvalidAmountException if amount is invalid.
   * @throws InsufficientFundsException if source account has insufficient funds.
   * @throws OverdraftExceededException if overdraft limit is exceeded.
   */
  public void transfer(Account fromAccount, Account toAccount, double amount)
      throws InvalidAmountException, InsufficientFundsException, OverdraftExceededException {

    ValidationUtils.validatePositiveAmount(amount);
    ApplicationLogger.info(String.format("Transfer initiated: $%.2f from %s to %s",
        amount, fromAccount.getAccountNumber(), toAccount.getAccountNumber()));

    // Execute Withdrawal
    fromAccount.withdraw(amount);
    addTransaction(
        new Transaction(fromAccount.getAccountNumber(), "TRANSFER-OUT", amount, fromAccount.getBalance()));

    // Execute Deposit
    toAccount.deposit(amount);
    addTransaction(
        new Transaction(toAccount.getAccountNumber(), "TRANSFER-IN", amount, toAccount.getBalance()));
  }

  /**
   * Returns the array of transactions.
   *
   * @return The transaction array.
   */
  public Transaction[] getTransactions() {
    return transactions;
  }

  /**
   * Returns the current number of transactions.
   *
   * @return Transaction count.
   */

  public int getTransactionCount() {
    return transactionCount;
  }
}