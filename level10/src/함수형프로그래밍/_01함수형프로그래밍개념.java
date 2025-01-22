package 함수형프로그래밍;

// 함수형 프로그래밍 조건 => 단 하나의 추상메서드만 존재해야함
@FunctionalInterface
interface Test {
	int getSum(int[] arr);
}

public class _01함수형프로그래밍개념 {

	public static int getSum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];
		return sum;
	}

	public static void main(String[] args) {
		// 명령형 프로그래밍 => how (과정) 1~60까지 합산
		int[] arr = { 10, 20, 30, 40, 50, 60 };
		int sum = 0;
		for (int i = 0; i < 6; i++)
			sum += arr[i];
		System.out.println(sum);

		// 선언형 프로그래밍 => 함수형
		System.out.println(getSum(arr));

		// 내부 클래스 == 이너 클래스 => 익명 클래스 : 일회용 클래스
		Test result = new Test() {
			@Override
			public int getSum(int[] arr) {
				int sum = 0;
				for (int i = 0; i < 6; i++)
					sum += arr[i];
				return sum;
			}
		};
		System.out.println(result.getSum(arr));

		// 람다식 => 함수형 프로그래밍 편하게 사용하는 방식
		Test result2 = (int[] array) -> {
			int hap = 0;
			for (int i = 0; i < 6; i++)
				hap += arr[i];
			return hap;
		};
		System.out.println(result2.getSum(arr));
		
		// 이미 호출해둔 함수 사용
		Test result3 = array -> result2.getSum(arr);
		System.out.println(result3.getSum(arr));
	}
}
