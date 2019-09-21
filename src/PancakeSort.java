import java.util.*;
import java.util.Map.Entry;

public class PancakeSort {
	public static Map<String,List<String>> map = new LinkedHashMap<String,List<String>>();
	public static final String result = "1W2W3W4W";
	public static List<List<String>> values = new ArrayList<List<String>>();
	
	
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
			if(str1.equals(str))
			{
				continue;
			}
			queue.add(str1);
			
			System.out.println(string + " " + str1);
			
			
			String str2 = twoFlip(string,len);
			if(str2.equals(str1))
			{
				continue;
			}
		
				
			queue.add(str2);
		
			System.out.println(string + " " + str2);
			
			
			String str3 = threeFlip(string,len);
			if(str3.equals(str1))
			{
				continue;
			}
	
			queue.add(str3);
			
			System.out.println(string + " " + str3);
			
		
	
			String str4 = fourFlip(string,len);
			if(str4.equals(str1))
			{
				continue;
			}
		
			queue.add(str4);
		
			System.out.println(string + " " + str4);
			if(!map.containsKey(string))
			{
				List<String> al = new ArrayList<String>();
				al.add(str1);
				al.add(str2);
				al.add(str3);
				al.add(str4);
				map.put(string,al);
			}
			else
			{
				List<String>al = map.get(string);
				al.add(str1);
				al.add(str2);
				al.add(str3);
				al.add(str4);
				map.put(string,al);
			}
			
		    if(str4.equals(result) || str3.equals(result) || str2.equals(result) || str1.equals(result))
			{
				break;
			}
	}
}
	public static void main(String[] args)
	{
		System.out.print("Enter your String");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int len = str.length();
		BFS(str,len);
		System.out.print(values);//String str1 = oneFlip(str,len);
		//String str2 = twoFlip(str,len);
		//String str3 = threeFlip(str,len);
		//String str4 = fourFlip(str,len);
		//System.out.print(str1 + " " + str2 + " " + str3 + " " + str4);
	}
	

}