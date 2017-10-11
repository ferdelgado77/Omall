package solucionesbeacon.omall.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Comercios {

    /**
     * An array of sample (dummy) items.
     */
    ///public static final List<Comercio> ITEMS = new ArrayList<Comercio>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Comercio> ITEM_MAP = new HashMap<String, Comercio>();

    private static final int COUNT = 12;

    //static {

    //  for (int i = 1; i <= COUNT; i++) {
    //        addItem(createDummyItem(i));
    //    }
    // }

    private static void addItem(Comercio item) {
       // ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Comercio createDummyItem(int position) {
        if (position<4) {
            return new Comercio(String.valueOf(position), "Item " + position, makeDetails(position), false);
        }
        else{
            return new Comercio(String.valueOf(position), "COMERCIO " + position, makeDetails(position), false);

        }
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */

}
