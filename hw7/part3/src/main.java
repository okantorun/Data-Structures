
public class main {

	public static void main(String[] args) {
		test testObj=new test();
		System.out.println("---------------------For 10K------------------------");
		testObj.BSTTest(10000);
		testObj.BTreeTest(10000);
		testObj.RedBlackTest(10000);
		testObj.SkipListTest(10000);
		testObj.TwoThreeTreeTest(10000);
		System.out.println("---------------------For 20K------------------------");
		testObj.BSTTest(20000);
		testObj.BTreeTest(20000);
		testObj.RedBlackTest(20000);
		testObj.SkipListTest(20000);
		testObj.TwoThreeTreeTest(20000);
		System.out.println("---------------------For 40K------------------------");
		testObj.BSTTest(40000);
		testObj.BTreeTest(40000);
		testObj.RedBlackTest(40000);
		testObj.SkipListTest(40000);
		testObj.TwoThreeTreeTest(40000);
		System.out.println("---------------------For 80K------------------------");
		testObj.BSTTest(80000);
		testObj.BTreeTest(80000);
		testObj.RedBlackTest(80000);
		testObj.SkipListTest(80000);
		testObj.TwoThreeTreeTest(80000);

	}

}
