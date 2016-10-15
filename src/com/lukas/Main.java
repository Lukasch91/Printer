package com.lukas;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		Printer printer = new Printer(12, 15);
		boolean keepRunning = true;
		while (keepRunning) {

			System.out.println(
					"Insert number: \n1 - Print;\n2 - Refill toner;\n3 - Refill paper;\n4 - Check paper;\n5 - Check toner; \n6 - Turn off");
			String input = reader.next();
			if (input.equals("1")) {
				System.out.println("How many sheets do you want to print?");
				int numbersOfSheets = reader.nextInt();
				try {
					printer.print(numbersOfSheets);
				} catch (PrinterException e) {
					System.out.println(e.getMessage());
				}
			} else if (input.equals("2")) {
				printer.refillToner();
				System.out.println("Toner has been refilled");
			} else if (input.equals("3")) {
				printer.refillPaper();
				System.out.println("Sheets have been refilled");
			} else if (input.equals("4")) {
				System.out.println("Sheets left : " + printer.getNumberOfSheets());
			} else if (input.equals("5")) {
				System.out.println("Toner left :" + printer.getTonerStorage() + "ml");
			} else if (input.equals("6")) {
				keepRunning = false;
			}
		}

	}

}
