package com.github.stiangao.list;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class P5181 {

    public static void main(String[] args) {
        int[] distance = {1, 2, 3, 4};
        int[] distance2 = {7,10,1,12,11,14,5,0};
        System.out.println(new P5181().dayOfTheWeek(31, 8, 2019));
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) {
            return 0;
        }
        int l = start - 1, r = start + 1;
        l = l < 0 ? distance.length - 1:l;

        int ld = distance[l], rd = distance[r - 1];

        r = r == distance.length ? 0 : r;

        while (l != destination) {
            l--;
            if (l < 0) {
                l = distance.length - 1;
            }
            ld += distance[l];
        }
        while (r != destination) {
            rd += distance[r];
            r++;
            if (r == distance.length) {
                r = 0;
            }
        }
        return Math.min(ld, rd);
    }

    public String dayOfTheWeek(int day, int month, int year) {
        long total = 0;
        total += 365 * year;
        if (year >= 0) {
            total += (year + 3) / 4 - (year + 99) / 100 + (year + 399) / 400;
        } else {
            total -= year / -4 - year / -100 + year / -400;
        }
        total += ((367 * month - 362) / 12);
        total += day - 1;
        if (month > 2) {
            total--;
            if (!((year & 3) == 0) && ((year % 100) != 0 || (year % 400) == 0)) {
                total--;
            }
        }
        int i = (int)Math.floorMod(total - ((146097 * 5L) - (30L * 365L + 7L)) + 4, 7);
        String[] dayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return dayName[i];
    }

}
