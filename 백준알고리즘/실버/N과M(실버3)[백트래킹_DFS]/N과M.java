/*
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

예제 입력 1 
3 1
예제 출력 1 
1
2
3
예제 입력 2 
4 2
예제 출력 2 
1 2
1 3
1 4
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3
예제 입력 3 
4 4
예제 출력 3 
1 2 3 4
1 2 4 3
1 3 2 4
1 3 4 2
1 4 2 3
1 4 3 2
2 1 3 4
2 1 4 3
2 3 1 4
2 3 4 1
2 4 1 3
2 4 3 1
3 1 2 4
3 1 4 2
3 2 1 4
3 2 4 1
3 4 1 2
3 4 2 1
4 1 2 3
4 1 3 2
4 2 1 3
4 2 3 1
4 3 1 2
4 3 2 1
*/

//공부를 위해 풀이부터 참고하여 +LOG를 작성해서 공부함

import java.util.Scanner;

public class Main {

    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();	// 정적타입으로 해주어야한다.

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);
        // 마지막에 한 번에 출력
        System.out.println("전체출력");
        System.out.println(sb);

    }

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int val : arr) {
                System.out.println("depth:"+depth+"/val:"+val);
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            System.out.println("1: i:"+i+"/depth:"+depth+"/visit[i]:"+visit[i]);
            if (!visit[i]) {
                System.out.println("2: i:"+i+"/depth:"+depth+"/visit[i]"+visit[i]);
                visit[i] = true;
                System.out.println("3: i:"+i+"/depth:"+depth+"/visit[i]"+visit[i]+"/arr[depth]:"+arr[depth]);
                arr[depth] = i + 1;
                System.out.println("4: i:"+i+"/depth:"+depth+"/visit[i]"+visit[i]+"/arr[depth]:"+arr[depth]);
                dfs(N, M, depth + 1);
                visit[i] = false;
                System.out.println("5: i:"+i+"/depth:"+depth+"/visit[i]"+visit[i]+"/arr[depth]:"+arr[depth]);
            }
        }
    }

}

