package Items;

import java.util.HashMap;
import java.util.Map;

public class Datalist {
    Map<Integer,Data> dt=new HashMap<>();

    public void putData(Integer id,Data data){
        dt.put(id,data);
    }

}
