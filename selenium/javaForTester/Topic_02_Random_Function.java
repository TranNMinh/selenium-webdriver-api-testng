package javaForTester;

import java.util.Random;

public class Topic_02_Random_Function {
	
	public static void main(String[] args) {
		Random rand = new Random();
			
		System.out.println(rand.nextBoolean());
		System.out.println(rand.nextDouble());
		System.out.println(rand.nextDouble());
		System.out.println(rand.nextDouble());
		System.out.println(rand.nextDouble());
		System.out.println(rand.nextFloat());
		System.out.println();
		System.out.println(rand.nextInt());
		System.out.println(rand.nextInt());
		System.out.println(rand.nextInt());
		System.out.println(rand.nextInt());
		
		System.out.println();
		System.out.println(rand.nextInt(9999));
		System.out.println(rand.nextInt(9999));
		System.out.println(rand.nextInt(9999));
		System.out.println(rand.nextInt(9999));
		
		System.out.println();
		System.out.println(rand);
		System.out.println(rand.toString());
		System.out.println(rand.hashCode());
		
		String EmailAdress = "Dong" + rand.nextInt(9999) + "@yahoo.com";
		System.out.println();
		System.out.println(EmailAdress);
		System.out.println(EmailAdress);
		System.out.println(EmailAdress);
		System.out.println(EmailAdress);

	}
}
