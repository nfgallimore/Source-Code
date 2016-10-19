package com.aethos.parser;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.List;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        for (String str : args) 
        {    
            final URL     url        = new URL(str);
            Article       article    = new Article(url);
            List<String>  names      = EntityExtractor.extractNames(article.getText());
            List<String>  sentences  = EntityExtractor.extractSentences(article.getText());
            APIInterfacer api        = new APIInterfacer();
            JSONObject    articleRes = api.addArticle(url.toString(), article.getTitle(), article.getImage());

            // First part of the sentence preview object is this articleId
            String articleId = articleRes.getString("objectId");

            // For every name in the the article,
            for (String name : names) {
                for (String sentence : sentences) {
                    if (sentence.contains(name)) {
                        try {
                            // Filters out names that aren't in backend by calling APIInterfacer.getUser
                            JSONObject userRes = api.getUser(name);

                            // The second part of the sentence preview object is this userId
                            String userId = userRes.getString("objectId");

                            // creates the sentence preview in the backend database with the first
                            // sentence of the article in which that first sentence contains a name from the database
                            api.addPreview(userId, articleId, sentence);

                        } catch (JSONException e) {
                            System.out.println("Error with JSON in request, most likely " + name + " is an invalid user name.");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break; // break out of inner look and continue to next name
                    }
                }
            }
        }
    }
}