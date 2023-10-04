import java.util.Scanner;


//    Приложение "Строковый калькулятор"

// 1) Калькулятор умеет выполнять операции сложения строк, вычитания строки из строки,
//    умножения строки на число и деления строки на число: "a" + "b", "a" - "b", "a" * b, "a" / b.
//    Данные передаются в одну строку (смотрите пример)!
//    Решения, в которых каждая строка, число и арифметическая операция передаются с новой строки считаются неверными.

// 2) Значения строк передаваемых в выражении выделяются двойными кавычками.

// 3) Результатом сложения двух строк, является строка состоящая из переданных.

// 4) Результатом деления строки на число n, является строка в n раз короче исходной.

// 5) Результатом умножения строки на число n, является строка,
//    в которой переданная строка повторяется ровно n раз.

// 6) Результатом вычитания строки из строки, является строка,
//    в которой удалена переданная подстрока или сама исходная строка,
//    если в нее нет вхождения вычитаемой строки.

//    [...]

// 8) Калькулятор умеет работать только с целыми числами.

//   [...]

// 10) При вводе пользователем неподходящих чисел, строк или неподдерживаемых операций (например, деление строки на строку)
//     приложение выбрасывает исключение и завершает свою работу.

//   [...]

// 11) При вводе пользователем выражения, не соответствующего одной из вышеописанных арифметических операций,
//     приложение выбрасывает исключение и завершает свою работу.


// Примеры работы калькулятора:

// Ввод:
// "100" + "500"

// Итог:
// "100500"

// Итог:
// "Hi World!" - "World!"

// Итог:
// "Hi "

// Итог:
//  "Bye-bye!" - "World!"

// Итог:
// "Bye-bye!"

// Итог:
// "Java" * 5

// Итог:
// "JavaJavaJavaJavaJava"

// Ввод:
// "Example!!!" / 3

// Итог:
// "Exa"


public class Main
{
    public static void main(String[] args)

    throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

//7) Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. И строки длинной не более 10 символов.
        if (input.length() > 10) {
            throw new Exception("Некорректный ввод!");
        }

            char operation;
            String[] arrayOfInput;

        if (input.contains(" + "))
        {
                arrayOfInput = input.split(" \\+ ");
                operation = '+';
        }

        else if (input.contains(" - "))
        {
                arrayOfInput = input.split(" - ");
                operation = '-';
        }

        else if (input.contains(" * "))
        {
                arrayOfInput = input.split(" \\* ");
                operation = '*';
        }

        else if (input.contains(" / "))
        {
                arrayOfInput = input.split(" / ");
                operation = '/';
        }

        else {throw new Exception("Некорректный ввод!");}


// 9) Первым аргументом выражения, подаваемого на вход, должна быть строка,
//    при вводе пользователем выражения вроде 3 + "hello",
//    калькулятор должен выбросить исключение и прекратить свою работу.
            if (arrayOfInput[0].contains("\""))
            {
                if (operation == '*' || operation == '/')
                {if (arrayOfInput[1].contains("\"")) throw new Exception("Некорректный ввод!");}


                for (int i = 0; i < arrayOfInput.length; i++)
                {
                    arrayOfInput[i] = arrayOfInput[i].replace("\"", "");
                }

                if (operation == '+')
                {
                    finalPhrase(arrayOfInput[0] + arrayOfInput[1]);
                }

                else if (operation == '*')
                {
                    int number = Integer.parseInt(arrayOfInput[1]);
                    if (number < 1 || number > 10) {throw new Exception("Некорректный ввод!");}

                    String result = "";
                    for (int i = 0; i < number; i++) {result += arrayOfInput[0];}

                    finalPhrase(result);
                }

                else if (operation == '-')
                {
                    int index = arrayOfInput[0].indexOf(arrayOfInput[1]);
                    if (index == -1) {finalPhrase(arrayOfInput[0]);}

                    else
                    {
                        String result = arrayOfInput[0].substring(0, index);
                        result += arrayOfInput[0].substring(index + arrayOfInput[1].length());
                        finalPhrase(result);
                    }
                }

                else
                {
                    int subresult = arrayOfInput[0].length() / Integer.parseInt(arrayOfInput[1]);

                    if (Integer.parseInt(arrayOfInput[1]) < 1 || Integer.parseInt(arrayOfInput[1]) > 10)
                    {throw new Exception("Некорректный ввод!");}

                    String result = arrayOfInput[0].substring(0, subresult);
                    finalPhrase(result);
                }

            }

            else {throw new Exception("Некорректный ввод!");}

    }

// 7) Если строка, полученная в результате работы приложения длиннее 40 символов,
//    то в выводе после 40 символа должны стоять три точки (...).
    static void finalPhrase (String text)
    {
        if (text.length() < 40){System.out.println("\"" + text + "\"");}
        else {System.out.println("\"" + text.substring(0,40) + "..." + "\"");}
    }
}
