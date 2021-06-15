import java.util.LinkedList;

public class InsertionSort {
    /**
     * Sort the table using insertion sort algorithm.
     * pre: table contains Comparable objects.
     * post: table is sorted.
     * @param table The array to be sorted.
     */
    public static <T extends Comparable<T>> void sort(LinkedList<Product> table){
        for(int nextPos=1;nextPos<table.size();nextPos++){
            insert(table,nextPos);
        }
    }
    /**
     * Insert the element aat nextPos where it belongs in the arrays
     * pre: table[0 . . . nextPos - 1] is sorted.
     * post: table[0 . . . nextPos] is sorted.
     * @param table The array being sorted
     * @param nextPos The position of the element to insert
     */
    private static <T extends Comparable<T>> void insert(LinkedList<Product> table,int nextPos){
        Product nextVal = table.get(nextPos);
        float disAmount=nextVal.getDiscountedPrice()*100/nextVal.getPrice();
        float disAmount2=table.get(nextPos-1).getDiscountedPrice()*100/table.get(nextPos-1).getPrice();
        while(nextPos > 0 && disAmount<disAmount2){
        	table.set(nextPos, table.get(nextPos-1));       	
            nextPos--;
            if(nextPos>0) {
            	disAmount=nextVal.getDiscountedPrice()*100/nextVal.getPrice();
                disAmount2=table.get(nextPos-1).getDiscountedPrice()*100/table.get(nextPos-1).getPrice();
            }
           
        }
        table.set(nextPos, nextVal);

    }
}