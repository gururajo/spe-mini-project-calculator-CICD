package com.example.calculator.scientific;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.stereotype.Service;


@Service
public class ScientificCalculatorService {

   public BigInteger calculateFactorial( int number ) {
      if (number < 0) {
         throw new ArithmeticException("factorial is only defined for positive numbers");
      }
      BigInteger result = BigInteger.ONE;
      for (int i = number; i > 0; i--) {
         result = result.multiply(BigInteger.valueOf(i));
      }
      return result;
   }

   public boolean isPrime( long number ) {
      if ( number <= 1) {
         return false;
      }
      for (int i = 2; i * i <= number; i++) {
         if (number % i == 0) {
            return false;
         }
      }
      return true;
   }
   public BigDecimal calculateSquareRoot(BigDecimal number) {
      if (number.compareTo(BigDecimal.ZERO) < 0) {
         throw new ArithmeticException("Square root is not defined for negative numbers");
      }
      return new BigDecimal(Math.sqrt(number.doubleValue()));
   }

   public double calculateNaturalLogarithm(double number) {
      if (number <= 0) {
         throw new ArithmeticException("Natural logarithm is not defined for non-positive numbers");
      }
      return Math.log(number);
   }

   public BigDecimal calculatePower(BigDecimal base, BigDecimal exponent) {
      if (base.compareTo(BigDecimal.ZERO) == 0 && exponent.compareTo(BigDecimal.ZERO) <= 0) {
         throw new ArithmeticException("0^0 is undefined");
      }
      return base.pow(exponent.intValue());
   }
}
