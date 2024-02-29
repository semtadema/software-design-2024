public class Card {
    public String fromWord;
    public String toWord;
    public String fromHint;
    public String toMeaning;

    public static final int MAX_WORD_LENGTH = 16;
    public static final int MAX_SENTENCE_LENGTH = 128;

    // rather than making a constructor i decided to make methods to set the values of the fields
    // this is so that we can have flexibility to generate the cards by part insted of all at once

    public void setFromWord(String fromWord) throws Exception{
        if(fromWord.length() > MAX_WORD_LENGTH) {
            throw new Exception("Word length is too long");
        }
        if(fromWord.length() == 0) {
            throw new Exception("Empty string");
        }
        this.fromWord = fromWord;
    }

    public void setToWord(String toWord) throws Exception{
        if(toWord.length() > MAX_WORD_LENGTH) {
            throw new Exception("Word length is too long");
        }
        if(toWord.length() == 0) {
            throw new Exception("Empty string");
        }
        this.toWord = toWord;
    }

    public void setFromHint(String fromHint) throws Exception{
        if(fromHint.length() > MAX_SENTENCE_LENGTH) {
            throw new Exception("Sentence length is too long");
        }
        this.fromHint = fromHint;
    }

    public void setToMeaning(String toMeaning) throws Exception{
        if(toMeaning.length() > MAX_SENTENCE_LENGTH) {
            throw new Exception("Sentence length is too long");
        }
        this.toMeaning = toMeaning;
    }

    public void verify() throws Exception{
        if(fromWord == null || toWord == null) {
            throw new Exception("One or more mandated fields are null");
        }

        if(fromWord.length() == 0 || toWord.length() == 0) {
            throw new Exception("One or more mandated fields are empty");
        }
    }
}
