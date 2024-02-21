

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Exception.GenderException;
import Exception.NameException;
import Exception.PhoneNumberException;


public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> b = enterList();// ввод данных

        int a = codeError(b);//Проверка на код ошибки

        answer(a);//Выводит ответ на вопрос достаточно ли указано данных пользователем

        System.out.println("_____________");// разделим код

        
        /*
         * проверяет строку на соотвествие формата ввода и если не равно null
         * то создает и записывает данные в файл
         */
        try{
            ArrayList<String> toFile = exceptionData(b);
            writeToFile(toFile);
        }catch(NullPointerException e){
            e.printStackTrace();
            System.out.println("Не корректные входные данные");
            System.out.println("____________________________");

        }
        
        
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
 * распарсим строку и посмотрим нужный ли формат данных с помощью
 * исключений
 */

 /*
  * метод поиска ошибки и выброса исключения для фио
  */
    public static void cycleOfString(String str){
        
        for(String s: str.split("")){
            if (Character.isLetter(s.charAt(0))){
                // System.out.println(s);
            }
            else {
                throw new NameException();
            }
        }
    }
/*
 * метод поиска ошибки и выброса исключения для телефона
 */
    public static void cycleOfNum(String str){
        
        for(String s: str.split("")){
            if (Character.isDigit(s.charAt(0))){
                // System.out.println(s);
            }
            else {
                throw new PhoneNumberException();
            }
        }
    }

    /*
     *метод поиска ошибки в выборе пола 
     */

     public static void genderErrorTest(String str){
        if (str.equals("m") || str.equals("f")){
            System.out.println("Правильно указан пол");
            System.out.println("_____________"); 
        }
        // if(){
        //     System.out.println("Правильно указан пол");
        // }
        else{
            throw new GenderException();
        }

     }
/*
 * метод для клиентского кода для поиска ошибок
 */
    public static ArrayList<String> exceptionData(ArrayList<String> enterList) {

/*Проверка фио
*/        
        int res = 0;
        try{

            System.out.println("Проверка имени...");
            String a0 = enterList.get(0);
            cycleOfString(a0);
            System.out.println("Имя введено правильно");
            System.out.println("_____________");

            System.out.println("Проверка фамилии...");
            String a1 = enterList.get(1);
            cycleOfString(a1);
            System.out.println("Фамилия введена правильно");
            System.out.println("_____________");

            System.out.println("Проверка отчества...");
            String a2 = enterList.get(2);
            cycleOfString(a2);
            System.out.println("Отчество введено правильно");
            System.out.println("_____________");

        }catch(NameException e){
            res ++;
            e.printStackTrace();
            System.out.println("Ошибка в ФИО");
            
            
        }
/*Проверка телефона
 */        
        try {
            System.out.println("Проверка телефона...");
            cycleOfNum(enterList.get(4));
            System.out.println("Телефон введен правильно"); 
            System.out.println("_____________");  
        } catch (PhoneNumberException e) {
            res ++;
            e.printStackTrace();
            System.out.println("Не правильный формат номера телефона");
        } 
/*
 * проверка даты
 */
        try{
            System.out.println("Проверка даты рождения...");
            SimpleDateFormat date_format = new SimpleDateFormat("dd.MM.yyyy");
            Date date_res;
            date_res = date_format.parse(enterList.get(3));
            System.out.println("Дата рождения введена верно");
            System.out.println("_____________"); 
            // System.out.println(date_res);
        }
        catch(ParseException e){
            res ++;
            e.printStackTrace();
            System.out.println("Не правильный формат даты рождения");
            System.out.println("_____________"); 

        }

/*
 * проверка пола
 */
        try {
            System.out.println("Проверка пола...");
            genderErrorTest(enterList.get(5));
        } catch (GenderException e) {
            res ++;
            e.printStackTrace();
            System.out.println("Не правильно указан пол...");
            System.out.println("_____________"); 
            
        }
        if (res == 0){
            
            return enterList;
        }
        else{
            return null;
        }

    }


    /*
     * запись строки в приложение
     */

      public static void writeToFile(ArrayList<String> enterList) throws IOException {
        String fileName = enterList.get(0) + ".txt";
        try {
            File path = new File(fileName);

            if (!path.exists()){
                path.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));

            String writeString = "<" + enterList.get(0) + ">" + " " + "<" + enterList.get(1) + ">" + " " +
                     "<" + enterList.get(2) + ">" + " " + "<" + enterList.get(3) + ">" + " " +
                     "<" + enterList.get(4) + ">" + " " + "<" + enterList.get(5) + ">";

            bw.write(writeString);
            System.out.println("Запись совершена");
            bw.newLine();
            bw.close();
            System.out.println("Файл закрыт");


        } catch (IOException e){
            throw new IOException("Произошла ошибка во время создания или записи файла");
        }

    }
}




