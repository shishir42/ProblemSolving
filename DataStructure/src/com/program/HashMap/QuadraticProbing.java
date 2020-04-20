package com.program.HashMap;

import java.util.ArrayList;

public class QuadraticProbing {
	String[] hashTable;
	int noOfCellsUsedInHashTable;

	public QuadraticProbing() {
		hashTable = new String[13];
		noOfCellsUsedInHashTable = 0;
	}

	public int simpleASCIIHashFunction(String value, int M) {
		char ch[];
		ch = value.toCharArray();
		int sum, i;
		for(i=0, sum=0; i< value.length(); i++) {
			sum = sum + ch[i];
		}

		return sum % M;
	}

	public double getLoadFactor() {
		return noOfCellsUsedInHashTable * 1.0 / hashTable.length;
	}

	public void insertKeyInHashTable(String value) {
		double loadfactor = getLoadFactor();
		if(loadfactor >= 0.75) {
			System.out.println("Load factor of this HashTable has exceeded 0.75, hence we need to Rehash !\n");
			rehashKeys(value);
		}else {
			System.out.println("Inserting \"" + value + "\" in HashTable...");
			int index = simpleASCIIHashFunction(value, hashTable.length);
			int counter = 0;
			for(int i = index; i < index + hashTable.length; i++) {
				int newIndex = (index + (counter * counter)) % hashTable.length;
				if(hashTable[newIndex] == null)
				{
					hashTable[newIndex] = value;
					System.out.println("Index: " + newIndex + " is blank. Inserting there...");
					System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + newIndex);
					System.out.println("-------------------------------------------\n");
					break;
				}
				else 
				{
					System.out.println("Index: " + newIndex + " is already occupied. Trying next empty cell...");
				}
				counter++;
			}
		}
		noOfCellsUsedInHashTable++;
	}

	public void rehashKeys(String value) {
		noOfCellsUsedInHashTable = 0; // need to reset it as we are now dealing with fresh HashTable
		ArrayList<String> data = new ArrayList<String>();
		for (String s : hashTable) { // loop through the HashTable and save all the keys in ArrayList
			if (s != null)
				data.add(s);
		}
		data.add(value);
		hashTable = new String[hashTable.length * 2]; // make new table with double size
		for (String s : data) { // push all old data into new table
			insertKeyInHashTable(s);
		}
	}

	public boolean searchKeyInHashTable(String value) {
		int index = simpleASCIIHashFunction(value, hashTable.length);
		for(int i=index; i< index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if(hashTable[newIndex] != null && hashTable[newIndex].contains(value)) {
				System.out.println(
						"\n" + "\"" + value + "\"" + " found in HashTable at location: " + newIndex);
				return true;
			}			
		}

		System.out.println("\n" + "\"" + value + "\"" + " not found in HashTable.");
		return false;
	}

	public void deleteKeyFromHashTable(String value) {
		int index = simpleASCIIHashFunction(value, hashTable.length);
		for(int i=index; i< index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if(hashTable[newIndex] != null && hashTable[newIndex].contains(value)) {
				hashTable[newIndex] = null;
				System.out.println("\n" + "\"" + value + "\"" + " has been found in HashTable.");
				System.out.println("\"" + value + "\"" + " has been deleted from HashTable !");
				return;
			}			
		}
	}

	public void displayHashTable() {
		if (hashTable == null) {
			System.out.println("\nHashTable does not exits !");
			return;
		} else {
			System.out.println("\n---------- HashTable ---------");
			for (int i = 0; i < hashTable.length; i++) {
				System.out.println("Index:" + i + ".   Key:" + hashTable[i]);
			}
		}
		System.out.println("\n");
	}

	public void deleteHashTable() {
		System.out.println("Successfully deleted HashTable !");
		hashTable = null;
	}
}
