package edu.lmu.cmsi.tree;

import edu.lmu.cmsi.tree.node.BinaryTreeNode;
import edu.lmu.cmsi.tree.exception.DuplicateItemException;
import edu.lmu.cmsi.tree.exception.ItemNotFoundException;
import java.util.*;

public class IntegerBinarySearchTree {

  protected BinaryTreeNode root;

  public IntegerBinarySearchTree() {
    this.root = null;
  }

  /**
   * Insert into the tree.
   *
   * @param x the item to insert.
   * @throws edu.lmu.cmsi.tree.exception.DuplicateItemException if x exists.
   */
  public void insert(int x) {
    if (root == null) {
      root = new BinaryTreeNode(x);
    } else {
      insertIn(root, x);
    }
  }

  private void insertIn(BinaryTreeNode node, int x) {
    if (node.getValue() == x) {
      throw new DuplicateItemException(x);
    } else {
      if (x < node.getValue()) {
        BinaryTreeNode left = node.getLeft();
        if (left == null) {
          left = new BinaryTreeNode(x);
          node.setLeft(left);
        } else {
          insertIn(left, x);
        }
      } else {
        BinaryTreeNode right = node.getRight();
        if (right == null) {
          right = new BinaryTreeNode(x);
          node.setRight(right);
        } else {
          insertIn(right, x);
        }
      }
    }
  }

  /**
   * Find the smallest item in the tree.
   *
   * @return smallest item or throws an exception if the tree is empty.
   * @throws edu.lmu.cmsi.tree.exception.ItemNotFoundException
   *
   */
  public int findSmallestValue() {
    if (root == null) {
      throw new ItemNotFoundException("Tree is empty.");
    }
    BinaryTreeNode node = root;
    while (node.getLeft() != null) {
      node = node.getLeft();
    }
    return node.getValue();
  }

  /**
   * Find the largest item in the tree.
   *
   * @return the largest item or throws an exception if the tree is empty.
   * @throws edu.lmu.cmsi.tree.exception.ItemNotFoundException
   *
   */
  public int findLargestValue() {
    if (root == null) {
      throw new ItemNotFoundException("Tree is empty.");
    }
    BinaryTreeNode node = root;
    while (node.getRight() != null) {
      node = node.getRight();
    }
    return node.getValue();
  }

  /**
   * Returns whether or not the value exists in the tree
   *
   * @return true if the value exists, false otherwise
   */
  public boolean contains(int value) {
    return containsIn(root, value);
  }

  private boolean containsIn(BinaryTreeNode node, int value) {
    if (node == null) {
      return false;
    }
    if (node.getValue() == value) {
      return true;
    } else {
      if (value < node.getValue()) {
        return containsIn(node.getLeft(), value);
      } else {
        return containsIn(node.getRight(), value);
      }
    }
  }

  /**
   * Returns an preorder-traversed array
   *
   * @return an array of Integers, or empty if the tree is empty.
   */
  public Integer[] toPreOrder() {
    return toPreOrderIn(root);
  }

  public Integer[] toPreOrderIn(BinaryTreeNode node) {
    ArrayList<Integer> result = new ArrayList<Integer>(); 
    if (node != null) {
      result.add(node.getValue());
      toPreOrderIn(node.getLeft());
      toPreOrderIn(node.getRight());
    }
  Integer[] arrayResult = result.toArray(new Integer[result.size()]);
  return arrayResult;
  }

  /**
   * Returns an inorder-traversed array
   *
   * @return an array of Integers, or empty if the tree is empty.
   */
  public Integer[] toInOrder() {
    throw new UnsupportedOperationException("toInOrder needs to be implemented");
  }

  /**
   * Returns an postorder-traversed array
   *
   * @return an array of Integers, or empty if the tree is empty.
   */
  public Integer[] toPostOrder() {
    throw new UnsupportedOperationException("toPostOrder needs to be implemented");
  }

  /**
   * Returns an Breadth First-traversed array
   *
   * @return an array of Integers, or empty if the tree is empty.
   */
  public Integer[] toBreadthFirstOrder() {
    ArrayList<Integer> result = new ArrayList<Integer>(); 
    BinaryTreeNode node = root;
    if (node != null) {
      ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();
      queue.addLast(node);
      while (!queue.isEmpty()) {
        node = queue.removeFirst();
        result.add(node.getValue());
        if (node.getLeft() != null) {
          queue.addLast(node.getLeft());
        }
        if (node.getRight() != null) {
          queue.addLast(node.getRight());
        }
      }
    }
  Integer[] arrayResult = result.toArray(new Integer[result.size()]);
  return arrayResult;
  }
}









