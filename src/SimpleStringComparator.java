public final class SimpleStringComparator implements Comparator {

    public static final SimpleStringComparator INSTANCE = new SimpleStringComparator();
    public SimpleStringComparator() { }

    public int compare(Object left, Object right) throws ClassCastException
    { return ((String)left).compareTo((String)right); }

}


