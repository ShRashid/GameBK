import java.util.List;
import java.util.Random;

public abstract class AbstractGame implements Game {
    abstract List<String> generateCharList();
    OutStringInLanguage ln = new OutStringInLanguage();

    private String word;
    Integer tryCount;
    GameStatus gameStatus = GameStatus.INIT;

    @Override
    public void start(Integer wordSize, Integer tryCount) {
        word = generateWord(wordSize);
        this.tryCount = tryCount;
        gameStatus = GameStatus.START;
    }

    private String generateWord(Integer wordSize) {
        List<String> alphabet = generateCharList();
        Random rnd = new Random();
        String result = "";
        for (int i = 0; i < wordSize; i++) {
            int randomIndex = rnd.nextInt(alphabet.size());
            result += alphabet.get(randomIndex);
            alphabet.remove(randomIndex);
        }
        return result;
    }

    @Override
    public Answer inputValue(int lang, String value) {
        if (!getGameStatus().equals(GameStatus.START)) {
            throw new RuntimeException(ln.outStrInLang(lang, "Игра не запущена", "The game is not running"));
        }
        int cowCounter = 0;
        int bullCounter = 0;
        for (int i = 0; i < word.length(); i++) {
            if (value.charAt(i) == word.charAt(i)) {
                cowCounter++;
                bullCounter++;
            } else if (word.contains(String.valueOf(value.charAt(i)))) {
                cowCounter++;
            }
        }
        tryCount--;
        if (tryCount == 0){
            gameStatus = GameStatus.LOOSE;
        }
        if (bullCounter == word.length()){
            gameStatus = GameStatus.WIN;
        }
        return new Answer(cowCounter, bullCounter, tryCount, lang);
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }
}