package ru.job4j.profiles;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().distinct().map(Profile::getAddress).sorted(new AddressComparator()).collect(Collectors.toList());
    }
}
