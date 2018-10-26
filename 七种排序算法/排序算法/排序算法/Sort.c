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

//时间复杂度: 最好/平均/最差  O(n)/O(n^2)/O(n^2)
//空间复杂度: O(1)
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
//				;                         //为什么break不行???
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


//时间复杂度: 最好/平均/最差  O(n)/O(n^2)/O(n^2)
//空间复杂度: O(1)
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

//插入排序
//原理:构建一个有序序列,对于未排序序列,在已排序序列中从后往前扫描,找到相应位置并插入
//思路:①从第一个元素依次进行以下操作：对于当前元素可以认为当前元素之前的部分已经有序；取出当前位置的下一个元素作为要排序的值，在已经排序的元素序列中从后向前扫描，
//如果该元素（已排序）大于新元素，将该元素移到下一位置；直到找到已排序的元素小于或者等于新元素的位置，将新元素插入到该位置中；
//②分别把下标从0到数组元素个数 - 1的元素作为end，进行以上操作；每次循环的目的就是为了将当前tmp值放置在之前序列中该放的位置上，使得当前部分序列有序。
//时间复杂度: 最好/平均/最差   O(n)/O(n^2)/O(n^2)
//空间复杂度: O(1)
//插入排序稳定
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

////希尔排序
////<1>介绍：希尔排序，也称递减增量排序算法，是插入排序的一种高速而稳定的改进版本。
////希尔排序是基于插入排序的以下两点性质而提出改进方法的：
////1、插入排序在对几乎已经排好序的数据操作时， 效率高， 即可以达到线性排序的效率；
////2、但插入排序一般来说是低效的， 因为插入排序每次只能将数据移动一位。
////<2>思路及排序效果：
////①：先将整个待排元素序列分割成若干个子序列（由相隔某个“增量”的元素组成的）分别进行直接插入排序；
////②：然后依次缩减增量再进行排序，待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序。
////先分组,在对每一组进行插排,最后对整个数列进行插排

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

//// 1. 不稳定
//// 2. 最好/平均/最差	O(n)/O(n^1.2~1.3)/O(n^2)
//// 3. 空间复杂度		O(1)
void ShellSort(int array[], int size)
{
	int gap = size;
	// gap 动态变化
	while (1) {
		gap = gap / 3 + 1;
		__InsertSort(array, size, gap);
		if (gap == 1) {
			break;
		}
	}
}


//hover法/左右指针法
//原理:定义两个指针begin和end,一开始时使begin位于left,end位于right,两头同时开始遍历整个数列,
//从begin开始,如果他小于等于基准值,就往后一个位置,如果end大于等于基准值,就往前一个位置,然后交换begin和end
//直到不满足循环的条件跳出后交换right和begin,此时便排好了一次序列,begin左边的小于begin,右边的大于begin
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

//指针遍历法
//原理:定义两个指针cur和div,用div来记录最终的基准值,一开始的基准值仍然是最右边的那个.
//让cur从left开始向后遍历,只要发现比基准值(arr[right])小的数便交换cur和div的值,并使div+1.直到cur遍历到right,说明在此时从div开始
//到cur-1都是比这个基准值大的数字,所以交换此时的div和right上的值,便完成了一次排序,在div左边的值都小于div,在div右边的值都大于div
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

//快速排序
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



