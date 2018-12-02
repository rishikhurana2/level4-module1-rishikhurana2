package _01_Custom_ArrayList;

@SuppressWarnings("unchecked")

public class ArrayList <T>{
	private T[] t;
	public ArrayList() {
		t = (T[]) new Object[0];
	}
	public T get(int loc) throws IndexOutOfBoundsException {
		if (loc > t.length - 1 || loc < 0) {
			throw new IndexOutOfBoundsException();
		}
		return t[loc];
	}
	
	public void add(T val) {
		T[] t2 = (T[]) new Object[t.length + 1];
		for (int i = 0; i < t.length; i++) {
			t2[i] = t[i];
		}
		t2[t2.length - 1] = val;
		t = t2;
	}
	
	public void insert(int loc, T val) throws IndexOutOfBoundsException {
		if (loc > t.length - 1 || loc < 0) {
			throw new IndexOutOfBoundsException();
		}
		T[] t2 = (T[]) new Object[t.length + 1];
		for (int i = 0; i < loc; i++) {
			t2[i] = t[i];
		}
		t2[loc] = val;
		for (int i = loc + 1; i < t.length + 1; i++) {
			t2[i] = t[i - 1];
		}
		t = t2;
	}
	
	public void set(int loc, T val) throws IndexOutOfBoundsException {
		if (loc > t.length - 1 || loc < 0) {
			throw new IndexOutOfBoundsException();
		}
		t[loc] = val;
		
	}
	
	public void remove(int loc) throws IndexOutOfBoundsException {
		if (loc > t.length - 1 || loc < 0) {
			throw new IndexOutOfBoundsException();
		}
		T [] t2 = (T[]) new Object[t.length - 1];
		for (int i = 0; i < loc; i++) {
			t2[i] = t[i];
		}
		for (int i = loc + 1; i < t.length; i++) {
			t2[i-1] = t[i];
		}
		t = t2;
	}
	
	public boolean contains(T val) {
		boolean yes = false;
		for (int i = 0; i < t.length; i++) {
			if (t[i] == val) {
				yes = true;
			}
		}
		return yes;
	}
	public int size() {
		return t.length;
	}
}