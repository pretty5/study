package exercise;

import extend.Student;

public class Students {
    private  String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Students(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
       if (obj instanceof  Students){
           Students obj1 = (Students) obj;
           return this.getId().equals(obj1.getId());

       }
       return  false;
    }

    public static void main(String[] args) {
        Students s1 = new Students("s1");
        Students s2 = new Students("s1");
        Students s3 = new Students("s3");
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));

    }
}
