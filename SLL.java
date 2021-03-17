package edu.mtc.egr283.project05;

public class SLL<E> {

	private int length;
	private SLLNode<E> head;
	private SLLNode<E> tail;
	
	public static final String COLON_SPACE = ": ";
	public static final String NEW_LINE = "\n";
	
	public SLL(){
		this.length = 0;
		this.tail = new SLLNode<E>();
		this.head = new SLLNode<E>(null, this.tail);
	}//end of constructor
	
	public int size() {
		return this.length;
	}//end of method size
	
	public E getDataAtPosition(int position) {
		return (this.find(position)).getNodeData();
	}//end of method getDataAtPositon
	
	public void addAtHead(E newNodeData) {
		this.addAfter(this.head, new SLLNode<E>(newNodeData, null));
	}//end of method addAtHead
	
	public void add(E newNodeData, int position) {
		SLLNode<E> cursor = this.head;
		if(position > 0) {
			cursor = this.find(position - 1);
		}//end of if
		this.addAfter(cursor, new SLLNode<E>(newNodeData, null));
	}//end of method add
	
	public void setData(E newNodeData, int position) {
		(this.find(position)).setNodeData(newNodeData);
	}// Ending bracket of method
	
	public E remove(int position) {
		SLLNode<E> cursor = this.head;
		if(position > 0) {
			cursor = this.find(position - 1);
		}//end of if
		SLLNode<E> target = cursor.getNext();
		cursor.setNext(target.getNext());
		--this.length;
		
		E rv = target.getNodeData();
		
		target.setNext(null);
		target.setNodeData(null);
		
		return rv;
	}//end of method remove(int)
	
	public E removeData(E targetData) {
		return this.remove(this.findIndex(targetData));
	}//end of method remove(E)
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		SLLNode<E> cursor = this.head.getNext();
		int index = 0;
		
		while(cursor != tail) {
			sb.append(index + COLON_SPACE + cursor.getNodeData().toString() + NEW_LINE);
			cursor = cursor.getNext();
			++index;
		}//end of while loop
		
		return sb.toString();
	}//ending bracket of method toString
	
	private void addAfter(SLLNode<E> currentNode, SLLNode<E> newNode) {
		newNode.setNext(currentNode.getNext());
		currentNode.setNext(newNode);
		++this.length;
	}//end of method addAfter
	
	private int findIndex(E targetData) {
		int rv = 0;
		SLLNode<E> cursor = head.getNext();
		while((cursor != tail) && (!cursor.getNodeData().equals(targetData))) {
			cursor = cursor.getNext();
			++rv;
		}//end of while loop
		
		if(rv == this.size()) {
			rv = -1;
		}//end of if
		
		return rv;
	}//end of method findIndex
	
	private SLLNode<E> find(E targetData){
		SLLNode<E> rv = new SLLNode<E>();
		
		SLLNode<E> cursor = head.getNext();
		
		while(cursor != tail) {
			if(cursor.getNodeData().equals(targetData)) {
				rv = cursor;
				break;
			}else {
				cursor = cursor.getNext();
			}//end of if
		}//end of while loop
		
		return rv;
	}//end of method find(E)
	
	private SLLNode<E> find(int position){
		
		SLLNode<E> cursor = head.getNext();
		int index = 0;
		
		while((index != position) && (cursor != tail)) {
			++index;
			cursor = cursor.getNext();
		}//end of while loop
		
		return cursor;
	}//end of method find(int)

	
	
	
}//end of class SLL
