package Object클래스;

import java.util.Objects;

class User{
	String name;

	User(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(name, other.name);
	}
	
	
}

public class _01Equals메서드 {

	public static void main(String[] args) {
		
		String name1 = "test";
		String name2  = "test";
		System.out.println(name1 == name2);
		System.out.println(name1.hashCode());
		System.out.println(name2.hashCode());
		
		User u1 = new User("test");
		User u2 = new User("test");
		System.out.println(u1.equals(u2));
		System.out.println(u1.hashCode());
		System.out.println(u2.hashCode());
		
	}
}
