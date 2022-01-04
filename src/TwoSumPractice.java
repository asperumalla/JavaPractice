import java.util.*;
import java.util.stream.Collectors;

public class TwoSumPractice {


    public static void main (String[] args) {
        //removeAnagrams(new String[]{});
    }

    public static void sum2(int[] a, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i< a.length ; i++){
            int val = Optional.ofNullable(map.get(  a[i])).map( x -> x +1).orElse( 1    ) ;
            map.put(a[i], val );
        }


    }

    private static boolean isAnagram (String code, String deco) {

        if( code.length() != deco.length()) return false;

        Map<Character,Integer> charCount = new HashMap<>();
        for( int i=0; i< code.length(); i++  ){
            Integer count = charCount.get(code.charAt(i)) == null? 1: charCount.get(code.charAt(i)) +1;
            charCount.put(  code.charAt(i), count );
        }

        for( int i=0; i< code.length() ; i++){
            Integer count = charCount.get(deco.charAt(i)) == null? null : charCount.get(deco.charAt(i)) -1;
            if( count == null || count == -1 )
                return false;
            charCount.put(deco.charAt(i),count);
        }


        return true;
    }

}
