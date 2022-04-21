package demo;

public class WordTool {


    public String findOccurrences(String word, String pattern){
        if(!word.contains(pattern)){
            return "no " + pattern + " pattern in word";
        }
        int patternLength = pattern.length();
        String result = "";
        String resultData = "[";
        while(word.contains(pattern)) {
            int place = word.indexOf(pattern);
            if(resultData.equals("[")){
                resultData += place;
            } else {
                resultData += ", " + place;
            }
            result += word.substring(0, place);
            result += colorText(word.substring(place, (place+patternLength)));
            word = word.substring(place+patternLength);
        }
        result += word;
        resultData += "]";
        return "Pattern found in substring(s): " + resultData + "\n" + result;
    }
    private String colorText(String text){
        return "\u001B[32m" + text + "\u001B[0m";
    }
}
