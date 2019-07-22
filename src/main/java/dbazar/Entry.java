package dbazar;


import java.util.Date;
import java.util.HashMap;


public class Entry {

    private HashMap<String,Object> hashMap =new HashMap<String, Object>();

    public  HashMap getHashMap() {
        return hashMap;
    }

    public  void setValue(String string1, String string2 ) {
        hashMap.put(string1,string2);

    }public  void setValue(String string, Date date ) {
        hashMap.put(string, date);

    }public void setValue(String string, int integer){
        hashMap.put(string,integer);
    }
}
