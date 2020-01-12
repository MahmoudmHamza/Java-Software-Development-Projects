public class IntToString {
	public int IntConverter(String number) {
	    int eachnumber = 0;
		int intConvert = 48;
		int reVal = 0;
		int maxlen =number.length() - 1;
		for(int i = 0 ; i <= maxlen ; i++)
			{
			    eachnumber = number.charAt(i);
			    eachnumber = eachnumber  - intConvert;
			    reVal = reVal + (eachnumber * (int) Math.pow(10, maxlen - i));
			}
		return reVal;
		}
	public String StringConverter(int number)
	{
	    int StringConvet = 48;
	    int eachDigit = number;
	    int afterDivide = number;
	    String reVal = "";

	    while(afterDivide >0)
	    {
	        eachDigit = afterDivide % 10;
	        afterDivide = afterDivide / 10;
	        if(eachDigit == 0)
	        {
	            reVal += "0";
	        }
	        else if(eachDigit == 1)
	        {
	            reVal += "1";
	        }
	        else if(eachDigit == 2)
	        {
	            reVal += "2";
	        }
	        else if(eachDigit == 3)
	        {
	            reVal += "3";
	        }
	        else if(eachDigit == 4)
	        {
	            reVal += "4";
	        }
	        else if(eachDigit == 5)
	        {
	            reVal += "5";
	        }
	        else if(eachDigit == 6)
	        {
	            reVal += "6";
	        }
	        else if(eachDigit == 7)
	        {
	            reVal += "7";
	        }
	        else if(eachDigit == 8)
	        {
	            reVal += "8";
	        }
	        else if(eachDigit == 9)
	        {
	            reVal += "9";
	        }
	    }
	    String reVal2 = "";
	    for(int i =  reVal.length() -1 ; i >= 0 ; i--)
	    {
	        reVal2 += reVal.charAt(i);
	    }
	    return reVal2;
	}
	public static void main(String[] args)  
    {
		IntToString conv = new IntToString();
		int num = 456456;
		String num2 = "456456";
		String numConverted = conv.StringConverter(num);
		int stringConverted = conv.IntConverter(num2);
		System.out.println("Number " + num + " Converted into the string " + numConverted);
		System.out.println("String " + num2 + " Converted into the number " + stringConverted);
    }
}
