public class Answer {
    private int cowCounter;
    private int bullCounter;
    private Integer tryCount;
    private int langText;
    

    @Override
    public String toString() {
        OutStringInLanguage ln = new OutStringInLanguage();
        String message = "";
        message = ln.outStrInLang(langText, cowCounter + " коровы " + bullCounter + " быков, осталось попыток : " + tryCount,cowCounter + " cows " + bullCounter + " bulls, there are still attempts left : " + tryCount);
        return message;
    }

    public Answer(int cowCounter, int bullCounter, Integer tryCount, int langText) {
        this.cowCounter = cowCounter;
        this.bullCounter = bullCounter;
        this.tryCount = tryCount;
        this.langText = langText;
    }
}