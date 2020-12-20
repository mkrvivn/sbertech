package CountMap;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {

    private Map<T, Integer> map;

    CountMapImpl(){
        this.map = new HashMap<>();
    }

    @Override
    public void add(T o) {
        map.computeIfPresent(o, (key, val) -> val + 1);
        map.putIfAbsent(o, 1);
    }

    @Override
    public int getCount(T o) {
        return map.getOrDefault(o, 0);
    }

    @Override
    public int remove(T o) {
        Integer r = map.computeIfPresent(o, (key, val) -> val - 1);
        if(r == null)
            return 0;
        if(r == 0)
        {
            map.remove(o);
            return 1;
        }
        return r + 1;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        source.toMap().forEach((key, val) -> {
            this.map.computeIfPresent(key, (outerKey, outerVal) -> outerVal + val);
            this.map.putIfAbsent(key, 1);
        });
    }

    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.putAll(map);
    }
}
