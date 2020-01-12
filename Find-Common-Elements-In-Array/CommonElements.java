public class CommonElements {
	//the first function demonstrates the method of finding common elements in one array
	//with time complexity O(n*n) using two for loops
	void FindRepeated1(int arr[])  
    { 
		//identifying counters for for loops
        int i, j; 
        System.out.println("Repeated Elements with time complexity O(n*n) :"); 
        for (i = 0; i < arr.length; i++)  
        { 
            for (j = i + 1; j < arr.length; j++)  
            { 
            	//if the number of index i in the first for loop equals
            	//the number of index j in the second for loop
            	//this number will be printed
                if (arr[i] == arr[j])  
                    System.out.print(arr[i] + " "); 
            } 
        } 
        System.out.println(" ");
    } 
	
	//the second function demonstrates the method of finding common elements in one array
	//with time complexity O(n) using for loops and a condition
	void FindRepeated2(int arr[]) 
    { 
		//identifying for loop counter
        int i;   
        System.out.println("Repeated Elements with time complexity O(n) : ");
        for (i = 0; i < arr.length; i++) 
        { 
        	//getting the absolute of the current number and sees its sign in the condition
        	//if positive then turn it into negative and go to the next number
        	//and then start comparing between coming numbers and the converted ones
            if (arr[Math.abs(arr[i])] >= 0) 
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])]; 
            else
                System.out.print(Math.abs(arr[i]) + " "); 
        }    
        System.out.println(" ");
    }  
	
    public static void main(String[] args)  
    { 
    	//creating new constructor for the class
    	CommonElements common = new CommonElements();
    	//the given array
        int arr[] = {1, 2, 3, 1, 3, 6, 8, 6, 9, 7, 8}; 
        //calling functions
        common.FindRepeated1(arr);
        common.FindRepeated2(arr);
    } 
}
