import java.io.PrintStream;
import java.util.*;
/**
 * Abstract definition of an object for printing a simple binary tree structure. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimpleTreeWriterImpl implements SimpleTreeWriter{
    PrintStream stream;

    public SimpleTreeWriterImpl(PrintStream stream){
	setDestination(stream);
    }
    /**
     * Set the PrintStream object to be used for output.
     * An implementing class may wish to supplement this functionality with a constructor 
     * that achieves the the same effect. 
     */
    public void setDestination(PrintStream stream){
	this.stream = stream;
    }
    	
    /**
     * Print a textual representation of the given tree structure to the PrintStream object
     * specified with <code>setDestination</code>.
     */
  public void write(BinaryTreeNode tree){

	List <BinaryTreeNode> ls = TreeUtils.levelZero(tree);

	int height = tree.getHeight();
	int largestNo = tree.getLargest();
	String largest = ""+largestNo;

	int length = largest.length();
	String paddingZeros = new String(new char[(length)]).replace("\0", "0");
	String nulls = new String(new char[(length)]).replace("\0", " ");

	for(int i = 0; i < height; i++){

    int noOfSpaces = (int)(((Math.pow(2,height-i)-1)/2));
    int noOfDashes = (int)((Math.pow(2,height-i)-1));
		//stream.println("ns-" + noOfSpaces + " nd-" + noOfDashes);

		String spaces = new String(new char[noOfSpaces*length]).replace("\0"," ");
    String dashes = new String(new char[noOfDashes*length]).replace("\0","-");
		String spacesBtwn = new String(new char[noOfDashes*length]).replace("\0"," ");
		
		for (int j = 0; j<ls.size(); j++){
			
			String nodes ="" + ls.get(j).getItem();
			int nodeLen = nodes.length(); 

			if(j == 0){
				if(ls.get(j).getItem() != null && nodeLen==length){
					stream.print(spaces+ls.get(j).getItem());
				} else if(ls.get(j).getItem() == null){
					stream.print(spaces+nulls);
				} else {
					String padding1 = new String(new char[length-nodeLen]).replace("\0","0");
					stream.print(spaces+padding1+ls.get(j).getItem());
				}			
		 }

			if (j % 2 == 0 && j != 0){
				
				if(ls.get(j).getItem()!=null && nodeLen==length){				
					stream.print(spacesBtwn+ls.get(j).getItem());
				} else if(ls.get(j).getItem() == null) {
					stream.print(spacesBtwn+nulls);
				} else {
					String padding2 = new String(new char[length-nodeLen]).replace("\0"," 0");
					stream.print(spacesBtwn+padding2+ls.get(j).getItem());
				}

			} else if (j % 2 != 0){

				if(ls.get(j).getItem()!=null && nodeLen==length){				
					stream.print(dashes+ls.get(j).getItem());
				} else if(ls.get(j).getItem()==null){
					stream.print(dashes+nulls);
				} else {
					String padding3 = new String(new char[length-nodeLen]).replace("\0"," 0");
					stream.print(dashes+padding3+ls.get(j).getItem());
				}

			}
 
			if(j+1 == ls.size()) {
				stream.print(spaces);
			}
		}
		stream.println();
		ls = TreeUtils.nextLevel(ls);
	}
 }
}
