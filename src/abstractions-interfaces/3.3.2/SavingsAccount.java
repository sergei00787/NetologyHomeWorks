public class SavingsAccount extends Account implements INoNegativeBalance{
    public SavingsAccount(int balance) {
        super(balance);
    }

    @Override
    public int addMoney(int amount) {
        if (isNegativeAmount(amount)) {
            System.out.println("Добавляемая сумма не может быть отрецательной. Операция отменена");
            return 0;
        }
        setBalance(getBalance() + amount);
        System.out.println("На счет поступила сумма " + amount);
        return amount;
    }

    private void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void transfer(Account toAccount, int amount) {
        if (isNegativeAmount(amount)) {
            System.out.println("Переводимая сумма не может быть отрецательной. Операция отменена");
            return;
        }
        if (isNegativeBalanceAfterTransaction(amount)) {
            System.out.println("Перевод не возможен. Недостаточно денег на счете");
        } else {
            int transactionAmount = toAccount.addMoney(amount);
            setBalance(getBalance() - transactionAmount);
            System.out.println("Переведена сумма " + transactionAmount);
        }
    }

    @Override
    public void pay(int amount) {
        System.out.println("Оплата не поддерживается на этом счете");
    }

    @Override
    public boolean isNegativeBalanceAfterTransaction(int amount) {
        return getBalance() < amount;
    }

}
