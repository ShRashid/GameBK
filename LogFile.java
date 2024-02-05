import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class LogFile {
    public static void saveLog(String text){
        try {
            FileWriter fileWriter = new FileWriter("input_log.txt", true); // Создаем объект FileWriter для записи в файл. Параметр true указывает на добавление данных к существующему файлу
            BufferedWriter writer = new BufferedWriter(fileWriter); // Создаем объект BufferedWriter для записи строк в поток файлов
            // Запись введенных данных в лог-файл
            writer.write(text);
            writer.newLine(); // Добавляем разделитель между вводами
            writer.close(); // Закрываем файл
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readLog(){
        //Пример чтения данных из лог-файла:
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input_log.txt")); // Создаем объект BufferedReader для чтения из файла
            String line;
            System.out.println("Содержимое лог-файла:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Выводим каждую строку из файла
            }
            reader.close(); // Закрываем файл
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void clearLog(){
        try {
            FileWriter fileWriter = new FileWriter("input_log.txt", false); // Передаем параметр false для перезаписи файла
            fileWriter.write(""); // Перезаписываем файл пустой строкой
            fileWriter.close();            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}