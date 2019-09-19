package teste;

public class AcharElementoQueApareceUmaVez {
	
	public static int search(int[] arr, int low, int high) { 
        if(low == high) return arr[low];
        if(low > high) return Integer.MIN_VALUE;
        
        int mid = (low + high)/2;
        if(mid % 2 == 0) {
        	if(arr[mid] == arr[mid + 1]) return search(arr, mid + 2, high);
        	else return search(arr, low, mid);
        } else {
        	if(arr[mid] == arr[mid - 1]) return search(arr, mid + 1, high);
        	else return search(arr, low, mid + 1);
        }
    } 
  
    public static void main(String[] args)  
    { 
        int[] arr = {1, 1, 2, 2, 5, 3, 3, 6, 6}; 
        System.out.println(search(arr, 0, arr.length-1));
        
    }     
} 
