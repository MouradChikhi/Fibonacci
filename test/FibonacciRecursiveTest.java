import Service.ServiceFibonacci;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Classe de test pour la méthode de calcul récursif de la suite de Fibonacci.
 */
class FibonacciRecursiveTest {
    ServiceFibonacci serviceFibonacci;
    @BeforeEach
    void setUp() {
        serviceFibonacci = new ServiceFibonacci();
    }

    @AfterEach
    void tearDown() {
        serviceFibonacci = null;
    }

    @Test
    void calculerTermeFibonacciRec() {

       assertEquals(serviceFibonacci.calculerTermeFibonacciRecursive(40), BigInteger.valueof(102334155));
    }


}
