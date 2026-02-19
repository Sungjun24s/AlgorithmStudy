// 체스판 1018번 브루트포스

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 0 : Black
// 1 : White

// 1차원 배열로 하는것이 더 좋을수도?

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> result = new ArrayList<>();
        String inputMN = rd.readLine();

        String[] parts = inputMN.split(" ", 2);
        int inputM = Integer.parseInt(parts[0]);
        int inputN = Integer.parseInt(parts[1]);
        int[][] inputMatrix = new int[inputM][inputN];

        for (int i = 0; i < inputM; i++) {
            String inputLine = rd.readLine();
            for (int j = 0; j < inputN; j++) {
                if (inputLine.charAt(j) == 'B')
                    inputMatrix[i][j] = 0;
                else
                    inputMatrix[i][j] = 1;
            }
        }

        for (int i = 0; i < inputM - 7; i++) {
            for (int j = 0; j < inputN - 7; j++) {
                int startBlack = 0;
                int startWhite = 0;
                for (int height = i; height < i + 8; height++) {
                    for (int width = j; width < j + 8; width++) {
                        if (height % 2 == 0 && width % 2 == 0) {
                            if (inputMatrix[height][width] == 0) {
                                startBlack++;
                            } else {
                                startWhite++;
                            }
                        } else if (height % 2 == 1 && width % 2 == 1) {
                            if (inputMatrix[height][width] == 0) {
                                startBlack++;
                            } else {
                                startWhite++;
                            }
                        } else {
                            if (inputMatrix[height][width] == 1) {
                                startBlack++;
                            } else {
                                startWhite++;
                            }
                        }
                    }
                }
                result.add(Math.min(startBlack, startWhite));
            }
        }

        int minResult = Collections.min(result);
        System.out.println(minResult);
    }
}