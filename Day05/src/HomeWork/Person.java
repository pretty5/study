package HomeWork;

public class Person {
    private  String name;
    private  int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Person){
            return  this.getName().equals(((Person) obj).getName())&&this.getAge()==((Person) obj).getAge();
        }
        return  false;
    }

    public static void main(String[] args) {
        Person p1 = new Person("xiaoming",15);
        Person p2 = new Person("xiaoming", 15);
        System.out.println(p1.equals(p2));
    }
}
