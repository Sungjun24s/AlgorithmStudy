import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        // 첫번째 - 기준으로 잘라서 문자열 저장
        String[] minusSplit = input.split("-");

        int result = 0;

        // 정규표현식에서 +라고 쓰면 애러남.
        // /+는 +를 문자 그대로 사요하겠다는 뜻
        // /를 쓰려면 //로 써야함
        // 따라서 //+로 함
        String[] first = minusSplit[0].split("\\+");
        for (String num : first) {
            result += Integer.parseInt(num);
        }

        // 그 이후는 전부 더해서 빼기
        for (int i = 1; i < minusSplit.length; i++) {
            int tempSum = 0;
            String[] plusSplit = minusSplit[i].split("\\+");
            for (String num : plusSplit) {
                tempSum += Integer.parseInt(num);
            }
            result -= tempSum;
        }

        System.out.println(result);
    }
}