#include"BinaryTree.h"
#include"Queue.h"
#include"Stack.h"

BNode* creatNode(DataType data)
{
	BNode* newBnode = (BNode* )malloc(sizeof(BNode));
	newBnode->data = data;
	newBnode->left = newBnode->right = NULL;
	return newBnode;
}

//利用含空结点的前序创建二叉树
//返回结果是二叉树的根节点

//递归创建,创建的过程中返回使用过的结点个数
RESULT creatTree(DataType preorder[], int size)
{
	if (size == 0)  //size为0,树不存在
	{
		RESULT result = { NULL, 0 };
		return result;
	}

	//采用前序遍历的思想创建二叉树
	//根,左子树,右子树

	//先创建根节点
	DataType rootValue = preorder[0];
	if (rootValue == -1)  //只有一个空结点
	{
		RESULT result = { NULL, 1 };
		return result;
	}

	BNode* root = creatNode(rootValue);

	//创建左子树
	RESULT lroot = creatTree(&preorder[1], size - 1);
	root->left = lroot.root;
	//创建右树
	RESULT rroot = creatTree(&preorder[1 + lroot.used],size-1-lroot.used);
	root->right = rroot.root;

	RESULT result = { root, 1 + lroot.used + rroot.used };
	return result;
}

//前序遍历
void Preorder(BNode* root)
{
	if (root == NULL)  //终止条件
	{
		return ;
	}

	//根
	printf("%d ", root->data);
	//左子树,子问题用递归处理
	Preorder(root->left);
	//右子树,子问题用递归处理
	Preorder(root->right);
}

void Inorder(BNode* root)
{
	if (root == NULL)
	{
		return;
	}

	Inorder(root->left);
	printf("%d ", root->data);
	Inorder(root->right);
}

void Postorder(BNode* root)
{
	if (root == NULL)
	{
		return;
	}

	Inorder(root->left);
	Inorder(root->right);
	printf("%d ", root->data);
}

//求二叉树所有节点的个数
int GetSize(BNode* root)
{
	if (root == NULL)
	{
		return 0;
	}

	return GetSize(root->left) + GetSize(root->right) + 1;
}

//求二叉树除根结点外其他结点的个数
int GetLeafSize(BNode* root)
{
	if (root == NULL)
	{
		return 0;
	}
	else if (root->left == NULL && root->right == NULL)
	{
		return 1;
	}
	else
	{
		return GetLeafSize(root->left) + GetLeafSize(root->right);
	}
}

//求二叉树某一层的结点个数
int GetLevelSize(BNode* root,int k)
{
	if (root == NULL)
	{
		return 0;
	}
	if (k == 1)
	{
		return 1;
	}

	return GetLevelSize(root->left, k - 1) + GetLevelSize(root->right, k - 1);
}

//求二叉树的树高
#define MAX(a,b) ((a) > (b) ? (a) : (b))

int GetHight(BNode* root)
{
	if (root == NULL)
	{
		return 0;
	}

	int leftHeight = GetHight(root->left);
	int rightHeight = GetHight(root->right);
	return MAX(leftHeight, rightHeight)+1;
}

//在二叉树中查找某一结点,找到了返回该结点地址,没有找到则返回NULL
BNode* searchNode(BNode* root,DataType dest)
{
	//树为空
	if (root == NULL)
	{
		return NULL;
	}
	//要查找的数为根节点
	if (root->data == dest)
	{
		return root;
	}
	//左子树中查找
	BNode* node = searchNode(root->left, dest);
	if (node != NULL)
	{
        return node;
	}
	//右子树中查找
	node = searchNode(root->right, dest);
	if (node != NULL)
	{
		return node;
	}
	else
	{
		return NULL;
	}
}


//可能用到的一些接口
/*
QueueInit		初始化队列
QueueDestroy	销毁队列

QueuePush		放队列尾
QueueFront		查看队首结点
QueuePop		弹出队首结点
QueueEmpty		判断队列是否为空
*/


//层序遍历二叉树
void LevelOrder(BNode* root)
{
	Queue queue;
	QueueInit(&queue);
	if (root == NULL)
	{
		return;
	}

	QueuePush(&queue, root);
	while (!QueueEmpty(&queue))
	{
		BNode* top = QueueFront(&queue);
		printf("%d ", top->data);
		QueuePop(&queue);

		if (top->left != NULL)
		{
			QueuePush(&queue, top->left);
		}

		if (top->right != NULL)
		{
			QueuePush(&queue, top->right);
		}
	}
	QueueDestroy(&queue);
}

//判断二叉树是否是完全二叉树
int IsCompleteBTree(BNode* root)
{
	Queue queue;
	QueueInit(&queue);
	if (root == NULL)
	{
		return 1;
	}
	QueuePush(&queue, root);
	while (!QueueEmpty(&queue))
	{
		BNode* top = QueueFront(&queue);
		QueuePop(&queue);

		if (top == -1)
		{
			break;
		}
		if (top->left != NULL)
		{
			QueuePush(&queue, top->left);
		}

		if (top->right != NULL)
		{
			QueuePush(&queue, top->right);
		}
	}
	while (!QueueEmpty(&queue))
	{
		BNode* node = QueueFront(&queue);
		QueuePop(&queue);

		if (node != NULL)
		{
			QueueDestroy(&queue);
			return 0;
		}
	}

	QueueDestroy(&queue);
	return 1;
}

//非递归前序遍历二叉树
void PreorderLoop(BNode* root)
{
	Stack stack;
	StackInit(&stack);
	BNode* pnode = root;
	BNode* top;

	while (pnode != NULL || !StackEmpty(&stack))
	{
		while (pnode != NULL)
		{
			printf("%d ", pnode->data);
			StackPush(&stack, pnode);  //压栈压的是节点的地址,而不是节点的值
			pnode = pnode->left;
		}

		top = StackTop(&stack);
		StackPop(&stack);
		pnode = top->right;
		
	}
}

//非递归中序遍历二叉树
void InorderLoop(BNode* root)
{
	Stack stack;
	StackInit(&stack);

	BNode* pnode = root;
	BNode* top;

	while (pnode != NULL || !StackEmpty(&stack))
	{
		while (pnode != NULL)
		{
			StackPush(&stack,pnode);
			pnode = pnode->left;
		}

		top = StackTop(&stack);
		printf("%d ", top->data);
		StackPop(&stack);
		pnode = top->right;
	}
}

//非递归后序遍历二叉树
void PostorderLoop(BNode* root)
{
	Stack stack;
	StackInit(&stack);

	BNode* pnode = root;
	BNode* top;
	BNode* last = NULL;

	while (pnode != NULL || !StackEmpty(&stack))
	{
		while (pnode != NULL)
		{
			StackPush(&stack, pnode);
			pnode = pnode->left;
		}

		top = StackTop(&stack);
		if (top->right == NULL || top->right==last)
		{
			printf("%d ", top->data);
			last = top;
			StackPop(&stack);
		}
		else
		{
			pnode = top->right;
		}
	}
}

void Mirror(BNode* root)
{
	if (root == NULL)
	{
		return;
	}
	BNode* t = root->left;
	root->left = root->right;
	root->right = t;

	Mirror(root->left);
	Mirror(root->right);
}


