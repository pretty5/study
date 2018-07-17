package tree;

public class BinTree {
    private Node root = new Node();

    public void add(int num) {
        //从根节点开始遍历，找到可以存放的节点。
        Node p = root;
        //创建一个新的节点，将数据封装。
        Node node = new Node();
        node.setData(num);
        findNode(p,node);
    }

    private void findNode(Node p,Node node) {
        if (p.getLeftChild() == null) {
            //父节点的左子引用指向了新的节点
            p.setLeftChild(node);
            //新节点的父引用指向了当前遍历的节点
            node.setFather(p);
            return;
        } else if (p.getRightChild() == null) {
            //父节点的左子引用指向了新的节点
            p.setRightChild(node);
            //新节点的父引用指向了当前遍历的节点
            node.setFather(p);
            return;
        } else {
            p = p.getLeftChild();
            if (p.getLeftChild() == null) {
                p.setLeftChild(node);
                node.setFather(p);
                return;
            } else if (p.getRightChild() == null) {
                //父节点的左子引用指向了新的节点
                p.setRightChild(node);
                //新节点的父引用指向了当前遍历的节点
                node.setFather(p);
                return;
            }
            p=p.getFather().getRightChild();
            if(p.getLeftChild()==null){
                p.setLeftChild(node);
                node.setFather(p);
                return;
            }else if(p.getRightChild()==null){
                p.setRightChild(node);
                node.setFather(p);
                return;
            }else{
                p=p.getFather().getLeftChild().getLeftChild();
                findNode(p,node);
            }
        }
    }
}
