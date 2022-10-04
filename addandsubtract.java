import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.io.PrintWriter;
public class addandsubtract {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int number1 = x.nextInt();//生成题目的个数；

        try {
            File file1 = new File("Exercise.txt");
            FileWriter fw1 = new FileWriter(file1, true);
            PrintWriter pw1 = new PrintWriter(fw1);

            File file2 = new File("Answers.txt");
            FileWriter fw2 = new FileWriter(file2, true);
            PrintWriter pw2 = new PrintWriter(fw2);

            for (int i = 0; i < number1; i++) {//开始循环

                Random rd1 = new Random();
                int number2 = rd1.nextInt(2) + 1;//生成运算符的个数；

                if (number2 == 2) {
                    Random rd2 = new Random();
                    int data1 = rd2.nextInt(100) + 1;//随机生成三个数
                    int data2 = rd2.nextInt(100) + 1;
                    int data3 = rd2.nextInt(100) + 1;

                    String[] operator = {"+", "-"};
                    Random rd3 = new Random();
                    int num1 = rd3.nextInt(2);//随机生成2个运算符
                    int num2 = rd3.nextInt(2);

                    String str = data1 + operator[num1] + data2 + operator[num2] + data3 + "=";
                    int result;

                    if (operator[num1].equals("+")) {

                        if (operator[num2].equals("+")) {
                            result = data1 + data2 + data3;
                            pw1.println(str);
                            pw2.println(result);

                        } else if (operator[num2].equals("-")) {
                            if (data1 + data2 > data3) {
                                result = data1 + data2 - data3;
                                pw1.println(str);
                                pw2.println(result);

                            } else if (data1 + data2 < data3) {
                                number1++;
                            }
                        }
                    }

                    if (operator[num1].equals("-")) {

                        if (operator[num2].equals("+")) {
                            if (data1 - data2 + data3 > 0) {
                                result = data1 - data2 + data3;
                                pw1.println(str);
                                pw2.println(result);

                            } else if (data1 - data2 + data3 < 0) {
                                number1++;
                            }

                        } else if (operator[num2].equals("-")) {
                            if (data1 - data2 - data3 > 0) {
                                result = data1 - data2 - data3;
                                pw1.println(str);
                                pw2.println(result);

                            } else if (data1 - data2 - data3 < 0) {
                                number1++;
                            }
                        }
                    }

                } else {
                    Random rd2 = new Random();
                    int data1 = rd2.nextInt(100) + 1;//随机生成两个数
                    int data2 = rd2.nextInt(100) + 1;

                    String[] operator = {"+", "-"};
                    Random rd3 = new Random();
                    int num1 = rd3.nextInt(2);//随机生成1个运算符

                    String str = data1 + operator[num1] + data2 + "=";
                    int result;

                    if (operator[num1].equals("+")) {
                        result = data1 + data2;
                        pw1.println(str);
                        pw2.println(result);


                    } else if (operator[num1].equals("-")) {
                        if (data1 > data2) {
                            result = data1 - data2;
                            pw1.println(str);
                            pw2.println(result);

                        } else if (data1 < data2) {
                            number1++;
                        }
                    }
                }
            }
            pw1.close();
            pw2.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}