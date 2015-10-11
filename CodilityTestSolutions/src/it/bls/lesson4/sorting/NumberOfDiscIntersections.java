package it.bls.lesson4.sorting;

//We draw N discs on a plane. The discs are numbered from 0 to N − 1. A zero-indexed array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].
//
//We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).
//
//The figure below shows discs drawn for N = 6 and A as follows:
//  A[0] = 1
//  A[1] = 5
//  A[2] = 2
//  A[3] = 1
//  A[4] = 4
//  A[5] = 0
//  
//		  There are eleven (unordered) pairs of discs that intersect, namely:
//
//		        discs 1 and 4 intersect, and both intersect with all the other discs;
//		        disc 2 also intersects with discs 0 and 3.
//
//		Write a function:
//
//		    class Solution { public int solution(int[] A); }
//
//		that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.
//
//		Given array A shown above, the function should return 11, as explained above.
//
//		Assume that:
//
//		        N is an integer within the range [0..100,000];
//		        each element of array A is an integer within the range [0..2,147,483,647].
//
//		Complexity:
//
//		        expected worst-case time complexity is O(N*log(N));
//		        expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
//
//		Elements of input arrays can be modified.  

import java.util.Arrays;
import java.util.Comparator;

public class NumberOfDiscIntersections {

	public static int solution(int[] A) {

		int j = 0;
		Pair[] arr = new Pair[A.length * 2];
		for (int i = 0; i < A.length; i++) {
			Pair s = new Pair(new Long(i) - new Long(A[i]), true);
			arr[j] = s;
			j++;
			Pair e = new Pair(new Long(i) + new Long(A[i]), false);
			arr[j] = e;
			j++;
		}
		Arrays.sort(arr, new Pair(0, true));

		long numIntersect = 0;
		long currentCount = 0;
		for (Pair p : arr) {
			if (p.start) {
				numIntersect += currentCount;
				if (numIntersect > 10000000) {
					return -1;
				}
				currentCount++;
			} else {
				currentCount--;
			}
		}

		return (int) numIntersect;
	}

	static private class Pair implements Comparator<Pair> {
		private long x;
		private boolean start;

		public Pair(long x, boolean start) {
			this.x = x;
			this.start = start;
		}

		public int compare(Pair p1, Pair p2) {
			if (p1.x < p2.x) {
				return -1;
			} else if (p1.x > p2.x) {
				return 1;
			} else {
				if (p1.start && p2.start == false) {
					return -1;
				} else if (p1.start == false && p2.start) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}	
	 
	 public static void main(String[] args) {
			
			int[] A = {1,5,2,1,4,0};
			
			System.out.println(solution(A));
		}
	
}


