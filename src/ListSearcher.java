
public interface ListSearcher {
//zwraca pozycję obiektu na liście - jeśli jest
//jeśli nie to - (pozycja_wstawienia + 1)
// plus1 umożliwia wskazanie, że element powinien się znajdować na początku listy

    int search(String[] list, String value);
}
