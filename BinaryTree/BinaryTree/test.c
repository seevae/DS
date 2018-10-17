#include"BinaryTree.h"

void Test()
{
	DataType preorder[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1};  //preorder:���ս���ǰ��
	int size = sizeof(preorder) / sizeof(DataType);  //preorder�ĳ���
	RESULT r = creatTree(preorder,size);
	printf("ǰ���ӡ������: \n");
 	Preorder(r.root);
	printf("\n");
	printf("������: %d\n", GetSize(r.root));
	printf("Ҷ�ӽ�����: %d\n", GetLeafSize(r.root));
	printf("�� 3 �������: %d\n", GetLevelSize(r.root, 3));
	printf("�߶�: %d\n", GetHight(r.root));
	printf("���� D: %d\n", (searchNode(r.root, 4))->data);
	printf("���� E: %d\n", (searchNode(r.root, 5))->data);
	printf("���� H: %p\n", searchNode(r.root, 8));
	printf("�������������:\n");
	LevelOrder(r.root);
	printf("\n");
	printf("�Ƿ�����ȫ������: %d\n", IsCompleteBTree(r.root));
	printf("�ǵݹ�ǰ�����������:\n");
	PreorderLoop(r.root);
	printf("\n");
	printf("�ǵݹ��������������:\n");
	InorderLoop(r.root);
	printf("\n");
	printf("�ǵݹ�������������\n");
	PostorderLoop(r.root);
	printf("\n");
	printf("���������\n");
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