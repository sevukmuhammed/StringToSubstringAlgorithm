import java.util.*;

public class Test {
	public static void main(String[] args) 
    {
        String str = readFromUser();
        
        System.out.println(shortestSubstring(str));
    }
	public static String readFromUser()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string => ");
		String str = scanner.nextLine();
		return str;
	}
	public static char[] elementsOfString(String letter)
	{
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0 ; i < letter.length();i++)
		{
			list.add(letter.charAt(i));
		}
		int a=0;
		while(a < list.size())
		{
			char temp = list.get(a);
			
			for(int b = a+1; b < list.size();b++)
			{
				if(temp == list.get(b))
				{
				
					list.remove(b);
					b--;
				}
				else
				{
					continue;
				}
			}
			a++;
		}
		char array[] = new char[list.size()];
		for(int k = 0 ; k < array.length ; k++)
		{
			array[k] = list.get(k);
		}
		return array;
	}
    public static int shortestSubstring(String str) 
    {
    	char arr[] = elementsOfString(str);
        int start = 0;
        int uniqueCounter = 0;
        int patLen = arr.length;
        String result = "";
        char headChar;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : arr) 
        {
            map.put(c, 0);
        }
        for (int i = start; i < str.length(); i++) 
        {
            char c = str.charAt(i);

            if (map.containsKey(c) == false)
            {
                continue;
            }
                
            int charCount = map.get(c);

            if (charCount == 0) 
            {
                uniqueCounter = uniqueCounter + 1;
            }
            map.put(c, map.get(c) + 1);   
            while (uniqueCounter == patLen) 
            {
                int tempLength = i - start + 1;
                
                if (tempLength == patLen)
                {
                	System.out.println(str.substring(start, i+1));
                    return str.substring(start, i+1).length();
                }
                if(result == "" || tempLength < result.length())
                {
                	result = str.substring(start, i+1);
                	
                }      
                headChar=str.charAt(start);
              
                int headCount=map.get(headChar)-1;                                  
                if(headCount==0)
                {
                    break;
                }
                map.put(headChar,headCount);
                           
                start++;
            }
        }
        System.out.println(result);
        return result.length();
    }
    

    
}