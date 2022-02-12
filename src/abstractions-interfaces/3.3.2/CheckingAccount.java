public class CheckingAccount extends Account implements INoNegativeBalance{
    public CheckingAccount(int balance) {
        super(balance);
    }

    private void setBalance(int balance) {
        this.balance = balance;
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

    @Override
    public boolean isNegativeBalanceAfterTransaction(int amount) {
        return getBalance() < amount;
    }

    @Override
    public void pay(int amount) {
        if (isNegativeAmount(amount)) {
            System.out.println("Оплачиваемая сумма не может быть отрецательной. Операция отменена");
            return;
        }
        if (isNegativeBalanceAfterTransaction(amount)) {
            System.out.println("Оплата не возможна. Недостаточно денег на счете");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Оплачена сумма " + amount);
        }
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
}
