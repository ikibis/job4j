package ru.job4j.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private LinkedList<Node<E>> treeList = new LinkedList<>();
    public Tree(E root) {
        this.root = new Node<>(root);
    }

    /**
     * в методе add нужно найти родителя и проверив что в дереве нет такого ребёнка
     * добавить найденному родителю этого ребенка
     *
     * @param parent parent.
     * @param child  child.
     * @return
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = true;
        Optional<Node<E>> par = this.findBy(parent);
        Optional<Node<E>> chil = this.findBy(child);
        if (chil.isPresent()) {
            result = false;
        } else {
            Node<E> element = new Node<>(child);
            treeList.add(element);
            par.get().add(element);
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

    @Override
    public Iterator iterator() {
        return new Iterator() {
            LinkedList<Node<E>> treeCopy = treeList;
            @Override
            public boolean hasNext() {
                return treeCopy.size() > 0;
            }

            @Override
            public Object next() {
                return treeCopy.poll();
            }
        };
    }
}
