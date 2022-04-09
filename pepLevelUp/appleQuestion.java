public class appleQuestion {

    public long minimumPerimeter(long neededApples) {

        long temp = 0;
        long i = 1;
        while (temp < neededApples) {

            temp += 4 * 3 * i;
            temp += (((2 * i) * ((2 * i) - 1)) / 2 - ((i * (i + 1)) / 2)) * 8;
            i++;
        }
        return 8 * (i - 1);
    }
}

//link -https://leetcode.com/problems/minimum-garden-perimeter-to-collect-enough-apples/
