package com.beniregev.springcucumberexampleapp;

import java.util.ArrayList;

/**
 *  <p>
 *     <div>
 *         Simple POJO (Plain Old Java Object) with private {@link ArrayList}
 *         property with simple basic methods to:
 *      </div>
 *      <div>
 *          {@code add}, {@code get}, {@code clear} and check {@code isEmpty}
 *      </div>
 *  </p>
 * @author Binyamin Regev
 * @since 1.8
 */
public class Bag {

    private final ArrayList<String> things;

    public Bag() {
        things = new ArrayList<>();
    }

    void add(final String something) {
        things.add(something);
    }

    public ArrayList<String> getThings() {
        return things;
    }

    public boolean isEmpty() {
        return things.isEmpty();
    }

    public void removeEverything() {
        things.clear();
    }
}
