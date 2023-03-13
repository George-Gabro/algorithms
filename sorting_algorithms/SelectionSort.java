public class SelectionSort
{

	public int[] selectionSort(int[] arr){

		int index = 0;

		while(index < arr.length){
			int smallerValueIndex = index;

			for(int i = index + 1; i <) {
				if(arr[i] < arr[index]) {
					smallerValueIndex = i;
				}
			}

			if(arr[smallerValueIndex] < arr[index]) {
				int temp = arr[index];
				arr[index] = arr[smallerValueIndex];
				arr[smallerValueIndex] = temp;
			}

			index++;
		}

		return arr;
	}

}
