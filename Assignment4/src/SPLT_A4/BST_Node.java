package SPLT_A4;


public class BST_Node {
	String data;
	  BST_Node left;
	  BST_Node right;
	  BST_Node par; //parent...not necessarily required, but can be useful in splay tree
	  boolean justMade; //could be helpful if you change some of the return types on your BST_Node insert.
	            //I personally use it to indicate to my SPLT insert whether or not we increment size.
	  
	  BST_Node(String data){ 
	    this.data=data;
	    this.justMade=true;
	  }
	  
	  BST_Node(String data, BST_Node left,BST_Node right,BST_Node par){ //feel free to modify this constructor to suit your needs
	    this.data=data;
	    this.left=left;
	    this.right=right;
	    this.par=par;
	    this.justMade=true;
	  }

	  // --- used for testing  ----------------------------------------------
	  //
	  // leave these 3 methods in, as is (meaning also make sure they do in fact return data,left,right respectively)

	  public String getData(){ return data; }
	  public BST_Node getLeft(){ return left; }
	  public BST_Node getRight(){ return right; }

	  // --- end used for testing -------------------------------------------

	  
	  // --- Some example methods that could be helpful ------------------------------------------
	  //
	  // add the meat of correct implementation logic to them if you wish

	  // you MAY change the signatures if you wish...names too (we will not grade on delegation for this assignment)
	  // make them take more or different parameters
	  // have them return different types
	  //
	  // you may use recursive or iterative implementations

	  /*
	  public BST_Node containsNode(String s){ return false; } //note: I personally find it easiest to make this return a Node,
	  (that being the node splayed to root), you are however free to do what you wish.
	  public BST_Node insertNode(String s){ return false; } //Really same logic as above note
	  public boolean removeNode(String s){ return false; } //I personal do not use the removeNode internal method in my impl 
	  since it is rather easily done in SPLT, feel free to try to delegate this out, however we do not "remove" like we do in BST
	  public BST_Node findMin(){ return left; } 
	  public BST_Node findMax(){ return right; }
	  public int getHeight(){ return 0; }

	  private void splay(BST_Node toSplay) { return false; } //you could have this return or take in whatever you want..so long as it will do the job internally. As a caller of SPLT functions, I should really have no idea if you are "splaying or not"
	                        //I of course, will be checking with tests and by eye to make sure you are indeed splaying
	                        //Pro tip: Making individual methods for rotateLeft and rotateRight might be a good idea!
	  */

	  // --- end example methods --------------------------------------

	  
	  

	  // --------------------------------------------------------------------
	  // you may add any other methods you want to get the job done
	  // --------------------------------------------------------------------
//	  public boolean containsNodeSplay(BST_Node n, String s){
//			if(n==null){
//				return false;
//			}
//			int compare=s.compareTo(n.data);
//			if(compare<0){//
//				if(n.left==null){
//					//splay this
//					//splay(n);
//					return false;
//				}
//				else
//					return containsNode(n.left, s);
//			}
//			else if(compare>0){
//				if(n.right==null){
//					//splay this
//					//splay(n);
//					return false;//might have to be true
//				}
//				else
//					return containsNode(n.right, s);
//			}
//			else {
//				//splay(n);	
//				return true;
//			}
//	  }
//old contains
//	  public boolean containsNode(BST_Node n, String s){
//			if(n==null){
//				//play(this);
//				return false;
//			}
//			int compare=s.compareTo(n.data);
//			if(compare<0){//<
//				return containsNode(n.left, s);
//			}
//			else if(compare>0){
//				return containsNode(n.right, s);
//			}
//			else 
//				return true;
//		}
	  public boolean containsNode(String s){
			//if(data.equals(s))return true;
			if(data.compareTo(s)>0){//s lexiconically less than data
				if(left==null){
					splay(this);
					return false;
				}else
				return left.containsNode(s);
			}
			if(data.compareTo(s)<0){
				if(right==null){
					splay(this);
					return false;
				}else
				return right.containsNode(s);
			}else{
			splay(this);
			return true;
			}//shouldn't hit
		}
//	  public BST_Node containsNode(String s){
//			if(data.equals(s)){
//				splay(this);
//				return this;
//			}
//			if(data.compareTo(s)>0){//s lexiconically less than data
//				if(left==null){
//					splay(this);
//					return null;
//				}
//				return left.containsNode(s);
//			}
//			if(data.compareTo(s)<0){
//				if(right==null){
//					splay(this);
//					return null;
//				}
//				return right.containsNode(s);
//			}
//			return null; //shouldn't hit
//		}
		public boolean insertNode(String s){
		if(data.compareTo(s)>0){
			if(left==null){
				
				//par=this;
				left=new BST_Node(s,null,null,this);
				splay(left);
				return true;
			}
			return left.insertNode(s);
		}
		if(data.compareTo(s)<0){
			if(right==null){
				//par=this;
				right=new BST_Node(s,null,null,this);
				splay(right);
				return true;
				//return true;
			}
			//par=this;
			return right.insertNode(s);
		}
		splay(this);
		return false;//ie we have a duplicate
		}
		

