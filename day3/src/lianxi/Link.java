package lianxi;

public class Link {
    //创建一个初始化的头、尾节点
    //连接节点
    //尾部放到尾节点
    private  Node head = new Node();
    private  Node tail = new Node();
    int index = 0;


    //取
    public  int get( int index){
        Node p = new Node();
        for (int i = 0; i < index+1; i++) {
            p= p.getNext();
        }
        return  p.getData();
    }

    //存
    public  void  add(int num){
        Node node = new Node();
        //创建节点，填充数据
        node.setData(num);
        //连接节点
        tail.setNext(node);
        //尾部指向节点
        tail = node;
    }

    public static void main(String[] args) {
        List list = new List();
        for (int i = 0; i < 100; i++) {
           list.add(i);
        }
        System.out.println(list.get(0));
    }


}
