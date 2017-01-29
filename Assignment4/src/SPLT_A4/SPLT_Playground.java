package SPLT_A4;

public class SPLT_Playground {
	public static void main(String[] args){
	    //genTest();
		lala();
	  }
	  
	  public static void genTest(){
	    SPLT tree= new SPLT();
	    tree.insert("hello");
	    tree.insert("world");
	    tree.insert("my");
	    //tree.insert("name");
	    //tree.insert("is");
	    //tree.insert("blank");
	    tree.remove("hello");
	    System.out.println("size is "+tree.size());
	    //System.out.println("does par work? "+tree.getRoot());
	    
	    printLevelOrder(tree);
	  }
	  public static void lala(){
		  SPLT tree= new SPLT();
		  tree.insert("C");
		  tree.insert("A");
		  tree.insert("D");
		  tree.contains("C");
		  tree.insert("E");
		  tree.remove("A");
		  tree.insert("V");
		  tree.insert("0");
		  tree.contains("E");
		  tree.insert("T");
		  tree.remove("L");
		  tree.findMin();
		  tree.insert("G");
		  tree.insert("P");
		  tree.remove("E");
		 // tree.findMax();
		  
		  System.out.println("size is "+tree.size());
		    //System.out.println("does par work? "+tree.getRoot());
		    
		    printLevelOrder(tree);
		  
	  }

	    static void printLevelOrder(SPLT tree){ 
	    //will print your current tree in Level-Order...
	    //https://en.wikipedia.org/wiki/Tree_traversal
	      int h=tree.getRoot().getHeight(tree.getRoot());
	      for(int i=0;i<=h;i++){
	        System.out.print("Level "+i+":");
	        printGivenLevel(tree.getRoot(), i);
	        System.out.println();
	      }
	      
	    }
	    static void printGivenLevel(BST_Node root,int level){
	      if(root==null)return;
	      if(level==0)System.out.print(root.data+" ");
	      else if(level>0){
	        printGivenLevel(root.left,level-1);
	        printGivenLevel(root.right,level-1);
	      }
	    }
}
