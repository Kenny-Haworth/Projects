/**
	@author Kendall Haworth
	
	Binary Node class for Project 1
	CS 241-02
*/


public class BinaryNode
{
	private int data; //the node must have data and two links
	private BinaryNode leftChild;
	private BinaryNode rightChild;
	
	public BinaryNode(int data) //initialize a node with data
	{
		this.data = data;
	}
	
	public int getData() //getters for data and node links
	{
		return data;
	}
	
	public BinaryNode getLeftChild()
	{
		return leftChild;
	}
	
	public BinaryNode getRightChild()
	{
		return rightChild;
	}
	
	public int setData(int newData) //setters for data and node links
	{
		int oldData = data;
		data = newData;
		return oldData;
	}
	
	public void setLeftChild(BinaryNode leftChild)
	{
		this.leftChild = leftChild;
	}
	
	public void setRightChild(BinaryNode rightChild)
	{
		this.rightChild = rightChild;
	}
	
	public boolean hasLeftChild() //checks if the node has a left/right child
	{
		return (leftChild != null);
	}
	
	public boolean hasRightChild()
	{
		return (rightChild != null);
	}
}