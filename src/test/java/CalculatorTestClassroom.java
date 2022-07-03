import mavenTestNGHomework.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTestClassroom {                   // kalkulatora testesana

    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
//        calculator.sum(10.00, 25.00);                        // objektam "calculator" metodes caur (.) sum, minus, multiply, divide
        Assert.assertEquals(calculator.add(10, 25), 35, "Incorrect result. Please check method implementation");
// Assert.assertEquals - metode, kas salidzina rezultatus ACTUAL vs EXPECTED
    }

    @Test
    public void testMinus() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.substract(25, 10), 15);
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiply(10, 25), 250);
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(30, 10), 3);
    }
}
