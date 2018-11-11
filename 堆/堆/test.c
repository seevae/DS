#include"Heap.h"


void test()
{
	int arr[] = { 7,8,6,2,1,0,3,9,4,5};
	int size = sizeof(arr) / sizeof(int);

	Heap heap;
	HeapInit(&heap, arr,size);

	

}

int main()
{
	test();
	system("pause");
	return 0;
}