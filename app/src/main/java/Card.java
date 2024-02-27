public class Card {
    public String fromWord;
    public String toWord;
    public String fromHint;
    public String toMeaning;

    public Card(String fromWord, String toWord, String fromHint, String toMeaning) throws Exception{
        if(fromWord == null) {
            throw new Exception("From word is required!");
        }
        if(toWord == null) {
            throw new Exception("To word is required!");
        }

        if(fromHint == null) {
            this.fromHint = "";
        }

        if(toMeaning == null) {
            this.toMeaning = "";
        }

        this.fromWord = fromWord;
        this.toWord = toWord;
        this.toMeaning = toMeaning;
        this.fromHint = fromHint;
    }

}
