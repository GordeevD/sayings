/*
 * =====================================================================================
 *
 *       Filename:  Saying.java
 *
 *    Description:  Implementation of Saying object, that contains the saying, the 
 *                  description of the saying, the english translation, and the english
 *                  meaning of the saying.
 *
 *         Author:  Jarren Seson, Dmitry Gordeev
 *
 * =====================================================================================
 *
 *   Methods:
 *   1. leftRoation (Node x)    
 *   2. rightRotation (Node x)
 *   3. meHua (String saying)
 *   4. withWord (String saying)
 *
 * =====================================================================================
 */

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