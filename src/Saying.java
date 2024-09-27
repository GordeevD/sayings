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

    /**
    * =====================================================================================
    * Method Name: Saying
    * -------------------------------------------------------------------------------------
    * Description: 
    *    Constructor for Saying object
    * 
    * Parameters:
    *    @param saying - Hawaiian version of saying
    *    @param sayingDescription - English description of saying
    *    @param englishTranslation - English translation of saying
    *    @param englishMeaning - English meaning of saying
    * 
    * Returns:
    *    N/A
    * 
    * -------------------------------------------------------------------------------------
    * Author:  Jarren Seson
    * =====================================================================================
    */
    public Saying(String saying, String sayingDescription, String englishTranslation, String englishMeaning){
        this.saying = saying;
        this.sayingDescription = sayingDescription;
        this.englishTranslation = englishTranslation;
        this.englishMeaning = englishMeaning;
    }

    // Implemented by Dmitry 
    public Saying(String saying) {
        this(saying, null, null, null);
    }
   
    /**
    * =====================================================================================
    * Method Name: getSaying
    * -------------------------------------------------------------------------------------
    * Description: 
    *    Returns saying property of Saying object
    * 
    * Parameters:
    *    N/A
    * 
    * Returns:
    *    @return - Saying property of Saying object
    * 
    * -------------------------------------------------------------------------------------
    * Author:  Jarren Seson
    * =====================================================================================
    */
    public String getSaying(){
        return this.saying;
    }

    // Implemented by Dmitry
    public String getSayingDescription(){
        return this.sayingDescription;
    }

    /**
    * =====================================================================================
    * Method Name: getEnglishTranslation
    * -------------------------------------------------------------------------------------
    * Description: 
    *    Returns english translation property of Saying object
    * 
    * Parameters:
    *    N/A
    * 
    * Returns:
    *    @return - English translation property of Saying object
    * 
    * -------------------------------------------------------------------------------------
    * Author:  Jarren Seson
    * =====================================================================================
    */
    public String getEnglishTranslation(){
        return this.englishTranslation;
    }

    /**
    * =====================================================================================
    * Method Name: getEnglishMeaning
    * -------------------------------------------------------------------------------------
    * Description: 
    *    Returns english meaning property of Saying object
    * 
    * Parameters:
    *    N/A
    * 
    * Returns:
    *    @return - English meaning property of Saying object
    * 
    * -------------------------------------------------------------------------------------
    * Author:  Jarren Seson
    * =====================================================================================
    */
    public String getEnglishMeaning(){
        return this.englishMeaning;
    }

    // Implemented by Dmitry
    @Override
    public String toString() {
        return getSaying();
    }
}