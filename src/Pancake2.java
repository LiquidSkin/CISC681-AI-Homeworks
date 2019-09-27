import java.util.*;

public class Pancake2 {
	public static List<List<Object>> list = new ArrayList<List<Object>>();
	public static final String result = "1W2W3W4W";
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

	
	public static void AStarSearch(String str, int len) {
	  Queue<String> queue = new LinkedList<String>();
	  List<List<Object>> objList = new ArrayList<List<Object>>();
	  List<String> flipList = new ArrayList<String>();
	  queue.add(str);
	  int gCount = 0;
	  Random rn = new Random();
	  Set<String> newSet = new HashSet<String>();
	  
	  while(!queue.isEmpty() && gCount <= 10)
	  {
		  int h1,h2,h3,h4=0;
		  String varChar = queue.poll();
		  System.out.println(varChar + " ");
		  
		  String str1 = oneFlip(varChar,len);
		  h1 = calculateHeuristics(str1,len);
		  gCount++;
		  if(gCount > 0)
		  {
			  
			  List<Object> al = new ArrayList<Object>();
			  al.add(rn.nextInt(6) + 5);
			  al.add(h1);
			  
			  al.add(str1);
			  list.add(al);
			  
		  }
		  
		  String str2 = twoFlip(varChar,len);
		  h2 = calculateHeuristics(str2,len);
		  gCount++;
		  if(gCount > 0)
		  {
			  List<Object> al_one = new ArrayList<Object>();
			  al_one.add(rn.nextInt(6) + 5);
			  al_one.add(h2);
			  al_one.add(str2);
			  list.add(al_one);
			  
		  }
		  
		  
		  String str3 = threeFlip(varChar,len);
		  h3 = calculateHeuristics(str3,len);
		  gCount++;
		  if(gCount > 0)
		  {
			  List<Object> al_two = new ArrayList<Object>();
			  al_two.add(rn.nextInt(6) + 5);
			  al_two.add(h3);
			  al_two.add(str3);
			  list.add(al_two);
		  }
		  
		  String str4 = fourFlip(varChar,len);
		  h4 = calculateHeuristics(str4,len);
		  gCount++;
		  if(gCount > 0)
		  {
			  List<Object> al_three = new ArrayList<Object>();
			  al_three.add(rn.nextInt(6) + 5);
			  al_three.add(h4);
			  al_three.add(str4);
			  list.add(al_three);
		  }
		  //String finalString = computeNextString(list);
		  //System.out.println("The Value which we need is" + " " + finalString);
		  //System.out.println(list);
		  //list.clear();
		  //System.out.print(list);
		  
		  if(str1.equals(result) || str2.equals(result) || str3.equals(result) || str4.equals(result))
		  {
			  System.out.println("Coming here inside the break function");
			  break;
		  }
		  List<Object> reqList = calculateTieBreaker(list); // tieBreaker
		  System.out.println(reqList);
		  String nextString = String.valueOf(reqList.get(2));
		  flipList.add(nextString);
		  objList.add(reqList);
		  System.out.println("The orders are " + nextString + " ");
		  System.out.println(reqList);
		  System.out.println("The required List is" + flipList);
		  queue.add(nextString);
		  list.clear();
		  
		  
	}
		
	}
	
	
	public static List<Object> calculateTieBreaker(List<List<Object>> list2) {
		int min = Integer.MIN_VALUE;
		int countMin = 0;
		String finalResult = null;
		List<Object> finList = new ArrayList<Object>();
		List<List<Object>> newList = new ArrayList<List<Object>>();
		for(List<Object> li: list2)
		{
			Object o1 = li.get(0);
			Object o2 = li.get(1);
			Integer foo = (Integer)o1;
			Integer foo1 = (Integer)o2;
			//System.out.println(foo + " " + foo1);
			if(foo + foo1 >= min)
			{
				min = (foo + foo1);
			}
		}
		System.out.println(list + " ");
		
		
		System.out.println(min + " ");
		for(List<Object> li: list2)
		{
			Integer in_One = (Integer)li.get(0);
			Integer in_Two = (Integer)li.get(1);
			if(in_One + in_Two ==  min)
			{
				countMin++;
				List<Object>al = new ArrayList<Object>();
				al.add(in_One);
				al.add(in_Two);
				al.add(li.get(2));
				newList.add(al);
			}
		}
	    if(newList.size() == 1)
	    {
	    	finList = newList.get(0);
	    }
	    else if(newList.size() == 2)
	    {
	        List<Object> list_one = newList.get(0);
	    	List<Object> list_two = newList.get(1);
	        System.out.println("The two list values are");
	        System.out.println(list_one + " " + list_two);
	    	Object iniOne = list_one.get(2);
	    	Object iniTwo = list_two.get(2);
	    	System.out.println("The two Object values are");
	    	System.out.println(iniOne + " " + iniTwo);
	    	String iniResultOne = String.valueOf(iniOne);
	    	String iniResultTwo = String.valueOf(iniTwo);
	    	iniResultOne = iniResultOne.replace('W','1');
	    	iniResultOne = iniResultOne.replace('B','0');
	    	iniResultTwo = iniResultTwo.replace('W','1');
	    	iniResultTwo = iniResultTwo.replace('B','0');
	    	System.out.println("Printing parsed intitial values");
	    	System.out.println(iniResultOne + " " + iniResultTwo);
	    ;
	    	long l1 = Long.valueOf(iniResultOne).longValue(); 
	    
	    	long l2 = Long.valueOf(iniResultTwo).longValue();
	        if(l1 > l2)
	        {
	        	finList = list_one;
	        }
	        else
	        {
	        	finList = list_two;
	        }
	    	
	    } 
	    else if(newList.size() > 2)
	    {
	    	finList = newList.get(0);
	    }
	    return finList;
		
		
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
	/*public static String computeNextString(List<List<Object>> list2) {
	 int max = Integer.MIN_VALUE;
	 
	 for(List<Object> li : list2)
	 {
		 for(Object o : li)
		 {
			 if(o instanceof Integer)
			 {
		     int i = (Integer)o;
			 if(i > max)
			 {
				 max = i;
			 }
		     }
		 }
	  }
	 System.out.println("The Maximum Value is" + " " + max);
     String result = getResultString(list2,max);
    		 
	  return result;
	} 
	public static String getResultString(List<List<Object>> list2, int max) {
		Object x = (Integer) max;
		Object result = null;
		for(List<Object> li: list2)
		{
			if(li.contains(x))
			{
				result = li.get(1);
			}
		}
		String finalString = String.valueOf(result);
		System.out.println("The String associated with the Maximum Value is" + " " + finalString);
		return finalString;
		
		
	} */
	public static void main(String[] args)
	{
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter your string");
	  String str = sc.next();
	  int len = str.length();
	  AStarSearch(str,len);
	  
	}

}
