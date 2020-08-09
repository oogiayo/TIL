package TIL_0809;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_11723_집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.valueOf(bf.readLine());
		int S = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String[] line = bf.readLine().split(" ");
			if(line[0].equals("all")) {
			 	S = 1048575;
			}
			else if(line[0].equals("empty")) {
				S = 0;
			}
			else {
				int x = Integer.valueOf(line[1]);
				if(line[0].equals("add")) {
					S |= (1<<x-1);
				}
				if(line[0].equals("remove")) {
					S &= ~(1<<x-1);
				}
				if(line[0].equals("check")) {
					if((S&(1<<x-1))==0) {
						sb.append("0\n");
					}
					else {
						sb.append("1\n");
					}
				}
				if(line[0].equals("toggle")) {
					if((S&(1<<x-1))==0) {
						S |= (1<<x-1);
					}
					else {
						S &= ~(1<<x-1);
					}
				}
			}
		}
		System.out.print(sb);
	}
}//end of class


//public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
//	int M = sc.nextInt();
//	S = new ArrayList<>();
//	for(int i=0; i<M; i++) {
//		String cmd = sc.next();
//		if(cmd.equals("add")) {
//			int x = sc.nextInt();
//			add(x);
//		}
//		if(cmd.equals("remove")) {
//			int x = sc.nextInt();
//			remove(x);
//		}
//		if(cmd.equals("check")) {
//			int x = sc.nextInt();
//			System.out.println(check(x));
//		}
//		if(cmd.equals("toggle")) {
//			int x = sc.nextInt();
//			toggle(x);
//		}
//		if(cmd.equals("all")) {
//			all();
//		}
//		if(cmd.equals("empty")) {
//			empty();
//		}
//	}
//	
////	System.out.println(S);
//}//end of main
//	
//private static void add(int x) {
//	if(!S.contains(x)) {
//		S.add(x);
//	}
//}
//
//private static void remove(int x) {
//	int idx = S.indexOf(x);
//	if(idx!=-1) {
//		S.remove(idx);
//	}
//}
//
//private static int check(int x) {
//	if(S.contains(x)) {
//		return 1;
//	}
//	else {
//		return 0;
//	}
//}
//
//private static void toggle(int x) {
//	if(S.contains(x)) {
//		int idx = S.indexOf(x);
//		S.remove(idx);
//	}
//	else {
//		S.add(x);
//	}
//}
//
//private static void all() {
//	S = new ArrayList<>();
//	for(int i=1; i<=20; i++) {
//		S.add(i);
//	}
//}
//
//private static void empty() {
//	S = new ArrayList<>();
//}