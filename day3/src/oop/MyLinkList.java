package oop;
//面对对象方式 单向链表
public class MyLinkList {
    //给它初始化，即空的节点
    private  Node head = new Node();
    private  Node tail = head;
    //定义存放数据的add方法
    public  void  add(int num){
        //创建一个节点
        Node node = new Node();
        //将数据填充到节点,还没有连接
        node.setData(num);
        //然后尾部节点的next 指向新创建的节点
       // Node next = tail.getNext();
        //找到下一个节点,并连接
        tail.setNext(node); //tail.Next=node //this.next= next //指向node节点
      //  next =node;
        //把尾部指到新连接的节点
        tail=node;// 相当于 tail = tail.getNext;  //尾部指向node 节点
    }
    //定义get 方法
public int get(int index){
        Node target = head;
    for (int i = 0; i < index+1; i++) {
        target=target.getNext();
    }
    return  target.getData();
}

    public static void main(String[] args) {
      //  MyArrayList list = new MyArrayList();
        MyLinkList list = new MyLinkList();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        System.out.println(list.get(9999));
    }

}
