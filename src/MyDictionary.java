import java.io.PrintWriter;

public class MyDictionary implements Dicitionary {

    public String[] dictionary;
    public String[] helper;
    int dictSize, helpSize;

    public MyDictionary(int capacity, int helpCapacity) {
        dictionary = new String[capacity];
        helper = new String[helpCapacity];
        dictSize = 0;
        helpSize = 0;
    }

    @Override
    public void add(String e) {
        if (!isHelperFull()) {
            helper[helpSize++] = e;
        } else {
            helper[helpSize++] = e;
            dictionary = merge();
        }
    }

    @Override
    public String[] sort() {
        ListSorter ls = new SelectSort(SimpleStringComparator.INSTANCE);
        return ls.sort(helper);
    }

    @Override
    public String find() {
        return null;
    }

    @Override
    public String[] merge() {
        sort();
        String[] toRet = new String[dictSize+helpSize];
        int currentD = 0 , currentH = 0, currentR = 0;
        while (currentD < dictSize && currentH < helpSize)
            toRet[currentR++] = dictionary[currentD].compareTo(helper[currentH]) < 0 ? dictionary[currentD++] : helper[currentH++];

        while (currentD < dictSize) {
            toRet[currentR] = dictionary[currentD];
            currentD++;
            currentR++;
        }

        while (currentH < helpSize) {
            toRet[currentR] = helper[currentH];
            currentH++;
            currentR++;
        }
        dictSize += helpSize;
        clearHelper();

        return toRet;
    }

    public void clearHelper() {
        helper = new String[helper.length];
        helpSize = 0;
    }
    boolean isHelperFull() {
        return helpSize >= helper.length -1;
    }

    boolean isDictionaryFull() {
        return dictSize >= dictionary.length;
    }

    public void print() {
        PrintWriter wyj = new PrintWriter(System.out, true);
        for (int i = 0; i < dictSize; i++)
            wyj.println(dictionary[i]);
    }
}
