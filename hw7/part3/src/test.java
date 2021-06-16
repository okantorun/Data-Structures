import java.util.ArrayList;
import java.util.Random;

public class test {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void BSTTest(int size) {
		Random rand = new Random();
        long startTime = 0, endTime = 0, time = 0;
        BinarySearchTree<Integer> BST=new BinarySearchTree<>();
        int[] randomGenerateNumbers = rand.ints(0, 2000000).distinct().limit(size+100).toArray();
        long avgTime=0;
        System.out.println("-------Adding "+100+" randomly numbers to "+size+" BST--------");
		for(int i=0;i<10;i++) {
			BST=new BinarySearchTree();
            for(int j=0;j<size;j++){
                BST.add(randomGenerateNumbers[j]);
            }
            startTime = System.nanoTime();
            for(int k=size;k<size+100;k++) {
            	BST.add(randomGenerateNumbers[k]);
            }
            endTime = System.nanoTime();
            time = endTime - startTime;
            avgTime+=time;
		}
		System.out.println("Avg Time: "+avgTime/10);
		avgTime=0;		
		
	}
	public void BTreeTest(int size) {
		Random rand = new Random();
        long startTime = 0, endTime = 0, time = 0;
        BTree<Integer> BTreeObj=new BTree<>(3);
        int[] randomGenerateNumbers = rand.ints(0, 2000000).distinct().limit(size+100).toArray();
        long avgTime=0;
        System.out.println("-------Adding "+100+" randomly numbers to "+size+" BTree--------");
		for(int i=0;i<10;i++) {
			BTreeObj=new BTree<>(3);
            for(int j=0;j<size;j++){
                BTreeObj.add(randomGenerateNumbers[j]);
            }
            startTime = System.nanoTime();
            for(int k=size;k<size+100;k++) {
            	BTreeObj.add(randomGenerateNumbers[k]);
            }
            endTime = System.nanoTime();
            time = endTime - startTime;
            avgTime+=time;
		}
		System.out.println("Avg Time: "+avgTime/10);
		avgTime=0;		
		
	}
	public void RedBlackTest(int size) {
		Random rand = new Random();
        long startTime = 0, endTime = 0, time = 0;
        RedBlackTree<Integer> RBtree=new RedBlackTree<>();
        int[] randomGenerateNumbers = rand.ints(0, 2000000).distinct().limit(size+100).toArray();
        long avgTime=0;
        System.out.println("-------Adding "+100+" randomly numbers to "+size+" RedBlackTree--------");
		for(int i=0;i<10;i++) {
			RBtree=new RedBlackTree<>();
            for(int j=0;j<size;j++){
                RBtree.add(randomGenerateNumbers[j]);
            }
            startTime = System.nanoTime();
            for(int k=size;k<size+100;k++) {
            	RBtree.add(randomGenerateNumbers[k]);
            }
            endTime = System.nanoTime();
            time = endTime - startTime;
            avgTime+=time;
		}
		System.out.println("Avg Time: "+avgTime/10);
		avgTime=0;		
		
	}
	public void SkipListTest(int size) {
		Random rand = new Random();
        long startTime = 0, endTime = 0, time = 0;
        SkipList<Integer> skipList=new SkipList<>();
        int[] randomGenerateNumbers = rand.ints(0, 2000000).distinct().limit(size+100).toArray();
        long avgTime=0;
        System.out.println("-------Adding "+100+" randomly numbers to "+size+" SkipList--------");
		for(int i=0;i<10;i++) {
			skipList=new SkipList<>();
            for(int j=0;j<size;j++){
                skipList.add(randomGenerateNumbers[j]);
            }
            startTime = System.nanoTime();
            for(int k=size;k<size+100;k++) {
            	skipList.add(randomGenerateNumbers[k]);
            }
            endTime = System.nanoTime();
            time = endTime - startTime;
            avgTime+=time;
		}
		System.out.println("Avg Time: "+avgTime/10);
		avgTime=0;		
		
	}
	public void TwoThreeTreeTest(int size) {
		Random rand = new Random();
        long startTime = 0, endTime = 0, time = 0;
        TwoThreeTree<Integer> twoThreeTree=new TwoThreeTree<>();
        int[] randomGenerateNumbers = rand.ints(0, 2000000).distinct().limit(size+100).toArray();
        long avgTime=0;
        System.out.println("-------Adding "+100+" randomly numbers to "+size+" TwoThreeTree--------");
		for(int i=0;i<10;i++) {
			twoThreeTree=new TwoThreeTree<>();
            for(int j=0;j<size;j++){
                twoThreeTree.add(randomGenerateNumbers[i]);
            }
            startTime = System.nanoTime();
            for(int k=size;k<size+100;k++) {
            	twoThreeTree.add(randomGenerateNumbers[k]);
            }
            endTime = System.nanoTime();
            time = endTime - startTime;
            avgTime+=time;
		}
		System.out.println("Avg Time: "+avgTime/10);
		avgTime=0;		
		
	}


      
}
