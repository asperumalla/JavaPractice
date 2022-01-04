public class SortedArrayToBTree {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};

        //List.of
        TreeNode root = addToTree( array, 0, array.length-1);
        TreeNode node = root;
        while( node != null){
            System.out.println( node.value );
            node = node.right;
        }
    }

    private static TreeNode addToTree(int[] array, int start, int end) {

        if(end < start) return null;
        int middle = start + (end - start)/2;
        TreeNode root = new TreeNode(array[middle],null,null);
        root.left = addToTree(array,start,middle-1);
        root.right = addToTree(array,middle+1,end);
        return root;
    }
}
