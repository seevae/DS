#pragma once

#include <stdio.h>
#include <stdlib.h>
#include<assert.h>


//���ڵ�Ķ���
typedef int DataType;

typedef struct BinTreeNode
{
	DataType data;
	struct BinTreeNode* left;   //ָ����������ָ��
	struct BinTreeNode* right;   //ָ����������ָ��
}BNode;

//������Ҫÿ����һ���������䷵�ؽ��ĵ�ַ���Ѿ��ù��Ľ����,���������Զ���һ�����ķ�������
typedef struct
{
	BNode* root;
	int used;
}RESULT;

RESULT creatTree(DataType preorder[], int size);
void Preorder(BNode* root);
void Inorder(BNode* root);
void Postorder(BNode* root);
int GetSize(BNode* root);
int GetLeafSize(BNode* root);
int GetLevelSize(BNode* root, int k);
int GetHight(BNode* root);
BNode* searchNode(BNode* root, DataType dest);








