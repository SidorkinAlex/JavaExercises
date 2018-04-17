package cz.parser;

/**
 * CLExecutor - the command-line executor
 *
 * @author Sergey Iryupin
 * @version 0.2.3 dated Apr 17, 2018
 */
import java.util.HashMap;
import java.util.Map;

public class CLExecutor {
    private Map<String, Item> map = new HashMap<>();

    public void add(Item item) {
        map.put(item.getName(), item);
    }

    public void execute(String[] args) {
        for (int i = 0; i < args.length; i++) {
            for (Map.Entry<String, Item> item : map.entrySet())
                if (item.getValue().isAlias(args[i])) {
                    item.getValue().act(args, i);
                    System.out.println(args[i]);
                }
        }
    }
}