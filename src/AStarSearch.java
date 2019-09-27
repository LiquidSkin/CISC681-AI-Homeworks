import java.util.*;
public class AStarSearch {
	public static final String result = "1W2W3W4W";
	public static List<List<String>> parentList = new ArrayList<List<String>>();
	public static List<String> allList = new ArrayList<String>();
	public static List<List<Object>> everyList = new ArrayList<List<Object>>();
	
	
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
	public static int calculateHeuristics(String str1, int len) {
		//System.out.println("Coming Inside heuristics function");
		String str = "";
		int bCount = 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(1234,0);
		map.put(1243, 4);
		map.put(1342,4);
		map.put(1324,2);
		map.put(1423,4);
		map.put(1432,4);
		map.put(2134,2);
		map.put(2143,4);
		map.put(2314,3);
		map.put(2341,4);
		map.put(2413,4);
		map.put(2431,4);
		map.put(3124,3);
		map.put(3142,4);
		map.put(3214,3);
		map.put(3241,4);
		map.put(3412,4);
		map.put(3421,4);
		map.put(4123,4);
		map.put(4132,4);
		map.put(4213,4);
		map.put(4231,4);
		map.put(4321,4);
		map.put(4312,4); 
		
		for(int i=0; i<len; i = i+2)
		{
			str = str + str1.charAt(i);
		}
		for(int j=1; j<len; j=j+2)
		{
			if(str1.charAt(j) == 'B')
			{
				bCount++;
			}
		}
		
		//System.out.println(str);
		int foo = Integer.parseInt(str);
		//System.out.println(foo);
		//System.out.println("the foo value is " + foo);
		int value = map.get(foo);
		int finalValue = Math.max(bCount,value);
		return finalValue;
	}
	

	
	/*public static String CalculatePopString(Queue<String> queue)
	{
		
		
        
       
	}*/
	
	public static void AStarAlgorithm(String str, int len)  {
		if(str.equals(result))
		{
			System.out.println("The String is already in Place");
			return;
		}
		Queue<String> queue = new LinkedList<String>();
		List<List<Object>> finalList = new ArrayList<List<Object>>();
	      int gCount = 0;
		  String str1 = oneFlip(str,len);
		  gCount++;
		  int h = calculateHeuristics(str1,len);
		  if(gCount > 0)
		  {
			  List<Object> li = new ArrayList<Object>();
			  li.add(gCount);
			  li.add(h);
			  li.add(str1);
			  finalList.add(li);
			  everyList.add(li);
		  }
		  String str2 = twoFlip(str,len);
		  gCount++;
		  int h1 = calculateHeuristics(str2,len);
		  if(gCount > 0)
		  {
			  List<Object> li = new ArrayList<Object>();
			  li.add(gCount);
			  li.add(h1);
			  li.add(str2);
			  finalList.add(li);
			  everyList.add(li);
		  }
		  String str3 = threeFlip(str,len);
		  gCount++;
		  int h2 = calculateHeuristics(str3,len);
		  if(gCount > 0)
		  {
			  List<Object> li = new ArrayList<Object>();
			  li.add(gCount);
			  li.add(h2);
			  li.add(str3);
			  finalList.add(li); 
			  everyList.add(li);
		  }
		  String str4 = fourFlip(str,len);
		  gCount++;
		  int h3 = calculateHeuristics(str4,len);
		  if(gCount > 0)
		  {
			  List<Object> li = new ArrayList<Object>();
			  li.add(gCount);
			  li.add(h3);
			  li.add(str4);
			  finalList.add(li); 
			  everyList.add(li);
		  }
		  
		  List<String> list = new ArrayList<String>();
		  list.add(str);
		  list.add(str1);
		  list.add(str2);
		  list.add(str3);
		  list.add(str4);
		  parentList.add(list);
		  
		  queue.add(str1);
		  queue.add(str2);
		  queue.add(str3);
		  queue.add(str4);
		  //System.out.println("the Parent List is" + parentList);
		  System.out.println("The queue without g and h is" + " " + queue);
		  System.out.println("The queue with g and h is" + " "  + finalList);
		  int count = 0;
          while(!queue.isEmpty())
          {
        	  String element = TieBreaker(finalList,queue);
        	  System.out.println("The Queue before removal is" + " "+ queue);
        	  System.out.println("The element which should be removed is" + " " + element);
        	  Object a = element;
        	  for(int j=0; j<finalList.size(); j++)
        	  {
        		  List<Object> li = finalList.get(j);
        		  if(li.contains(a))
        		  {
        			  finalList.remove(li);
        		  }
        	  }
        	  queue.remove(element);
        	  
        	  System.out.println("After removing the element from the finalList, finalList is" + " " + finalList);
        	  System.out.println("The Queue after element removal is" + " " + queue);
        	  System.out.println("The Gcount is" + " " + gCount);
        	  String oneString = oneFlip(element, element.length());
        	  gCount++;
        	  if(gCount > 0)
        	  {
        		  int a_1 = calculateHeuristics(oneString,oneString.length());
        		  List<Object> li = new ArrayList<Object>();
        		  li.add(gCount);
        		  li.add(a_1);
        		  li.add(oneString);
        		  finalList.add(li);
        		  everyList.add(li);
        		  queue.add(oneString);
        	  }
        	  String secString = twoFlip(element, element.length());
        	  gCount++;
        	  if(gCount > 0)
        	  {
        		  int a_2 = calculateHeuristics(secString,secString.length());
        		  List<Object> li = new ArrayList<Object>();
        		  li.add(gCount);
        		  li.add(a_2);
        		  li.add(secString);
        		  finalList.add(li);
        		  everyList.add(li);
        		  queue.add(secString);
        	  }
        	  String threeString = threeFlip(element, element.length());
        	  gCount++;
        	  if(gCount > 0)
        	  {
        		  int a_3 = calculateHeuristics(threeString, threeString.length());
        		  List<Object> li = new ArrayList<Object>();
        		  li.add(gCount);
        		  li.add(a_3);
        		  li.add(threeString);
        		  finalList.add(li);
        		  everyList.add(li);
        		  queue.add(threeString);
        	  }
        	  String fourString = fourFlip(element, element.length());
        	  gCount++;
        	  if(gCount > 0)
        	  {
        		  int a_4 = calculateHeuristics(fourString, fourString.length());
        		  List<Object> li = new ArrayList<Object>();
        		  li.add(gCount);
        		  li.add(a_4);
        		  li.add(fourString);
        		  finalList.add(li);
        		  everyList.add(li);
        		  queue.add(fourString);
        	  }
        	 
        	  List<String> al = new ArrayList<String>();
        	  al.add(element);
        	  al.add(oneString);
        	  al.add(secString);
        	  al.add(threeString);
        	  al.add(fourString);
        	  parentList.add(al);
        	  
        	  if(element.equals(result) || oneString.equals(result) || secString.equals(result) || threeString.equals(result) || fourString.equals(result))
        	  {
        		  break;
        	  }
        	  
          }
          System.out.println("The final parent List is" + " " + parentList);
            BacktrackList(parentList,str);
		
	}
	
