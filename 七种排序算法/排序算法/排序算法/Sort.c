#include"Sort.h"

void Swap(int* a, int* b)
{
	int tmp = *a;
	*a = *b;
	*b = tmp;
}

void Print(int arr[], int size)
{
	for (int i = 0; i < size; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}

//ʱ�临�Ӷ�: ���/ƽ��/���  O(n)/O(n^2)/O(n^2)
//�ռ临�Ӷ�: O(1)
void SelectSort(int arr[], int size)
{
	int i, j, k;
	for (i = 0; i < size - 1; i++)
	{
		k = i;
		for (j = i + 1; j < size; j++)
		{
			if (arr[j] < arr[k])
			{
				k = j;
			}
		}

		if (k != i)
		{
			int tmp = arr[k];
			arr[k] = arr[i];
			arr[i] = tmp;
		}
	}
}
//void SelectSort(int arr[], int size)
//{
//	int i, j, k;
//	for (i = 0; i<size; i++)
//	{
//		k = i;
//		for (j = i + 1; j<size; j++)
//		{
//			if (arr[j] >= arr[k])
//			{
//				;                         //Ϊʲôbreak����???
//			}
//			else
//			{
//				k = j;
//			}
//		}
//
//		if (k != i)
//		{
//			Swap(arr + k, arr + i);
//		}
//	}
//}

void SelectSortOP(int arr[], int size)
{
	int left = 0;
	int right = size - 1;
	while (left < right)
	{
		int max = left;
		int min = left;
		for (int i = left+1; i <= right; i++)
		{
			if (arr[i] > arr[max])
			{
				max = i;
			}
			if (arr[i] < arr[min])
			{
				min = i;
			}
		}
		Swap(arr + left, arr + min);
		if (max == left)
		{
			max = min;
		}
		Swap(arr + right, arr + max);
		left++; right--;	  
	}
	
}


//ʱ�临�Ӷ�: ���/ƽ��/���  O(n)/O(n^2)/O(n^2)
//�ռ临�Ӷ�: O(1)
void BubbleSort(int arr[], int size)
{
	int i,j;
	for (i = 0; i < size - 1; i++)
	{
		for (j = 0; j < size - 1 - i; j++)
		{
			if (arr[j + 1] < arr[j])
			{
				/*int tmp = arr[j + 1];
				arr[j + 1] = arr[j];
				arr[j] = tmp;*/
				Swap(arr + j + 1, arr + j);
			}
		}
	}
}

//��������
//ԭ��:����һ����������,����δ��������,�������������дӺ���ǰɨ��,�ҵ���Ӧλ�ò�����
//˼·:�ٴӵ�һ��Ԫ�����ν������²��������ڵ�ǰԪ�ؿ�����Ϊ��ǰԪ��֮ǰ�Ĳ����Ѿ�����ȡ����ǰλ�õ���һ��Ԫ����ΪҪ�����ֵ�����Ѿ������Ԫ�������дӺ���ǰɨ�裬
//�����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ�ã�ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ�ã�����Ԫ�ز��뵽��λ���У�
//�ڷֱ���±��0������Ԫ�ظ��� - 1��Ԫ����Ϊend���������ϲ�����ÿ��ѭ����Ŀ�ľ���Ϊ�˽���ǰtmpֵ������֮ǰ�����и÷ŵ�λ���ϣ�ʹ�õ�ǰ������������
//ʱ�临�Ӷ�: ���/ƽ��/���   O(n)/O(n^2)/O(n^2)
//�ռ临�Ӷ�: O(1)
//���������ȶ�
void InsertSort(int arr[], int size)
{
	int i, j;
	int key;
	for (i = 1; i < size; i++)
	{
		key = arr[i];
		for (j = i - 1; j >= 0; j--)
		{
			if (key >= arr[j])
			{
				break;
			}
			else
			{
				/*int tmp = arr[j + 1];
				arr[j + 1] = arr[j];
				arr[j] = tmp;*/
				arr[j + 1] = arr[j];
			}
		}
		arr[j + 1] = key;
	}
}

////ϣ������
////<1>���ܣ�ϣ������Ҳ�Ƶݼ����������㷨���ǲ��������һ�ָ��ٶ��ȶ��ĸĽ��汾��
////ϣ�������ǻ��ڲ�������������������ʶ�����Ľ������ģ�
////1�����������ڶԼ����Ѿ��ź�������ݲ���ʱ�� Ч�ʸߣ� �����Դﵽ���������Ч�ʣ�
////2������������һ����˵�ǵ�Ч�ģ� ��Ϊ��������ÿ��ֻ�ܽ������ƶ�һλ��
////<2>˼·������Ч����
////�٣��Ƚ���������Ԫ�����зָ�����ɸ������У������ĳ������������Ԫ����ɵģ��ֱ����ֱ�Ӳ�������
////�ڣ�Ȼ���������������ٽ������򣬴����������е�Ԫ�ػ������������㹻С��ʱ���ٶ�ȫ��Ԫ�ؽ���һ��ֱ�Ӳ�������
////�ȷ���,�ڶ�ÿһ����в���,�����������н��в���

#if 1
void __InsertSort(int arr[], int size, int gap)
{
	for (int g = 0; g < gap; g++)
	{
		int key;
		int i, j;
		for (i = gap + g; i < size; i += gap)
		{
			key = arr[i];
			for (j = i - gap; j >= 0; j-=gap)
			{
				if (key >= arr[j])
				{
					break;
				}
				else
				{
					arr[j + gap] = arr[j];
				}
			}
			arr[j + gap] = key;
		}
	}
}
#else
void __InsertSort(int arr[], int size, int gap)
{
	int i, j;
	int key;
	for (i = gap; i < size; i ++)
	{
		key = arr[i];
		for (j = i - gap; j >= 0; j -= gap)
		{
			if (key >= arr[j])
			{
				break;
			}
			else
			{
				arr[j + gap] = arr[j];
			}
		}
		arr[j + gap] = key;
	}
}
#endif

//// 1. ���ȶ�
//// 2. ���/ƽ��/���	O(n)/O(n^1.2~1.3)/O(n^2)
//// 3. �ռ临�Ӷ�		O(1)
void ShellSort(int array[], int size)
{
	int gap = size;
	// gap ��̬�仯
	while (1) {
		gap = gap / 3 + 1;
		__InsertSort(array, size, gap);
		if (gap == 1) {
			break;
		}
	}
}


//hover��/����ָ�뷨
//ԭ��:��������ָ��begin��end,һ��ʼʱʹbeginλ��left,endλ��right,��ͷͬʱ��ʼ������������,
//��begin��ʼ,�����С�ڵ��ڻ�׼ֵ,������һ��λ��,���end���ڵ��ڻ�׼ֵ,����ǰһ��λ��,Ȼ�󽻻�begin��end
//ֱ��������ѭ�������������󽻻�right��begin,��ʱ���ź���һ������,begin��ߵ�С��begin,�ұߵĴ���begin
int Patition_1(int arr[], int left, int right)
{
	int begin = left;
	int end = right;

	while (begin < end)
	{
		while (begin < end && arr[begin] <= arr[right])
		{
			begin++;
		}
		while (begin < end && arr[end] >= arr[right])
		{
			end--;
		}
		Swap(arr + begin, arr + end);
	}
	Swap(arr + begin, arr + right);
	return begin;
}

//ָ�������
//ԭ��:��������ָ��cur��div,��div����¼���յĻ�׼ֵ,һ��ʼ�Ļ�׼ֵ��Ȼ�����ұߵ��Ǹ�.
//��cur��left��ʼ������,ֻҪ���ֱȻ�׼ֵ(arr[right])С�����㽻��cur��div��ֵ,��ʹdiv+1.ֱ��cur������right,˵���ڴ�ʱ��div��ʼ
//��cur-1���Ǳ������׼ֵ�������,���Խ�����ʱ��div��right�ϵ�ֵ,�������һ������,��div��ߵ�ֵ��С��div,��div�ұߵ�ֵ������div
int Patition_3(int arr[], int left, int right)  
{
	int cur = left;
	int div = left;

	for (cur = left; cur < right; cur++)
	{
		if (arr[cur] < arr[right])
		{
			Swap(arr + cur, arr + div);
			div++;
		}	
	}
	Swap(arr + div, arr + right);
	return div;
}

//��������
void __QuickSort(int arr[], int left, int right)
{
	if (left == right)
	{
		return;
	}
	if (left > right)
	{
		return;
	}

	int div = Patition_1(arr, left, right);
	__QuickSort(arr, left, div - 1);
	__QuickSort(arr, div+1, right);
}

void QuickSort(int arr[], int size)
{
	__QuickSort(arr, 0, size-1);
}

//������

void AdjustDown(int arr[], int size, int root)
{
	while (1)
	{
		int left = root * 2 + 1;
		int right = root * 2 + 2;

		int max = left;
		if (left >= size)
		{
			return;
		}

		if (right<size && arr[right]>arr[left])
		{
			max = right;
		}

		if (arr[root] < arr[max])
		{
			Swap(arr + root, arr + max);		
		}
		else
		{
			return;
		}	
		root = max;
	}
}

void CreatHeap(int arr[], int size)
{
	for (int i = (size - 2) / 2; i >= 0; i--)
	{
		AdjustDown(arr, size, i);
	}
}

void HeapSort(int arr[], int size)
{
	CreatHeap(arr, size);

	for (int i = 0; i < size; i++)
	{
		Swap(&arr[0], &arr[size - 1 - i]);
		AdjustDown(arr, size-1-i, 0);
	}
}
//�鲢����


