/*
===============================================================
   _____                       ______
  / ___/____ _____ ___  ____ _/ ____/___ _____ ___  ___  _____
  \__ \/ __ `/ __ `__ \/ __ `/ / __/ __ `/ __ `__ \/ _ \/ ___/
 ___/ / /_/ / / / / / / /_/ / /_/ / /_/ / / / / / /  __(__  )
/____/\__,_/_/ /_/ /_/\__,_/\____/\__,_/_/ /_/ /_/\___/____/

===============================================================
  Persistance API
  Copyright (c) for SamaGames, all right reserved
  By MisterSatch, January 2016
===============================================================
*/

package net.samagames.persistanceapi.utils;

import java.lang.reflect.Field;
import java.util.HashMap;

public class Transcoder
{
    // Remove dash to insert in the database
    public static String Encode(String uuid)
    {
        uuid = uuid.replace("-","");
        return uuid;
    }

    // Put lower case and add dash for uuid
    public static String Decode(String uuid)
    {
        // Regexp to format uuid
        uuid = uuid.toLowerCase();
        uuid = uuid.replaceAll("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5");
        return uuid;
    }

    // Convert javafield to string separate by point
    public static String parseField(String fieldName)
    {
        String parsedField = "";
        String[] separateField = fieldName.split("(?=\\p{Upper})");
        for (int i=0; i< separateField.length; i++)
        {
            parsedField += separateField[i].toLowerCase() +".";
        }
        parsedField = parsedField.substring(0,parsedField.length()-1);
        return parsedField;
    }

    // Make introspection of field of class
    public static HashMap<String, String> getHashMap(Object permissions)
    {
        // Defines
        Class theClass;
        Field[] fields;
        Field field;
        String fieldName;
        String fieldValue;
        HashMap<String, String> processedHashMap = new HashMap<>();

        // Do the reverse engineering
        try
        {
            // Get the class and fields
            theClass = permissions.getClass();
            fields = theClass.getDeclaredFields();
            // Iterate the fields
            for (int i = 0 ; i < fields.length ; i++)
            {
                // Set field accessible and get the name
                field = fields[i];
                field.setAccessible(true);
                fieldName = field.getName();
                // Check if the field is a permission
                if (! fieldName.equals("groupsId"))
                {
                    // Get the value
                    fieldValue = field.get(permissions).toString();
                    // Transcode the field name
                    fieldName = Transcoder.parseField(fieldName);
                    // Construct the HashMap
                    processedHashMap.put(fieldName, fieldValue);
                }
            }
            return processedHashMap;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return processedHashMap;
    }
}
