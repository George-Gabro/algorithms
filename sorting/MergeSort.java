public class MergeSort
{

	public List<int> mergeSort(List<int> arr){

		if(arr.size() == 1){
			return arr;
		}else{


			int mid = arr.size() / 2;
			List<int> subArrayLeft = arr.subList(0, mid);
			List<int> subArrayRight = arr.subList(mid + 1, arr.size());

			subArrayLeft = mergeSort(subArrayLeft);
			subArrayRight = mergeSort(subArrayRight);

			arr = merge(subArrayLeft , subArrayRight);
		}
		return arr;
	}

	public List<int> merge(List<int> left,List<right>){

		List<int> result = new ArrayList<>();

		int pointerLeft, pointerRight;
		pointerLeft = pointerRight = 0;

		while(pointerLeft < left.size() || pointerRight < right.size()){

			if(pointerLeft< left.size() && pointerRight < right.size()){

				if(left.get(pointerLeft) < right.get(pointerRight)){
					result.add(left.get(pointerLeft));
					pointerLeft++;
				}else{
					result.add(right.get(pointerRight));
					pointerRight++;
				}
			}

			else if(pointerLeft < left.size(){
				result.addAll(left);
				pointerLeft = left.size();
			}

			else if(pointerRight < right.size()){
				result.addAll(right);
				pointerRight = right.size();
			}
		}
		return result;
	}

}
