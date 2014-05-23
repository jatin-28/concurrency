public class BlockingQueueTest {

    public static void main(String[] args) {
        testJoinQueueOrdering();
    }

    private static void testJoinQueueOrdering() {
        BlockingQueue blockingQueue = new BlockingQueue();
        for(int i=0; i < 10; i++) {
            blockingQueue.joinQueue(i);
        }
        System.out.println(blockingQueue.toString());
    }

    static class BlockingQueue {
        private Node head;
        private Node tail;

        public void joinQueue(int i) {
            if( head == null) {
                head = new Node(null, null, i);
                tail = head;
            } else {
                tail = new Node(head, null, i);
            }
        }

        public int take() {
            int currentValue = head.getValue();
            head = head.getTail();
            return currentValue;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node currentNode = head;
            while( currentNode != null) {
                sb.append(currentNode.toString()).append(",");
                currentNode = head.getTail();
            }
            return sb.toString();
        }
    }

    static class Node {
        private Node head;
        private Node tail;
        private int value;

        Node(Node head, Node tail, int value) {
            this.head = head;
            this.tail = tail;
            this.value = value;
        }

        public Node getHead() {
            return head;
        }

        public void setHead(Node head) {
            this.head = head;
        }

        public Node getTail() {
            return tail;
        }

        public void setTail(Node tail) {
            this.tail = tail;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

}
