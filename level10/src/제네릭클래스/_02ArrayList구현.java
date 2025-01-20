package 제네릭클래스;

class MyArrayList<T> {

	private T[] arr;
	private int size = 0;
	private int capacity = 10;

	// 경고 제거 => 오류가 날 수 있는 구간이지만 type safe 하면 사용
	@SuppressWarnings("unchecked")
	MyArrayList() {
		// unchecked - Object always can downcast to T
		arr = (T[]) new Object[capacity];
	}

	public int size() {
		return size;
	}

	public int capacity() {
		return capacity;
	}

	public void add(T t) {
		addCapacity();
		arr[size++] = t;
	}

	public void add(int i, T t) {
		addCapacity();
		for (int k = size; k > i; k--)
			arr[k] = arr[k - 1];
		arr[i] = t;
		size++;
	}
	
	private void addCapacity() {
		if (size == capacity) {
			capacity += 10;
			setArr();
		}
	}

	@SuppressWarnings("unchecked")
	private void setArr() {
		T[] temp = arr;
		// unchecked - Object always can downcast to T
		arr = (T[]) new Object[capacity];
		for (int i = 0; i < size; i++)
			arr[i] = temp[i];
	}

	public T get(int i) {
		return arr[i];
	}

	public void set(int i, T d) {
		arr[i] = d;
	}

	public void remove(int i) {
		for (int k = i; k < size; k++)
			arr[k] = arr[k + 1];
		arr[size--] = null;
		if (size != 0 && size % 10 == 0) {
			capacity -= 10;
			setArr();
		}
	}

	@SuppressWarnings("unchecked") 
	public void clear() {
		capacity = 10;
		size = 0;
		// unchecked - Object always can downcast to T
		arr = (T[]) new Object[capacity];
	}

	@Override
	public String toString() {
		String data = "[";
		for (int i = 0; i < size; i++)
			data += arr[i] + ", ";
		return (size == 0 ? data : data.substring(0, data.length() - 2)) + "]";
	}

}

public class _02ArrayList구현 {

	public static void main(String[] args) {

		MyArrayList<Double> list = new MyArrayList<>();

		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.capacity());

		for (int i = 0; i < 10; i++)
			list.add((i + 1) * 10 * 1.0);
		System.out.println(list.size());
		System.out.println(list.capacity());
		System.out.println(list.get(1));

		list.set(1, 1000.0);
		System.out.println(list);

		list.add(1, 20.0);
		System.out.println(list);

		list.remove(3);
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.capacity());

		list.clear();
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.capacity());
	}

}
