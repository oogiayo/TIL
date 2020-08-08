package TIL_0808;
import java.util.*;

public class op_Main_bj_11723_집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int S = 0;
		for(int i=0; i<M; i++) {
			String cmd = sc.next();
			if(cmd.equals("all")) {
			 	S = 1048575;
			}
			else if(cmd.equals("empty")) {
				S = 0;
			}
			else {
				int x = sc.nextInt();
				if(cmd.equals("add")) {
					S |= (1<<x-1);
				}
				if(cmd.equals("remove")) {
					S &= ~(1<<x-1);
				}
				if(cmd.equals("check")) {
					if((S&(1<<x-1))==0) {
						System.out.println(0);
					}
					else {
						System.out.println(1);
					}
				}
				if(cmd.equals("toggle")) {
					if((S&(1<<x-1))==0) {
						S |= (1<<x-1);
					}
					else {
						S &= ~(1<<x-1);
					}
				}
			}
//			System.out.println(S);
			
		}
		
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