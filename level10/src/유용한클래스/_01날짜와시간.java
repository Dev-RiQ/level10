package 유용한클래스;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class _01날짜와시간 {

	public static void main(String[] args) {

		// 1970년 1월 1일 0시 기준으로 현재까지 경과한 시간 1000분의 1로 (밀리초) 반환
		System.out.println(System.currentTimeMillis());
		
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		LocalTime now = LocalTime.now();
		System.out.println(now);
		
		System.out.println(Clock.systemDefaultZone());
		
		LocalDate tomorrow = today.plusDays(1);
		System.out.println(tomorrow);
		
		LocalDate tempDate = today.minusYears(10);
		System.out.println(tempDate);
		
		LocalDate test1 = LocalDate.of(2030, 5, 5);
		Period test2 = Period.between(today, test1);
		System.out.printf("%d년 %d월 %d일 \n",test2.getYears(),test2.getMonths(),test2.getDays());
		
		Duration test3 = Duration.between(LocalDateTime.of(2025, 01,22,13,12), LocalDateTime.of(2027, 04,23,13,02));
		System.out.println(test3);
		System.out.println(test3.toDays());
		System.out.println(test3.toHours());
		System.out.println(test3.toMinutes());
		System.out.println(test3.toSeconds());
		
		DateTimeFormatter test4 = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일 a h시 mm분 ss초 ");
		LocalDateTime today2 = LocalDateTime.now();
		System.out.println(today2);
		System.out.println(today2.format(test4));
		
		DateTimeFormatter test5 = DateTimeFormatter.ofPattern("yy년 MMM월 dd일 E요일 a HH:mm:ss");
		System.out.println(today2.format(test5));
		
		String nowDate = "2025-01-22";
		DateTimeFormatter test6 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate time = LocalDate.parse(nowDate, test6);
		System.out.println(time);
		
	}

}
