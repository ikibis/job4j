package ru.job4j.hotels;

public class HotelsRank {

    int[] setStars(int hotels, int[] rating) {
        int[] result = new int[hotels];
        int stars = hotels;
        int quantity = hotels / 5;
        while (stars > 0) {
            int highRating = 0;
            int index = 0;
            for (int i = 0; i < rating.length; i++) {
                if (rating[i] == 0) {
                    continue;
                }
                if (rating[i] > highRating) {
                    highRating = rating[i];
                    index = i;
                }
            }
            result[index] = stars % quantity == 0 ? stars / quantity : stars / quantity + 1;
            stars--;
            rating[index] = 0;
        }
        return result;
    }
}
