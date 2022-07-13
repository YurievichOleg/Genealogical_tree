import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Search {
   
    /* метод устанавливающий родство между двумя экземплярами класса Personage */
    public void searchForRelatives(Personage a, Personage b) {
        ArrayList<Set<Integer>> humans = new ArrayList<>();
        Set<Integer> serched = new HashSet<>();
        int count = 0;
        humans.add(a.getConnection());
        // int i = 0; i < humans.size(); i ++
        // 
        for (int i = 0; i < humans.size(); i ++) {
            if (humans.get(i).contains(b.getId())) {
                count ++;
                System.out.println("Родственники");
                i = humans.size();
            } else {
                for (int j : humans.get(i)) {
                    if (!serched.contains(j)) {
                        humans.add(Storage_for_Personages.personages.get(j).getConnection());
                        serched.add(j);
                    }
                }
            }
        }
        if (count == 0 ){
            System.out.println("Не нашлось связи");
        }
    }

    
}
