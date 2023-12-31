/*
문제
한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

입력
첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.

예제 입력 1 
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14

예제 출력 1 
4
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[][] time = new int[N][2];


        for(int i = 0; i < N; i++) {
            time[i][0] = in.nextInt();	//시작시간
            time[i][1] = in.nextInt();	//종료시간
        }

		Arrays.sort(time, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				// 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.  
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1]; //종료시간 기준 오름차순 정렬
			}
 
		});

        int count = 0;
        int curEnd= 0;

        for(int i = 0; i < N; i++) {
           int start =time[i][0];   //시작시간
           if(start>=curEnd){        //시작시간이 종료시간보다 큰지 확인
               curEnd=time[i][1];   //시작시간이 더큰 회의의 종료시간으로 변경
               count++;
           }
        }
        /*for(int i = 0; i < N; i++) {
            System.out.print(time[i][0]+"/");
            System.out.println(time[i][1]);
        }*/

        System.out.println(count);
    }
}
//1회차 실패 , 시작시간기준 정렬을 하여 틀림.
/*
import java.util.*;

public class Test {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[][] time = new int[N][2];


        for(int i = 0; i < N; i++) {
            time[i][0] = in.nextInt();	//시작시간
            time[i][1] = in.nextInt();	//종료시간
        }

        Arrays.sort(time,(x,y)->x[0]-y[0]);

        int count = 0;
        int curEnd= 0;

        for(int i = 0; i < N; i++) {
           int start =time[i][0];   //시작시간
           if(start>curEnd){        //시작시간이 종료시간보다 큰지 확인
               curEnd=time[i][1];   //시작시간이 더큰 회의의 종료시간으로 변경
               count++;
           }
        }
        /*for(int i = 0; i < N; i++) {
            System.out.print(time[i][0]+"/");
            System.out.println(time[i][1]);
        }*/

        System.out.println(count);
    }
}
*/
