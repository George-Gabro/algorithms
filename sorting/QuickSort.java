public class QuickSort
{

	public List<int> quickSort(List<int> arr) {

	    List<int> result = new ArrayList<>();

	    if(arr.size() == 0){
	    }

	    else if(arr.size > 1){
	        Random random = new Random();
	        int pivot = random.nextInt(arr.size);
	        List<int> leftPivot = new ArrayList<>();
	        List<int> rightPivot = new ArrayList<>();
	        for(int i = 0 ; i < arr.size() ; i++){
	            if(arr.get(i) < pivot){
	                leftPivot.add(arr.get(i));
	            }else{
	                rightPivot.add(arr.get(i));
	            }
	        }

	        result.addAll(quickSort(leftPivot));
	        result.add(pivot);
	        result.addAll(quickSort(rightPivot));
	    }
	    else{
	        result.addAll(arr);
	    }
	    return result;
	}

}
