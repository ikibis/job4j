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
     * @return
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
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int count = 0;
            Queue<Node<E>> res;
            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public Object next() {
                Object result;
                Object element;
                if (count == 0) {
                    result = root;
                    res = (Queue<Node<E>>) findBy((E)root).get().leaves();
                    count++;
                } else {
                    element = res.poll();
                    for (List<Node<E>> elements : element.leaves()) {
                        res.offer(elements);
                    }
                    count++;
                }
                return result;
            }
        };
    }
}

