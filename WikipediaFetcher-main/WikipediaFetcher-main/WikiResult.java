package tech.codingclub.utility.GeneralClasses;

public class WikiResult {
    private String query;
    private String text_result;
    private String image_url;
    public WikiResult(String query, String textResult, String imageUrl)
    {
        this.query = query;
        text_result = textResult;
        image_url = imageUrl;
    }

}
