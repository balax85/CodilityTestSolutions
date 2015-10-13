package it.bls.lesson5.stacksqueues;

import java.util.Stack;

public class Fish {

	public static int fish(int[] A, int[] B) {
		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < A.length; i++) {
			int size = A[i];
			int dir = B[i];
			if (s.empty()) {
				s.push(i);
			} else {
				while (!s.empty() && dir - B[s.peek()] == -1
						&& A[s.peek()] < size) {
					s.pop();
				}
				if (!s.empty()) {
					if (dir - B[s.peek()] != -1)
						s.push(i);
				} else {
					s.push(i);
				}
			}
		}
		return s.size();
	}

}
