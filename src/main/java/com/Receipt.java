package com;

import java.util.List;

public class Receipt {
	List<ShoppingItem> shoppingList;
	double salesTaxes = 0;
	double total = 0;
	
	public Receipt(List<ShoppingItem> p_shoppingList) {
		// TODO Auto-generated constructor stub
		shoppingList = p_shoppingList;
	}
	
	public void printReceipt() {
		for (ShoppingItem item : shoppingList) {
			double currTax = 0;
			double afterTaxPrice = 0;
			if (item.getIfBasicTax()) {
				currTax += item.getPrice() *.1;
			}
			if (item.getisImported()) {
				currTax += item.getPrice() *.05;
			}
			currTax = Math.ceil(currTax * 20.0) /20.0;
			salesTaxes += item.getAmount() * currTax;
			afterTaxPrice += item.getAmount() * item.getPrice() + currTax;
			total += afterTaxPrice;
			System.out.println(String.format("%d %s: %.2f", item.getAmount(), item.getName(), afterTaxPrice));
		}
		System.out.println(String.format("Sales Taxes: %.2f", salesTaxes));
		System.out.println(String.format("Total:%.2f", total));
	}
}