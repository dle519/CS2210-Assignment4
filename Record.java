
public class Record {
	private Pair key;
	private String data;
	
	
	public Record (Pair key, String data) {
		this.key = key;
		this.data = data.toLowerCase();
	}
	
	public Pair getKey() {
		return this.key;
	}
	
	public String getData() {
		return this.data;
	}

}
