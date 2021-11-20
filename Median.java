package web.WEB_INF;

import java.util.*;

//find median in array&sort that array
public class Median {
    public static void main(String[] args) {}
    public static Integer median(Integer[] array){
        Arrays.sort(array);
        if(array.length%2!=0){return array[array.length/2];}
        else{return (array[array.length/2]+array[array.length/2-1])/2;}}
    public static Integer[] sort(Integer[] array){
        int median = median(array);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        Collections.sort(list,
                Comparator.comparing((obj->{
                    if(Math.abs((Integer)obj-median)==Math.abs((Integer)obj-median)){
                        Comparator<Integer> comp = new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return o1-o2;}
                        };}
                    return Math.abs(obj-median);
                })));
        Integer [] ar = new Integer [list.size()];
        for(int i = 0; i<list.size(); i++){
            ar[i]=list.get(i);}
        return ar;}}

