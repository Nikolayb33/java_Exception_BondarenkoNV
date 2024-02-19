import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.type.ErrorType;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> b = enterList();// ввод данных

        int a = codeError(b);//Проверка на код ошибки

        answer(a);//Выводит ответ на вопрос достаточно ли указано данных пользователем

    }


/*
 * Ввод данных
 */
    public static ArrayList<String> enterList(){
        System.out.println("Введите данные:");
        Scanner sc = new Scanner(System.in);
        String i = sc.nextLine();
        ArrayList<String> result = new ArrayList<>();
        for (String s :i.split(" ")){
            result.add(s);
        }
        // ArrayList<String> result = new ArrayList<>(result_l.);
        return result;
    }

/*
 * Проверка на код ошибки
 */
    public static int codeError(ArrayList<String> enterList){
        if (enterList.size() > 6){
            return -1;
        }
        if (enterList.size() < 6){
            return -2;
        }
        else{
            return enterList.size();
        }
    }

/*
 * Выводит ответ на вопрос достаточно ли указано данных пользователем
 */
    public static void answer(int a) {
        if(a == -1){
            System.out.println("Введено больше данных");
        }
        if(a == -2){
            System.out.println("Введено меньше данных");
        }
        if(a == 6){
            System.out.println("Введено нужное количество данных");
        }
    }

/*
 * распарсим строку и посмотрим нужный ли формат данных
 */
    public static void exceptionData(ArrayList<String> enterList) {
        int i = 0;
        String a0 = enterList.get(0);
        String a1 = enterList.get(1);
        String a2 = enterList.get(2);
        String a3 = enterList.get(3);
        try {
            Integer a4 = Integer.parseInt(enterList.get(4));    
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        String a5 = enterList.get(5);

        // if (enterList.get(0) instanceof String){
        //     i ++;
        // }
        // if (enterList.get(1) instanceof String){
        //     i ++;
        // }
        // if (enterList.get(2) instanceof String){
        //     i ++;
        // }
        // if (enterList.get(3) instanceof String | enterList.get(3).split(".").length == 3){
        //     i ++;
        // }
        // if (Integer.parseInt(enterList.get(4)){
        //     i ++;
        // }
        // if (Integer.parseInt(enterList.get(5)) == "m" || Integer.parseInt(enterList.get(5)) == "f"){
        //     i ++;
        // }
    }
}


