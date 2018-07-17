package Inner.inner;

/*
*@ClassName:Outer
 @Description:TODO
 @Author:
 @Date:2018/7/17 10:39 
 @Version:v1.0
*/
public class Outer {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.testInnerLocal();
    }
    public void testInnerLocal() {
        class InnerLocal {
            private String name;
            private String address;

            public InnerLocal(String name, String address) {
                super();
                this.name = name;
                this.address = address;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            @Override
            public String toString() {
                return "InnerLocal[name=" + getName() + ",address=" + getAddress() + "]";
            }
        }

        InnerLocal local = new InnerLocal("马加爵", "河南省郑州市中原区");

        System.out.println(local);

    }

}
