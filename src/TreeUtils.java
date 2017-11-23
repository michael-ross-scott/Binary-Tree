import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Utility procedures for binary tree structures.
 * 
 * @version 25/2/2015
 */
public class TreeUtils {
        
    /**
     * Determine whether one tree node structure is similar (has the same structure) as another.
     */
    public static boolean similar(BinaryTreeNode treeStructOne, BinaryTreeNode treeStructTwo) {
	if(treeStructOne.getHeight()!=treeStructTwo.getHeight()){
		return false;
	} else if(treeStructOne.hasLeft() && treeStructTwo.hasLeft() && treeStructOne.hasRight() && treeStructTwo.hasRight()){
		return similar(treeStructOne.getLeft(),treeStructTwo.getLeft()) && similar(treeStructOne.getRight(),treeStructTwo.getRight()); 
	} else if(treeStructOne.hasLeft() && treeStructTwo.hasLeft() && !treeStructOne.hasRight() && !treeStructTwo.hasRight()){	
		return similar(treeStructOne.getLeft(),treeStructTwo.getLeft());
	} else if(treeStructOne.hasRight() && treeStructTwo.hasRight() && !treeStructOne.hasLeft() && !treeStructTwo.hasLeft()){
		return similar(treeStructOne.getRight(),treeStructTwo.getRight());
	} else if (treeStructOne.hasLeft() && !treeStructTwo.hasLeft() || treeStructOne.hasRight() && !treeStructTwo.hasRight()) {
		return false;
	} else {
		return true;
	}
    }
    
    /**
     * Obtain a list containing the root node of the given structure i.e. tNode itself.
     */
    public static List<BinaryTreeNode> levelZero(BinaryTreeNode tNode) {
        	ArrayList <BinaryTreeNode> lists = new ArrayList <BinaryTreeNode> ();
		lists.add(tNode); 
		return lists;
    }
    
    
    /**
     * Given a list of nodes, obtain the next level. 
     * 
     * <p>
     * If the tree structure is incomplete, <code>BinaryTreeNode.EMPTY_NODE</code> is inserted as a place holder for each
     * missing node.
     * </p>
     */
    public static List<BinaryTreeNode> nextLevel(List<BinaryTreeNode> level) {

		ArrayList <BinaryTreeNode> lists = new ArrayList <BinaryTreeNode> ();

		for(int i = 0; i < level.size(); i++){
			if(level.get(i).hasLeft()){
				lists.add(level.get(i).getLeft());
			} else {
				lists.add(BinaryTreeNode.EMPTY_NODE);
			} 
			if (level.get(i).hasRight()){
				lists.add(level.get(i).getRight());
			} else {
				lists.add(BinaryTreeNode.EMPTY_NODE);
			}
		}
		return lists;
    }
    
    /**
     * Determine whether node is a place holder i.e. <code>node==BinaryTreeNode.EMPTY_NODE</code>
     */
    public static boolean isPlaceHolder(BinaryTreeNode node) {
		if(node==BinaryTreeNode.EMPTY_NODE){
			return true;
		}
		return false;
    }
    
}
