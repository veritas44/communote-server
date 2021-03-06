package com.communote.common.matcher;

import java.util.HashSet;
import java.util.Set;

/**
 * Matcher, representing an OR conjunction of sub matchers.
 * 
 * <p>
 * <b>Note:</b> No child matchers will always return true.
 * </p>
 * 
 * @author Communote GmbH - <a href="http://www.communote.com/">http://www.communote.com/</a>
 * 
 * @param <T>
 *            Type of entity to match.
 */
public class OrMatcher<T> extends Matcher<T> {

    private final Set<Matcher<T>> matchers = new HashSet<Matcher<T>>();

    /**
     * Constructor.
     */
    // Avoid compile warnings.
    public OrMatcher() {
        // Do nothing.
    }

    /**
     * Constructor.
     * 
     * @param matchers
     *            Additional matchers.
     */
    public OrMatcher(Matcher<T>... matchers) {
        if (matchers != null) {
            for (Matcher<T> matcherr : matchers) {
                this.matchers.add(matcherr);
            }
        }
    }

    /**
     * Method to add new matchers.
     * 
     * @param matcher
     *            Matcher to add.
     */
    public void addMatcher(Matcher<T> matcher) {
        matchers.add(matcher);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean matches(T entity) {
        // No matchers return true.
        if (matchers.size() == 0) {
            return true;
        }
        for (Matcher<T> matcher : matchers) {
            if (matcher.matches(entity)) {
                return true;
            }
        }
        return false;
    }
}
