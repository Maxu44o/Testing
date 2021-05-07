import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class SavingAccountTest {

    SavingAccount acc2;
    SavingAccount acc3;

    @ParameterizedTest
    @ValueSource(ints = {-10, 0, 10})
    void constructor_test(int arg) {
        SavingAccount acc1 = new SavingAccount(arg);
        if (arg < 0) Assertions.assertEquals(acc1.currentAmount, 0);
        else Assertions.assertSame(acc1.currentAmount, arg);
    }

    @BeforeEach
    void prepareData() {
        acc2 = new SavingAccount(500);
        acc3 = new SavingAccount(0);
    }


    @ParameterizedTest
    @ValueSource(ints = {-1000, -500, 0, 500, 1000})
    void testTransferCondition(int arg) {
        if (arg <= acc2.currentAmount) Assertions.assertTrue(acc2.transferCondition(arg));
        else Assertions.assertFalse(acc2.transferCondition(arg));
    }


    @ParameterizedTest
    @ValueSource(ints = {-100, 0, 100, 200, 300})
    void testTransferAmount(int arg) {
        acc2.transfer(acc3, arg);
        Assertions.assertEquals(500 - Math.abs(arg), acc2.currentAmount);
        Assertions.assertEquals(0 + Math.abs(arg), acc3.currentAmount);
    }


    @ParameterizedTest
    @ValueSource(ints = {-100, 0, 100, 200, 300})
    void testAddAmount(int arg) {
        acc2.addmoney(arg);
        Assertions.assertEquals(500 + Math.abs(arg), acc2.currentAmount);
    }

    @Test
        void testPayAmount() {
        acc2.pay(100);
        Assertions.assertEquals(500,acc2.currentAmount);
        Assertions.assertFalse(acc2.payCondition(100));
        }


}