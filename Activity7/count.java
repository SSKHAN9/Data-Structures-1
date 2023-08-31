package week5;

import java.util.HashMap;

public class count {
	
	public static void countEach(Integer[] nums) {
		
		int max = 0;
		HashMap<Integer, Integer> Count = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++ ) {
			
			if (nums[i] > max) {
				max = nums[i];
			}
			
		}
		
		for (Integer i = 0; i < max; i++ ) {
			Count.put(i, 0);
		}

		for (Integer i = 0; i < nums.length; i++ ) {
			Integer value = 0;
			value = Count.containsKey(nums[i]) ? Count.get(nums[i]) : 0;
			Count.put(nums[i], value + 1);
			
		}
		
		for (int i = 0; i < Count.size() ; i++ ) {
			System.out.println( i + " occurs " + Count.get(nums[i]) + " times.");
		}
		
		}
		
		
	}

