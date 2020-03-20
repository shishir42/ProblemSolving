package com.program.String;

public class DefangIpAddress {

	public static void main(String[] args) {
		DefangIp defIp = new DefangIp();
		System.out.println(defIp.defangIpAdd("255.100.50.0"));
		System.out.println(defIp.defangIpAdd("1.1.1.1"));
	}
}

class DefangIp
{
	public String defangIpAdd(String address)
	{
		if(address == null)
		{
			return address;
		}
		
		StringBuilder strBuilder = new StringBuilder();
		char[] arr = address.toCharArray();
		int arrLen = arr.length;
		for (int i = 0; i < arrLen; i++) {
			if(arr[i] == '.')
			{
				strBuilder.append("[.]");
			}
			else
			{
				strBuilder.append(arr[i]);
			}
		}
		return strBuilder.toString();
	}
}