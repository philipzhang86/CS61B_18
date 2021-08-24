import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Example {
    public static void sort(Comparable[] a){
        System.out.println(Arrays.toString(a));
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(a[j], a[min])) min = j;//如果后面小于前面，后面作min
            }
            exch(a, i, min);//
            //assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }
    //问问大佬我的思路对不对，就是因为String implements comparable interface 也override了compareTo方法，所以就可以拿着那个Override
    //过的compareTo().来这里比较？为了用这个compareTO，所以我们就要将Comparable[] a 传进去我们的sort method?
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t =a[i];
        a[i]=a[j];
        a[j]=t;
    }

    private static void show(Comparable[] a){
        for(int i=0;i<a.length;i++){
            StdOut.print(a[i]+" ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a){
        for(int i=1;i< a.length;i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args)
    { // Read strings from standard input, sort them, and print.
        String[] a = {"z","k","b","a","j"};//{4,7,1,-1};//StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
