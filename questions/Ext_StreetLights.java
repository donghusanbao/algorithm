package questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ext_StreetLights {
    public static int leastLights(String street, int num) {
        System.out.println(street);
        char[] points = street.toCharArray();
        if (points.length != num) {
            return -1;
        }
        int index = 0;
        int lights = 0;
        while (index < num) {
            if (points[index] == 'X') {
                index++;
            } else {
                if (index + 1 < num && points[index + 1] == 'X') {
                    index += 2;
                } else if (index + 1 < num && points[index + 1] == '.') {
                    index += 3;
                } else {
                    index++;
                }
                lights++;
            }
        }
        return lights;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String street = br.readLine();
        System.out.println(leastLights(street, n));
    }
}
