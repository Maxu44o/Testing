
public abstract class Account {
    int currentAmount;

    public boolean payCondition(int amount) {
        return false;
    }

    public boolean transferCondition(int amount) {
        return false;
    }

    public boolean addCondition(int amount) {
        return false;
    }


    public int pay(int amount) {
        System.out.println(getClass().getName() + ": " + currentAmount + "$");
        if (payCondition(amount)) {
            currentAmount -= Math.abs(amount);
            System.out.println(getClass().getName() + " Payment " + amount + " complete. ");
        } else {
            System.out.println("Payment of " + amount + "$ impossible");
        }
        System.out.println(getClass().getName() + ": " + currentAmount + "$");
        System.out.println();
        return currentAmount;
    }

    public int addmoney(int amount) {
        System.out.println(getClass().getName() + ": " + currentAmount + "$");
        if (addCondition(amount)) {
            System.out.println(getClass().getName() + " Adding " + amount + "$ complete. ");
            currentAmount += Math.abs(amount);
        } else {
            System.out.println("Adding of " + amount + "$ impossible");
        }
        System.out.println(getClass().getName() + ": " + currentAmount + "$");
        System.out.println();
        return currentAmount;
    }

    public int transfer(Account account, int amount) {
        System.out.println(this.getClass().getName() + ": " + this.currentAmount + "$");
        System.out.println(account.getClass().getName() + ": " + account.currentAmount + "$");
        if (transferCondition(amount) && account.addCondition(amount)) {
            this.currentAmount -= (Math.abs(amount));
            account.currentAmount += (Math.abs(amount));
            System.out.println(getClass().getName() + "Transfer  " + amount + " complete. ");
        } else {
            System.out.println("Transfer of " + amount + "$ impossible");
        }
        System.out.println(this.getClass().getName() + ": " + this.currentAmount + "$");
        System.out.println(account.getClass().getName() + ": " + account.currentAmount + "$");
        System.out.println();
        return this.currentAmount;
    }

    public String toString() {
        return '{' + "currentAmount=" + currentAmount +
                '}';
    }
}