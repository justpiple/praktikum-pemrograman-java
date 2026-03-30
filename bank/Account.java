
public class Account {

    private String accountNumber;
    private int saldo;
    private final int SALDO_MINIMUM = 25_000;

    public Account(String accountNumber, int initialSaldo) {
        if (initialSaldo < SALDO_MINIMUM) {
            throw new IllegalArgumentException("Minimal saldo tidak mencukupi.");
        }
        this.accountNumber = accountNumber;
        this.saldo = initialSaldo;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public void topUp(int saldo) {
        this.saldo += saldo;
    }

    public void withdraw(int nominal) {
        int saldoAfterWithdraw = this.saldo - nominal;
        if (saldoAfterWithdraw < SALDO_MINIMUM) {
            throw new IllegalArgumentException("Minimal saldo tidak mencukupi.");
        }

        this.saldo = saldoAfterWithdraw;
    }

}
