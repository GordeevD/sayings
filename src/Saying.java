public class Saying{
    private String saying;
    private String sayingDescription;
    private String englishTranslation;
    private String englishMeaning;

    public Saying(String saying, String sayingDescription, String englishTranslation, String englishMeaning){
        this.saying = saying;
        this.sayingDescription = sayingDescription;
        this.englishTranslation = englishTranslation;
        this.englishMeaning = englishMeaning;
    }
    public Saying(String saying) {
        this(saying, null, null, null);
    }

    public String getSaying(){
        return this.saying;
    }

    public String getSayingDescription(){
        return this.sayingDescription;
    }

    public String getEnglishTranslation(){
        return this.englishTranslation;
    }

    public String getEnglishMeaning(){
        return this.englishMeaning;
    }

    @Override
    public String toString() {
        return getSaying();
    }
}