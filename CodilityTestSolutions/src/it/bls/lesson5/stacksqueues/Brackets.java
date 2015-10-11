package it.bls.lesson5.stacksqueues;

import java.util.Stack;

public class Brackets {
	
	@SuppressWarnings("unchecked")
	public static int solution(String S) {
		
		Stack stack = new Stack(); 
		
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			
			switch (c) {
			case '(':
			case '[':
			case '{':	
				stack.push(c);
				break;
			case ')':
				if (stack.isEmpty()) return 0;
				char v1 = (char) stack.lastElement();
				if (v1 == '(') stack.pop();
				else return 0;
				break;
			case ']':
				if (stack.isEmpty()) return 0;
				char v2 = (char) stack.lastElement();
				if (v2 == '[') stack.pop();
				else return 0;
				break;
			case '}':		
				if (stack.isEmpty()) return 0;
				char v3 = (char) stack.lastElement();
				if (v3 == '{') stack.pop();
				else return 0;
				break;
			default:
				break;
			}

		}
		
		return stack.isEmpty() ? 1 : 0;
	}
	
	public static void main(String[] args) {
		String S = "([)()]";
		
		System.out.println(solution(S));
	}

}
