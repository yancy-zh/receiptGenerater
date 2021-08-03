package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShoppingItem {
	private String name;
	private float price;
	private int amount;
	private boolean isImported = false;
	private boolean applyBasicTax =true;
	
	public ShoppingItem(String itemString) {
		determineType(itemString);
		determinePrice(itemString);
		setAmount(itemString);
		name = findNameString(itemString);
	}
	
	private void determineType(String itemString) {
		Pattern patternIsImported = Pattern.compile("(books?)|(magazines?)|(chocolates?)|(candy)|(medicine)|(pills?)");
		Matcher matcher1 = patternIsImported.matcher(itemString);
		if (matcher1.find()) {
			applyBasicTax = false;
		}
		Pattern patternApplySalesTax = Pattern.compile("imported\s");
		Matcher matcher2 = patternApplySalesTax.matcher(itemString);
		if (matcher2.find()) {
			isImported = true;
		}
	}
	
	private void determinePrice(String itemString) {
		Pattern patternPrice = Pattern.compile("\\s(at)\\s\\d+\\.?\\d*");
		Matcher matcher = patternPrice.matcher(itemString);
		if (matcher.find()) {
			price = Float.parseFloat(matcher.group().substring(4));
		}
	}
	
	private String findNameString(String itemString) {
		// pattern relates to item amount
		Pattern pattern1 = Pattern.compile("^\\d*\\s");
		Matcher matcher1 = pattern1.matcher(itemString);
		int index1 = 0;
		int index2 = itemString.length();
		if (matcher1.find()) {
			index1 = matcher1.end();
		}
		// pattern relates to item price
		Pattern pattern2 = Pattern.compile("\\s(at)\\s");
		Matcher matcher2 = pattern2.matcher(itemString);
		if (matcher2.find()) {
			index2 = matcher2.start();
		}
		// return the remaining text in line, without the pattern.
		return itemString.substring(index1, index2);
	}
	
	public void setAmount(String itemString) {
		Pattern patternAmount = Pattern.compile("^\\d*\\s");
		Matcher matcher = patternAmount.matcher(itemString);
		if (matcher.find()) {
			amount = Integer.parseInt(matcher.group().strip());
		}
	}
	
	public int getAmount() {
		return amount;
	}
	
	public float getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getIfBasicTax() {
		return applyBasicTax;
	}
	
	public boolean getisImported() {
		return isImported;
	}
}
