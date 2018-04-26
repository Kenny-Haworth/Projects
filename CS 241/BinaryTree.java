/**
	@author Kendall Haworth
	
	BinaryTree ADT for CS 241-02
*/

import java.util.Scanner;
import java.util.StringTokenizer;

public class BinaryTree
{
	BinaryNode root; //Global root node available to all methods
	
	//constructor to initialize the root node
	public BinaryTree()
	{
		root = null;
	}
	
	/**
		Adds the root to the binary search tree if it doesn't exist
		and calls the recursive method addNode()
	
		@param data The data passed in to be added as a node to the tree
		@return BinaryNode The node that was added to the tree or null if the node already exists
	*/
	public BinaryNode add(int data)
	{
		if (root == null) //if the root node has not been created, create the root node
		{
			root = new BinaryNode(data);
			return root;
		}
		else
		{
			return addNode(root, data);
		}
	}
	
	/**
		Adds a node to the binary search tree using recursion
		
		@param data The data passed in to be added as a node to the tree
		@return BinaryNode The node that was added to the tree or null if the node already exists
	*/
	private BinaryNode addNode(BinaryNode node, int data)
	{
		if (data == node.getData()) //if the data is the same, the node already exists and the data is overwritten
		{
			return null;
		}
		else if (data < node.getData()) //the node should be to the left
		{
			if (node.hasLeftChild()) //The node has a left child, so call addNode() again and continue searching
			{
				return addNode(node.getLeftChild(), data);
			}
			else //the location has been found, set the parent's left child as the new node
			{
				node.setLeftChild(new BinaryNode(data));
				return node;
			}
		}
		else //data > node.getData(), the node should be to the right
		{
			if (node.hasRightChild()) //The node has a right child, so call addNode() again and continue searching
			{
				return addNode(node.getRightChild(), data);
			}
			else //the location has been found, set the parent's right child as the new node
			{
				node.setRightChild(new BinaryNode(data));
				return node;
			}
		}
	}
	
	/**
		Calls the recursive method remove() with the root and the data
		
		@param data The data the node contains that needs to be removed from the tree
		@return BinaryNode The node that was removed or null if no such node exists
	*/
	public BinaryNode remove(int data)
	{
		return remove(root, data);
	}
	
	/**
		Removes the node with the given data by using recursion
		
		@param data The data the node contains that needs to be removed from the tree
		@return BinaryNode The node that was removed or null if no such node exists
	*/
	private BinaryNode remove(BinaryNode node, int data)
	{
		if (root == null) //if the root is null, the tree is empty and nothing can be removed
		{
			System.out.println("This tree is empty!");
			return null;
		}
		
		if (root.getData() == data) //special case for removing the root node
		{
			BinaryNode predecessor = findPredecessor(data); //find the predecessor
			
			if (predecessor == null) //if the root has no predecessor, check for successor
			{
				BinaryNode successor = findSuccessor(data);
				
				if (successor == null) //if the root has no successor either, it is the only node in the tree and can be removed
				{
					BinaryNode copy = root; // a copy of root is made to be returned so a null node is not returned, which would indicate failure in removal
					root = null;
					return copy;
				}
				else //if the root has a successor, replace the root with it and delete the successor
				{
					remove(root.getRightChild(), successor.getData());
					root.setData(successor.getData());
					return root;
				}
			}
			else //the root has a predecessor, replace the root with it and delete the predecessor
			{
				remove(root.getLeftChild(), predecessor.getData());
				root.setData(predecessor.getData());
				return root;
			}
		}
		
		//Find the node in the tree to be removed
		BinaryNode child = findNode(node, data);
		
		if (child == null) //if the node could not be found, the node does not exist to be removed
		{
			return null;
		}

		//if the node exists and is not the root, find it's parent
		BinaryNode parent = findParent(root, data);
		
		if (child.hasLeftChild() && child.hasRightChild()) //the child has two children
		{
			BinaryNode predecessor = findPredecessor(data); //find it's predecessor
			remove(node, predecessor.getData()); //delete it's predecessor
			child.setData(predecessor.getData()); //replace the child's data with the predecessor's data

		}
		else if (child.hasLeftChild()) //the node has only a left child
		{
			if (parent.getLeftChild() == child) //set the parent's link to the child's only link
			{
				parent.setLeftChild(child.getLeftChild());
			}
			else //parent.getRightChild() == child
			{
				parent.setRightChild(child.getLeftChild());
			}
		}
		else if (child.hasRightChild()) //the node has only a right child
		{
			if (parent.getLeftChild() == child) //set the parent's link to the child's only link
			{
				parent.setLeftChild(child.getRightChild());
			}
			else //parent.getRightChild() == child
			{
				parent.setRightChild(child.getRightChild());
			}
		}
		else //node has no children and is a leaf node
		{
			if (parent.getLeftChild() == child) //simply delete parent's link to the child
			{
				parent.setLeftChild(null);
			}
			else //parent.getRightChild() == child
			{
				parent.setRightChild(null);
			}
		}
		
		return child; //return the node that was removed
	}
	
	//calls preorder with the root node
	public void preorder()
	{
		preorder(root);
	}
	
	/**
		overloads method preorder() and
		prints the BST out with recursive preorder traversal
	*/
	private void preorder(BinaryNode node)
	{
		if (node != null)
		{
			System.out.print(node.getData() + " ");
			preorder(node.getLeftChild());
			preorder(node.getRightChild());
		}
	}
	
	//calls inorder with the root node
	public void inorder()
	{
		inorder(root);
	}
	
