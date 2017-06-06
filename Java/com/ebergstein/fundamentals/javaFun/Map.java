import java.util.HashMap;
class Map {
	public HashMap<String, String> newMap(){
		HashMap<String, String>  map = new HashMap<>();
		return (map);
	}
	public void add(String key, String value, HashMap<String, String> map){
		map.put(key, value);
	}
	public String get(String key, HashMap<String, String> map){
		return map.get(key);
	}
}