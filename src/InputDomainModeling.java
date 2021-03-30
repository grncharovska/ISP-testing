package Dom_1;

import java.util.HashSet;
import java.util.Set;

public class InputDomainModeling {

    public Set setDifference(Set set1, Set set2) {
        if (set1 == null || set2 == null )
            throw new NullPointerException();

        Set result = new HashSet(set1);
        result.removeAll(set2);

        if (result.isEmpty())
            return null;

        return result;
    }
}
