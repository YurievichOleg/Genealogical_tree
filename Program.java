public class Program {
    public static void main(String[] args) {
        Personage man1 = new Personage("Дед ", "lastName1", 75, 1);
        Personage man2 = new Personage("Бабуля", "lastName1", 73, 0);
        Personage man3 = new Personage("Отец сын деда", "lastName1", 55, 1);
        Personage man4 = new Personage("Сын", "lastName1", 35, 1);
        Personage man5 = new Personage("Внук1", "lastName1", 15, 1);
        Personage man6 = new Personage("Внук2", "lastName1", 11, 1);
        Personage man7 = new Personage("Внебрачный сын деда", "lastName1", 57, 1);
        Personage man8 = new Personage("Внебрачная внучка", "lastName1", 30, 0);
        Personage man9 = new Personage(50, 0);

        man3.AddConnection(man4);
        man3.AddConnection(man2);
        man3.AddConnection(man1);
        man3.AddConnection(man2);
        man4.AddConnection(man5);
        man4.AddConnection(man6);
        man1.AddConnection(man7);
        man7.AddConnection(man8);
        
        Storage_for_Personages map = new Storage_for_Personages();
        map.addToPersonages(man1);
        map.addToPersonages(man2);
        map.addToPersonages(man3);
        map.addToPersonages(man4);
        map.addToPersonages(man5);
        map.addToPersonages(man6);
        map.addToPersonages(man7);
        map.addToPersonages(man8);
        map.addToPersonages(man9);

        Search(man1, map,1,"");
        System.out.println(man5.getBroAndSis());
        System.out.println(man3.getBroAndSis());
        System.out.println(man4.getConnection());
        System.out.println();
        Search s = new Search();
        s.searchForRelatives(man5,man1);


    
        



        // System.out.println(man3.getAge());
        // System.out.println(man4.getSize());
        // System.out.println(man4.toString());
        // System.out.println(man5.getId());

        // System.out.println(man3.getConnection());
        // System.out.println(man4.getId());
        // System.out.println(man4.getConnection());
        // System.out.println(man3.getId());
        // System.out.println(man5.getConnection());
        // System.out.println(man6.getConnection());

        // System.out.println(man4.getSize());
        // System.out.println(man1.getId());
        // System.out.println(Person_1.personById.get(man1.getId()).getName());
        // System.out.println(Person_1.personById.size());
        // System.out.println(man4.getParents().toString());
        // System.out.println(man3.getId());
        // System.out.println(man4.getChildren());
        // System.out.println(map.getSize());
    }
    static void Search(Personage a, Storage_for_Personages map, int b,String s){
        
        
        if (a.getChildren().isEmpty() || b == 0){
            System.out.println("");
        }
        for ( int i : a.getChildren()){
            System.out.println( s +(String.format(" %s %s", 
            map.getPersonage(i).getName(), map.getPersonage(i).getLastName())));
            Search(map.getPersonage(i), map , b-1, (s + "___"));
        }
        
    }
    
}
