import java.util.Arrays;
import java.util.HashSet;

public class CommonElements2Arrays {
	//the first function demonstrates the method of finding common elements in two arrays
	//with time complexity O(n*n) using two for loops
	void FindRepeated1(int arr1[],int arr2[])  
    { 
		//identifying counters for for loops
        int i, j; 
        System.out.println("Repeated Elements with time complexity O(n*n) :"); 
        for (i = 0; i < arr1.length; i++)  
        { 
            for (j = 0; j < arr2.length; j++)  
            { 
            	//if the number of index i in the first for loop equals
            	//the number of index j in the second for loop
            	//this number will be printed
                if (arr1[i] == arr2[j])  
                    System.out.print(arr1[i] + " "); 
            } 
        } 
        System.out.println(" ");
    } 
	//the first function demonstrates the method of finding common elements in 2 arrays
	//with time complexity O(n) using sorting and while loop
	void FindRepeated2(int arr1[],int arr2[])  
    { 
		//sorting arrays before finding common elements
		Arrays.sort(arr1);
	    Arrays.sort(arr2);
		//identifying counters for while loop
        int i = 0;
        int	j = 0; 
        System.out.println("Repeated Elements with time complexity O(n) :"); 
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                i++;
            }
        }
        System.out.println(" ");
    }
	//the first function demonstrates the method of finding common elements in one array
	//with time complexity O(1) using hash sets
	void FindRepeated3(int arr1[],int arr2[])  
    { 
		System.out.println("Repeated Elements with time complexity O(1) :");
		
		
		//using hash sets to get common elements between 2 arrays
		HashSet<int[]> set1 = new HashSet<int[]>(Arrays.asList(arr1)); 
        HashSet<int[]> set2 = new HashSet<int[]>(Arrays.asList(arr2));
  
        set1.retainAll(set2); 
        System.out.println("Numbers =" + set1);
    } 
	public static void main(String[] args)  
    { 
    	//creating new constructor for the class
    	CommonElements2Arrays common = new CommonElements2Arrays();
    	
    	//the given two array
        int array1[] = {1, 20, 32, 16, 35, 61, 42}; 
        int array2[] = {16, 2, 35, 11, 42, 95, 61};
        
        //calling functions
        common.FindRepeated1(array1,array2);
        common.FindRepeated2(array1,array2);
        common.FindRepeated3(array1,array2);
    }
}
