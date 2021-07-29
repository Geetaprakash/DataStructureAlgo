
public class StackPal{
Node head;
Node left;

public class Node
{
	public char data;
	public Node next;
	public Node(char d)
	{
		data = d;
		next = null;
	}
}
boolean isPalindrome(Node right)
{
	left = head;
	if (right == null)
		return true;
	boolean isp = isPalindrome(right.next);
	if (isp == false)
		return false;
	boolean isp1 = (right.data == left.data);
	left = left.next;
	//next node
	return isp1;
}
boolean isPalindromeH(Node head)
{
	boolean result = isPalindromeH(head);
	return result;
}
public void push(char new_data)
{
	Node new_node = new Node(new_data);
	new_node.next = head;
	head = new_node;
}

void printList(Node ptr)
{
	while (ptr != null)
	{
		System.out.print(ptr.data + "->");
		ptr = ptr.next;
	}
	System.out.println("Null");
}


public static void main(String[] args)
{
	StackPal spal = new StackPal();
	char[] str = { 'a', 'b', 'a', 'c', 'a', 'b', 'a'};
	for(int i = 0; i < 7; i++)
	{
		spal.push(str[i]);
		spal.printList(spal.head);
		
		if (spal.isPalindromeH(spal.head))
		{
			System.out.println("Is Palindrome");
			System.out.println("");
		}
		else
		{
			System.out.println("Not Palindrome");
			System.out.println("");
		}
	}
}
}

