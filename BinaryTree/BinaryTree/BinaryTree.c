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

//���ú��ս���ǰ�򴴽�������
//���ؽ���Ƕ������ĸ��ڵ�

//�ݹ鴴��,�����Ĺ����з���ʹ�ù��Ľ�����
RESULT creatTree(DataType preorder[], int size)
{
	if (size == 0)  //sizeΪ0,��������
	{
		RESULT result = { NULL, 0 };
		return result;
	}

	//����ǰ�������˼�봴��������
	//��,������,������

	//�ȴ������ڵ�
	DataType rootValue = preorder[0];
	if (rootValue == -1)  //ֻ��һ���ս��
	{
		RESULT result = { NULL, 1 };
		return result;
	}

	BNode* root = creatNode(rootValue);

	//����������
	RESULT lroot = creatTree(&preorder[1], size - 1);
	root->left = lroot.root;
	//��������
	RESULT rroot = creatTree(&preorder[1 + lroot.used],size-1-lroot.used);
	root->right = rroot.root;

	RESULT result = { root, 1 + lroot.used + rroot.used };
	return result;
}

//ǰ�����
void Preorder(BNode* root)
{
	if (root == NULL)  //��ֹ����
	{
		return ;
	}

	//��
	printf("%d ", root->data);
	//������,�������õݹ鴦��
	Preorder(root->left);
	//������,�������õݹ鴦��
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

//����������нڵ�ĸ���
int GetSize(BNode* root)
{
	if (root == NULL)
	{
		return 0;
	}

	return GetSize(root->left) + GetSize(root->right) + 1;
}

//�����������������������ĸ���
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

//�������ĳһ��Ľ�����
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

//�������������
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

//�ڶ������в���ĳһ���,�ҵ��˷��ظý���ַ,û���ҵ��򷵻�NULL
BNode* searchNode(BNode* root,DataType dest)
{
	//��Ϊ��
	if (root == NULL)
	{
		return NULL;
	}
	//Ҫ���ҵ���Ϊ���ڵ�
	if (root->data == dest)
	{
		return root;
	}
	//�������в���
	BNode* node = searchNode(root->left, dest);
	if (node != NULL)
	{
        return node;
	}
	//�������в���
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


//�����õ���һЩ�ӿ�
/*
QueueInit		��ʼ������
QueueDestroy	���ٶ���

QueuePush		�Ŷ���β
QueueFront		�鿴���׽��
QueuePop		�������׽��
QueueEmpty		�ж϶����Ƿ�Ϊ��
*/


//�������������
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

//�ж϶������Ƿ�����ȫ������
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

//�ǵݹ�ǰ�����������
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
			StackPush(&stack, pnode);  //ѹջѹ���ǽڵ�ĵ�ַ,�����ǽڵ��ֵ
			pnode = pnode->left;
		}

		top = StackTop(&stack);
		StackPop(&stack);
		pnode = top->right;
		
	}
}

//�ǵݹ��������������
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

//�ǵݹ�������������
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


