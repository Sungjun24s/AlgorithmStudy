import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int num = Integer.parseInt(br.readLine()); // 숫자 입력
        long input = Long.parseLong(br.readLine());

        long sum = 0;
        long count = 0;
        long i = 1;
        while(sum <= input){
            if(sum + i >= input){
                long temp = input - sum;
                if(temp == i){
                    count++;
                    break;
                }
                else{
                    break;
                }
            }
            sum +=i;
            i++;
            count++;
        }
        System.out.println(count);
    }
}