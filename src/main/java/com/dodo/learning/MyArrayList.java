package com.dodo.learning;

import java.util.Arrays;

public class MyArrayList<T> {

	private final static int DEFAULT_SIZE = 10;
	private final static int DEFAULT_INCREACE_SIZE = 10;
	private int current_index, current_size;
	private T[] array;
	
	@SuppressWarnings("unchecked")
	public MyArrayList(){
		array = (T[]) new Object[DEFAULT_SIZE];
		current_index = -1;
		current_size = DEFAULT_SIZE;
	}
	
	public boolean add(T t){
		checkSize(++current_index);
		array[current_index] = t;
		return true;
	}
	
	public T get(int index){
		if(index > current_index)
			throw new IndexOutOfBoundsException("Size is " + size() +" but index is " + index);
		return array[index];
	}
	
	public T remove(int index){
		if(current_index >= 0 && index <= current_index && index>=0){
			T t = array[index];
			if (current_index!=index) {
				System.out.println("here");
				System.arraycopy(array, index+1, array, index, current_index - index);
			}
			array[current_index--] = null;
			return t;
		}else{
			throw new IndexOutOfBoundsException("Size is " + size() +" but index is " + index);
		}
	}
	
	public void addAll(T[] t){
		if (null==t) {
			throw new NullPointerException();
		}
		for (T t2 : t) {
			add(t2);
		}
	}
	
	public int size(){
		return current_index+1;
	}
	
	private void checkSize(int size){
		if (size >= current_size) {
			current_size += DEFAULT_INCREACE_SIZE;
			array = Arrays.copyOf(array, current_size);
		}
	}
	
	public static void main(String[] args) {
		MyArrayList<String> myArrayList = new MyArrayList<>();
		myArrayList.add("test");
		String[] s = {"1","2","3","4","5","6","7","8","9","10"};
		myArrayList.addAll(s);
		System.out.println(myArrayList.remove(0)+" "+myArrayList.get(0)+" "+" "+myArrayList.get(9)+" "+myArrayList.size());
	}
}
