import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {                   // kalkulatora testesana

    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
//        calculator.sum(10.00, 25.00);                        // objektam "calculator" metodes caur (.) sum, minus, multiply, divide
        Assert.assertEquals(calculator.sum(10.00, 25.00), 35, "Incorrect result. Please check method implementation");
// Assert.assertEquals - metode, kas salidzina rezultatus ACTUAL vs EXPECTED
    }

    @Test
    public void testMinus() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.minus(25.00, 10.00), 15);
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiply(10.00, 25.00), 250);
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(30.00, 10.00), 3);
    }
}
