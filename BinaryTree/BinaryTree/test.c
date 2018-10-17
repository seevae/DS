#include"BinaryTree.h"

void Test()
{
	DataType preorder[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1};  //preorder:带空结点的前序
	int size = sizeof(preorder) / sizeof(DataType);  //preorder的长度
	RESULT r = creatTree(preorder,size);
	printf("前序打印二叉树: \n");
 	Preorder(r.root);
	printf("\n");
	printf("结点个数: %d\n", GetSize(r.root));
	printf("叶子结点个数: %d\n", GetLeafSize(r.root));
	printf("第 3 层结点个数: %d\n", GetLevelSize(r.root, 3));
	printf("高度: %d\n", GetHight(r.root));
	printf("查找 D: %d\n", (searchNode(r.root, 4))->data);
	printf("查找 E: %d\n", (searchNode(r.root, 5))->data);
	printf("查找 H: %p\n", searchNode(r.root, 8));
	printf("层序遍历二叉树:\n");
	LevelOrder(r.root);
	printf("\n");
	printf("是否是完全二叉树: %d\n", IsCompleteBTree(r.root));
	printf("非递归前序遍历二叉树:\n");
	PreorderLoop(r.root);
	printf("\n");
	printf("非递归中序遍历二叉树:\n");
	InorderLoop(r.root);
	printf("\n");
	printf("非递归后序遍历二叉树\n");
	PostorderLoop(r.root);
	printf("\n");
	printf("镜像二叉树\n");
	Mirror(r.root);
	Preorder(r.root);
	printf("\n");
}

int main()
{
	Test();
	system("pause");
	return 0;
}