
public class BinaryListSearcher implements  ListSearcher {

    private final Comparator _comparator;

    public BinaryListSearcher(Comparator comparator)
    { _comparator = comparator; }

    public int search(String[] list, String value) {
        int lower = 0;
        int upper = list.length - 1;
        int index=0,cmp=0;
        while (lower <= upper &&
                (cmp = _comparator.compare(value, list[index=(lower + upper)/2]))!=0)
            if (cmp < 0) upper = index - 1;
            else lower = index + 1;
        return lower<=upper && cmp==0 ? index : -(lower+1);
    }

}
