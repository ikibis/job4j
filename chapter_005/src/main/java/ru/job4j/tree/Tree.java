package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int size;

    public Tree(E root) {
        this.root = new Node<>(root);
        size++;
    }

    /**
     * в методе add нужно найти родителя и проверив что в дереве нет такого ребёнка
     * добавить найденному родителю этого ребенка
     *
     * @param parent parent.
     * @param child  child.
     * @return boolean
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = true;
        Optional<Node<E>> par = this.findBy(parent);
        Optional<Node<E>> chil = this.findBy(child);
        if (chil.isPresent()) {
            result = false;
        } else if (par.isPresent()) {
            Node<E> element = new Node<>(child);
            par.get().leaves().add(element);
            size++;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    public boolean isBinary() {
        boolean result = true;
        if (root.getValue() == null || root.leaves().size() > 2) {
            result = false;
        } else {
            Queue<Node<E>> treeCopySource = new LinkedList<>(root.leaves());
            Queue<Node<E>> treeCopy = new LinkedList<>();
            while (treeCopySource.peek() != null) {
                Node<E> node = treeCopySource.poll();
                if (node.leaves().size() < 3) {
                    treeCopy.addAll(node.leaves());
                } else {
                    result = false;
                    break;
                }
                while (treeCopy.peek() != null) {
                    Node<E> node2 = treeCopy.poll();
                    if (node2.leaves().size() < 3) {
                        treeCopySource.addAll(node.leaves());
                    } else {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int count = 0;
            Queue<Node<E>> treeCopy = new LinkedList<>();

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public Object next() {
                Object result;
                if (count == 0) {
                    result = root.getValue();
                    treeCopy.addAll(root.leaves());
                    count++;
                } else {
                    Node<E> node = treeCopy.poll();
                    result = node.getValue();
                    treeCopy.addAll(node.leaves());
                    count++;
                }
                return result;
            }
        };
    }
}

