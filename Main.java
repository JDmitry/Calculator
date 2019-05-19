import java.util.Scanner;//Импорт класса Scanner;

class Calculator{//Класс Calculator с основными методами;

    static Scanner sc = new Scanner(System.in);//Экземпляр класса Scanner;

    //Метод getNum() возвращает челочисленное значение для операндов;
    public static int getNum(){

        System.out.println(" Enter a number: ");

        int number;

        // В методе используется рекурсия;
        if (sc.hasNextInt()) {
                number = sc.nextInt();

            } else {
                System.out.println(" Error! Enter number only! ");
                sc.next();
                number = getNum();

            }
            return number;
    }

    //Метод operation() возвращает символ операции;
    public static char operation(){

        System.out.println(" Enter an operation (+,-,*,/,%): ");
        char oper;
        if(sc.hasNext()){
            oper = sc.next().charAt(0) ;

        } else {
            System.out.println(" Error! Try again! ");
            sc.next();
            oper = operation();
        }
        return oper;
    }

    //В методе calculation(int number1, int number2, char oper) производятся
    //манипуляции с операндами и возвращает соответсвующий результат;
    public static int calculation(int number1, int number2, char oper){

        int result;

        switch (oper) {

                case '+':
                    result = number1 + number2;
                    break;

                case '-':
                    result = number1 - number2;
                    break;

                case '*':
                    result = number1 * number2;
                    break;

                case '/':

                    int res1=0;

                    try{//Проверка деления на ноль;

                        res1 = number1 / number2;

                    }catch(ArithmeticException e){

                            System.out.println(" By zero! Divider can't be zero! ");

                    }
                    result=res1;
                    break;

                case '%':

                    int res2=0;

                    try{//Проверка деления на ноль;

                        res2 = number1 % number2;

                    }catch(ArithmeticException e){

                            System.out.println(" By zero! Divider can't be zero! ");

                        }
                        result=res2;
                        break;

                default:
                    System.out.println(" Enter symbol of operation only! ");
                    result = calculation(number1, number2, operation());
        }

            return result;
    }
}

public class Main{//Класс Main с главным методом;

    public static void main(String[] args) {

        System.out.println("------------ CALCULATOR ------------\n************************************");

        while(true){

            System.out.println("------------------------------------");
            int firstNumber = Calculator.getNum();
            int secondNumber = Calculator.getNum();
            char operation = Calculator.operation();
            int result = Calculator.calculation(firstNumber, secondNumber, operation);
            System.out.println(" Result: " +result);
            System.out.println("------------------------------------");

        }
    }
}