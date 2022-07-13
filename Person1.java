
    /** Класс для создания персоны, у которой есть id, возраст, пол( 0 или 1), имя и фамилия */
public class Person1 {
    protected static Integer id;
    protected int id_person;
    protected int age;
    protected String name;
    protected String lastName;
    protected int sex;
    // protected static List<Person_1> allPersons = new ArrayList<>();
    // protected static Map<Integer, Person_1> personById = new HashMap<>();
    // protected List<Person_1> closePerson = new ArrayList<>();
    static{
        id = 1;
    }
      
    protected Person1(String name, String lastName, int age,int sex, int id_person) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.id_person = id_person;       
        id ++;
    }
    /* При создании экземпляра класса автоматически генерируется id  */
    public Person1(String name, String lastName, int age,int sex){
        this(name, lastName, age, sex, id);
    }



    public int getId() {
        return this.id_person;
    }

    public String getName() {
        return this.name;
    }
    
    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public int getSex() {
        return this.sex;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.lastName );
    }
    
}
