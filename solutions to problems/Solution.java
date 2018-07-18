	public static int getHeight(Node root){
      //Write your code here   /////////////////////Recursive fuction because left and right also binary trees
        //int height =0;
        if(root == null){
            //height = 0;
            return 0;
        }
        else if (root.left == null ){
            return getHeight(root.right);
        }
        else if (root.right ==null){
            return getHeight(root.left);
        }
        else if (root.right.right != null || root.right.left != null){
            return (1+ getHeight(root.right.right != null? root.right.right : root.right.right));
        }
        else if (root.left.right != null || root.left.left != null){
            return (1+ getHeight(root.left.right != null? root.left.right : root.left.right));
        }
        
        /*
        if (root.left.left == null && root.left.right == null){
            if (root.right.left == null && root.right.right == null){
            height += 1;
            return height;
            }
            else{
                return (getHeight(root.right));
            }
        }
        if (root.right.left == null && root.right.right == null){
            if (root.left.left == null && root.left.right == null){
            height += 1;
            return height;
            }
            else{
                return (getHeight(root.left));
            }
        }  */
        //return height;
    }