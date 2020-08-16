package TIL_0816;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_bj_2628_종이자르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] size = bf.readLine().split(" ");
		int w = Integer.valueOf(size[0]), h = Integer.valueOf(size[1]);
		int N = Integer.valueOf(bf.readLine());
		ArrayList<Integer> hor = new ArrayList<>();
		hor.add(0);
		hor.add(h);
		ArrayList<Integer> ver = new ArrayList<>();
		ver.add(0);
		ver.add(w);
		for(int i=0; i<N; i++) {
			String[] cmd = bf.readLine().split(" ");
			int dir = Integer.valueOf(cmd[0]);
			int loc = Integer.valueOf(cmd[1]);
			if(dir==0) {
				hor.add(loc);
			}
			else {
				ver.add(loc);
			}
		}
		Collections.sort(hor);
		Collections.sort(ver);
		int max_h = 0;
		for(int r=1; r<hor.size(); r++) {
			h = hor.get(r) - hor.get(r-1);
			if(h > max_h) {
				max_h = h;
			}
		}
		int max_w = 0;
		for(int c=1; c<ver.size(); c++) {
			w = ver.get(c) - ver.get(c-1);
			if(w > max_w) {
				max_w = w;
			}
		}
		System.out.println(max_w * max_h);
	}
}
