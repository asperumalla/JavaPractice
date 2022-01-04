import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayDelete {


    private static void removeDuplicateElement (int[] nums, int val) {

        int lastValidIndex = nums.length - 1;
        // check for each element, if number is found, then reduce the size
        for(int i =lastValidIndex; i > -1; i--){
            if( nums[i] == val){
                nums[i] = nums[lastValidIndex];
                lastValidIndex--;
            }
        }
       Arrays.stream(nums).forEach(System.out::println);
    }

    public static void main (String[] args) {
       // removeDuplicateElement(new int[]{1,2,3,4,2,2,5,2,6},2);
       // removeDupinSorted(new int[]{3,3,4,4,4,5,6,7,7});
        find2X(  new int[]{5,3,4} );

    }

    public static void removeDupinSorted(int[] dups){

        // SOLUTION: make a note of all unique values
        // When a unique value is encountered,
        // move one step for unic pointer and assing the new value
        int latestUnicPointer = 0;
        for(int movingPointr = 1; movingPointr < dups.length; movingPointr++ ){

            if( dups[latestUnicPointer] != dups[movingPointr] ){
                latestUnicPointer++;
                dups[latestUnicPointer]= dups[movingPointr];
            }
        }

        Arrays.stream(dups).forEach(System.out::println);
    }

    public static void find2X(int[] a ){
    }


}
