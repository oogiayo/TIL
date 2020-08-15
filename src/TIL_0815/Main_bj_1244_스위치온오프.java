package TIL_0815;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_1244_스위치온오프 {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(bf.readLine());
		String[] line = bf.readLine().split(" ");
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.valueOf(line[i]);
		}
		int students = Integer.valueOf(bf.readLine());

		for(int i=0; i<students; i++) {
			String[] commands = bf.readLine().split(" ");
			int sex = Integer.valueOf(commands[0]);
			int num = Integer.valueOf(commands[1]);
			
			if(sex==1) {
				for(int j=0; j<N; j++) {
					if((j+1)%num==0) {
						arr[j] = 1 - arr[j];
					}
				}
			}
			else {
				arr[num-1] = 1 - arr[num-1];
				int idx = 1;
				while(true) {
					if(num-1-idx < 0 || num-1+idx >= N)	break;
	
					if(arr[num-1-idx]==arr[num-1+idx]) {
						arr[num-1-idx] = 1 - arr[num-1-idx];
						arr[num-1+idx] = 1 - arr[num-1+idx];
					}
					else break;
					idx++;
				}
			}
		}
		for(int i=0; i<N; i++) {
			System.out.print(arr[i] + " ");
			if((i+1)%20==0) {
				System.out.println();
			}
		}
	}
}
