package TIL_0812;
import java.util.*;
import java.io.*;

public class op_Main_bj_2251_물통 {
	static class Water {
		int x; int y;
		public Water(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] line = bf.readLine().split(" ");
		int A = Integer.valueOf(line[0]);
		int B = Integer.valueOf(line[1]);
		int C = Integer.valueOf(line[2]);

//		HashSet<Water> s = new HashSet<>();
		Queue<Water> q = new LinkedList<>();
		q.add(new Water(0, 0));
		
		while(!q.isEmpty()) {
			Water w = q.poll();
			int x = w.x, y = w.y, z = C-x-y;
			if(x==0) {
				System.out.println(z);
				continue;
			}
			
		}
	}//end of main	
}//end of class
