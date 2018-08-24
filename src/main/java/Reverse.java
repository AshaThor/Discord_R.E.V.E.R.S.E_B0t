public class Reverse{
    public String getReverse(String text)
        {
            String plainText = text;
            plainText = plainText.toLowerCase();
            String targetText = plainText.replace("!reverse ","");
            String reverseText = "";
            for(int i = targetText.length() -1 ; i >= 0; i--) {
                reverseText = reverseText + targetText.charAt(i);
            }
            return reverseText;
        }
}
