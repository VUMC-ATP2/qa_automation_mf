package mavenTestNGHomework;

import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorTest {
    Calculator calculator;

    @BeforeSuite
    public void beforeSuite() {
        this.calculator = new Calculator();
        System.out.println("Before Suite - will run only once, before all tests in the suite are executed");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method: new test has been started");
    }

    @Test
    public void test1Add() {
        calculator.add(3, 4);
        Assert.assertEquals(calculator.add(3, 4), 7);
        System.out.println("Test 1");
    }

    @Test
    public void test2Substract() {
        Assert.assertEquals(calculator.substract(10, 6), 4);
        System.out.println("Test 2");
    }

    @Test
    public void test3Divide() {
        Assert.assertEquals(calculator.divide(15, 3), 5);
        System.out.println("Test 3");
    }

    @Test
    public void test4Multiply() {
        Assert.assertEquals(calculator.multiply(3, 2), 6);
        System.out.println("Test 4");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method: this test has been finished");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test - all tests are finished.");
    }
}
