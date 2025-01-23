package 유용한클래스;

public class _02문자열향상1 {

	public static void main(String[] args) {

		String str1 = "abc";
		String str2 = new String("abc");
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		str1 += "def"; // new String("abcdef");
		System.out.println(System.identityHashCode(str1));
		
		//String builder(싱글 스레드) , String Buffer(멀티 스레드)
		StringBuilder builder = new StringBuilder();
		System.out.println(System.identityHashCode(builder));
		builder.append("abc");
		System.out.println(System.identityHashCode(builder));
		builder.append("def");
		System.out.println(System.identityHashCode(builder));
		System.out.println(builder);
		builder.setLength(0); // 초기화
		System.out.println(builder);
		System.out.println("==========");
		
	}

}
