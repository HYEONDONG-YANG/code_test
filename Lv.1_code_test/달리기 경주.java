import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] result = players;              //result배열에 players배열저장
        Map<String, Integer> map = new HashMap<>();//players배열 인덱스 검색을 위한 map 변환
        
        //각 선수들의 이름을 key값으로, players배열의 인덱스를 value값으로 
        for(int j=0; j<result.length; j++){
           map.put(result[j],j); 
        }

        //추월한 선수들을 한명씩 순서대로 호명
        for(int i =0; i<callings.length; i++){
          String celling=callings[i];   //0번째 선수부터 차례로 호명
          int idx=(int)map.get(celling); //호명한 선수를 현재 순위에서 찾음
            
          //찾은 선수의 위치를 한단게 앞으로 추월
          map.put(result[idx-1],idx);    
          map.put(result[idx],idx-1);  
            
          String temp;
          temp=result[idx]; 
          result[idx]=result[idx-1];
          result[idx-1]=temp;
        

        }
        
        return result;
    }
}