public class TeeHeight {

    public static void main(String[] args) {

        TreeNode left1 = new TreeNode(1,null,null);
        TreeNode right1 = new TreeNode(5,null,left1);
        TreeNode left = new TreeNode(1,right1,null);
        TreeNode right = new TreeNode(5,null,null);
        TreeNode root = new TreeNode(3,left,right);

        System.out.println(maxHeight(root));

    }


    public static int maxHeight(TreeNode root){

            if ( root == null) return -1;

            // The height is always 1 more than its subtree
            int leftHeight =  maxHeight(root.left);
            int rightHeight = maxHeight(root.right);

            return 1 + Math.max(  leftHeight,rightHeight);

    }
}

