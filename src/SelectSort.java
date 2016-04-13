
public class SelectSort implements ListSorter {
    private final Comparator _comparator;

    public SelectSort(Comparator comparator)  { _comparator = comparator; }

    public String[] sort(String[] list) {
        int size = list.length;
        for (int slot = 0; slot < size - 1; ++slot) {
            int smallest = slot;
            for (int check = slot + 1; check < size; ++check)
                if (_comparator.compare(list[check], list[smallest]) < 0)
                    smallest = check;
            swap(list, smallest, slot);
        }
        return list;
    }
    private void swap(String[] list, int left, int right) {
        if (left != right) {
            String temp = list[left];
            list[left]= list[right];
            list[right] = temp;
        }
    }
}
