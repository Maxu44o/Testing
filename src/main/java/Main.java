public class Main {
    public static void main(String[] args) throws Exception {

        Account savingAccount = new SavingAccount(10);
        Account creditAccount = new CreditAccount(10);
        Account checkingAccount = new CheckingAccount(10);

        System.out.println(savingAccount);
        System.out.println(creditAccount);
        System.out.println(checkingAccount);

        savingAccount.addmoney(50);
        savingAccount.transfer(checkingAccount, 1800);
        checkingAccount.addmoney(20);
        creditAccount.pay(400);
        checkingAccount.transfer(creditAccount, 10);
        savingAccount.pay(50);
        checkingAccount.transfer(creditAccount, 5000);

    }
}
