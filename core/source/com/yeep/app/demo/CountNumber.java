package com.yeep.app.demo;

/**
 * Count the number of appearance of '1' from 1 to N
 * 
 * @author Roger Yee
 */
public class CountNumber
{
	public static void main(String[] args)
	{
		int number = 20;

		long startForFunction2 = System.currentTimeMillis();
		System.out.println("Using Function2: The count for 1 is "
				+ getOneCount2(number) + ", cost time = "
				+ (System.currentTimeMillis() - startForFunction2) + " ms ");
	}

	/**
	 * Count the number of appearance of '1' from 1 to N
	 * 
	 * @param number
	 * @return
	 */
	public static int getOneCount1(int number)
	{
		int countOne = 0;
		for (int n = 1; n <= number; n++)
		{
			String numberStr = String.valueOf(n);
			char[] charArray = numberStr.toCharArray();

			for (int i = 0; i < charArray.length; i++)
			{
				String str = String.valueOf(charArray[i]);
				if ("1".equals(str))
					countOne++;
			}
		}

		return countOne;
	}

	/**
	 * Count the number of appearance of '1' from 1 to N
	 * 
	 * @param number
	 * @return
	 */
	private static int getOneCount2(int n)
	{
		int count = 0;
		int factor = 1;
		int lower;
		int current;
		int higher;
		while (n / factor != 0)
		{
			lower = n - (n / factor) * factor;
			current = (n / factor) % 10;
			higher = n / (factor * 10);
			switch (current)
			{
				case 0:
					count += higher * factor;
					break;
				case 1:
					count += higher * factor + lower + 1;
					break;
				default:
					count += (higher + 1) * factor;
			}
			factor *= 10;
		}
		return count;
	}
}
