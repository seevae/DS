#pragma once
#include<stdio.h>
#include<assert.h>
#include<stdlib.h>

typedef void* QDataType;	// 树的结点地址

typedef struct QNode {
	QDataType data;
	struct QNode *next;
}	QNode;

typedef struct Queue {
	QNode *front;
	QNode *rear;
	int size;
}	Queue;

void QueueInit(Queue *pQ)
{
	assert(pQ != NULL);
	pQ->front = pQ->rear = NULL;
}

void QueueDestroy(Queue *pQ)
{
	QNode *cur, *next;
	for (cur = pQ->front; cur != NULL; cur = next) {
		next = cur->next;
		free(cur);
	}
	pQ->front = pQ->rear = NULL;
}

// 插入
void QueuePush(Queue *pQ, QDataType data)
{
	// 申请结点空间
	pQ->size++;
	QNode *node = (QNode *)malloc(sizeof(QNode));
	node->data = data;
	node->next = NULL;
	if (pQ->rear == NULL) {
		pQ->front = pQ->rear = node;
		return;
	}
	pQ->rear->next = node;
	pQ->rear = node;
}
// 删除
void QueuePop(Queue *pQ)
{
	pQ->size--;
	assert(pQ != NULL);
	assert(pQ->front != NULL);	// 表示不能是空队列

#if 0
	if (pQ->front == pQ->rear) {
		free(pQ->front);
		pQ->front = pQ->rear = NULL;
	}
	else {
		QNode *del = pQ->front;
		pQ->front = pQ->front->next;
		free(del);
	}
#endif

	QNode *del = pQ->front;
	pQ->front = pQ->front->next;
	free(del);
	if (pQ->front == NULL) {
		pQ->rear = NULL;
	}
}

QDataType QueueFront(const Queue *pQ)
{
	assert(pQ != NULL);
	assert(pQ->front != NULL);	// 表示不能是空队列

	return pQ->front->data;
}

int QueueEmpty(const Queue *pQ)
{
	return pQ->front == NULL ? 1 : 0;
}

int QueueSize(const Queue *pQ)
{
	return pQ->size;
}