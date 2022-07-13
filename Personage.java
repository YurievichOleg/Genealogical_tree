import java.util.ArrayList;
import java.util.HashSet;

import java.util.Set;
/** Класс Personage наследуется от классаPerson_1
 * Содержит в себе Set connectionPerson в котором содержатся id близких людей 
 * находящихся с ним в прямом родстве, родителей и детей. Братья и сестры являются для этого класса
 * связями второго порядка
  */
public class Personage extends Person1{
    private static String unknown = "Unknown";
    private Set<Integer> connectionPerson = new HashSet<>();
    // private static Map<Integer, Personage> personById_1 = new HashMap<>();

    // private List<Person_1> allPersons = new ArrayList<>();

    public Personage(String name, String lastName, int age, int sex) {
        super(name, lastName, age, sex);
        // Person_1.allPersons.add(new Person_1(name, lastName, age, sex));
        // Person_1.personById.put(allPersons.get(allPersons.size()-1).getId() - 1, allPersons.get(allPersons.size()-1));
        
    }
    /** Конструктор для создания экземпляров класса, у которыъ неизвестны имя и фамилия */
    public Personage(int near, int sex){
        super(String.format("%s%d", unknown, Person1.id), String.format("%s%d", unknown, Person1.id), near , sex);
    }

    // public int getSize(){
    //     return Person_1.allPersons.size();
    // }
    /*
     * метод добавления связей персонажу
    */
    public void AddConnection(Personage human){
        connectionPerson.add(human.getId());
        human.connectionPerson.add(getId());
    }
    /* Метод возвращающий Set c id близких людей */
    public Set<Integer> getConnection(){
        return connectionPerson;
    }
    /* Метод возвращающий список с id роддителей */
    public ArrayList<Integer> getParents(){
        ArrayList<Integer> parentsId = new ArrayList<>();
        if (!connectionPerson.isEmpty()){
            for (int i : connectionPerson){
                if (Storage_for_Personages.personages.get(i).getAge() > getAge()){
                    parentsId.add(i);
                }
            }
        }
        return parentsId;
    }
    /* Метод возвращающий список с id детей */
    public ArrayList<Integer> getChildren(){
        ArrayList<Integer> childrenId = new ArrayList<>();
        if (!connectionPerson.isEmpty()){
            for (int i : connectionPerson){
                if (Storage_for_Personages.personages.get(i).getAge() < getAge()){
                    childrenId.add(i);
                }
            }
        }
        return childrenId;
    }
    /* Метод возвращающий Set с id братьев или систер */
    public Set<Integer> getBroAndSis(){
        Set <Integer> broAndSis = new HashSet<>();
        for (int i : getParents()){
            for (int j : Storage_for_Personages.personages.get(i).getChildren()){
                if (super.id_person != j) broAndSis.add(j);
            }
        }
        return broAndSis;

    }
    
}
