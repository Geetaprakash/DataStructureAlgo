import java.util.Arrays;
import java.util.LinkedList;

public class QueueAna
{
	static final int NO_OF_CHARS = 26;
	static class TrieNode
	{
		boolean isEnd; 
		TrieNode[] child = new TrieNode[NO_OF_CHARS];
		// head o
		LinkedList<Integer> head;
		public TrieNode()
		{
			isEnd = false;
			head = new LinkedList<>();
			for (int i = 0; i < NO_OF_CHARS; ++i)
				child[i] = null;
		}
	}
	
	// insert a word to Trie
	static TrieNode insert(TrieNode root,String word,int index, int i)
	{
		// Base 
		if (root == null)
		{
			root = new TrieNode();
		}
		
		if (i < word.length() )
		{
			int index1 = word.charAt(i) - 'a';
			root.child[index1] = insert(root.child[index1],word, index, i+1 );
		}
		else // If end of the word reached
		{
			// index end 
			if (root.isEnd == true)
			{
				root.head.add(index);
			}
			else // If list is empty
			{
				root.isEnd = true;
				root.head.add(index);
			}
		}
		return root;
	}
	static void printAnagramsUtil(TrieNode root,String wordArr[])
	{
		if (root == null)
			return;
	
		// lead node reached, print anagram
		if (root.isEnd)
		{
			for(Integer pCrawl: root.head)
				System.out.println(wordArr[pCrawl]);
		}
	
		for (int i = 0; i < NO_OF_CHARS; ++i)
			printAnagramsUtil(root.child[i], wordArr);
	}

	static void printAnagramsTogether(String wordArr[],
											int size)
	{
		// Create empty Trie
		TrieNode root = null;
		for (int i = 0; i < size; ++i)
		{
			char[] buffer = wordArr[i].toCharArray();
			Arrays.sort(buffer);
			root = insert(root, new String(buffer), i, 0);
			
		}
		printAnagramsUtil(root, wordArr);
	}
	public static void main(String args[])
	{
		String wordArr[] = {"cat", "dog", "tac", "god","act", "gdo"};
		int size = wordArr.length;
		printAnagramsTogether(wordArr, size);
	}
}
