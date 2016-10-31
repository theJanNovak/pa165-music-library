package cz.muni.fi.pa165;

import java.util.List;

/**
 * Created by johnny on 31.10.16.
 */
public class TestUtil {
    public static <T> boolean listEquals(List<T> list1, List<T> list2) {
        if (list1.size() != list2.size()) return false;
        for (T item1 : list1) {
            for (T item2 : list2) {
                if (item1.equals(item2)) {
                    list2.remove(item2);
                    break;
                }
            }
        }
        return list2.size() == 0;
    }
}