    public static void BacktrackList(List<List<String>> al,String str) {
    	List<String> alList = al.get(al.size() - 1); 
		String element = alList.get(0);
		System.out.println("The parent element of the result is" + " " + element);
		 allList.add(element);
		String finalEle = searchArrayList(al,element);
		
		allList.add(finalEle);
		
		if(finalEle.equals(str))
		{
			return;
		}
		String nextEle = searchArrayListIndex(al,finalEle);
		
		allList.add(nextEle);
		String nextnextEle = searchArrayList(al,nextEle);
		
		allList.add(nextnextEle);
		if(nextnextEle.equals(str))
		{
			return;
		}
		String varEle = searchArrayListIndex(al,nextnextEle);
		allList.add(varEle);
		String varvarEle = searchArrayList(al,varEle);
	
		allList.add(varvarEle);
		if(varvarEle.equals(str))
		{
			return;
		}
		String varElement = searchArrayListIndex(al,varvarEle);
		allList.add(varElement);
		String fooElement =  searchArrayList(al,varElement);
		allList.add(fooElement);
		if(fooElement.equals(str))
		{
			return;
		}
		String foofooElement = searchArrayListIndex(al,fooElement);
		allList.add(foofooElement);
		String charElement = searchArrayList(al,foofooElement);
		allList.add(charElement);
		if(charElement.equals(str))
		{
			return;
		}
		String characterElement = searchArrayListIndex(al,charElement);
		allList.add(characterElement); 
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
	public static String TieBreaker(List<List<Object>> finalList, Queue<String> queue) {
	  
    	int min = Integer.MAX_VALUE;
    	String result = null;
    	List<List<Object>> tieList = new ArrayList<List<Object>>();
    	int count = 0;
    	for(int i=0; i<finalList.size(); i++)
    	{
    		List<Object> li = finalList.get(i);
    		int a = (Integer)li.get(0);
    		int b = (Integer)li.get(1);
    		if(a + b < min)
    		{
    			min = (a+b);
    		}
    	}
    	
    	for(int j=0; j<finalList.size(); j++)
    	{
    		List<Object> li = finalList.get(j);
    		int c = (Integer) li.get(0);
    		int d = (Integer) li.get(1);
    		if((c+d) == min)
    		{
    			tieList.add(li);
    		}
    	}
    	if(tieList.size() == 1)
    	{
    		List<Object> al = tieList.get(0);
    		result = String.valueOf(al.get(2));
    		
       }
    	else if(tieList.size() == 2)
    	{
    		List<Object> list_one = tieList.get(0);
	    	List<Object> list_two = tieList.get(1);
	        String res1 = String.valueOf(list_one.get(2));
	        String res2 = String.valueOf(list_two.get(2));
	        res1 = res1.replace('W','1');
	    	res1 = res1.replace('B','0');
	    	res2 = res2.replace('W','1');
	    	res2 = res2.replace('B','0');
	    	long l1 = Long.valueOf(res1).longValue(); 
		    long l2 = Long.valueOf(res2).longValue();
		    if(l1 >= l2)
	        {
	        	 result = String.valueOf(list_one.get(2));
	        }
	        else
	        {
	        	result = String.valueOf(list_two.get(2));
	        }
    	}
    	else if(tieList.size() > 2)
    	{
    		List<Object> li = tieList.get(1);
    		result = String.valueOf(li.get(2));
    	}
		return result;
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		  System.out.println("Enter your string");
		  String str = sc.next();
		  int len = str.length();
		  AStarAlgorithm(str,len);
		  Collections.reverse(allList);
		  allList.add(result);
		  System.out.println("The Path taken by the string is" + allList);
		  System.out.println("The List containing g and h values are" + " " + everyList);
		
		  
	}
	

}
