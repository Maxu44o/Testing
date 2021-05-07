public class SavingAccount extends Account {

    public SavingAccount(int currentAmount) {
        if (currentAmount >= 0) this.currentAmount = currentAmount;
    }

    @Override
    public boolean transferCondition(int amount) {
        return (currentAmount >= amount);
    }

    @Override
    public boolean addCondition(int amount) {
        return true;
    }

    @Override
    public String toString() {
        return "Saving" + super.toString();
    }

}
