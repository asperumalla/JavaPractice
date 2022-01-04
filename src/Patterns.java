import java.lang.reflect.Array;
import java.util.Arrays;

public class Patterns {

    public static void main(String[] args) {

       // System.out.println(  Integer.signum(1));
        // boolean isPresent = containsPattern(new int[]{-3,-1,-1,0,0,0,0,0,2},2,2);
        /*System.out.println(Arrays.asList(removeDuplicates(new int[]{
               1,1,2
                // -50,-50,-49,-48,-47,-47,-47,-46,-45,-43,-42,-41,-40,-40,-40,-40,-40,-40,-39,-38,-38,-38,-38,-37,-36,-35,-34,-34,-34,-33,-32,-31,-30,-28,-27,-26,-26,-26,-25,-25,-24,-24,-24,-22,-22,-21,-21,-21,-21,-21,-20,-19,-18,-18,-18,-17,-17,-17,-17,-17,-16,-16,-15,-14,-14,-14,-13,-13,-12,-12,-10,-10,-9,-8,-8,-7,-7,-6,-5,-4,-4,-4,-3,-1,1,2,2,3,4,5,6,6,7,8,8,9,9,10,10,10,11,11,12,12,13,13,13,14,14,14,15,16,17,17,18,20,21,22,22,22,23,23,25,26,28,29,29,29,30,31,31,32,33,34,34,34,36,36,37,37,38,38,38,39,40,40,40,41,42,42,43,43,44,44,45,45,45,46,47,47,47,47,48,49,49,49,50
        })));*/

       // replaceElements(new int[]{17,18,5,4,6,1});

     // moveZeroes(new int[]{0,1,0,3,12});

        removeElement(new int[]{1,3,2,4,2},2);

    }


    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index ++;
            }
        }
        Arrays.stream(nums).forEach(a -> System.out.print(a+","));

        System.out.println(index);
        return index;
    }


    public static void moveZeroes(int[] nums) {

        int n = 0;
        int z = 0;
        int i =0;

        while (n< nums.length && z < nums.length){

            if(  nums[n] != 0 && nums[z] ==0 && n>z){
                nums[z] = nums[n];
                nums[n]= 0;
            }

            while(z < nums.length  && nums[z++] == 0);
            while( n < nums.length && nums[n++] != 0);

        }

        Arrays.stream(nums).forEach(a -> System.out.print(a+","));
    }

    public static int[] replaceElements(int[] arr) {

        int max = arr[arr.length -1];
        arr[ arr.length -1 ] = -1;

        if( arr.length == 1) return arr;

        int temp = 0;

        for(int i =arr.length-2; i>-1 ; i--){
            temp = arr[i];
            arr[i] = max;
            if(max< temp){
                max = temp;
            }
        }

        Arrays.stream(arr).forEach(a -> System.out.print(a+","));
        return arr;
    }

    public static int[] removeDuplicates(int[] nums){

        int start = 0;
        int end = 1;
        while( end < nums.length){
            if(  nums[start]!=nums[end] ){
                start++;
                nums[start]=nums[end];
            }

            end++;
        }
        start++;
        Arrays.stream( nums ).forEach(h -> System.out.print(h+","));
        System.out.println(  start  );
        return nums;

/*        int lastIndex = nums.length -1;
        int current = 0;
        for(int i=0; i < lastIndex; i++){
            if( nums[i] == nums[i+1]){
                System.arraycopy(nums,i+1,nums,i, lastIndex-i);
                nums[lastIndex] = 0;
                lastIndex--;
                i--;
            }
        }

        Arrays.stream( nums ).forEach(h -> System.out.print(h+","));
        return nums; */

    }

    public static boolean containsPattern(int[] arr, int m, int k) {
        if( arr == null || arr.length <m) return false;
        int subCount = 0;
        for(int i =0; i<= arr.length-m; i++){

            for(int j=m+i;j<= arr.length-m; j+=m){
                int localCount = 0;
                for(int l=0;l< m; l++){
                    if(arr[i+l] == arr[j+l]){
                        localCount++;
                    }else break;
                }

                if(localCount == m) {
                    subCount++;
                }else{
                    break;
                }
            }

            if(subCount == k){
                return true;
            }else subCount = 0;

        }
        return false;
    }
}
