import java.util.ArrayDeque;
import java.util.Stack;  
/*
 * ѧϰ����������������һ���������������ṹ�����ʵ�֡�
 * 07/07/2016
 * ��������������ݽṹ���е㣺һ�����������飬���ڲ�����������ٶȺ������������в���һ���죻
 * ��һ�����������ڲ������ݺ�ɾ����������ٶȺ�����һ������Ȼ�������Ҿ�Ҫ�ú�ȥѧ��....
 */
class BinaryTreeNode {// �ڵ���
	int data;
	BinaryTreeNode leftNode = null, rightNode = null;

	public void setBinaryTreeNode(int data) {
		this.data = data;
	}

	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}
}

class BinaryTree {
	BinaryTreeNode[] btn;
	BinaryTreeNode rooNode;// ���ڵ�
	int NodeSize;

	// 1��������
	public BinaryTree(int[] arrayNode) {
		NodeSize = arrayNode.length;
		btn = new BinaryTreeNode[NodeSize];
		// ��arrayNodeԪ��ת��Ϊ�ڵ�
		for (int i = 0; i < NodeSize; i++) {
			btn[i] = new BinaryTreeNode();
			btn[i].setBinaryTreeNode(arrayNode[i]);
			if (i == 0)
				rooNode = btn[i];
		}
		// �Ѷ����������������ڵ㲹ȫ
		for (int i = 0; i < (NodeSize - 2) / 2; i++) {
			btn[i].setLeftNode(btn[2 * i + 1]);
			btn[i].setRightNode(btn[2 * i + 2]);
		}
	}

	// 2���ݹ鷽��ǰ���������-��-�ң�
	void preOrder(BinaryTreeNode btn) {
		BinaryTreeNode root = btn;
		if (root != null) {
			printNode(root);
			preOrder(root.leftNode);
			preOrder(root.rightNode);
		}else
			return;
	}
	/*
	 * ����������ȱ�������Ϊû��parentָ�룬���зǵݹ���ʽһ��Ҫ����ջ���෴������������Ľڵ���parentָ�룬��ô�Ͳ���Ҫջ�ˡ�
	 * ���ø���ջ��ֻҪջ��Ϊ�գ��Ϳ��Ե�ջ��ÿ�ε���һ���ڵ㣬Ҫ���������ҽڵ��ջ���ҽڵ��Ƚ�ջ����
	 */
	// 2.1 �ǵݹ鷽��ǰ���������-��-�ң�
	void preOrder1(BinaryTreeNode btn) {
		BinaryTreeNode root = btn;
		if(root == null)
			return;
		Stack <BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(root);
		while(stack.isEmpty() != true){
			root = stack.pop();
			printNode(root);
			if(root.rightNode != null)
				stack.push(root.rightNode);
			if(root.leftNode != null)
				stack.push(root.leftNode);
		}
	}
		
	// 3���ݹ鷽�������������-��-�ң�
	void inOrder(BinaryTreeNode btn) {
		BinaryTreeNode root = btn;
		if (root != null) {
			inOrder(root.leftNode);
			printNode(root);	
			inOrder(root.rightNode);
		}else
			return;
	}
	/*
	 * �������������˵���ǵݹ���㷨�ȵݹ��㷨��Ч��Ҫ�ߵĶࡣ����������㷨��ʵ�ֵĹ������£�
	 * (1)��ʼ��ջ��������ջ��
	 * (2)��ջ�ǿգ���ջ���������ӽ����̽�ջ��ֱ��null(��Ҷ�ӽ��ʱ)��ջ������ջ�����(ִ��visit����)
	 * ��ʹջ�������Һ��ӽ���ջ��Ϊջ����㡣
	 * (3)�ظ�ִ��(2)��ֱ��ջΪ�ա�
	 */
	// 3.1 �ǵݹ鷽�������������-��-�ң�
	void inOrder1(BinaryTreeNode btn) {
		BinaryTreeNode root = btn;
		if(root == null)
			return;
		Stack <BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while(root != null || stack.isEmpty() != true){
			while(root != null){
			stack.push(root);
			root = root.leftNode;
			}
			if(root == null){
				BinaryTreeNode node = stack.pop();
				printNode(node);
				root = node.rightNode;
			}
		}	
	}
		
