package case04;

import java.util.Scanner;

public class UserSystem {
	
	public static void menu() {
		while (true) {
			System.out.println("--------------");
			System.out.println("1. 新增");
			System.out.println("2. 修改");
			System.out.println("3. 刪除");
			System.out.println("4. 查詢全部");
			System.out.println("5. 查詢平均年齡");
			System.out.println("0. Exit");
			System.out.println("--------------");
			System.out.print("請選擇: ");
			menuChoice();
		}
	}
	
	private static void menuChoice() {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		switch (input) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 0:
			System.out.println("離開系統");
			System.exit(1);
	
		}
	}

	public static void main(String[] args) {
		
	}
