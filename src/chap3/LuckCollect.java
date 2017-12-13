package chap3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LuckCollect {

    public void luckySort(ArrayList<String> list , Comparator<String> comp){
        int number=0;
        while(luckSortCall(list,comp)) {
            number++;
            Collections.shuffle(list);
        }
        list.forEach(s->System.out.println(s));
        System.out.println(number);
    }

    public boolean luckSortCall(ArrayList<String> list,Comparator<String> comp) {
        ArrayList<String> cloneList = new ArrayList<>(list);
        Collections.sort(cloneList);

        for (int a = 0; a < cloneList.size(); a++) {
            if (comp.compare(cloneList.get(a), list.get(a)) < 0) {
                return true;
            }
        }
        return false;

    }


}
