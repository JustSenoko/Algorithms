package lesson6;

import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;
    private int size;
    private int maxHeight;

    public TreeImpl(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public Node<E> getRoot() {
        return root;
    }

    @Override
    public boolean add(E value) throws IndexOutOfBoundsException {
        Node<E> newNode = new Node<>(value);
        if (isEmpty()) {
            this.root = newNode;
            return true;
        }

        NodeAndParent nodeAndParent = doFind(value);
        if (nodeAndParent.current != null) {
            return false;
        }
        if (nodeAndParent.height >= maxHeight) {
            throw new IndexOutOfBoundsException("Превышена максимальная высота дерева");
            //return false;
        }

        Node<E> parent = nodeAndParent.parent;

        assert parent != null;
        if (parent.shouldBeLeft(value)) {
            parent.setLeftChild(newNode);
        } else {
            parent.setRightChild(newNode);
        }

        size++;
        return true;
    }

    @Override
    public boolean find(E value) {
        return doFind(value).current != null;
    }

    private NodeAndParent doFind(E value) {
        Node<E> parent = null;
        Node<E> current = this.root;
        int depth = 0;

        while (current != null) {
            if (current.getValue().equals(value)) {
                return new NodeAndParent(current, parent, depth);
            }

            parent = current;
            if (current.shouldBeLeft(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
            depth++;
        }

        return new NodeAndParent(null, parent, depth);
    }

    @Override
    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> parent = nodeAndParent.parent;
        Node<E> removedNode = nodeAndParent.current;

        if (removedNode == null) {
            return false;
        }

        if ( removedNode.isLeaf() ) {
            removeLeafNode(parent, removedNode);
        }
        else if (hasOnlySingleChildNode(removedNode)) {
            removeNodeWithSingleChild(parent, removedNode);
        }
        else {
            removeCommonNode(parent, removedNode);
        }

        size--;
        return true;
    }

    private void removeCommonNode(Node<E> parent, Node<E> removedNode) {
        Node<E> successor = getSuccessor(removedNode);
        if (removedNode == root) {
            root = successor;
        }
        else if ( parent.shouldBeLeft(removedNode.getValue()) ) {
            parent.setLeftChild(successor);
        }
        else {
            parent.setRightChild(successor);
        }

        successor.setLeftChild(removedNode.getLeftChild());
    }

    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> successor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removedNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }

        return successor;
    }

    private void removeNodeWithSingleChild(Node<E> parent, Node<E> removedNode) {
        Node<E> childNode = removedNode.getLeftChild() != null ? removedNode.getLeftChild() : removedNode.getRightChild();

        if (removedNode == root) {
            root = childNode;
        }
        else if ( parent.shouldBeLeft(removedNode.getValue()) ) {
            parent.setLeftChild(childNode);
        }
        else {
            parent.setRightChild(childNode);
        }
    }

    private void removeLeafNode(Node<E> parent, Node<E> removedNode) {
        if (removedNode == root) {
            root = null;
        }
        else if ( parent.shouldBeLeft(removedNode.getValue()) ) {
            parent.setLeftChild(null);
        }
        else {
            parent.setRightChild(null);
        }
    }

    private boolean hasOnlySingleChildNode(Node<E> removedNode) {
        return removedNode.getLeftChild() != null ^ removedNode.getRightChild() != null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown value: " + mode);
        }
    }

    private void postOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        inOrder(current.getRightChild());
        System.out.println(current);
    }

    private void preOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        System.out.println(current);
        inOrder(current.getLeftChild());
        inOrder(current.getRightChild());
    }

    private void inOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        System.out.println(current);
        inOrder(current.getRightChild());
    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 32;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    @Override
    public int height() {
        return height(root);
    }

    private class NodeAndParent {
        Node<E> current;
        Node<E> parent;
        int height;

        NodeAndParent(Node<E> current, Node<E> parent, int height) {
            this.current = current;
            this.parent = parent;
            this.height = height;
        }
    }
}
