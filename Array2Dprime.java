import java.util.*;
public class Array2Dprime{
	public static void main(String[] args)
	{
		Deque<String> dq = new ArrayDeque<String>();
		dq.add("For");
		dq.addFirst("java");
		dq.addLast("program");
		dq.add("is so good");

		for (Iterator itr = dq.iterator();
			itr.hasNext();) {
			System.out.print(itr.next() + " ");
		}

		System.out.println();

		for (Iterator itr = dq.descendingIterator();
			itr.hasNext();) {
			System.out.print(itr.next() + " ");
		}
	}
}
