/*
 * ������������һЩ��������
 * 08/04/2017
 * ���������������ӽ��ֵ�ȵ�ǰ���ֵС���Һ��ӽ��ֵ�ȵ�ǰֵ�����ڵ�ǰֵ��
 */
class TreeNode {
	public int iData;
	public TreeNode leftChild;
	public TreeNode rightChild;

	public TreeNode(int iData) {
		this.iData = iData;
	}

	public void displayNode() {
		System.out.print(" " + this.iData);
	}
}

class BinarySearchTree {

	public TreeNode root;

	public BinarySearchTree(int iData) {
		root = new TreeNode(iData);
	}

	// ����ָ����㷽��
	public TreeNode find(int iData) {
		TreeNode current;
		current = root;
		while (current != null) {
			if (iData < current.iData) {
				current = current.leftChild;
			} else if (iData > current.iData) {
				current = current.rightChild;
			} else {
				return current;
			}
		}
		return null;
	}

	// ��ȡ��ǰֵ���ĸ���㷽��
	public TreeNode getParentNode(int iData) {
		TreeNode current;
		current = root;
		TreeNode parent = root;
		while (current != null) {
			if (iData < current.iData) {
				parent = current;
				current = current.leftChild;
			} else if (iData > current.iData) {
				parent = current;
				current = current.rightChild;
			} else {
				if (current == root) {
					return null;
				} else
					return parent;
			}
		}
		return null;
	}

	// ����������Сֵ���
	public TreeNode findMin(TreeNode root) {
		TreeNode node;
		node = root;
		while (node != null) {
			if (node.leftChild != null) {
				node = node.leftChild;
			} else {
				System.out.println("min:" + node.iData);
				return node;
			}
		}
		System.out.println("tree is null");
		return null;
	}

	// �����������ֵ���
	public TreeNode findMax(TreeNode root) {
		TreeNode node;
		node = root;
		while (node != null) {
			if (node.rightChild != null) {
				node = node.rightChild;
			} else {
				System.out.println("max:" + node.iData);
				return node;
			}
		}
		System.out.println("tree is null");
		return null;
	}

	public TreeNode findInorderSuccessor(TreeNode node) {
		TreeNode current = node.rightChild;
		while (current != null) {
			if (current.leftChild != null) {
				current = current.leftChild;
			} else
				return current;
		}
		return current;
	}

	// ɾ��ָ��ֵ�Ľ��
	public void deleteNode(int key) {
		TreeNode keyNode = find(key);
		TreeNode parent = getParentNode(key);
		if (keyNode != null) {// ����ҵ���Ҫɾ���Ľ��
			if (keyNode.leftChild == null && keyNode.rightChild == null) {// ���ý����Ҷ�ӽ��
				if (parent == null) {// ���ý���Ǹ����
					this.root = null;
					return;
				}
				if (parent.leftChild == keyNode) {
					parent.leftChild = null;
				} else {
					parent.rightChild = null;
				}
				return;
			} else if (keyNode.rightChild == null) { // ���ý�������������
				if (parent.leftChild == keyNode) {
					parent.leftChild = keyNode.leftChild;
				} else {
					parent.rightChild = keyNode.leftChild;
				}
				return;
			} else if (keyNode.leftChild == null) { // ���ý�������������
				if (parent.leftChild == keyNode) {
					parent.leftChild = keyNode.rightChild;
				} else {
					parent.rightChild = keyNode.rightChild;
				}
				return;
			} else { // ���ý��������ӽ�㶼���գ�1���ý���������е������̽���Ǹý������ӽ�㣻2���ý����������е������̽���Ǹý����������������ӽ�㣻
				TreeNode inorderSuccessor = findInorderSuccessor(keyNode);
				TreeNode parentSuccessor = getParentNode(inorderSuccessor.iData);
				if (inorderSuccessor == keyNode.rightChild) {// ���ý���������е������̽���Ǹý������ӽ�㣻
					inorderSuccessor.leftChild = keyNode.leftChild;
					if (parent.leftChild == keyNode) {
						parent.leftChild = inorderSuccessor;
					} else {
						parent.rightChild = inorderSuccessor;
					}
				} else { // ���ý����������е������̽���Ǹý����������������ӽ�㣻
					if (parent.leftChild == keyNode) {
						parentSuccessor.leftChild = inorderSuccessor.rightChild;
						inorderSuccessor.rightChild = keyNode.rightChild;
						parent.leftChild = inorderSuccessor;
						inorderSuccessor.leftChild = keyNode.leftChild;
					} else {
						parentSuccessor.leftChild = inorderSuccessor.rightChild;
						inorderSuccessor.rightChild = keyNode.rightChild;
						parent.rightChild = inorderSuccessor;
						inorderSuccessor.leftChild = keyNode.leftChild;
					}
				}
			}
		}
	}

	// ����ָ��ֵ�Ľ��
	public void insert(int iData) {
		TreeNode node = new TreeNode(iData);
		TreeNode current;
		if (root == null) {
			root = node;
			return;
		} else {
			current = root;
			while (true) {
				if (iData >= current.iData) {
					if (current.rightChild == null) {
						current.rightChild = node;
						return;
					} else
						current = current.rightChild;
				} else {
					if (current.leftChild == null) {
						current.leftChild = node;
						return;
					} else
						current = current.leftChild;
				}
			}
		}
	}

	public void preOrder(TreeNode node) {
		if (node != null) {
			System.out.print(" " + node.iData);
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}
}

public class theBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree tree = new BinarySearchTree(-1);
		tree.insert(-2);
		tree.insert(1);
		tree.insert(0);
		tree.insert(4);
		tree.insert(2);
		tree.insert(5);
		tree.insert(3);

		tree.preOrder(tree.root);
		System.out.print("\n");

		tree.findMin(tree.root);
		tree.findMax(tree.root);

		tree.deleteNode(1);

		tree.preOrder(tree.root);
		System.out.print("\n");
	}
}