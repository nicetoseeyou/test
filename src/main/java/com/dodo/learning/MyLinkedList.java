package com.dodo.learning;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {
	
	//双向链表
	
	private int size = 0;
	private Node<T> head = new Node<T>(null, null, null);
	
	
	//data-structure
	private static class Node<T>{
		T data;
		Node<T> next;
		Node<T> previous;
		
		Node(T data, Node<T> next, Node<T> previous){
			this.data = data;
			this.next = next;
			this.previous = previous;
		}
		
	}
	
	public MyLinkedList() {
		head.previous = head.next = head;
	}
	
	public boolean add(T t){
		addBefore(t, head);
		size++;
		return true;
	}
	
	public boolean add(T t, int index){
		return true;
	}
	
	public T getFirst(){
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return head.next.data;
	}
	
	public T get(int index) {
		return findByIndex(index).data;
	}
	
	public void remove(int index){
		Node<T> node = findByIndex(index);
		node.previous.next = node.next;
		node.next.previous = node.previous;
		size--;
		node = null;
	}
	
	public int size(){
		return size;
	}
	
	//表头插入
	public void addHead(T t){
		addBefore(t, head.next);
	}
	
	//表尾插入
	public void addTail(T t){
		addBefore(t, head);
	}
	
	// 将节点t添加到node节点之前。
	private Node<T> addBefore(T t, Node<T> node){
		//新节点的初始化，指定新节点的前一个节点和后一个节点
		Node<T> newNode = new Node<T>(t, node, node.previous);
		//告知新节点的前一个节点其后面是新节点
		newNode.previous.next = newNode;
		//告知新节点的后一个节点其前节点是新节点
		newNode.next.previous = newNode;
		return newNode;
	}
	
	private Node<T> findByIndex(int index){
		if (index<0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: "+ index + ", Size: " + size());
		}
		
		Node<T> node = head;
		//from head
		if (index < size - index) {
			for(int i = 0; i <= index; i++){
				node = node.next;
			}
		}else{
			for(int i = size; i > index; i--){
				node = node.previous;
			}
		}
		return node;
	}
	
	public static void main(String[] args) {
		MyLinkedList<String> myLinkedList = new MyLinkedList<>();
		myLinkedList.add("test");
		myLinkedList.add("test2");
		myLinkedList.add("1");
		myLinkedList.remove(0);
		System.out.println(myLinkedList.get(1)+" "+myLinkedList.getFirst());
	}

}
