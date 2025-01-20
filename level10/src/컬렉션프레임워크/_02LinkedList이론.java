package 컬렉션프레임워크;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _02LinkedList이론 {

	public static void main(String[] args) {

//		LinkedList<Integer> list1 = new LinkedList<>();
		
		//#1. 데이터 추가시간 비교
				List<Integer> aList = new ArrayList<>();
				List<Integer> linkedList = new LinkedList<>();
				long startTime=0, endTime=0;
				
				//@1-1 ArrayList 데이터 추가시간
				startTime = System.nanoTime();
				for(int i=0; i<100000; i++) {
					aList.add(0, i);
				}		
				endTime = System.nanoTime();
				System.out.printf("ArrayList  데이터 추가시간 = %10d ns\n", endTime-startTime);
				
				//@1-2 LinkedList 데이터 추가시간
				startTime = System.nanoTime();
				for(int i=0; i<100000; i++) {
					linkedList.add(0, i);
				}		
				endTime = System.nanoTime();
				System.out.printf("LinkedList 데이터 추가시간 = %10d ns\n", endTime-startTime);
				
						
				//@2-1 ArrayList 데이터 검색시간
				startTime = System.nanoTime();
				for(int i=0; i<100000; i++) {
					aList.get(i);
				}		
				endTime = System.nanoTime();
				System.out.printf("ArrayList  데이터 검색시간 = %10d ns\n", endTime-startTime);
				
				//@2-2 LinkedList 데이터 검색시간
				startTime = System.nanoTime();
				for(int i=0; i<100000; i++) {
					linkedList.get(i);
				}		
				endTime = System.nanoTime();
				System.out.printf("LinkedList 데이터 검색시간 = %10d ns\n", endTime-startTime);
				
				
				//@3-1 ArrayList 데이터 제거시간
				startTime = System.nanoTime();
				for(int i=0; i<100000; i++) {
					aList.remove(0);
				}		
				endTime = System.nanoTime();
				System.out.printf("ArrayList  데이터 제거시간 = %10d ns\n", endTime-startTime);
				
				//@3-2 LinkedList 데이터 제거시간
				startTime = System.nanoTime();
				for(int i=0; i<100000; i++) {
					linkedList.remove(0);
				}		
				endTime = System.nanoTime();
				System.out.printf("LinkedList 데이터 제거시간 = %10d ns", endTime-startTime);
	}

}
