import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FirstAndLast {
	
	static int count = 1;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String var = in.nextLine();
		
		Map<Character, Integer> hmap = new HashMap<Character, Integer>();
		
		
		
		var.codePoints().forEach((c) -> {
			if (hmap.containsKey((char)c)) {
				hmap.put((char)c, count++);
			}
			else hmap.put((char)c, 0);
		});
		
		
		Map<Character, Integer> res = hmap.entrySet().stream().filter(map -> (map.getValue() > 0)).
				sorted(Map.Entry.<Character, Integer> comparingByValue()) .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

		
		System.out.println("first:  " + res.entrySet().toArray()[0]);
		
		System.out.println("last:  " + res.entrySet().toArray()[res.size() - 1]);
		
	}
	
	

}
