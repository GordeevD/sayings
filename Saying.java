public class Saying{
    private String saying;
    private String englishTranslation;
    private String englishMeaning;

    public Saying(String saying, String englishTranslation, String englishMeaning){
        this.saying = saying;
        this.englishTranslation = englishTranslation;
        this.englishMeaning = englishMeaning;
    }

    public String getSaying(){
        return this.saying;
    }

    public String getEnglishTranslation(){
        return this.englishTranslation;
    }

    public String getEnglishMeaning(){
        return this.englishMeaning;
    }
}