package by.dobrovolskaya.list;

import java.util.ArrayList;
import java.util.List;

public class ListService {
    private  static  List <Person> groupList =  new ArrayList<>();
    static {
    groupList.add(new Person("anna", "2656846","anna@mail.ru"));
    groupList.add(new Person("andrey", "1156846","andr@mail.ru"));
    }
    static  public  List <Person> retriveList(){
        return groupList;
    }

    static public void addPerson(Person person) {
        groupList.add(new Person(person));
    }


}