//로직이래를 위한 분석 로그, 출력결과 공부
/*
4 2

1: i:0/depth:0/visit[i]:false
2: i:0/depth:0/visit[i]false
3: i:0/depth:0/visit[i]true/arr[depth]:0
4: i:0/depth:0/visit[i]true/arr[depth]:1
----------------->재귀로 호출(1).
1: i:0/depth:1/visit[i]:true	//0은 방문함.

1: i:1/depth:1/visit[i]:false
2: i:1/depth:1/visit[i]false
3: i:1/depth:1/visit[i]true/arr[depth]:0
4: i:1/depth:1/visit[i]true/arr[depth]:2
depth:2/val:1
depth:2/val:2
->return
5: i:1/depth:1/visit[i]false/arr[depth]:2	//다시 depth가 1로돌아옴

1: i:2/depth:1/visit[i]:false
2: i:2/depth:1/visit[i]false
3: i:2/depth:1/visit[i]true/arr[depth]:2
4: i:2/depth:1/visit[i]true/arr[depth]:3
depth:2/val:1
depth:2/val:3
->return
5: i:2/depth:1/visit[i]false/arr[depth]:3 //다시 depth가 1로돌아옴

1: i:3/depth:1/visit[i]:false
2: i:3/depth:1/visit[i]false
3: i:3/depth:1/visit[i]true/arr[depth]:3
4: i:3/depth:1/visit[i]true/arr[depth]:4
depth:2/val:1
depth:2/val:4
->return
5: i:3/depth:1/visit[i]false/arr[depth]:4 //다시 depth가 1로돌아옴

//이후 중요

----------------->재귀로 호출한것(1) return

5: i:0/depth:0/visit[i]false/arr[depth]:1

1: i:1/depth:0/visit[i]:false
2: i:1/depth:0/visit[i]false
3: i:1/depth:0/visit[i]true/arr[depth]:1
4: i:1/depth:0/visit[i]true/arr[depth]:2

----------------->재귀로 호출(2).
1: i:0/depth:1/visit[i]:false
2: i:0/depth:1/visit[i]false
3: i:0/depth:1/visit[i]true/arr[depth]:4
4: i:0/depth:1/visit[i]true/arr[depth]:1
depth:2/val:2
depth:2/val:1
5: i:0/depth:1/visit[i]false/arr[depth]:1
1: i:1/depth:1/visit[i]:true
1: i:2/depth:1/visit[i]:false
2: i:2/depth:1/visit[i]false
3: i:2/depth:1/visit[i]true/arr[depth]:1
4: i:2/depth:1/visit[i]true/arr[depth]:3
depth:2/val:2
depth:2/val:3
5: i:2/depth:1/visit[i]false/arr[depth]:3
1: i:3/depth:1/visit[i]:false
2: i:3/depth:1/visit[i]false
3: i:3/depth:1/visit[i]true/arr[depth]:3
4: i:3/depth:1/visit[i]true/arr[depth]:4
depth:2/val:2
depth:2/val:4
5: i:3/depth:1/visit[i]false/arr[depth]:4
----------------->재귀로 호출한것(2) return

5: i:1/depth:0/visit[i]false/arr[depth]:2
1: i:2/depth:0/visit[i]:false
2: i:2/depth:0/visit[i]false
3: i:2/depth:0/visit[i]true/arr[depth]:2
4: i:2/depth:0/visit[i]true/arr[depth]:3

----------------->재귀로 호출(3).
1: i:0/depth:1/visit[i]:false
2: i:0/depth:1/visit[i]false
3: i:0/depth:1/visit[i]true/arr[depth]:4
4: i:0/depth:1/visit[i]true/arr[depth]:1
depth:2/val:3
depth:2/val:1
5: i:0/depth:1/visit[i]false/arr[depth]:1
1: i:1/depth:1/visit[i]:false
2: i:1/depth:1/visit[i]false
3: i:1/depth:1/visit[i]true/arr[depth]:1
4: i:1/depth:1/visit[i]true/arr[depth]:2
depth:2/val:3
depth:2/val:2
5: i:1/depth:1/visit[i]false/arr[depth]:2
1: i:2/depth:1/visit[i]:true
1: i:3/depth:1/visit[i]:false
2: i:3/depth:1/visit[i]false
3: i:3/depth:1/visit[i]true/arr[depth]:2
4: i:3/depth:1/visit[i]true/arr[depth]:4
depth:2/val:3
depth:2/val:4
5: i:3/depth:1/visit[i]false/arr[depth]:4
----------------->재귀로 호출한것(3) return

5: i:2/depth:0/visit[i]false/arr[depth]:3
1: i:3/depth:0/visit[i]:false
2: i:3/depth:0/visit[i]false
3: i:3/depth:0/visit[i]true/arr[depth]:3
4: i:3/depth:0/visit[i]true/arr[depth]:4

----------------->재귀로 호출(4).
1: i:0/depth:1/visit[i]:false
2: i:0/depth:1/visit[i]false
3: i:0/depth:1/visit[i]true/arr[depth]:4
4: i:0/depth:1/visit[i]true/arr[depth]:1
depth:2/val:4
depth:2/val:1
5: i:0/depth:1/visit[i]false/arr[depth]:1
1: i:1/depth:1/visit[i]:false
2: i:1/depth:1/visit[i]false
3: i:1/depth:1/visit[i]true/arr[depth]:1
4: i:1/depth:1/visit[i]true/arr[depth]:2
depth:2/val:4
depth:2/val:2
5: i:1/depth:1/visit[i]false/arr[depth]:2
1: i:2/depth:1/visit[i]:false
2: i:2/depth:1/visit[i]false
3: i:2/depth:1/visit[i]true/arr[depth]:2
4: i:2/depth:1/visit[i]true/arr[depth]:3
depth:2/val:4
depth:2/val:3
5: i:2/depth:1/visit[i]false/arr[depth]:3
----------------->재귀로 호출한것(4) return
1: i:3/depth:1/visit[i]:true

----------------->최초 호출한것 return
5: i:3/depth:0/visit[i]false/arr[depth]:4

전체출력
1 2 
1 3 
1 4 
2 1 
2 3 
2 4 
3 1 
3 2 
3 4 
4 1 
4 2 
4 3 


Process finished with exit code 0
*/