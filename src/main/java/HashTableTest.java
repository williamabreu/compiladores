import java.util.Hashtable;

public class HashTableTest {
    public static void main(String[] args) {
        Hashtable<String, String> $hs = new Hashtable<>();
        $hs.put("0xFF01", "Um");
        $hs.put("0xFF02", "Dois");
        $hs.put("0xFF03", "Três");
        System.out.println($hs);

        String addr = $hs.get("0xFF026");
        System.out.println(addr);
    }
}
