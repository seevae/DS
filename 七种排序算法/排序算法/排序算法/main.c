#include"Sort.h"


void test()
{
	//int arr[] = { 7, 5, 8, 9, 6, 4, 1, 2, 3, 0 };
	int arr[] = { 7,8,6,2,1,0,3,9,4,5};
	int size = sizeof(arr) / sizeof(int);
	//SelectSort(arr, size);
	//BubbleSort(arr, size);
	//ShellSort(arr, size);
	//InsertSort(arr, size);
	//QuickSort(arr, size);
	HeapSort(arr, size);
	Print(arr, size);
}



int main()
{
	test();
	system("pause");
	return 0;
}