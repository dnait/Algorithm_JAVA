/*46. Permutations
Given a collection of distinct numbers, return all possible permutations.
For example,
[1,2,3] have the following permutations:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        dfs(nums, 0, res);
        return res;
    }
    
    private void dfs(int[] nums, int index, List<List<Integer>> res) {
        //way1 is wrong: java8:List<Integer> path = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> path = new ArrayList<>();
        for(int x : nums) path.add(x);
        //way2 is wrong: List path = Arrays.asList(nums);  //[[[1,2,3]],[[1,2,3]],[[1,2,3]],[[1,2,3]],[[1,2,3]],[[1,2,3]]]
        if (index == nums.length) {
            res.add(path);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            dfs(nums, index + 1, res);
            swap(nums, i, index);
        }

    }
    private void swap(int[] nums, int a, int b) {
        if (a == b) return;
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

/*List myList = Arrays.asList(myArray);
System.out.println(myList.size());
}
} The output of the code will be: 
1 Why? 
The List created by asList is fixed-size 
The returned list by the asList method is fixed sized and it can not accommodate more items. 

example:

public class Test {
public static void main(String[] args) {
String[] myArray = { "Apple", "Banana", "Orange" };
List<String> myList = Arrays.asList(myArray);
myList.add("Guava");
}
} Will have the output: 
Exception in thread "main" java.lang.UnsupportedOperationException
at java.util.AbstractList.add(AbstractList.java:148)
at java.util.AbstractList.add(AbstractList.java:108)
at Test.main(Test.java:8) Because myList is fixed-sized an can't add more items to it. 
*/