import java.util.Arrays;


/**********
 *  Lear how to flatten Integer/ int 2D array
 */
public class MeetingRoom {

    public static void main (String[] args) {

        int a[][] = {
                {0,30},
                {5,10},
                {15,20}
        };

        Arrays.stream(a).flatMapToInt(Arrays::stream ).forEach(System.out::println);

    }
}
