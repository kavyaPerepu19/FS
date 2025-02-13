// Cliff Shaw is working on the singly linked list.
// He is given a list of boxes arranged as singly linked list,
// where each box is printed a positive number on it.

// Your task is to help Mr Cliff to find the given list is equivalent to 
// the reverse of it or not. If yes, print "true", otherwise print "false"

// Input Format:
// -------------
// Line-1: space separated integers, boxes as list.

// Output Format:
// --------------
// Print a boolean a value.

// Sample Input-1:
// ---------------
// 3 6 2 6 3

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 3 6 2 3 6

// Sample Output-2:
// ----------------
// False


import java.util.*;

class Node{    
	int data;    
	Node next;    
		
	public Node(int data) {    
		this.data = data;    
		this.next = null;    
	}    
}    

class Solution
{
	//Write if any supporting methods here

	Node getMid(Node head)
	{
		Node fast = head;
		Node slow = head;

		while(fast!=null && fast.next!=null)
		{
			fast=fast.next.next;
			slow = slow.next;
		}

		return slow;


	}


	Node reverse(Node mid)
	{
		Node curr = mid;
		Node prev = null;

		while(curr!=null)
		{
			Node fwd = curr.next;
			curr.next = prev;
			prev = curr;
			curr = fwd;

		}

		return prev;
	}

	boolean compare(Node head,Node last,Node mid)
	{
		Node hptr = head;
		Node lptr = last;
		while(lptr!=null)
		{
			if(lptr.data!= hptr.data)
			{
				return false;
			}

			lptr = lptr.next;
			hptr = hptr.next;
		}
		return true;
	}
	
    
	boolean isPalindrome(Node head) 
	{
		//Write your code here and return boolean value
		Node mid = getMid(head);
		Node last =  reverse(mid);

		boolean isPali = compare(head,last,mid);
		return isPali;
	}    
}

public class PalindromeList 
{    
	public Node head = null;    
	public Node tail = null;    

	public void addNode(int data) 
	{    
		Node newNode = new Node(data);    
		if(head == null) 
		{    
			head = newNode;    
			tail = newNode;    
		}    
		else 
		{    
			tail.next = newNode;    
			tail = newNode;    
		}    
	}    
        
	public static void main(String[] args) 
	{    
		Scanner sc=new Scanner(System.in);
		PalindromeList list = new PalindromeList();       
		String list2[]=sc.nextLine().split(" "); 
		for(int i=0;i<list2.length;i++)
			list.addNode(Integer.parseInt(list2[i]));
		Solution sl=new Solution();
		System.out.println(sl.isPalindrome(list.head));
	}    
}    