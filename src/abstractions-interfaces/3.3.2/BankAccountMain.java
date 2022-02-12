public class BankAccountMain {
    public static void main(String[] args) {

        Account accountChecking = new CheckingAccount(50_000);
        Account accountCredit = new CreditAccount(50_000);
        Account accountSavings = new SavingsAccount(50_000);

        System.out.println("Проверка расчетного счета на котором баланс " + accountChecking.getBalance());
        System.out.println("Пытаемся оплатить 100_000");
        accountChecking.pay(100_000);
        accountChecking.printBalance();
        System.out.println("Пытаемся оплатить 20_000");
        accountChecking.pay(20_000);
        accountChecking.printBalance();
        System.out.println("Пытаемся перевести 20_000 на кредитный счет");
        accountChecking.transfer(accountCredit, 20_000);
        accountChecking.printBalance();
        System.out.println("Пытаемся положить на счет 10_000");
        accountChecking.addMoney(10_000);
        accountChecking.printBalance();

        System.out.println();
        System.out.println("Проверка кредитного счета с лимитом 50_000");
        System.out.println("Пытаемся оплатить 100_000");
        accountCredit.pay(100_000);
        accountCredit.printBalance();
        System.out.println("Пытаемся оплатить 20_000");
        accountCredit.pay(20_000);
        accountCredit.printBalance();
        System.out.println("Пытаемся перевести 20_000");
        accountCredit.transfer(accountCredit, 20_000);
        accountCredit.printBalance();
        System.out.println("Пытаемся положить 30_000");
        accountCredit.addMoney(30_000);
        accountCredit.printBalance();
        System.out.println("Пытаемся положить 20_000");
        accountCredit.addMoney(20_000);
        accountCredit.printBalance();

        System.out.println();
        System.out.println("Проверка сбер счета с лимитом 50_000");
        System.out.println("Пытаемся оплатить 100_000");
        accountSavings.pay(100_000);
        accountSavings.printBalance();
        System.out.println("Пытаемся оплатить 20_000");
        accountSavings.pay(20_000);
        accountSavings.printBalance();
        System.out.println("Пытаемся перевести 20_000");
        accountSavings.transfer(accountChecking, 20_000);
        accountSavings.printBalance();
        System.out.println("Пытаемся положить 30_000");
        accountSavings.addMoney(30_000);
        accountSavings.printBalance();
        System.out.println("Пытаемся положить 20_000");
        accountSavings.addMoney(20_000);
        accountSavings.printBalance();



    }
}
