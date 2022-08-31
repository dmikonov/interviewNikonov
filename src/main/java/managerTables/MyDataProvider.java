package managerTables;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object []> dataSearch(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{2,"Alfreds Futterkiste",2,"Germany"});
        list.add(new Object[]{3,"Centro comercial Moctezuma",3,"Mexico"});
        return list.iterator();
    }
}
