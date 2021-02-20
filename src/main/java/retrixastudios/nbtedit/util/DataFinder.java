package retrixastudios.nbtedit.util;

public class DataFinder {

    public static Object getType(String data) {
        if(isInteger(data)) return Integer.parseInt(data);
        if(isBoolean(data)) return Boolean.parseBoolean(data);
        return data;
    }

    private static boolean isInteger(String data) {
        try {
            Integer.parseInt(data);
        } catch(NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    private static boolean isBoolean(String data) {
        if(data.toLowerCase().equalsIgnoreCase("true") || data.toLowerCase().equalsIgnoreCase("false")) return true;
        return false;
    }

}
