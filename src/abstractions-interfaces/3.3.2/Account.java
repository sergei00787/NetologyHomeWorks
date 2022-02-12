public abstract class Account {
    protected int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public boolean isNegativeAmount(int amount){
        return amount < 0;
    }

    public abstract int addMoney(int amount);
    public abstract void transfer(Account toAccount, int amount);
    public abstract void pay(int amount);

    public void printBalance(){
        System.out.println("Баланс равен " + getBalance());
    }

}
