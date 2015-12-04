
public class MergeSort
	{
//		public static void main(String args[])
//			{
//				int k[] = {3, 5, 18, 29, 81, 23, 54, 57, 1, 4};
//				mergeSort(k);
//				for(int fred : k)
//					System.out.println(fred);
//			}
		
		public static void mergeSort(int elements[])
			{
				int from = 0, to = elements.length - 1;
				int temp[] = new int[elements.length];
				mergeSortHelper(elements, from, to, temp);
			}
		
		private static void mergeSortHelper(int[] elements, int from, int to, int[] temp)
			{
				if (from < to)
					{
						int middle = (from + to) / 2;
						mergeSortHelper(elements, from, middle, temp);
						mergeSortHelper(elements, middle + 1, to, temp);
						merge(elements, from, middle, to, temp);
					}
			}
		
		private static void merge(int[] elements, int from, int mid, int to, int[] temp)
			{
				int i = from;
				int j = mid + 1;
				int k = from;
				while (i <= mid && j <= to)
					{
						if (elements[i] < elements[j])
							{
								temp[k] = elements[i];
								i++;
							}
						else
							{
								temp[k] = elements[j];
								j++;
							}
						k++;
					}
				while (i <= mid)
					{
						temp[k] = elements[i];
						i++;
						k++;
					}
				while (j <= to)
					{
						temp[k] = elements[j];
						j++;
						k++;
					}
				for (k = from; k <= to; k++)
					{
						elements[k] = temp[k];
					}
			}
	}
