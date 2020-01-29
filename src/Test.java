
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;
public class Test { 
    public static final LinkedHashMap<String, Integer> ARRAYLIST = new LinkedHashMap<>();
    public static void main(String args[]) throws Exception {
        ARRAYLIST.put("OWO", 0);
        ARRAYLIST.put("OWO1", 1);
        ARRAYLIST.put("OWO2", 2);
        for(Map.Entry<String, Integer> a : ARRAYLIST.entrySet()){
            System.out.println(a);
        }
    } 
}