		public boolean removeNode(String s){
			if(data==null)return false;
			if(data.equals(s)){
				if(left!=null){
					data=left.findMax().data;
					left.removeNode(data);
					if(left.data==null)left=null;
				}
				else if(right!=null){
					data=right.findMin().data;
					right.removeNode(data);
					if(right.data==null)right=null;
				}
				else data=null;
				return true;
			}
			else if(data.compareTo(s)>0){
				if(left==null)return false;
				if(!left.removeNode(s))return false;
				if(left.data==null)left=null;
				return true;
			}
			else if(data.compareTo(s)<0){
				if(right==null)return false;
				if(!right.removeNode(s))return false;
				if(right.data==null)right=null;
				return true;
			}
			return false;
		}

			
		public BST_Node findMin(BST_Node n){
			if(n==null)
				return null;
			else if(n.left==null)
				return n;
			else
				return findMin(n.left);
		}

		public BST_Node findMax(BST_Node n){
			if(n==null)
				return null;
			else if(n.right==null)
				return n;
			else 
				return findMax(n.right);
		}
		public BST_Node findMin(){
			if(left!=null)return left.findMin();
			splay(this);
			return this;
		}
		public BST_Node findMax(){
			if(right!=null)return right.findMax();
			splay(this);
			return this;
		}

		public int getHeight(BST_Node n){//BST_Node n){
			//BST_Node n;
			int h;
			if(n==null){
				return -1;
			} else
				h=Math.max(getHeight(n.left),getHeight(n.right));
			//System.out.println(h+1);
				return h+1;
						
			
		}
		  
		public String toString(){
			return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
		            +",Right: "+((this.right!=null)?right.data:"null");
		  }

		public void splay(BST_Node n){
			while(n.par!=null){
				BST_Node parent=n.par;
				BST_Node grand=parent.par;
				
				if(grand==null){
					if(parent.left==n){
						rotateL(n);
					}
					else{
						rotateR(n);
					}
				}
				else{
					if(grand.left==parent&&parent.left==n){
						rotateL(parent);
						rotateL(n);
					}
					else if(grand.right==parent&&parent.right==n){
						rotateR(parent);
						rotateR(n);
					}
					else if(grand.left==parent&&parent.right==n){
						rotateR(n);
						rotateL(n);
					}
					else if(grand.right==parent&&parent.left==n){
						rotateL(n);
						rotateR(n);
					}
				}
			}

			

		}
		public void rotateL(BST_Node n){//swapped the r and l 
			
			BST_Node parent = n.par; 
			BST_Node grand = parent.par; 
			
			parent.left = n.right;
			if (n.right != null) {
				n.right.par = parent; 
			}
			parent.par=n;
			n.right=parent;
			n.par = grand;
			if(grand!=null&&grand.right==parent)
				grand.right=n;
			else if(grand!=null&&grand.left==parent)
				grand.left=n;
			
		}
		public void rotateR(BST_Node n){
			BST_Node parent= n.par;
			BST_Node grand=parent.par;
			parent.right=n.left;
			if(n.left !=null){
				n.left.par=parent;
			}
			parent.par=n;
			n.left=parent;
			n.par=grand;
			if(grand!=null&&grand.right==parent)
				grand.right=n;
			else if(grand!=null&&grand.left==parent)
				grand.left=n;
			//n.par.right=n.left;
			//n.left=n.par;
			//return n;
//			BST_Node n1= n2.left;
//			n2.left=n1.right;
//			n1.right=n2;
//			//height stuff from book;
//			return n1;	
		}
}
////        SCAP CODE


