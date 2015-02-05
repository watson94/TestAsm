import java.util.HashMap;
import java.util.Map;

/**
 * Created by watson on 04.02.15.
 */
public class Test {
    class TestInner {
        Map<Integer, Integer> testMap = new HashMap<Integer, Integer>();
        public void doSomething() {
            x = new Node();
        }
    }
    private Node x;
    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    public Node sayX() {
        m.put(1, 1);
        x.mmap.put(1, 1);
        return x;
    }
}

class Node {
    public Node next;
    public Map<Integer, Integer> mmap = new HashMap<Integer, Integer>();
}
