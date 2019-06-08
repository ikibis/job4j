package ru.job4j.profiles;

import java.util.Comparator;

public class AddressComparator implements Comparator<Address> {
    @Override
    public int compare(Address left, Address right) {
        int result = 0;
        int count = left.getCity().length() <= right.getCity().length() ? left.getCity().length() : right.getCity().length();
        for (int i = 0; i < count; i++) {
            result = (-1) * Character.compare(left.getCity().charAt(i), right.getCity().charAt(i));
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result = Integer.compare(left.getCity().length(), right.getCity().length());
        }
        return result;
    }
}
