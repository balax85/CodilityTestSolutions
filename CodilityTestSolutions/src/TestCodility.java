import java.util.Arrays;
import java.util.Random;


public class TestCodility {
	
	public static void swapArrayElements(int[] array, int firstIndex, int secondIndex) {
		int tmp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = tmp;
	}
	
    public static boolean solutionFirst(int[] A) {
        
        int[] arrayCopy = Arrays.copyOf(A, A.length);
        Arrays.sort(arrayCopy);
       
        int indexFirstElem = -1;
        int lastElem = A[0];
        int indexLastElem = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                indexFirstElem = indexLastElem;
                break;
            }
            if (A[i] != lastElem) {
                lastElem = A[i];
                indexLastElem = i;
            }
        }
       
        int indexSecondElem = -1;

        for (int i = 0; i < A.length; i++) {
            if (i != indexFirstElem) {
                if ( indexFirstElem > -1 && ((A[i] < A[indexFirstElem] && i < A.length - 1 && A[i + 1] >= A[indexFirstElem]) ||
                        (A[i] < A[indexFirstElem] && i == A.length - 1))) {
                    indexSecondElem = i;
                }
            }
        }
       
        if (indexFirstElem > -1 && indexSecondElem > - 1)swapArrayElements(A, indexFirstElem, indexSecondElem);
       
        if (Arrays.equals(A, arrayCopy)) return true;

       

        //The array are not equals.   

        return false;
       
    }	
	
	public static boolean solution(int[] A) {
		
		int[] arrayCopy = Arrays.copyOf(A, A.length);
		
		Arrays.sort(arrayCopy);
				
		boolean firstElementSwap = false;
		int elemValueToSwap = -1;
		int swapFirstElem = -1;
		int swapSecondElem = -1;
		
			for (int i = 0; i < A.length - 1; i++) {
				if(A[i] > A[i + 1] && !firstElementSwap){
					elemValueToSwap = A[i];
					swapFirstElem = i;
					firstElementSwap = true;
					continue;
				}
				
				if (i > 0 && i < A.length - 1 && A[i - 1] <= elemValueToSwap && A[i + 1] > elemValueToSwap) {
					swapSecondElem = i;
				} else if (i == 0 && A[i + 1] > elemValueToSwap) {
					swapSecondElem = i;
				} else if (i == A.length - 1 && A[i - 1] <= elemValueToSwap) {
					swapSecondElem = i;
				} else {
					swapSecondElem = A.length - 1;
				}
				
			}
			
			if (swapFirstElem > -1 && swapSecondElem > - 1)swapArrayElements(A, swapFirstElem, swapSecondElem);
			
			if (Arrays.equals(A, arrayCopy)) return true;
			
		return false;
	}
	
	public static int solution2(int[] A) {
	
		 if (A.length <= 1) return 0;
		
		Arrays.sort(A);
		
		int[] sum = new int[A.length]; 
		sum[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			if (i > 1) sum[i] = A[i] + sum[i - 1] + sum[i - 1];
			else sum[i] = A[i] + sum[i - 1];
		}
		
		int count = 0; 
		count = A[0];
		for (int i = 1; i < A.length; i++) {
			if (i > 1) count = A[i] + count + count;
			else count = A[i] + count;
		}
		
		
		return count;
	}

	public static void main(String[] args) {
		
		int[] A = {1,2,4,8,16};
		
//		int[] A = new int[10000];
//		
//		Random rand = new Random();
//		int max = 1000;
//		int min = 1;
//		for (int i = 0; i < A.length; i++) {
//			int randomNum = rand.nextInt((max - min) + 1) + min;
//			A[i] = 1000;
//		}
 
		//1,3,5,3,7
		//1,10,3,4,2 **
		//1,1,2,3,9,5,4
		//1,2,3,4
		//11,10,3,4,2
		//1,3,5,3,4
		
		System.out.println(solution2(A));
		

	}

}
