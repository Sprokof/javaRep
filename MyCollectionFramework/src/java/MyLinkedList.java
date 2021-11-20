public class MyLinkedList<E> {
    private Node<E> last = new Node<>();
    private Node<E> first = new Node<>();

    private int size = 0;

    public int size() {
        return size;
    }

    private static class Node<E>{
        private Node<E> next;
        private Node<E> prev;
        private E value;

        private Node(){}

        public Node(E value) {
            this.value = value;
        }}



    public void add(E value) {
        if (first.next == null) {
            Node<E> node = new Node<>(value);
            node.value = value;
            first.next = node;
        }

        if (last.prev == null) {
            last.prev = first.next;
            return;
        }

        Node<E> node = new Node<>(value);
        node.value = value;

        Node<E> lastNode = last.prev;
        lastNode.next = node;
        node.prev = lastNode;
        last.prev = node;
        size++;

    }


    public E get(int index) {
        Node<E> requestedElement = first.next;
        for (int i = 0; i != index; i++){
            requestedElement = requestedElement.next;
            if (requestedElement == null){
                return null;}}
        return requestedElement.value;}
    
    public void remove(E value){
        if(last==null){return;}
        if(last.value == value){last = last.next;
            return;}
        Node<E> curNode = last;
        while (curNode.next!=null){
            if(curNode.next.value==value){
                curNode.next = curNode.next.next;
                return;}
            curNode = curNode.next;}}

    public void remove(int index){
        if(last==null){return;}
        Node<E> curNode = last;
        for(int i = 0; i!=index; i++){
            while (curNode.next!=null){
                if(i==index){
                    curNode.next = curNode.next.next;
                    return;}
                curNode = curNode.next;}}
    }}
