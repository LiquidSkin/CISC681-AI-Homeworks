import java.util.*;
import java.util.Map.Entry;

public class Pancake {
	
	public static final String result = "1W2W3W4W";
	public static List<List<String>> al = new ArrayList<List<String>>(); // LIST OF LISTS TO STORE THE STATE SPACE GRAPH
	public static List<String> alList = new ArrayList<String>(); 
	
	public static String oneFlip(String str1, int len) // helper function to make one flip
	{
		StringBuilder str = new StringBuilder(str1);
		char ch = str.charAt(1);
		if(ch == 'W')
		{
			str.setCharAt(1, 'B');
		}
		else
		{
			str.setCharAt(1, 'W');
		}
		return str.toString();
	}
	public static String twoFlip(String str1, int len) // helper function to make two flips
	{
	  StringBuilder str = new StringBuilder(str1);
	  char ch1 = str.charAt(0);
	  char ch2 = str.charAt(1);
	  char ch3 = str.charAt(2);
	  char ch4 = str.charAt(3);
	  
	 //System.out.print(ch1 + " " + ch2  + " " + ch3 + " " + ch4);
	  str.setCharAt(2, ch1);
	  str.setCharAt(0,ch3);
	  if(ch2 == 'W')
	  {
		  str.setCharAt(3,'B');
	  }
	  else if(ch2 == 'B')
	  {
		  str.setCharAt(3,'W');
	  }
	  if(ch4 == 'W')
	  {
		  str.setCharAt(1, 'B');
	  }
	  else if(ch4 == 'B')
	  {
		  
		  str.setCharAt(1, 'W');
	  }
	  return str.toString();
		  
	}
	public static String threeFlip(String str1, int len) // helper function to make three flips
	{
     StringBuilder str = new StringBuilder(str1);
	 char ch1 = str.charAt(0);
     char ch2 = str.charAt(1);
     char ch3 = str.charAt(2);
     char ch4 = str.charAt(3);
     char ch5 = str.charAt(4);
     char ch6 = str.charAt(5);
     str.setCharAt(0, ch5);
     str.setCharAt(4, ch1);
     if(ch4 == 'W')
     {
    	 str.setCharAt(3, 'B');
     }
     else if(ch4 == 'B')
     {
    	 str.setCharAt(3, 'W');
     }
     if(ch2 == 'W')
     {
    	 str.setCharAt(5,'B');
     }
     else if(ch2 == 'B')
     {
    	 str.setCharAt(5, 'W');
     }
     if(ch6 == 'B')
     {
    	 str.setCharAt(1,'W');
     }
     else if(ch6 == 'W')
     {
    	 str.setCharAt(1, 'B');
     }
	return str.toString();
	}

