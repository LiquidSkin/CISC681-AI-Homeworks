import java.util.*;
import java.util.Map.Entry;

public class Pancake {
	
	public static final String result = "1W2W3W4W";
	public static List<List<String>> al = new ArrayList<List<String>>();
	public static List<String> alList = new ArrayList<String>();
	
	public static String oneFlip(String str1, int len)
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
	public static String twoFlip(String str1, int len)
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
	public static String threeFlip(String str1, int len)
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

	public static String fourFlip(String str1, int len)
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
	public static void BFS(String str, int len)
	{
		Queue<String> queue = new LinkedList<String>();
		queue.add(str);
		int count = 0;
		while(queue.size() != 0) 
		{
			
			String string = queue.poll();
			System.out.println(string + " ");
			if(string.equals(result))
			{
				break;
			}
			
			
			String str1 = oneFlip(string,len);
			
			queue.add(str1);
			
			System.out.println(string + " " + str1);
			
			
			String str2 = twoFlip(string,len);
			
		
				
			queue.add(str2);
		
			System.out.println(string + " " + str2);
			
			
			String str3 = threeFlip(string,len);
			
	
			queue.add(str3);
			
			System.out.println(string + " " + str3);
			
		
	
			String str4 = fourFlip(string,len);
			
		
			queue.add(str4);
		
			System.out.println(string + " " + str4);
			
			   List<String> list = new ArrayList<String>();
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
		List<String> li = al.get(al.size() - 1);
		String element = li.get(0);
		System.out.println("Printing the last element of the ArrayList and the element " + li + "  " + element);
		alList.add(element);
		String finalEle = searchArrayList(al,element);
		System.out.println("the next initial element is" + finalEle);
		alList.add(finalEle);
		
		if(finalEle.equals(str))
		{
			return;
		}
		String nextEle = searchArrayListIndex(al,finalEle);
		System.out.println("the next  Element is " + nextEle);
		alList.add(nextEle);
		String nextnextEle = searchArrayList(al,nextEle);
		System.out.println("the next next Element is" + nextnextEle);
		alList.add(nextnextEle);
		if(nextnextEle.equals(str))
		{
			return;
		}
		String varEle = searchArrayListIndex(al,nextnextEle);
		System.out.println("the next variable element is" + varEle);
		alList.add(varEle);
		String varvarEle = searchArrayList(al,varEle);
		System.out.println("the var var Element is" + varvarEle);
		alList.add(varvarEle);
		if(varvarEle.equals(str))
		{
			return;
		}
		String varElement = searchArrayListIndex(al,varvarEle);
		System.out.println("the next variable variable element is" + varElement);
		alList.add(varElement);
		String fooElement =  searchArrayList(al,varElement);
		System.out.println("the FooElement is" + fooElement);
		alList.add(fooElement);
		if(fooElement.equals(str))
		{
			return;
		}
		String foofooElement = searchArrayListIndex(al,fooElement);
		alList.add(foofooElement);
		System.out.println("the FooFooElement is" + foofooElement);
		String charElement = searchArrayList(al,foofooElement);
		System.out.print("The Char Element is" + charElement);
		alList.add(charElement);
		if(charElement.equals(str))
		{
			return;
		}
		String characterElement = searchArrayListIndex(al,charElement);
		alList.add(characterElement);
		System.out.print("the Character Element is" + characterElement);
		
		
		
	
		
		
}
	public static String searchArrayListIndex(List<List<String>>list, String key) // DO NOT GET THE FIRST ARRAYLIST
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
	public static String searchArrayList(List<List<String>> list, String key) // GET FIRSTINDEX
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
	

	
     
     
    
    
     

	
	
		
		
	
		
		
	public static void main(String[] args)
	{
		System.out.print("Enter your String");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int len = str.length();
		BFS(str,len);
		System.out.print(alList);
	
	}
	

}
