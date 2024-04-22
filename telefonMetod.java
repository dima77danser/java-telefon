
import java.util.*;


public class Book{
    private HashMap<String,TreeSet<String>> phoneBook;
    public Book(){
        phoneBook = new HashMap<>();
    }
    public static void main(String[]args){
        Book phoneBook = new Book();
        phoneBook.addContact("Лукашин Дима","89264849404");// добавление контантов в тел справочник
        phoneBook.addContact("Петров Алексей","89678494904");
        phoneBook.addContact("Лукашин Дима","89264748001");
        phoneBook.addContact("Лукашин Дима","89345678905");
        phoneBook.addContact("Пуговкина Людмила","89567243900");
        phoneBook.addContact("Пуговкина Людмила","89674820377");

        phoneBook.print();// вывод телефонной книги

        // phoneBook.removeContact("Лукашин Дима","89264748001");// удаление телефона по имени
        // phoneBook.removeContact("Петров Алексей","89678494904");// при отсутствии других телефонов -удаление имени из тел книги
        //  phoneBook.print(); 

        //  System.out.println("Лукашин Дима:" +phoneBook.getPhones("Лукашин Дима")); //вызов всех телефонов контакта

        System.out.println("Отсортированные контакты:");// сортировка контактов по убыванию числа телефонов
        List <String> sortedContacts = phoneBook.sort();
        for (String contact:sortedContacts){
            System.out.println(contact);
        }

    }
    public void addContact(String name, String phoneNum){
        TreeSet<String> phones = phoneBook.getOrDefault(name,new TreeSet<>());
        phones.add(phoneNum);
        phoneBook.put(name,phones);
    }
    public void print(){
        for (String name: phoneBook.keySet()){
            TreeSet<String> phones = phoneBook.get(name);
            System.out.println(name + ": " + phones);
        }
    }
    public void removeContact(String name, String phoneNum){
        TreeSet<String> phones = phoneBook.getOrDefault(name,new TreeSet<>());
        phones.remove(phoneNum);
        if(phones.isEmpty()){
            phoneBook.remove(name);
        }else {
            phoneBook.put(name,phones);
        }
    }
    public TreeSet<String>getPhones(String name){
        return phoneBook.get(name);
    }
    public List<String> sort(){
        List<Map.Entry<String,TreeSet<String>>> sortedEntr = new ArrayList<>(phoneBook.entrySet());
        sortedEntr.sort((e1,e2)-> e2.getValue().size()-e1.getValue().size());
        List<String> result = new ArrayList<>();
        for (Map.Entry<String,TreeSet<String>> entry:sortedEntr){
            result.add(entry.getKey()+": " + entry.getValue());
        }
        return result;
    }
}