	public static String fourFlip(String str1, int len) // helper function to get four flips
	{
		StringBuilder str = new StringBuilder(str1);
		char ch1 = str.charAt(0);
		char ch2 = str.charAt(1);
		char ch3 = str.charAt(2);
		char ch4 = str.charAt(3);
		char ch5 = str.charAt(4);
		char ch6 = str.charAt(5);
		char ch7 = str.charAt(6);
		char ch8 = str.charAt(7);
		str.setCharAt(0, ch7);
		str.setCharAt(6, ch1);
		str.setCharAt(2, ch5);
		str.setCharAt(4, ch3);
		if(ch8 == 'W')
		{
			str.setCharAt(1, 'B');
		}
		else if(ch8 == 'B')
		{
			str.setCharAt(1,'W');
		}
		if(ch2 =='W')
		{
			str.setCharAt(7,'B');
		}
		else if(ch2 == 'B')
		{
			str.setCharAt(7,'W');
		}
		if(ch4 == 'W')
		{
			str.setCharAt(5,'B');
		}
		else if(ch4 == 'B')
		{
			str.setCharAt(5,'W');
		}
		if(ch6 == 'W')
		{
			str.setCharAt(3,'B');
		}
		else if(ch6 == 'B')
		{
			str.setCharAt(3,'W');
		}
		return str.toString();
		
	}
	public static void BFS(String str, int len) // Function to perform BFS
	{
		if(str.equals(result)) // If the input string is already sorted, there is no need to flip
		{
			System.out.println("There is no need to Flip");
			return;
		}
		System.out.println("The State Space Graph is" + " "); // we are printing the state space graph
			
		Queue<String> queue = new LinkedList<String>(); // for BFS, we use a queue which acts as a fringe. 
		queue.add(str); // we add the input string as the root of the tree to the queue
		int count = 0;
		while(queue.size() != 0) 
		{
			
			String string = queue.poll(); // we output the queue and the four children(in this case, which are the strings obtained by the four flips as children to the root in the queue)
			System.out.println(string + " ");
			if(string.equals(result)) // this is to avoid processing reoccuring branches of the tree. if any state becomes equal to the input, we stop processing that string.
			{
				break;
			}
			
			
			String str1 = oneFlip(string,len); // add first child after doing one flip
			
			queue.add(str1);
			
			System.out.println(str1);
			
			
			String str2 = twoFlip(string,len); // add second child after doing two flips
			
		
				
			queue.add(str2);
		
			System.out.println(str2);
			
			
			String str3 = threeFlip(string,len); // add third child after doing three flips
			
	
			queue.add(str3);
			
			System.out.println(str3);
			
		
	
			String str4 = fourFlip(string,len); // add fourth child after doing four flips
			
		
			queue.add(str4);
		
			System.out.println(str4);
			
			   List<String> list = new ArrayList<String>(); // store the parent and the four children in a list of lists. the first element of each list in the lists would be the parent
			    list.add(string);
			    list.add(str1);
			    list.add(str2);
			    list.add(str3);
			    list.add(str4);
			    al.add(list);
			
		    if(str4.equals(result) || str3.equals(result) || str2.equals(result) || str1.equals(result))
			{
				break;
			}
		 }
		List<String> li = al.get(al.size() - 1); // starting from here to end of the function is the logic to backtrack through the state space tree and find the parent till the root. I tried writing a recursive function but it was tricky and hence I am calling the helper functions repeatedly.
		String element = li.get(0);
		
		alList.add(element);
		String finalEle = searchArrayList(al,element);
		
		alList.add(finalEle);
		
		if(finalEle.equals(str))
		{
			return;
		}
		String nextEle = searchArrayListIndex(al,finalEle);
		
		alList.add(nextEle);
		String nextnextEle = searchArrayList(al,nextEle);
		
		alList.add(nextnextEle);
		if(nextnextEle.equals(str))
		{
			return;
		}
		String varEle = searchArrayListIndex(al,nextnextEle);
		alList.add(varEle);
		String varvarEle = searchArrayList(al,varEle);
	
		alList.add(varvarEle);
		if(varvarEle.equals(str))
		{
			return;
		}
		String varElement = searchArrayListIndex(al,varvarEle);
		alList.add(varElement);
		String fooElement =  searchArrayList(al,varElement);
		alList.add(fooElement);
		if(fooElement.equals(str))
		{
			return;
		}
		String foofooElement = searchArrayListIndex(al,fooElement);
		alList.add(foofooElement);
		String charElement = searchArrayList(al,foofooElement);
		alList.add(charElement);
		if(charElement.equals(str))
		{
			return;
		}
		String characterElement = searchArrayListIndex(al,charElement);
		alList.add(characterElement);
}
	public static String searchArrayListIndex(List<List<String>>list, String key) // This function is to find the parent when it occurs as a child of a root.
	{
		String val = null;
		for(int i = list.size()-1; i>=0; i--)
		{
			List<String> al = list.get(i);
			if((al.contains(key)) && (al.get(0) != key))
			{
			  val = al.get(0);	
			}
		}
		return val;
		
	}
	public static String searchArrayList(List<List<String>> list, String key) // This function is used to find the parent of a child node.
	{
		String val = null;
		for(int i = list.size()-1; i>=0; i--)
		{
			List<String> al = list.get(i);
			if(al.contains(key))
			{
				val = al.get(0);
			}
		}
		return val;
	}
	public static void formatOutput(List<String> alList) //This is a helper function to format the output in the desired format.
	{
		String sb = null;
		alList.add(result);
		
		for(int i=0; i<alList.size()-1; i++)
		{
		
			int count = 0;
			String str1 = alList.get(i);
			String str2 = alList.get(i+1);
			if(!str1.substring(0,2).equals(str2.substring(0,2)))
			{
				count++;
			}
			if(!str1.substring(2,4).equals(str2.substring(2,4)))
			{
				count++;
			}
			if(!str1.substring(4,6).equals(str2.substring(4,6)))
			{
				count++;
			}
			if(!str1.substring(6,str1.length()).equals(str2.substring(6,str1.length())))
			{
				count++;
			}
			if(count == 1)
			{
				sb = str1.substring(0,2) + "|" + str1.substring(2,str1.length());
			}
			else if(count == 2)
			{
				sb = str1.substring(0,4) + "|" + str1.substring(4,str1.length());
			}
			else if(count == 3)
			{
				sb = str1.substring(0,6) + "|" + str1.substring(6,str1.length());
			}
			else if(count == 4)
			{
				sb = str1 + "|";
			}
			System.out.println(str1 + " "  + "to" + " " + str2 + " " + "needs" + " " + count + " " + "flips at " + " " + sb);
			sb = null;	
	}
	
		
}
	public static void main(String[] args)
	{
		System.out.print("Enter your String");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int len = str.length();
		BFS(str,len);
		Collections.reverse(alList);
		formatOutput(alList);
	
	}
	

}
