package etc;

import java.util.Scanner;

public class Debuging {

	public static void main(String[] args) {
		
		Scanner scanf = new Scanner(System.in);
		
		System.out.println("수1 >> ");
		int num1 = scanf.nextInt();
		
		System.out.println("수2 >>");
		int num2 = scanf.nextInt();
		
		while(num1 <= num2) {
			System.out.println(num1);
			
			num1++;
		}
		
		
//		int num;
//		
//		System.out.println("나이 >> ");
//		num = scanf.nextInt();
//
//		if(num >= 10) {
//			System.out.println("10살 이상입니다.");
//		}else {
//			System.out.println("10살 미만입니다.");
//		}
//		
//		System.out.println("num => " + num);
	}
}
