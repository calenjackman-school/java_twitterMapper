package filters;

import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * A filter that represents the logical not of its child filter
 */
public class AndFilter implements Filter {
    private final Filter child1;
	private final Filter child2;

    public AndFilter(Filter child1, Filter child2) {
        this.child1 = child1;
        this.child2 = child2;
    }

    /**
     * A not filter matches when its child doesn't, and vice versa
     * @param s     the tweet to check
     * @return      whether or not it matches
     */
    @Override
    public boolean matches(Status s) {
        return child1.matches(s) && child2.matches(s);
    }

    @Override
    public List<String> terms() {
    	List<String> retVar = new ArrayList<>();
    	for (String i : child1.terms()) {
    		if (!retVar.contains(i)) { retVar.add(i); }
		}
		for (String i : child2.terms()) {
			if (!retVar.contains(i)) { retVar.add(i); }
		}
    	return retVar;
    }

    public String toString() {
        return "(" + child1.toString() + " and " + child2.toString() + ")";
    }
}
