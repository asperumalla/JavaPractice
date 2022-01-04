
import java.util.HashMap;
import java.util.Map;

public class UniqueCharsCount {

    public static void main(String[] args) {
        int count = lengthOfLongestSubstring("qwerty");
        System.out.println( count );
    }
    public static int lengthOfLongestSubstring(String st) {
        //your implementation here

        if(  st == null || st.isEmpty()){
            return 0;
        }
        /*else if(st.length() == 1){
            return 1;
        }*/

        char s[] = st.toCharArray();
        Map<Character,Integer> duplicates = new HashMap<>();

        int  maxcount = 0;
        int startPoiner = 0;
        int movingPointer = 1;
        int localCount = 1;
        duplicates.put( s[startPoiner], 1  );// making the first char visisted

        while(  movingPointer < s.length  &&
                //if the max count is greater than the length of the remaining new chars, then stop the loop
                ((s.length) - startPoiner) > maxcount  ){

            //Integer count = duplicates.get( s[movingPointer]) ;
            boolean isCharVisited = duplicates.get( s[movingPointer]) == null? false:true ;

            //if(count != null && count >0){
            if(isCharVisited){
                startPoiner++;
                movingPointer =  startPoiner + 1;
                maxcount = Math.max(maxcount, localCount); // as we would loose the count, collect the max count value
                localCount = 1; //reset the counter value
                duplicates.clear(); // clear all visited chars
                duplicates.put( s[startPoiner], 1  ); // as this is the first visited char, make it visited
            }else{
                if(!isCharVisited){
                    duplicates.put( s[movingPointer], 1  ); // make the char visited
                }/*else{
                    duplicates.put( s[movingPointer], ++count  );
                }*/
                localCount++; // as we came accross unique char, increment the count
                movingPointer++;
            }
        }

        return Math.max(maxcount, localCount);
    }
}
