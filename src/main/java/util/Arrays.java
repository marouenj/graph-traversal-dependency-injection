package util;

public class Arrays {
	
	public static<A extends Comparable<A>> int indexOf(A[] arr, A val) {
		return indexOf(arr, 0, arr.length-1, val);
	}
	
	public static<A extends Comparable<A>> int indexOf(A[] arr, int lo, int hi, A val) {
		if (arr == null || lo > hi || lo < 0 || hi >= arr.length)
			return -1;
		while (lo <= hi) {
			if (arr[lo].compareTo(val) == 0)
				return lo;
			lo++;
		}
		return -1;
	}
}
