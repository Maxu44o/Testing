public class CreditAccount extends Account {

    public CreditAccount(int currentAmount) {
        if (currentAmount <= 0) this.currentAmount = currentAmount;
    }

    @Override
    public boolean payCondition(int amount) {
        return true;
    }

    @Override
    public boolean addCondition(int amount) {
        return (Math.abs(currentAmount) >= amount);
    }


    @Override
    public String toString() {
        return "Credit" + super.toString();
    }
}
