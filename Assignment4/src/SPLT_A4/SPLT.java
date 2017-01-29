package SPLT_A4;


public class SPLT implements SPLT_Interface {
	private BST_Node root;
	  private int size;
	  
	  public SPLT() {
	    this.size = 0;
	  }

	  public void insert(String s){
		  //root.splay(root);
			if (root==null){
				root=new BST_Node(s);
				//if(root.par!=null);
				//root.splay(root);
				size++;
				//return true;
//			}
//			else if(contains(s)){
//				if(root.par!=null)
//					root.splay(root);
				//return false;
			}//root.splay(root);
			else{
				if(root.insertNode(s)){
					size++;
				}
				while(root.par!=null)
					root=root.par;
			}
//			if(root.insertNode(s) == null){
//				while(root.par!=null){
//					root=root.par;
//				}size++;
//			}
//			else{
//				while(root.par!=null)
//					root=root.par;
//				//root.insertNode(s);//root.insertNode(root, s);
//				
//				//size++;
//				//root.splay(root);
//				//if(root.par!=null)
//					//root.splay(root.insertNode(s));
//				//return true;
//			}
			
		}


		public void remove(String s){
			if(root==null)
				return;
			if(this.contains(s)==true){
				BST_Node rootL=root.left;
				BST_Node rootR=root.right;
			
				if(rootL==null && rootR==null)
					root=null;
				else if(rootL!=null){
					rootL.par=null;
					
					BST_Node neo=rootL.findMax();
					neo.right=rootR;
					if(rootR!=null)
						rootR.par=neo;
					this.root=neo;
				}else if(rootR!=null){
					rootR.par=null;
					this.root=rootR;
				}size--;
			}return;
		}
//		public void remove(String s){
//			if(empty())
//				return;
//			//size--;
//			if(contains(s)){
//				//size--;
//				BST_Node rootL=root.left;
//				BST_Node rootR=root.right;
////				if(size==1){
////					root=null;
//				if(rootL!=null){
//					//size--;
//					//rootL.par=null;
//					
//					/*root=rootL;
//					
//					rootL.findMax().right=rootR; */
//					
//					BST_Node L = rootL.findMax();
//					L.right = rootR;
//					
//					
//					if(rootR!=null)
//						//rootR.par=rootL;
//						rootR.par = L; 
//					/*if(rootL.par==null)
//						root=rootL;
//					else
//						while(root.par!=null)
//							root=root.par; */
//					this.root = L;
//				}else if(rootR!=null){
//					//size--;
//					rootR.par=null;
//					rootR.findMin().left=rootL;
//					if(rootR.par==null)
//						root=rootR;
//					else
//						while(root.par!=null)
//							root=root.par;
//					//size--;
//				}else root=null;
//				//size--;
//			}
//			size--;
//		}
				
//			}
//			//BST_Node n= root;
//			if(empty()||contains(s)==false){
//				//return false;
//				}
//			else if(size==1){
//					root=null;
//					size--;
//					//return true;
//				}
//			else{
//				root.removeNode(root, s);
//				size--;
//				//return true;
//			}
//			//return false;
//			}


		@Override
		public String findMin() {
			//BST_Node n=root;
			//BST_Node n=null;
			if (empty())
				return null;
			else{
			//root=root.findMin(root);
				root.findMin();
				while(root.par!=null)
					root=root.par;
			}
				return root.getData();
				
			
		}


		@Override
		public String findMax() {
			//BST_Node nR=root;
			//BST_Node nR=null;
			if(empty()){
				return null;
			}else{
			//root=root.findMax(root);
				root.findMax();
				while(root.par!=null)
					root=root.par;
			}
			return root.getData();
			
		}


		@Override
		public boolean empty() {
			// TODO Auto-generated method stub
			if(root==null){
				return true;
			}
			else
			return size==0;
		}

		@Override
		public boolean contains(String s) {
			boolean oye;
			if (empty())
				return false;
			else{
				if(root.containsNode(s)==false){
					oye=false;
				}
				else{
					oye=true;
				}
			}
			while(root.par!=null){
				root=root.par;
			}
			return oye;
//		//BST_Node n=root;
//			if(empty())
//				return false;
//			else{
//				oye=root.containsNode(s);
//				while(root.par!=null){
//					root=root.par;
//				}
//				return oye;
//			}
			//return true;
//			n.containsNode(n,s);
//			if(n.par!=null)
//				n.splay(n);
//			return n.containsNode(n, s);
		}


		@Override
		public int size() {
			// TODO Auto-generated method stub
			return size;
		}

		@Override
		public int height() {
			BST_Node n=root;
			return n.getHeight(n);
			// TODO Auto-generated method stub
			//return 0;
		}


		@Override
		  //used for testing, please leave as is
		  public BST_Node getRoot(){ return root; }

//	@Override
//	public void insert(String s) {
//		// TODO Auto-generated method stub
//		if(root==null){
//			root=new BST_Node(s);
//			size++;
//			//return true;
//		}
//		if(root.insertNode(s)){
//			size++;
//			//return true;
//		}
//		//return false;
//
//	}
//
//	@Override
//	public void remove(String s) {
//		// TODO Auto-generated method stub
//		if(root==null)//return false;
//		if(size==1&&root.data.equals(s)){
//			root=null;
//			size--;
//			//return true;
//		}
//		if(root.removeNode(s)){
//			size--;
//			//return true;
//		}
//		//return false;
//
//	}
//
//	@Override
//	public String findMin() {
//		// TODO Auto-generated method stub
//		if(root==null)return null;
//		return root.findMin().data;
//		//return null;
//	}
//
//	@Override
//	public String findMax() {
//		// TODO Auto-generated method stub
//		if(root==null)return null;
//		return root.findMax().data;
//		//return null;
//	}
//
//	@Override
//	public boolean empty() {
//		// TODO Auto-generated method stub
//		//return false;
//		return size==0;
//	}
//
//	@Override
//	public boolean contains(String s) {
//		// TODO Auto-generated method stub
//		//return root;
//		//return false;
//		if(empty())return false;
//		return root.containsNode(s);
//	}
//
//	@Override
//	public int size() {
//		// TODO Auto-generated method stub
//		return size;
//	}
//
//	@Override
//	public int height() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public BST_Node getRoot() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
