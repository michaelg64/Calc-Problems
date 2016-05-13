package org.rhnet.calc;

import java.util.ArrayList;

public class Digit
{
	static long startVal = 1234567890;
	static long endVal = 9876543210L;
	static ArrayList<Long> solutions = new ArrayList<Long>(0);
	
	public static void main(String[] args)
	{
		Digit digit = new Digit();

		for(long val = startVal; val <= endVal; val += 10)
		{
			System.out.print("#");
			String valString = Long.toString(val);			
			
			//Initially check 5 and 0 condition, separated if to reduce computations
			if(valString.substring(4, 4).equals("5") && valString.substring(9, 9).equals("0"))
			{
				if(digit.checkNoRepeats(valString))
				{
					if(digit.checkValue(valString))
					{
						solutions.add(val);
						System.out.println(val);
					}
				}
			}
		}
	}
	
	//Check to ensure number has no repeated digits
	public boolean checkNoRepeats(String val)
	{
		boolean result = false;
		
		for(int i = 0; i <= 9; i++)
		{
			if(stringContains(val, Long.toString(i)) == 1)
			{
				result = true;
			}
			else
			{
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * Get number of occurrences of a string with in another string
	 * 
	 * @param str String to search
	 * @param findStr String to look for
	 * @return Count of occurrences
	 */
	private int stringContains(String str, String findStr)
	{
		int lastIndex = 0;
		int count = 0;

		//For every occurrence of findStr in str, increase the count
		while(lastIndex != -1)
		{
			lastIndex = str.indexOf(findStr, lastIndex);

			if(lastIndex != -1)
			{
				count++;
				lastIndex += findStr.length();
			}
		}

		return count;
	}
	
	//Check to ensure number follows the rule that the each possible subdigit must be divisble by length
	public boolean checkValue(String val)
	{
		boolean result = false;
		
		for(int i = 1; i <= 10; i++)
		{
			if(Long.valueOf(val.substring(0, i)) % i == 0)
			{
				result = true;
			}
			else
			{
				result = false;
				break;
			}						
		}
		
		return result;
	}
}
