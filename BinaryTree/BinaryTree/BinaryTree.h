#pragma once

#include <stdio.h>
#include <stdlib.h>
#include<assert.h>


//根节点的定义
typedef int DataType;

typedef struct BinTreeNode
{
	DataType data;
	struct BinTreeNode* left;   //指向左子树的指针
	struct BinTreeNode* right;   //指向右子树的指针
}BNode;

//我们想要每创建一个结点就让其返回结点的地址及已经用过的结点数,所以我们自定义一个结点的返回类型
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