	// 4���ݹ鷽�������������-��-����
	void postOrder(BinaryTreeNode btn) {
		BinaryTreeNode root = btn;
		if (root != null) {
			postOrder(root.leftNode);
			postOrder(root.rightNode);
			printNode(root);
		}
	}
	
	// 4.1 �ǵݹ鷽�������������-��-����
	void postOrder1(BinaryTreeNode btn) {
		BinaryTreeNode root = btn;
		if(root == null)
			return;
		Stack <BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while(root != null || stack.isEmpty() != true){
			while(root != null){
				if(root.rightNode != null)
					stack.push(root.rightNode);
				stack.push(root);
				root = root.leftNode;
			}
			// ��Ȼ��ջ�ˣ��ýڵ�϶�û������
			root = stack.pop();
			if(root.rightNode != null&& !stack.isEmpty()&&root.rightNode == stack.peek()){
				stack.pop();// ��ջ�Һ���
				stack.push(root);
				root = root.rightNode;
			}else {
				printNode(root);
				root = null;
			}		
		}
	}

	// 5������ڵ�
	void insertNode(){
		
	}
	
	// 6��ɾ���ڵ�
	void delNode(){
			
	}
	
	// 7�����ҽڵ�
	void findNode(){
		
	}
	
	// 8���п���
	boolean emptyTree(BinaryTreeNode btn){
		BinaryTreeNode root = btn;
		if(root == null)
			return true;
		return false;
	}
	
	// 9���ÿ���
	void clearTree(BinaryTreeNode btn){
		BinaryTreeNode root = btn;
		root = null;
		printNode(btn);
	}
	
	// 10�����������
	void depthTree(){
		
	}
	
	// 11�����ĳ�ڵ��˫�׽ڵ�
	void findParent(){
		
	}
	
	// 12��������
	void traverseTree(){
		
	}
	
	// 13�����ĳ�ڵ��������
	void findLeftChild(){
		
	}
	
	// 14��������ֵ�
	void findRightSibling(){
		
	}
	
	// 15���ж��Ƿ�ΪҶ�ӽڵ�
	boolean isLeaf(){
		
		return false;
	}
	
