public class InsertionSort
{

	public int[] insertionSort(int[] arr){

		int index = 1;

		while(index < arr.length){
			for(int i = index - 1; i >= 0 ; i--){

				if(arr[i] > arr[index]){
					int temp = arr[index];
					arr[index] = arr[i];
					arr[i] = temp;
				}
			}
			index++;
		}
		return array;
	}

}
