/*
 * @author js
 * @since 20160312
 * to show v2 strategy pattern using interface Comparator
 * run
 * javac -d classes/ -cp lib/aplu5.jar -sourcepath src/ src/com/sd/sort/v2/SorterMainV2.java 
 * java -cp classes/:lib/aplu5.jar com.sd.sort.v2.SorterMainV2
 * cases
 * 1) Integer
 * 2) String
 * 3) Turtle
 *      TurtleComparator did not implement java.util.Comparator
 *      see separately saved TurtleComparator.java
 * 4) 2014-10-05 DateComparator, ReverseComparator added
 *      To sort integers represented as strings in descending order, you could do:
 *      Arrays.sort(stringArray, new ReverseComparator(new StringIntegerComparator()));
> com.sd.sort.v2.Sorter s = new com.sd.sort.v2.Sorter()
> com.sd.sort.v2.Comparator stringComp = new com.sd.sort.v2.StringComparator()
> String[] B={"John", "Adam", "Skrien", "Smith", "Jones"};
> s.sort(B,stringComp)
> B
{ Adam, John, Jones, Skrien, Smith }
> Integer[] C = {new Integer(3), new Integer(1), new Integer(4), new Integer(2)};
> com.sd.sort.v2.Comparator integerComp=new com.sd.sort.v2.IntegerComparator();
> s.sort(C,integerComp)
> C
{ 1, 2, 3, 4 }
> java com.sd.sort.v2.SorterMainV2
B[0]=Adam
B[1]=John
B[2]=Jones
B[3]=Skrien
B[4]=Smith
C[0]=1
C[1]=2
C[2]=3
C[3]=4
  *
  */

package com.sd.sort.v2;

public class SorterMainV2 {
    public static void main(String[] args) {
        String[] B={"John", "Adam", "Skrien", "Smith", "Jones"};
        Comparator stringComp=new StringComparator(); //웬만하면 상위클래스를 사용(다형적으로쓰기쉬움)
        Sorter.sort(B, stringComp);

        Integer[] C = {new Integer(3), new Integer(1), new Integer(4), new Integer(2)}; //Array
        Comparator integerComp=new IntegerComparator();
        Sorter.sort(C, integerComp);

        for(int i=0; i<B.length; i++)
            System.out.println("B["+i+"]="+B[i]);
        for(int i=0; i<C.length; i++)
            System.out.println("C["+i+"]="+C[i]);
    }
}

class Sorter {
  public Sorter() {}
    public static void sort(Object[] data, Comparator comp) {
        for(int i=data.length-1; i>=1; i--) {
            int indexOfMax=0;
            for(int j=1; j<=i; j++) {
                if(comp.compare(data[j], data[indexOfMax]) > 0) //이부분이 하이라이트이다
                    indexOfMax=j;
                }
                Object temp=data[i];
                data[i]=data[indexOfMax];
                data[indexOfMax]=temp;
        }
    }
}

// declare my own, also possible to use java.util.Comparator
interface Comparator {
    public int compare(Object o1, Object o2);
    public boolean equals(Object o);
}

class IntegerComparator implements Comparator {
    public IntegerComparator() {}
    public int compare(Object o1, Object o2) {
        return (Integer)o1 - (Integer)o2;
    }
}

class StringComparator implements Comparator {
    public StringComparator() {}
    public int compare(Object o1, Object o2) {
        String s1=(String)o1;
        String s2=(String)o2;
        return s1.compareTo(s2);
        //return Integer.parseInt((String) o1) -
        //   Integer.parseInt((String) o2);
    }
}

