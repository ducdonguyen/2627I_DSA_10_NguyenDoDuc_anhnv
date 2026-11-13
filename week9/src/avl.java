//AVL

import java.util.*;

class Node2 {
  int val;
  int ht;
  Node2 left;
  Node2 right;

  static Node2 newNode2(int data) {
    Node2 temp = new Node2();
    temp.val = data;
    temp.left = null;
    temp.right = null;
    return temp;
  }


  static int ht_hidden(Node2 T)
  {
    int lh, rh;
    if (T == null)
    {
      return(0);
    }
    if (T.left == null)
    {
      lh = 0;
    }
    else
    {
      lh = 1 + T.left.ht;
    }
    if (T.right == null)
    {
      rh = 0;
    }
    else
    {
      rh = 1 + T.right.ht;
    }
    if (lh > rh)
    {
      return(lh);
    }
    return(rh);
  }
  static Node2 rotate_right_hidden(Node2 x)
  {
    Node2 y;
    y = x.left;
    x.left = y.right;
    y.right = x;
    x.ht = ht_hidden(x);
    y.ht = ht_hidden(y);
    return(y);
  }
  static Node2  rotate_left_hidden(Node2 x)
  {
    Node2 y;
    y = x.right;
    x.right = y.left;
    y.left = x;
    x.ht = ht_hidden(x);
    y.ht = ht_hidden(y);
    return(y);
  }
  static Node2 RR_hidden(Node2 T)
  {
    T = rotate_left_hidden(T);
    return(T);
  }
  static Node2 LL_hidden(Node2 T)
  {
    T = rotate_right_hidden(T);
    return(T);
  }
  static Node2 LR_hidden(Node2 T)
  {
    T.left = rotate_left_hidden(T.left);
    T = rotate_right_hidden(T);
    return(T);
  }
  static Node2 RL_hidden(Node2 T)
  {
    T.right = rotate_right_hidden(T.right);
    T = rotate_left_hidden(T);
    return(T);
  }
  static int BF_hidden(Node2 T)
  {
    int lh, rh;
    if (T == null)
    {
      return(0);
    }
    if (T.left == null)
    {
      lh = 0;
    }
    else
    {
      lh = 1 + T.left.ht;
    }
    if (T.right == null)
    {
      rh = 0;
    }
    else
    {
      rh = 1 + T.right.ht;
    }
    return(lh - rh);
  }
  static void inorder_hidden(Node2 T)
  {
    if (T != null)
    {
      inorder_hidden(T.left);
      // printf("%d(BF=%d) ", T->val, BF_hidden(T));
      System.out.print(T.val+"(BF="+BF_hidden(T)+") ");
      inorder_hidden(T.right);
    }
  }

  static void preorder_hidden(Node2 T)
  {
    if (T != null)
    {
      System.out.print(T.val+"(BF="+BF_hidden(T)+") ");
      preorder_hidden(T.left);
      preorder_hidden(T.right);
    }
  }



  static Node2 hiddenInsert(Node2 T,int x)
  {
    if (T == null)
    {
      T = newNode2(x);
    }
    else if (x > T.val)
    {
      T.right = hiddenInsert(T.right, x);
      if (BF_hidden(T) == -2)
      {
        if (x > T.right.val)
        {
          T = RR_hidden(T);
        }
        else
        {
          T = RL_hidden(T);
        }
      }
    }
    else if (x < T.val)
    {
      T.left = hiddenInsert(T.left, x);
      if (BF_hidden(T) == 2){
        if (x < T.left.val)
        {
          T = LL_hidden(T);
        }
        else
        {
          T = LR_hidden(T);
        }
      }
    }
    T.ht = ht_hidden(T);
    return(T);
  }

	/* Class node is defined as :
    class Node2 
    	int val;	//Value
    	int ht;		//Height
    	Node2 left;	//Left child
    	Node2 right;	//Right child

	*/

  static Node2 insert(Node2 root, int val) {
    if (root == null) {
      return Node2.newNode2(val);
    }

    if (val < root.val) {
      root.left = insert(root.left, val);

      if (BF_hidden(root) == 2) {
        if (val < root.left.val) {
          root = LL_hidden(root);
        } else {
          root = LR_hidden(root);
        }
      }
    } else if (val > root.val) {
      root.right = insert(root.right, val);

      if (BF_hidden(root) == -2) {
        if (val > root.right.val) {
          root = RR_hidden(root);
        } else {
          root = RL_hidden(root);
        }
      }
    }

    root.ht = ht_hidden(root);
    return root;
  }


}

public class avl {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    int n;
    Scanner in = new Scanner(System.in);
    n=in.nextInt();


    Node2 root=null;

    for(int i=0;i<n;i++)
    {
      int val;
      val=in.nextInt();
      root=root.hiddenInsert(root,val);
    }
    int nv;
    nv=in.nextInt();
    root=root.insert(root,nv);
    Node2.inorder_hidden(root);
    System.out.println("");
    Node2.preorder_hidden(root);
    System.out.println("");
  }
}