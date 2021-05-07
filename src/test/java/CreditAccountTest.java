import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CreditAccountTest {

    CreditAccount cracc2;
    CreditAccount cracc3;

    @ParameterizedTest
    @ValueSource(ints = {-10, 0, 10})
    void constructor_test(int arg) {
        CreditAccount cracc1 = new CreditAccount(arg);
        if (arg > 0) Assertions.assertEquals(cracc1.currentAmount, 0);
        else Assertions.assertSame(cracc1.currentAmount, arg);
    }

    @BeforeEach
    void prepareData() {
        cracc2 = new CreditAccount(0);
        cracc3 = new CreditAccount(-500);
    }

    @Test
    void testTransferAmount() {
        cracc2.transfer(cracc3, 100);
        Assertions.assertEquals(0, cracc2.currentAmount);
        Assertions.assertEquals(-500, cracc3.currentAmount);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 100, 500, 1000})
    void testAddAmount(int arg) {
        cracc3.addmoney(arg);
        if (arg > Math.abs(-500)) Assertions.assertEquals(-500, cracc3.currentAmount);
        else Assertions.assertEquals(-500 + Math.abs(arg), cracc3.currentAmount);
    }

    @Test
    void testPayAmount() {
        cracc2.pay(100);
        Assertions.assertEquals(-100, cracc2.currentAmount);
    }


}