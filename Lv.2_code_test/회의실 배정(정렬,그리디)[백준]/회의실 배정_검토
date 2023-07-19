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

->종료시점을 비교군으로 잡기위해서는, 작은 종료시점부터시작해야하며, 종료시간이 같을경우는 빠른순으로 정렬.
