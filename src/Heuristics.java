import java.util.HashMap;
import java.util.Map;

public class Heuristics {
	
	private static int Heuristics(String str1, int len) {
		System.out.println("Coming Inside heuristics function");
		String str = "";
		int bCount = 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(1234,0);
		map.put(1243, 4);
		map.put(1342,4);
		map.put(1324,2);
		map.put(1423,4);
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
		
		System.out.println(str);
		int foo = Integer.parseInt(str);
		System.out.println(foo);
		int value = map.get(foo);
		int finalValue = Math.max(bCount,value);
		return finalValue;
	}
	
	
	public static void main(String[] args)
	{
		String str = "1B2B3B4B";
		int len = str.length();
		int value = Heuristics(str,len);
		System.out.println("The value is" + " " + value);
	}

	

}
