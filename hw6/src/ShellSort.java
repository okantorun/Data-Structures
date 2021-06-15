import java.util.LinkedList;

public class ShellSort {
    /**
     * Sort the table using Shell sort algorithm.
     * pre: table contains Comparable objects.
     * post: table is sorted.
     * @param table The array to be sorted
     */
    public static <T extends Comparable<T>> void sort(LinkedList<Product> table){
        int gap = table.size() / 2;
        while (gap > 0){
            for(int nextPos=gap;nextPos<table.size();nextPos++){
                insert(table,nextPos,gap);
            }
            if(gap == 2)
                gap = 1;
            else
                gap = (int) (gap/2.2);
        }
    }
    /**
     * Insert element ar nextPos where it belongs in array.
     * pre: Elements though nextPos - gap in subarray are sorted.
     * post: Elements though nextPos in subarray are sorted.
     * @param table The array being sorted
     * @param nextPos The position of the element to insert
     * @param gap The gap between elements in the subarray
     */
    private static <T extends Comparable<T>> void insert(LinkedList<Product> table,int nextPos,int gap){
        Product nextVal = table.get(nextPos);
        while((nextPos > gap - 1) && (nextVal.getDiscountedPrice() >table.get(nextPos-gap).getDiscountedPrice())){
        	table.set(nextPos, table.get(nextPos-gap));
            nextPos -= gap;
        }
        table.set(nextPos, nextVal);
    }
}