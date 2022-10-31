package practice.datastructure;

import java.util.Arrays;



public class MockArrayList<T> implements MockList<T>{
	private Object[] array;
	private int size;
	private static final int DEFAULT_CAPACITY = 5;
	private static final Object[] EMPTY_ARRAY = {};
	public MockArrayList() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
	}
	public MockArrayList(int size) {
		this.array = new Object[size];
		this.size = 0;
	}

	/**
	 * 동적 할당 메소드
	 * ArrayList의 재정의가 필요할 때 변경 
	 * - 한번에 변경되는 크기가 클수록 변경 크기를 올림 (메소드 호출 수 감소)
	 * - 일반적인 상황은 1.5배
	 */
	private void resize() {
		int length = array.length;
		
		// if the length of array is 0
		if(Arrays.equals(array, EMPTY_ARRAY)) {
			array = new Object[DEFAULT_CAPACITY];
			return;
		}
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean add() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