//while(n.par!=null){
//BST_Node parent=n.par;
//BST_Node grand=parent.par;
//
//if(grand==null){
//	if(parent.left==n)
//		rotateL(n);
//	else
//		rotateR(n);
//}
//else{
//	if(grand.left==parent&&parent.left==n){
//		rotateR(n);
//		rotateR(n);
//	}
//	else if(grand.left==parent&&parent.right==n){
//		rotateL(n);
//		rotateR(n);
//	}
//	else if(grand.right==parent&&parent.right==n){
//		rotateL(n);
//		rotateL(n);
//	}
//	else{
//		rotateR(n);
//		rotateL(n);
//	}
//}
//}
//public boolean containsNode(String s){
//		if(data.equals(s))return true;
//		if(data.compareTo(s)>0){//s lexiconically less than data
//			if(left==null)return false;
//			return left.containsNode(s);
//		}
//		if(data.compareTo(s)<0){
//			if(right==null)return false;
//			return right.containsNode(s);
//		}
//		return false; //shouldn't hit
//	}
//	public boolean insertNode(String s){
//		if(data.compareTo(s)>0){
//			if(left==null){
//				left=new BST_Node(s);
//				return true;
//			}
//			return left.insertNode(s);
//		}
//		if(data.compareTo(s)<0){
//			if(right==null){
//				right=new BST_Node(s);
//				return true;
//			}
//			return right.insertNode(s);
//		}
//		return false;//ie we have a duplicate
//	}
//	public boolean removeNode(String s){
//		if(data==null)return false;
//		if(data.equals(s)){
//			if(left!=null){
//				data=left.findMax().data;
//				left.removeNode(data);
//				if(left.data==null)left=null;
//			}
//			else if(right!=null){
//				data=right.findMin().data;
//				right.removeNode(data);
//				if(right.data==null)right=null;
//			}
//			else data=null;
//			return true;
//		}
//		else if(data.compareTo(s)>0){
//			if(left==null)return false;
//			if(!left.removeNode(s))return false;
//			if(left.data==null)left=null;
//			return true;
//		}
//		else if(data.compareTo(s)<0){
//			if(right==null)return false;
//			if(!right.removeNode(s))return false;
//			if(right.data==null)right=null;
//			return true;
//		}
//		return false;
//	}
//	public BST_Node findMin(){
//		if(left!=null)return left.findMin();
//		return this;
//	}
//	public BST_Node findMax(){
//		if(right!=null)return right.findMax();
//		return this;
//	}
//	public int getHeight(){
//		int l=0;
//		int r=0;
//		if(left!=null)l+=left.getHeight()+1;
//		if(right!=null)r+=right.getHeight()+1;
//		return Integer.max(l, r);
//	}
//	public String toString(){
//		return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")+",Right: "+((this.right!=null)?right.data:"null");
//	}

//public void insertNode(BST_Node n, String s){
//int compare=s.compareTo(n.data);
//
//if(compare<0){
//	if(n.left!=null){
//		//par=this;
//		//System.out.print("---"+par.data);
//		insertNode(n.left,s);
//		//System.out.print(par.data);
//	}else{
//		par=this;
//		System.out.print("---"+par.data);
//		n.left=new BST_Node(s);
//	}
//}else if(compare>0){
//	if(n.right!=null){
//		//par=this;
//		//System.out.print("---"+par.data);
//		insertNode(n.right,s);
//	}
//	else{
//		par=this;
//		System.out.print("---"+par.data);
//		n.right=new BST_Node(s);
//	}
//}
//else{
//	
//}
//}



//public BST_Node removeNode(BST_Node n, String s){
//if(n==null)
//	return n;
//int compare=s.compareTo(n.data);
//if(compare<0){
//	n.left=removeNode(n.left,s);
//}else if(compare>0){
//	n.right=removeNode(n.right, s);
//}
//else if(n.left!=null&&n.right!=null){
//	n.data=findMin(n.right).getData();
//	n.right=removeNode(n.right,n.right.findMin(n.right).getData());
//	//n.right=null;
//}
//else{//System.out.println("Found node to remove");
//
//	//BST_Node blah;
//	if(n.left!=null){
//		n=n.left;
//		//n.left=null;
//		//blah=n.findMax(n);
//		//blah=null;
//	}
//	else{
//		n=n.right;
//		//blah=n.right.findMin(n);
//		//blah=null;
//		
//	}
//}
//return n;
//}
