/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST.service;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;
import TEST.StudentProfile;
import TEST.StudentLocation;
/**
 *
 * @author Yang-Deng
 */
public class sortHashMapByValues {
    
    public LinkedHashMap<StudentLocation, Double> sortHashMapByValues(HashMap<StudentLocation, Double> passedMap) 
    {
    List<StudentLocation> mapKeys = new ArrayList<>(passedMap.keySet());
    List<Double> mapValues = new ArrayList<>(passedMap.values());
    Collections.sort(mapValues);
    //Collections.sort(mapKeys);

    LinkedHashMap<StudentLocation, Double> sortedMap = new LinkedHashMap<>();

    Iterator<Double> valueIt = mapValues.iterator();
    while (valueIt.hasNext()) {
        Double val = valueIt.next();
        Iterator<StudentLocation> keyIt = mapKeys.iterator();

        while (keyIt.hasNext()) {
            StudentLocation key = keyIt.next();
            Double comp1 = passedMap.get(key);
            Double comp2 = val;

            if (comp1.equals(comp2)) 
            {
                keyIt.remove();
                sortedMap.put(key, val);
                break;
            }
        }
    }
    return sortedMap;
}
}
