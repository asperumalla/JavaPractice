import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Practise {

    public static void main(String[] args) {

        String s = "Alpha";

        String sarray[] = new String[2];
        // Empty array
        String sarray1[] = new String[]{};
        // single value array
        String sarray22[] = new String[]{"Alpha"};
        System.out.println("size fo {} array :"+sarray1.length);

        //List intlist  = Arrays.asList(   {1,2,3,4}   ); // this will not work as there is no initialization
        //List stringlist  = Arrays.asList(   {"Alpha","Sovereign"}   );// this is even not working
        List intlist  = Arrays.asList(  new Integer[] {1,2,3,4}   );
        intlist.stream().forEach(System.out::println);

        Arrays.stream(  new int[]{1,2,3,4,5} ).forEach(System.out::println);
        IntStream.range(0,11).forEach(System.out::println);


        List stringlist  = Arrays.asList(   new String[]{"Alpha","Sovereign"}   ); // This will work


        String[] a2darray = {"alpha","elsiha"};

        Stream.of(a2darray).forEach(System.out::println);

        print( new String[]{"alpha", "sovereign"} );

    }

    private static void print(String[] ss) {

        Collections.sort( Arrays.asList(ss), (a,b) -> b.compareTo(a)  );

        Arrays.stream(ss).forEach(System.out::println);


        List<String> s1 =  Arrays.asList(new String[]{"alpha","sovereign"});
        List s2 =  new ArrayList(s1);

        System.out.println(  s1 == s2 );
        System.out.println(  s1.equals(s2) );

        Collections.sort( s1, (c,d) ->  d.compareTo(c) );

Stream.of(s1).forEach(System.out::println);
        Stream.of(s2).forEach(System.out::println);
    }

}