	// 16����ĳ�ڵ�ĸ߶�
	/*
	 * ����߶ȵ�ʱ�����õݹ�,�Ӹ��ڵ㵽�ӽڵ㣬ֱ��Ҷ�ӽڵ㣬����Ҷ�ӽڵ�ĸ߶���0��
	 * �ٴ�Ҷ�ӻص����ڵ㣬ֱ�������ڵ㣬height(parentnode) = max(height(left),height(son))+1
	 * ���ĸ߶ȵ��ڸ��ڵ�߶�+1
	 */
	int heightTree(BinaryTreeNode btn){
		BinaryTreeNode root = btn;
		if(root == null)
			return -1;
		int leftHeight = heightTree(root.leftNode);// ����ýڵ����ӵĸ߶�
		int rightHeight = heightTree(root.rightNode);// ����ýڵ��Һ��ӵĸ߶�
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	// 17�� �ǵݹ�ʵ�ֲ������
	void levelOrder1(BinaryTreeNode btn){
		BinaryTreeNode root = btn;
		ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();
		if(root == null)
			return;
		queue.add(root);
		while(queue.isEmpty() != true){
			root = queue.remove();
			printNode(root);
			if(root.leftNode != null)
				queue.add(root.leftNode);
			if(root.rightNode != null)
				queue.add(root.rightNode);
		}
	}
	// �����ж�ƽ�������
	int heightTreeForJudge(BinaryTreeNode btn){
		BinaryTreeNode root = btn;
		if(root == null)
			return 0;
		int leftHeight = heightTree(root.leftNode);// ����ýڵ����ӵĸ߶�
		int rightHeight = heightTree(root.rightNode);// ����ýڵ��Һ��ӵĸ߶�
		if(leftHeight < 0 || rightHeight < 0 || Math.abs(leftHeight - rightHeight) > 0)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	// 18���ж�ƽ�������
	boolean isBalanced(BinaryTreeNode btn){
		return heightTreeForJudge(btn)>=0;
	}
	
	//19����������+�����������ع�������
	public static BinaryTreeNode buildTree(int postOrder[], int pend, int inOrder[], int iend, int length) {

		if (postOrder == null || postOrder.length == 0 || inOrder == null
				|| inOrder.length == 0 || postOrder.length != inOrder.length) {
			return null;
		}
		BinaryTreeNode root = new BinaryTreeNode();
		int value = postOrder[pend];
		root.data = value;
		if (length == 1)
			return root;
		int i = 0;
		//�ҵ�����������ڵ������
		while (inOrder[iend - i] != value) {
			i++;
		}
		root.rightNode = buildTree(postOrder, pend - 1, inOrder, iend, i);
		root.leftNode = buildTree(postOrder, pend - i - 1, inOrder, iend - i - 1, length - i - 1);
		return root;
	}
	
	// 20������ǰ��+�����������ع�������
	public static BinaryTreeNode buildTree2(int[] preOrder, int start, int[] inOrder, int end, int length) {
		// ˼·�� ǰ�������ÿһ���ڵ㶼�ǵ�ǰ�����ĸ��ڵ㡣ͬʱ���Զ�Ӧ�Ľڵ�Ϊ�߽磬�ͻ����������Ľ����Ϊ����������������
		if (preOrder == null || preOrder.length == 0 || inOrder == null
				|| inOrder.length == 0 || length <= 0) {
			return null;
		}

		// ���� ǰ������ĵ�һ��Ԫ�ؽ��������ڵ�
		int value = preOrder[start];
		BinaryTreeNode root = new BinaryTreeNode();
		root.data = value;

		// �ݹ���ֹ����������ֻ��һ���ڵ�
		if (length == 1)
			return root;

		// ���� ǰ������ĵ�һ��Ԫ������������е�λ�÷ֲ�������������������
		int i = 0;
		while (i < length) {
			if (value == inOrder[end - i]) {
				break;
			}
			i++;
		}

		// ����������������
		root.leftNode = buildTree(preOrder, start + 1, inOrder, end - i - 1, length - 1 - i);
		// ����������������
		root.rightNode = buildTree(preOrder, start + length - i, inOrder, end, i);
		return root;
	}
	
	public static void printNode(BinaryTreeNode btn) {
		System.out.print(btn.data + " " );
		
	}
}
public class Tree {

	public static void main(String[] args) {
		
		int[] arrayNode = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BinaryTree bt = new BinaryTree(arrayNode);
		System.out.println("�ݹ��������: ");
		bt.inOrder(bt.rooNode);
		System.out.println();
		System.out.println("�ǵݹ��������: ");
		bt.inOrder1(bt.rooNode);
		System.out.println();
		System.out.println("�ݹ�ǰ�����: ");
		bt.preOrder(bt.rooNode);
		System.out.println();
		System.out.println("�ǵݹ�ǰ�����: ");
		bt.preOrder1(bt.rooNode);
		System.out.println();
		System.out.println("�ݹ�������: ");
		bt.postOrder(bt.rooNode);
		System.out.println();
		System.out.println("�ǵݹ�������: ");
		bt.postOrder1(bt.rooNode);
		System.out.println();
		System.out.println("�ǵݹ�������: ");
		bt.levelOrder1(bt.rooNode);
		System.out.println("������: " + bt.emptyTree(bt.rooNode));
		System.out.println("���ڵ�ĸ߶�: " + bt.heightTree(bt.rooNode));
		System.out.println("�Ƿ�Ϊƽ�������: " + bt.isBalanced(bt.rooNode));
//		bt.clearTree(bt.rooNode);
	}

}
