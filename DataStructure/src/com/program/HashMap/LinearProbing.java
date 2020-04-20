package com.program.HashMap;

import java.util.ArrayList;

public class LinearProbing {
	String [] hashTable;
	int noOfCellUsedInHashTable;

	public LinearProbing()
	{
		hashTable = new String[13];
		noOfCellUsedInHashTable = 0;
	}

	public int simpleASCIIHashFunction(String x, int M) {
		char ch[];
		ch = x.toCharArray();
		int sum, i;
		for(i=0,sum=0; i<x.length();i++) {
			sum = sum + ch[i];
		}

		return sum % M;
	}

	public double getLoadFactor() {
		double loadfactor = noOfCellUsedInHashTable * 1.0 / hashTable.length;
		return loadfactor;
	}

	public void insertKeyInHashTable(String value) {
		double loadFactor = getLoadFactor();
		if(loadFactor >= 0.75) {// we need to rehash in new table doubling the size
			System.out.println("Load factor of this HashTable has exceeded 0.75, hence we need to Rehash !\n");
			rehashKeys(value);
		}else {
			System.out.println("Inserting \"" + value + "\" in HashTable...");
			int index = simpleASCIIHashFunction(value, hashTable.length);
			for(int i = index; i < index + hashTable.length; i++) {
				int newIndex = i % hashTable.length;
				if(hashTable[newIndex] == null) {
					hashTable[newIndex] = value;
					System.out.println("Index: " + newIndex + " is blank. Inserting there...");
					System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + newIndex);
					System.out.println("-------------------------------------------\n");
					break;
				}else {
					System.out.println("Index: " + newIndex + " is already occupied. Trying next empty cell...");
				}
			}
		}
		noOfCellUsedInHashTable++;
	}

	//Creates a new HashTable and does ReHashing
	public void rehashKeys(String newStringToBeInserted) {
		noOfCellUsedInHashTable = 0; //need to reset it as we are now dealing with fresh HashTable
		ArrayList<String> data = new ArrayList<String>();
		for (String s : hashTable) { //loop through the HashTable and save all the keys in ArrayList
			if (s != null)
				data.add(s);
		}
		data.add(newStringToBeInserted);
		hashTable = new String[hashTable.length * 2]; // make new table with double size
		for (String s : data) { // push all old data into new table
			insertKeyInHashTable(s);
		}
	}

	public boolean searchKeyInHashTable(String value) {
		int index = simpleASCIIHashFunction(value, hashTable.length);
		for(int i = index; i < index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if(hashTable[newIndex] != null && hashTable[newIndex].contains(value)) {
				System.out.println("\n" + "\"" + value + "\"" + " found in HashTable at location: "+newIndex);
				return true;
			}
		}
		System.out.println("\n" + "\"" + value + "\"" + " not found in HashTable.");
		return false;
	}

	public void deleteKeyFromHashTable(String value) {
		int index = simpleASCIIHashFunction(value, hashTable.length);
		for(int i = index; i< index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if(hashTable[newIndex] != null && hashTable[newIndex].contains(value)) {
				hashTable[newIndex] = null;
				System.out.println("\n" + "\"" + value + "\"" + " has been found in HashTable." );
				System.out.println("\"" + value + "\"" + " has been deleted from HashTable !" );
				return;
			}
		}
		System.out.println("\nCould not find " + "\"" + value + "\"" + " in HashTable");
	}

	public void displayHashTable() {
		if(hashTable == null) {
			System.out.println("\nHashTable does not exits !");
			return;
		}else {
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
















