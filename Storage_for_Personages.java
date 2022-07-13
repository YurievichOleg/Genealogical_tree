import java.util.HashMap;
import java.util.Map;

/** Класс для хранения экземпляров класса Personage по ключу id */
public class Storage_for_Personages {
    static Map<Integer,Personage> personages = new HashMap<>();

    public void addToPersonages(Personage a){
        personages.put(a.getId(), a);
    }
    public Map<Integer, Personage> getPersonages() {
        return personages;
    }

    public Personage getPersonage(int a){
        return personages.get(a);
    }

    public int getSize(){
        return personages.size();
    }

    
}
