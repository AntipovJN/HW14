import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        Arrays.stream(new Scanner(System.in).nextLine().toLowerCase().split("[\\p{Punct}\\s]+"))
                .collect(Collectors.toMap(a -> a, a -> 1, (a, b) -> a + b))
                .entrySet()
                .stream()
                .sorted(new EntryComparator())
                .limit(10)
                .forEach(x -> System.out.println(x.getKey()));
    }

    public static class EntryComparator implements Comparator<Entry<String, Integer>> {
        @Override
        public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
            return o1.getValue().compareTo(o2.getValue()) != 0 ?
                    -o1.getValue().compareTo(o2.getValue()) : o1.getKey().compareTo(o2.getKey());
        }
    }
}
