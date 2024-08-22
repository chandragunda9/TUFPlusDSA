package t15_graphs.shortest_path_algorithms;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Sample {
    public static void main(String[] args) {
        Set<DijkstrasAlgorithm.Node> se = new TreeSet<>(Comparator.comparingInt(a -> a.dist));
        DijkstrasAlgorithm.Node node = new DijkstrasAlgorithm.Node(1, 1);
        DijkstrasAlgorithm.Node node1 = new DijkstrasAlgorithm.Node(1, 1);
        se.add(node);
//        node.dist=2;
//        se.add(node1);
        System.out.println(se);
        se.remove(new DijkstrasAlgorithm.Node(1, 1));
        System.out.println(se);
    }
}
