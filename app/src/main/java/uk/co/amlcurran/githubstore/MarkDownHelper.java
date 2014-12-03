package uk.co.amlcurran.githubstore;

import android.text.Html;
import android.widget.TextView;

/**
 * Quick and filthy markdowner
 */
public class MarkDownHelper {
    public static void markDown(TextView target)
    {
        String text = target.getText().toString();
        String[] components = text.split("\n");

        String htmlBuffer = "";
        for (String line : components) {
            if(line.startsWith("#"))
            {
                int headingStrength = countSimilarCharacters(line, '#', 0);
                if(headingStrength < 6)
                {
                    htmlBuffer += "<h"+headingStrength+">"+line.substring(headingStrength)+"</h"+headingStrength+">";
                }
            }
            else if(line.startsWith("* "))
            {
                htmlBuffer += "&bull; "+line.substring(2)+"<br>";
            }
            else
            {
                htmlBuffer += line+"<br>";
            }
        }

        target.setText(Html.fromHtml(htmlBuffer), TextView.BufferType.SPANNABLE);
    }


    private static int countSimilarCharacters(String input, char search, int offset)
    {
        int count = 0;
        for(int i = offset; i<input.length(); i++)
        {
            if(input.charAt(i) == search)
            {
                count++;
            }
            else
            {
                break;
            }
        }
        return count;
    }
}
