import java.lang.reflect.Array;
import java.util.*;

public class PathSumII {

    public static void main(String[] args) {

        int aa[] = new int[]{1,2,3,4,5,6,7};
        int bb[] = Arrays.copyOfRange(aa,2,5);

        TreeNode l7 = new TreeNode(7,null,null);
        TreeNode r2 = new TreeNode(2,null,null);
        TreeNode l5 = new TreeNode(5,null,null);
        TreeNode r1 = new TreeNode(6,null,null);
        TreeNode l13 = new TreeNode(13,null,null);

        TreeNode r4 = new TreeNode(3,l5,r1);
        TreeNode r8 = new TreeNode(8,l13,r4);

        TreeNode l11 = new TreeNode(11,l7,r2);

        TreeNode left = new TreeNode(4,l11,null);

        TreeNode root = new TreeNode(5,left, r8);

        Stack<Integer> slate = new Stack<>();
        dfs(root,22,slate);

        System.out.println(bag);
    }

    static List<List<Integer>> bag = new ArrayList<>();
    public static void dfs(TreeNode node, int target, Stack<Integer> slate){

        //Base case
        if(node.left == null && node.right == null){
            if( node.value == target){
                slate.add(node.value);
                bag.add(new ArrayList<>(slate));
                slate.pop();
            }
            return;
        }

        slate.add(node.value);
        Optional.ofNullable(node.left).ifPresent( child -> dfs( child , target -  node.value,slate ) );
        Optional.ofNullable(node.right).ifPresent( child -> dfs( child , target -  node.value,slate ) );
        slate.pop();
        // recursion
        /*if(node.left != null){
            dfs(node.left, target -  node.value,slate );
        }
        if(node.right != null){
            dfs(node.right, target -  node.value,slate );
        }*/
        //slate.pop();

    }

}



