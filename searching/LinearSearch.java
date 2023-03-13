public class LinearSearch {

	public static int linearSearch(int[] arr, int value){
		for(int searchIndex = 0 ; searchIndex < arr.length() ; i++){
			if(arr[i] == value){
				return i;
			}
		}
	}

}


