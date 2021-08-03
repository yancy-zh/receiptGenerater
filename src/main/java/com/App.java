package com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws Exception {
		FileIO fileIO = new FileIO();
		// read user input
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please type in the absolute path of the input file in the format of \"<ABSOLUTE_PATH>/FILENAME.txt\"");
		String file = keyboard.next();
		keyboard.close();
		String line;
		// create file read buffer 
		BufferedReader br = fileIO.getBufferedReader(new File(file));
		List<ShoppingItem> shoppingItems = new ArrayList<>();
		// process each line of the file
		while ((line = br.readLine()) != null) {
			ShoppingItem shoppingItem = new ShoppingItem(line);
			shoppingItems.add(shoppingItem);
		}
		Receipt receipt = new Receipt(shoppingItems);
		receipt.printReceipt();
		System.out.println("\n");
	}
}
