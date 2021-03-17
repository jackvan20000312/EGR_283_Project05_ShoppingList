package edu.mtc.egr283.project05;

public class SLLNode<T> {

	private T nodeData;
	private SLLNode<T> next;
	
	/**
	 * default constructor
	 */
	public SLLNode() {
		this(null, null);
	}//end of constructor no args
	
	/**
	 * Constructor
	 * @param newNodeData
	 * @param newNext
	 */
	public SLLNode(T newNodeData, SLLNode<T> newNext) {
		this.setNodeData(newNodeData);
		this.setNext(newNext);
	}//end of constructor
	
	
	/**
	 * Accessor method for nodeData
	 * @return the nodeData
	 */
	public T getNodeData() {
		return this.nodeData;
	}//end of method getNodeData
	
	/**
	 * Mutator method for nodeData
	 * @param nodeData the nodeData to set
	 */
	public void setNodeData(T newNodeData) {
		this.nodeData = newNodeData;
	}//end of method setNodeData
	
	
	/**
	 * Accessor method for next
	 * @return the next
	 */
	public SLLNode<T> getNext() {
		return this.next;
	}//end of method getNext
	
	
	/**
	 * Mutator method for next
	 * @param next the next to set
	 */
	public void setNext(SLLNode<T> newNext) {
		this.next = newNext;
	}//end of method setNext
	
	
	
}//end of class sllnode
