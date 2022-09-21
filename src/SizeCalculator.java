import java.util.HashMap;
import static java.lang.Long.parseLong;

public class SizeCalculator
{
    private static final char[] sizeMultipliers =
            {'B', 'K', 'M', 'G', 'T'};
    private static final HashMap<Character, Integer>
            char2multiplier = getMultipliers();

    public static String getHumanReadableSize(long size)
    {
        for (int i = 0; i < sizeMultipliers.length; i++)
        {
            double value = (double) size / Math.pow(1024, i);
            if(value < 1024) {
                return Math.round(value * 100)/100. + " " + sizeMultipliers[i] +
                        (i > 0 ? "b" : "");
            }
        }
        return "Very big!";
    }

    public static long getSizeFromHumanReadable(String size)
    {
        char sizeFactor = size.replaceAll("[0-9\\s+]+", "").charAt(0);
        int multiplier = char2multiplier.get(sizeFactor);
        long length;
        length = multiplier * parseLong(size.replaceAll("[^0-9]", ""));
        return length;
    }

    private static HashMap<Character, Integer> getMultipliers()
    {
        HashMap<Character, Integer> char2Multiplier = new HashMap<>();
        for (int i = 0; i < sizeMultipliers.length; i++) {
            char2Multiplier.put(
                    sizeMultipliers[i],
                    (int) Math.pow(1024, i)
            );
        }
        return char2Multiplier;
    }
}
