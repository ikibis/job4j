package ru.job4j.profiles;

import java.util.Comparator;

public class AddressComparator implements Comparator<Address> {
    @Override
    public int compare(Address left, Address right) {
        int result;
        if (left == null && right == null) {
            result = 0;
        } else if (left == null) {
            result = -1;
        } else if (right == null) {
            result = 1;
        } else {
            result = left.getCity().compareTo(right.getCity());
        }
        return result;
    }
}
