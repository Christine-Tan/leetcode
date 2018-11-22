/**
 * Created by Seven on 19/10/2018.
 */
import java.util.*;

public class OASample_1 {
    public static void main(String[] args) {
        OASample_1 oa4 = new OASample_1();
        int[] stores = new int[]{1, 5, 20, 11, 16};
        int[] hourses = new int[]{5, 10, 17};
        int[] re = oa4.solution(stores, hourses);
        System.out.println(Arrays.toString(re));
    }

    //o(nlogn+mn)
    public int[] solution(int[] stores, int[] houses) {
        List<Pair> storeWithIndex = new ArrayList<>();
        for (int i = 0; i < stores.length; i++) {
            storeWithIndex.add(new Pair(i, stores[i]));
        }
        Collections.sort(storeWithIndex);
        int[] re = new int[houses.length];
        for (int i = 0; i < re.length; i++) {
            re[i] = nearestStore(storeWithIndex, houses[i]);
        }
        return re;
    }

    public int nearestStore(List<Pair> sortedStore, int position) {
        int index = 0;
        //last index是用来处理多个store在同一个index上的时候
        int lastIndex = index;
        for (; index < sortedStore.size(); index++) {
            Pair p = sortedStore.get(index);
            if (p.value == position)
                return p.index;
            if (p.value > position)
                break;
            if (index != 0 && p.value > sortedStore.get(lastIndex).value)
                lastIndex = index;
        }
        int reIndex;
        if (index == sortedStore.size())
            reIndex = lastIndex;
        else if (index == 0)
            reIndex = 0;
        else {
            int right = sortedStore.get(index).value - position;
            int left = position - sortedStore.get(lastIndex).value;
            reIndex = left <= right ? lastIndex : index;
        }
        return sortedStore.get(reIndex).value;
    }

    class Pair implements Comparable<Pair> {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.value < o.value || (this.value == o.value && this.index < o.index))
                return -1;
            if (this.value > o.value || (this.index > o.index))
                return 1;
            return 0;
        }
    }
}
