package 유용한클래스;

import java.math.BigDecimal;
import java.math.BigInteger;

public class _05빅데시멀 {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		
		BigInteger bigNum1 = new BigInteger("9223372036854775807111111");
		BigInteger bigNum2 = new BigInteger("9999999999999999999999999");
		
		System.out.println(bigNum1);
		System.out.println(bigNum2);
		
		System.out.println(bigNum1.add(bigNum2));
		System.out.println(bigNum1.subtract(bigNum2));
		System.out.println(bigNum1.multiply(bigNum2));
		System.out.println(bigNum1.divide(bigNum2));
		
		
		double num =0.1;
		BigDecimal num2 = new BigDecimal("0.0");
		
		for(int i =0; i < 1000;i+=1) {
			num+= 0.1;
			num2 = num2.add(new BigDecimal("0.1"));
			
		}
		System.out.println(num);
		System.out.println(num2);
		
	}

}
