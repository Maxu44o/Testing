import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class MainTest {

    SavingAccount sacc1;
    SavingAccount sacc2;
    CheckingAccount chacc1;
    CheckingAccount chacc2;
    CreditAccount cracc1;
    CreditAccount cracc2;


    @BeforeEach
    void prepareData() {
        sacc1 = new SavingAccount(500);
        sacc2 = new SavingAccount(0);
        chacc1 = new CheckingAccount(500);
        chacc2 = new CheckingAccount(0);
        cracc1 = new CreditAccount(0);
        cracc2 = new CreditAccount(-500);
    }


    //@ParameterizedTest

    @Test
    void testTransferFromSacc() {
        sacc1.transfer(sacc2, 100);
        sacc1.transfer(chacc2, 100);
        sacc1.transfer(cracc2, 100);
        sacc1.transfer(cracc1, 100);
        Assertions.assertEquals(100, sacc2.currentAmount);
        Assertions.assertEquals(100, chacc2.currentAmount);
        Assertions.assertEquals(0, cracc1.currentAmount);
        Assertions.assertEquals(-400, cracc2.currentAmount);

    }

    @Test
    void testTransferFromChacc() {
        chacc1.transfer(sacc2, 100);
        chacc1.transfer(chacc2, 100);
        chacc1.transfer(cracc2, 100);
        chacc1.transfer(cracc1, 100);
        Assertions.assertEquals(100, sacc2.currentAmount);
        Assertions.assertEquals(100, chacc2.currentAmount);
        Assertions.assertEquals(0, cracc1.currentAmount);
        Assertions.assertEquals(-400, cracc2.currentAmount);

    }

}


