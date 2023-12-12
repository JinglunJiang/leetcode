/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> flatten;
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        flatten = new ArrayList<>();
        index = 0;
        flatten = flatten(nestedList);
    }

    private List<Integer> flatten(List<NestedInteger> nestedList){
        List<Integer> result = new ArrayList<>();
        for (NestedInteger ni: nestedList){
            if (ni.isInteger()){
                result.add(ni.getInteger());
            }
            else{
                result.addAll(flatten(ni.getList()));
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        int result = flatten.get(index);
        index++;
        return result;
    }

    @Override
    public boolean hasNext() {
        if (index < flatten.size()){
            return true;
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */