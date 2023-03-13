public class BinarySearchRecursive
{

	public static int binarySearchRec(int arr[], int l, int r, int x) {
	      if (r >= l) {
	         int mid = l + (r - l) / 2;
	         if (arr[mid] == x)
	        	 return mid;

	         if (arr[mid] > x)
		         return binarySearchRec(arr, l, mid - 1, x);
		         return binarySearchRec(arr, mid + 1, r, x);
	      }
	      return -1;
	}

}
