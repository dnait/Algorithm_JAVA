//List elements in array 1 that do not belong in array 2 
//use set 

import java.util.HashSet;
import java.util.Set;

public class leftJoin {

	public static void main(String[] args) {
		int[] a1 = {1,2,3,4,5,6,7};
		int[] a2 = {5,6,7,8,9,10};
		Set<Integer> set1 = new HashSet<>();
		for (int x : a1) set1.add(x);
		Set<Integer> set2 = new HashSet<>();
		for (int x : a2) set2.add(x);
		set1.retainAll(set2);
		for (int x : a1) {
			if (!set1.contains(x)) System.out.println(x);
		}		
	}
}
