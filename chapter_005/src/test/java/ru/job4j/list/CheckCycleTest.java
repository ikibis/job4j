package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CheckCycleTest {
    CheckCycle cycle = new CheckCycle();
    Node first = new Node(1);
    Node two = new Node(2);
    Node third = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    Node six = new Node(6);
    Node seven = new Node(7);

    @Test
    public void whenAddFourCycleElementsThenTrue() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(cycle.hasCycle(first), is(true));
    }

    @Test
    public void whenAddFourNonCycleElementsThenFalse() {
        first.next = two;
        two.next = third;
        third.next = four;
        assertThat(cycle.hasCycle(first), is(false));
    }

    @Test
    public void whenAddFourCycleElementsThenTrue2() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = five;
        five.next = two;
        six.next = seven;
        assertThat(cycle.hasCycle(first), is(true));
    }
}

