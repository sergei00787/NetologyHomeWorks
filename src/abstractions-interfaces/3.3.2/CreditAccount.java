public class CreditAccount extends Account {
    private int creditLimit;

    public CreditAccount(int creditLimit) {
        super(0);
        this.creditLimit = creditLimit;
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
        if (isPositiveBalanceAfterTransaction(amount)){
            System.out.println("Баланс не может быть положительным.");
            System.out.println("Для погашения кредитной задолженности вам необходимо положить " + Math.abs(getBalance()) );
        } else {
            setBalance(getBalance() + amount);
            System.out.println("На счет поступила сумма " + amount);
            return amount;
        }
        return 0;

    }

    @Override
    public void transfer(Account toAccount, int amount) {
        System.out.println("Перевод не поддерживается на этом счете");
    }

    @Override
    public void pay(int amount) {
        if (isOverLimit(amount)) {
            System.out.println("Превышен кредитный лимит");
        } else {
            setBalance(getBalance() - amount);
        }
    }

    private boolean isOverLimit(int amount){
        return Math.abs(getBalance() - amount) > creditLimit;
    }

    private boolean isPositiveBalanceAfterTransaction(int amount){
        return getBalance() + amount > 0;
    }
}
