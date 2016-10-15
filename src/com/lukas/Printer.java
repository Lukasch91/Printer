package com.lukas;

public class Printer {
	private int tonerStorage;
	private int numberOfSheets;
	private final static int FULL_TONNER = 12;
	private final static int FULL_PAPER_STORAGE = 15;

	public Printer(int tonerStorage, int numberOfSheets) {
		this.tonerStorage = tonerStorage;
		this.numberOfSheets = numberOfSheets;
	}

	private void executePrint(int amountOfSheetsToPrint) {
		numberOfSheets -=amountOfSheetsToPrint;
		tonerStorage -=amountOfSheetsToPrint;
		System.out.println("Sheets have been printed");
	}

	private boolean isEnoughPaper(int amountOfSheetsToPrint) {
		if (amountOfSheetsToPrint >= numberOfSheets)
			return true;
		return false;
	}

	private boolean isEnoughToner(int amountOfSheetsToPrint) {
		if (amountOfSheetsToPrint >= tonerStorage)
			return true;
		return false;
	}

	public int getTonerStorage() {
		return tonerStorage;
	}

	public int getNumberOfSheets() {
		return numberOfSheets;
	}

	public void print(int amountOfSheetsToPrint) throws PrinterException {
		if (isEnoughPaper(amountOfSheetsToPrint)) {
			throw new PrinterException("It is not enough paper !");
		}
		if (isEnoughToner(amountOfSheetsToPrint)) {
			throw new PrinterException("It is not enough toner!");
		}
		executePrint(amountOfSheetsToPrint);
	}

	public void refillToner() {
		tonerStorage = FULL_TONNER;
	}

	public void refillPaper() {
		numberOfSheets = FULL_PAPER_STORAGE;
	}
}
