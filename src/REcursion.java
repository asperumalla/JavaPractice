import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class REcursion {

    public static void main(String[] args) {

        TreeNode left = new TreeNode(1,null,null);
        TreeNode right = new TreeNode(5,null,null);
        TreeNode root = new TreeNode(3,left,right);

        bfs(root);

    }

    private static void bfs(TreeNode root) {
        if(root == null ) return;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add( root );

        while( !queue.isEmpty()){

            // Get the size of the queue
            int qSize = queue.size();
            List<Integer> buffer= new ArrayList<>(qSize);
            for( int i=0; i< qSize; i++  ){
                TreeNode node = queue.poll();
                buffer.add(node.value);

                if( node.left != null){
                    queue.add(node.left);
                }

                if( node.right != null){
                    queue.add(node.right);
                }
            }
            System.out.println(buffer);
        }


    }

    /*  check for bit wise operations

        int holder = 0;
        int a = 10;
        int b = 20;
        holder |= 1<<a;
        holder |= 1<<b;

        System.out.println(holder & (1<<10) );
     */


}


class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value, TreeNode left,TreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;

    }
}
