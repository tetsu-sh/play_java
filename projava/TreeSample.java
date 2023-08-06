package projava;

import java.util.Optional;

public class TreeSample {
    static abstract class Node {
        int val;

        Node(int val) {
            this.val = val;
        }

        abstract int sum();
    }


    static class Leaf extends Node {
        Leaf(int val) {
            super(val);
        }

        @Override
        int sum() {
            return this.val;
        }

    }

    static class Branch extends Node {
        Optional<Node> left;
        Optional<Node> right;

        Branch(int val, Optional<Node> left, Optional<Node> right) {
            super(val);
            this.left = left;
            this.right = right;
        }

        @Override
        int sum() {
            int result = this.val;
            if (this.left.isPresent()) {
                result += this.left.get().sum();
            }
            if (this.right.isPresent()) {
                result += this.right.get().sum();
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Node root = new Branch(5,
                Optional.of(new Branch(2, Optional.of(new Leaf(4)), Optional.ofNullable(null))),
                Optional.of(new Branch(7, Optional.of(new Leaf(6)), Optional.of(new Leaf(8)))));
        System.out.println(root.sum());

    }


}
