#include"Heap.h"

void CreatHeap(int arr, int size)
{
	for (int i = (size - 2) / 2; i >= 0; i++)
	{

	}
}

void HeapInit(Heap* pH,int arr,int size)
{
	assert(pH != NULL);
	memcpy(pH->arr, arr, sizeof(int)*size);
	pH->size = size;

	CreatHeap(pH->arr, pH->size);
}

