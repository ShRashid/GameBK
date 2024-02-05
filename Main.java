import java.util.Scanner;

/*
 * Быки и коровы — логическая игра, в ходе которой за несколько попыток 
 * один из игроков должен определить, что задумал другой игрок. Варианты 
 * игры могут зависеть от типа отгадываемой последовательности — это могут 
 * быть числа, цвета, пиктограммы или слова. После каждой попытки задумавший
 * игрок выставляет «оценку», указывая количество угаданного без совпадения 
 * с их позициями (количество «коров») и полных совпадений (количество «быков»).
 * Роли участников игры не равнозначны — угадывающий должен анализировать 
 * сделанные попытки и полученные оценки, то есть его роль активна. Его 
 * партнёр лишь сравнивает очередной вариант с задуманным и выставляет оценку 
 * по формальным правилам, то есть его роль пассивна. Для уравновешивания 
 * ролей одновременно играют две встречные партии.
 */
public class Main {
    public static void main(String[] args) {
        while (true) {
            AbstractGame ag = new GameNumber();
            OutStringInLanguage ln = new OutStringInLanguage();
            LogFile log = new LogFile();
            ag.start(5, 3);
            int lang = 1; // default language Russian
            int menu = 1; // default menu
        
            System.out.println("Please enter the language: 1 - Русский,2 - English");
            Scanner scaner = new Scanner(System.in);
            lang = scaner.nextInt();
            System.out.println(ln.outStrInLang(lang, "Введите значение ", "Enter the value "));
            log.clearLog(); // clear log
            Scanner value = new Scanner(System.in);
            while (ag.getGameStatus().equals(GameStatus.START)) {
                String txt = value.nextLine();
                //Answer answer = ag.inputValue(lang, value.nextLine());
                log.saveLog(txt);
                Answer answer = ag.inputValue(lang, txt);
                System.out.println(answer);
            }
            if (ag.getGameStatus().equals(GameStatus.WIN)) {
                System.out.println(ln.outStrInLang(lang, "Вы победили", "You have won"));
            } else if (ag.getGameStatus().equals(GameStatus.LOOSE)) {
                System.out.println(ln.outStrInLang(lang, "Вы проиграли", "You've lost"));
            } else {
                System.out.println(ln.outStrInLang(lang, "Неопределенный статус", "Unidentified status"));
            }
            System.out.println(ln.outStrInLang(lang, "Для перезапуска игры нажмите 1, для выхода 0, для просмотра лога 2", "To restart the game, press 1, to exit 0, to view the log 2"));
            //log.readLog();
            menu = scaner.nextInt();
            if(menu == 0) {break;}
            else if(menu == 2){
                log.readLog();
                break;
            }
        }
    }

}