	/**
		overloads method inorder() and
		prints the BST out with recursive inorder traversal
	*/
	public void inorder(BinaryNode node)
	{
		if (node != null)
		{
			inorder(node.getLeftChild());
			System.out.print(node.getData() + " ");
			inorder(node.getRightChild());
		}
	}
	
	//calls postorder with the root node
	public void postorder()
	{
		postorder(root);
	}
	
	/**
		overloads method postorder() and
		prints the BST out with recursive preorder traversal
	*/
	private void postorder(BinaryNode node)
	{
		if (node != null)
		{
			postorder(node.getLeftChild());
			postorder(node.getRightChild());
			System.out.print(node.getData() + " ");
		}
	}
	
	/**
		Finds the predecessor for a node with the given data
		
		@param data The data of the node to find the predecessor for
		@return The predecessor of the node with the given data
	*/
	public BinaryNode findPredecessor(int data)
	{
		BinaryNode node = findNode(root, data); //first find the node
		
		if (node == null || (node.getData() == root.getData() && !root.hasLeftChild())) //if the node doesn't exist, or is the root node without a left child, the predecessor does not exist
		{
			return null;
		}
		
		if (node.hasLeftChild()) //If the node has a left child, take it and find the rightmost child. That is the predecessor
		{
			node = node.getLeftChild();
		
			while (node.hasRightChild())
			{
				node = node.getRightChild();
			}
		
			return node; //return the predecessor
		}
		else //node does not have a right child
		{	
			BinaryNode parent = findParent(root, data);
			
			while (parent.getRightChild() != node) //if the parent's right child is the node, that is the predecessor
			{
				node = parent; //the child is not the right parent's link, so set the parent as the new child and find that child's parent
				parent = findParent(root, node.getData());
				
				if (parent == null) //if at any point the parent is null, the root has been reached (the root has no parent) and the node does not have a predecessor
				{
					return null;
				}
			}
			
			return parent; //return the predecessor
		}
	}
	
	/**
		Finds the successor for a node with the given data
		
		@param data The data of the node to find the successor for
		@return The successor of the node with the given data
	*/
	public BinaryNode findSuccessor(int data)
	{
		BinaryNode node = findNode(root, data); //first find the node
		
		if (node == null || (node.getData() == root.getData() && !root.hasRightChild())) //if the node doesn't exist, or is the root node without a right child, the successor does not exist
		{
			return null;
		}
		
		if (node.hasRightChild()) //If the node has a right child, take it and find the leftmost child. That is the successor
		{
			node = node.getRightChild();
		
			while (node.hasLeftChild())
			{
				node = node.getLeftChild();
			}
		
			return node; //return the successor
		}
		else //node does not have a right child
		{	
			BinaryNode parent = findParent(root, data);
			
			while (parent.getLeftChild() != node) //if the parent's left child is the node, that is the predecessor
			{
				node = parent; //the child is not the left parent's link, so set the parent as the new child and find that child's parent
				parent = findParent(root, node.getData());
				
				if (parent == null) //if at any point the parent is null, the root has been reached (the root has no parent) and the node does not have a successor
				{
					return null;
				}
			}
			
			return parent; //return the successor
		}
	}
	
	/**
		Finds the node with the given data starting at the given node using recursion
		
		@param node The root of the subtree given. Begin at this point to find the node
		@param data The data of the node to be found
		@return BinaryNode The node that is found with the given data in the given subtree
	*/
	private BinaryNode findNode(BinaryNode node, int data)
	{
		if (data == node.getData()) //if the data equals the node, the node has been found
		{
			return node;
		}
		else if (data < node.getData()) //if the data is less than the node, search the left subtree
		{
			if (node.hasLeftChild()) //calls findNode again with the left subtree and the same data
			{
				return findNode(node.getLeftChild(), data);
			}
			else //if the node has no left child, the node doesn't exist
			{
				return null;
			}
		}
		else //data > node.getData(), the data is greater than the node, search the right subtree
		{
			if (node.hasRightChild()) //calls FindNode again with the right subtree and teh same data
			{
				 return findNode(node.getRightChild(), data);
			}
			else //if the node has no right child, the node doesn't exist
			{
				return null; //the node this method is searching for doesn't exist
			}
		}
	}
	
	/**
		Finds the parent of the node with the given data starting at the given node using recursion
		
		@param node The root of the subtree given. Begin at this point to find the parent's node
		@param data The data of the node whose parent is to be found
		@return BinaryNode The node that is found with the given data in the given subtree
	*/
	private BinaryNode findParent(BinaryNode node, int data)
	{
		if (data == node.getData()) //this node has no parent; it is the root node
		{
			return null;
		}
		else if (data < node.getData()) //search the left subtree for the parent
		{
			if (data == node.getLeftChild().getData()) //if the left link of this node is the child, it is the parent
			{
				return node;
			}
			else
			{
				if (!node.hasLeftChild()) //the child node does not exist, therefore it does not have a parent
				{
					return null;
				}
				else //search for the parent further in the left subtree
				{
					return findParent(node.getLeftChild(), data);
				}
			}
		}
		else //data > node.getData(), search the right subtree for the parent
		{
			if (data == node.getRightChild().getData()) //if the right link of this node is the child, it is the parent
			{
				return node;
			}
			else
			{
				if (!node.hasRightChild()) //the child node does not exist, therefore it does not have a parent
				{
					return null;
				}
				else //search for the parent further in the right subtree
				{
					return findParent(node.getRightChild(), data);
				}
			}
		}
	}
}