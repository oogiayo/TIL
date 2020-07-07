package TIL_0707;
import java.util.*;

public class Sort_n_quare {
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Random rand = new Random();
		int N = rand.nextInt(30);
		arr = new int[N];
		visited = new boolean[arr.length+1];
		for(int i=0; i<arr.length; i++) {
			L: while(true) {
				int x = rand.nextInt(arr.length)+1;
				if(visited[x]==false) {
					arr[i] = x;
					break L;
				}
			}
			visited[arr[i]]=true;
		}
		System.out.println("Unsorted");
		System.out.println(Arrays.toString(arr));
		System.out.println();
		
		System.out.println("Bubble Sort");
		BubbleSort(arr);
		System.out.println();
		
		System.out.println("Selection Sort");
		SelectionSort(arr);
		System.out.println();
		
		System.out.println("Insertion Sort");
		InsertionSort(arr);
		System.out.println();
	}//end of main
	
	private static void InsertionSort(int[] ans) {
		for(int i=1; i<ans.length; i++) {
			int temp = ans[i];
			for(int j=i-1; j>=0; j--) {
				if(ans[i]<ans[j]) {
					ans[i] = ans[j];
				}
				else if(ans[i]>ans[j]) {
					break;
				}
			}
		}
		System.out.println(Arrays.toString(ans));
	}//end of method: Insertion Sort
	
	private static void SelectionSort(int[] ans) {
		for(int i=0; i<ans.length; i++) {
			int min = ans.length;
			int idx = 0;
			for(int j=i; j<ans.length; j++) {
				if(ans[j]<=min) {
					min = ans[j];
					idx = j;
				}
			}
			int temp = ans[i];
			ans[i] = min;
			ans[idx] = temp;
		}
		System.out.println(Arrays.toString(ans));
	}//end of method: Selection Sort
	
	private static void BubbleSort(int[] ans) {
		for(int i=0; i<ans.length; i++) {
			for(int j=ans.length-1; j>=i+1; j--) {
				if(ans[j-1]>ans[j]) {
					int temp = ans[j];
					ans[j] = ans[j-1];
					ans[j-1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(ans));
	}//end of method: Bubble Sort
	
}//end of class
