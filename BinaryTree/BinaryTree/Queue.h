#pragma once
#include<stdio.h>
#include<assert.h>
#include<stdlib.h>

typedef void* QDataType;	// ���Ľ���ַ

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

// ����
void QueuePush(Queue *pQ, QDataType data)
{
	// ������ռ�
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
// ɾ��
void QueuePop(Queue *pQ)
{
	pQ->size--;
	assert(pQ != NULL);
	assert(pQ->front != NULL);	// ��ʾ�����ǿն���

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
	assert(pQ->front != NULL);	// ��ʾ�����ǿն���

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