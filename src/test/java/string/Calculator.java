package string;

import java.util.Scanner;

public class Calculator {

    public int input(){
        System.out.print("문자열을 입력하세요: ");
        Scanner scanner = new Scanner(System.in);
        String value;

        int result = 0;
        try {
            value = scanner.nextLine();
            String[] values = value.split(" ");
            result = cal(values);
        }catch (Exception e){
            System.out.println("입력값이 올바르지 않습니다.");
            return 0;
        }

        return result;
    }

    public int calculate(int num1, String operator, int num2){
        switch (operator){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                try {
                    return num1 / num2;
                }catch (Exception e){
                    System.out.println("0으로는 나눌 수 없습니다.");
                    break;
                }
            default:
                System.out.println("사칙연산 부호가 아닙니다.");
                break;
        }
        return -1;
    }

    public int cal(String[] values) {

        int[] nums = new int[values.length/2 + 1];
        // 짝수 index == 부호, int 형변환 후 생성한 배열에 넣기
        for(int i = 0; i < values.length; i+=2){
            nums[i/2] = Integer.parseInt(values[i]);
        }

        int result = nums[0];
        // 홀수 index == 부호
        for(int i = 1; i < values.length; i+=2){
            result = calculate(result, values[i], nums[i/2+1]);
            if(result == -1)
                break;
        }
        return result;
    }

}