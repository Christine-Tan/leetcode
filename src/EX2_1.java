import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Seven on 05/09/2018.
 */
public class EX2_1 {

    public void removeDup(List<String> list){
        //you only need a hashset rather than a hashmap
        //
        Map<String,Boolean> listMap = new HashMap<>();
        for(int i =0;i<list.size();i++){
            if (!listMap.containsKey(list.get(i))){
                listMap.put(list.get(i),true);
            }else{
                list.remove(i);
                i--;
            }
        }
        for(String s : list){
            System.out.print(s+",");
        }
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        EX2_1 ex = new EX2_1();
        List<String> list = new LinkedList<>();
        list.add("1234");
        list.add("1234");
        list.add("1234");
        list.add("2345");
        list.add("2345");
        list.add("2345");
        list.add("2345");
        list.add("kfjwe");
        list.add("sfew");
        ex.removeDup(list);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + "ms");


    }
}
