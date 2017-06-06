import java.util.HashMap;
import java.util.ArrayList;
class MapTest {
	public static void main(String[] args){
		Map mapManager = new Map();
		HashMap<String, String>  map = mapManager.newMap();
		mapManager.add("abc", "def", map);
		mapManager.add("ghi", "jkl", map);
		mapManager.add("mno", "pqr", map);
		mapManager.add("stu", "vwx", map);
		System.out.println(mapManager.get("abc", map));
		ArrayList<String> keys = new ArrayList<String>(map.keySet());
		//System.out.println(keys);
		ArrayList<String> values = new ArrayList<String>(map.values());
		for (int i = 0; i < map.size(); i++){
			System.out.println("Track: " + keys.get(i) + ", Lyrics: " + values.get(i));
		}
	}
		
		
}