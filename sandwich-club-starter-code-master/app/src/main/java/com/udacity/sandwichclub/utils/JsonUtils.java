package com.udacity.sandwichclub.utils;


import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonUtils {

    public JsonUtils() throws JSONException {}

    public static Sandwich parseSandwichJson(String json) {

        try {


            JSONObject root = new JSONObject(json); // for getting JSON OBJECT from the string
            JSONObject _name = root.getJSONObject("name");// get name

            String mainName = _name.getString("mainName"); // get main name

            JSONArray alsoKnowArray = _name.getJSONArray("alsoKnownAs"); // get alsoKnownAs
            List<String> alsoKnownAsList = new ArrayList<>();// to store the alsoName items

            String placeOfOrigin = root.getString("placeOfOrigin"); // get PlaceOfOrigin
            String description = root.getString("description");// get description
            String imagePath = root.getString("image");// get image

            JSONArray ingredientArray = root.getJSONArray("ingredients");// get ingredients
            List<String> ingredientList = new ArrayList<>();// to store the ingredients items

            // add alsoKnowAs names to alsoKnowList
            for (int i = 0; i < alsoKnowArray.length(); i++) {
                String alsoKnownAs = alsoKnowArray.getString(i);
                alsoKnownAsList.add(alsoKnownAs);
            }

            //add ingredients to ingredientList
            for (int i = 0; i < ingredientArray.length(); i++) {
                ingredientList.add(ingredientArray.getString(i));
            }

            Sandwich sandwich = new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, imagePath, ingredientList);
            return sandwich;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}