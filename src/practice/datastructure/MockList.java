package practice.datastructure;

public interface MockList<T> {
	public int size();
	public boolean isEmpty();
	public boolean contains(Object o);
	public Object[] toArray();
	public boolean add();
	public boolean remove(Object o);
	public void clear();
	public T get(int index);
	public T set(int index, T element);
	public int indexOf(Object o);
	public int lastIndexOf(Object o);
}
