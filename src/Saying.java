public class Saying{
    private String saying;
    private String sayingDescription;
    private String englishTranslation;
    private String englishMeaning;

    // Implemented by Jarren
    public Saying(String saying, String sayingDescription, String englishTranslation, String englishMeaning){
        this.saying = saying;
        this.sayingDescription = sayingDescription;
        this.englishTranslation = englishTranslation;
        this.englishMeaning = englishMeaning;
    }

    // Implemented by Jarren 
    public Saying(String saying) {
        this(saying, null, null, null);
    }
   
    // Implemented by Jarren
    public String getSaying(){
        return this.saying;
    }

    // Implemented by Dmitry
    public String getSayingDescription(){
        return this.sayingDescription;
    }

    // Implemented by Jarren
    public String getEnglishTranslation(){
        return this.englishTranslation;
    }

    // Implemented by Jarren 
    public String getEnglishMeaning(){
        return this.englishMeaning;
    }

    // Implemented by Dmitry
    @Override
    public String toString() {
        return getSaying();
    }
}