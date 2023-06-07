package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return this.height(this.root);
	}

	private int height(BSTNode<T> node) {
		int height;
		if (node.isEmpty()) {
			height = -1;
		}
		height = 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
		return height;
	}
	
	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> found = null;
		if (element != null && !this.isEmpty()) {
			found = this.search(this.root, element);
		}
		return found;
	}
	
	private BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> found = null;
		if (element.equals(node.getData())) {
			found = node;
		}
		else if (node.getLeft().isEmpty() && element.compareTo(node.getData()) == -1) {
			found = this.search((BSTNode<T>) node.getLeft(), element);
		}
		else {
			found = this.search((BSTNode<T>) node, element);
		}
		return found;
	}

	@Override
	public void insert(T element) {
		BSTNode<T> left = new BSTNode<T>();
		BSTNode<T> right = new BSTNode<T>();

		if (this.isEmpty()) {
			this.root.setData(element);
			this.root.setLeft(left);
			this.root.setRight(right);
			this.root.setParent(this.root);
			
			left.setParent(this.root);
			right.setParent(this.root);
		}
		else {
			BSTNode<T> newNode = new BSTNode<T>();
			newNode.setData(element);
			newNode.setLeft(left);
			newNode.setRight(right);
			this.recursiveInsert(root, newNode);
		}
	}
	
	private void recursiveInsert(BSTNode<T> search, BSTNode<T> newNode) {
		
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> found = null;
		if (!this.isEmpty()) {
			found = this.searchMaximum(this.root);
		}
		return found;
	}

	private BSTNode<T> searchMaximum(BSTNode<T> node) {
		BSTNode<T> found = null;
		if (!node.getRight().isEmpty()) {
			found = this.searchMaximum((BSTNode) node.getRight());
		}
		return found;
	}
	
	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> found = null;
		if (!this.isEmpty()) {
			found = this.searchMinimum(this.root);
		}
		return found;
	}
	
	private BSTNode<T> searchMinimum(BSTNode<T> node) {
		BSTNode<T> found = null;
		if (!node.getLeft().isEmpty()) {
			found = this.searchMinimum((BSTNode) node.getLeft());
		}
		return found;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> found = this.search(element);
			if (found != null) {
				if (found.isLeaf() && found.getParent().equals(found)) {
					this.root = new BSTNode<T>();
				}
				else if (found.isLeaf()) {
					BSTNode<T> parent = (BSTNode<T>) found.getParent();
				}
			}
		}
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
