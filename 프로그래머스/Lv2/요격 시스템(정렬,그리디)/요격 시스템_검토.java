정렬 / 그리디 문제

[그리디]
그리디 알고리즘(탐욕 알고리즘)
동적프로그래밍에서 지나치게 많은 일을 한다는것에 착안하여 고안된 알고리즘.
미래를 생각하지않고, 각 단계에서 가장 최선의 선택을 하는 기법.


[정렬]
Arrays.sort(targets, ((x, y) -> x[0] - y[0])); (정렬부분이 핵심)
(x,y)->x[0] - y[0] 람다식
x[0] - y[0] 은 오름차순의 Comparator

기존 소스
Arrays.sort(targets, new Comparator<int[]>(){
          public int compare(int[] x, int[] y) {
            return x[0] - y[0];
        }
});

람다식
Arrays.sort(targets, ((x, y) -> x[0] - y[0]));  


x[0] - y[0] //오름차순
y[0] - x[0] //내림차순 
