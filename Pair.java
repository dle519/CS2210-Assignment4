
public class Pair {

	private String word;
	private String type;

	public Pair(String word, String type) {
		this.word = word.toLowerCase();
		this.type = type.toLowerCase();
	}

	public String getWord() {
		return this.word;
	}

	public String getType() {
		return this.type;
	}

	public int compareTo(Pair k) {
		// If the key words are the same
		if (this.word.compareTo(k.getWord()) == 0) {
			// if the key type of this object is lexographically < than type given
			if (this.type.compareTo(k.getType()) < 0) {
				return -1;
			}
			// If the key type of this object is lexographically > than type given
			else if (this.type.compareTo(k.getType()) > 0) {
				return 1;
			} else {
				return 0;
			}
		}
		// If the current word is smaller than the comparing key
		else if (this.word.compareTo(k.getWord()) < 0) {
			return -1;
		}
		// If the current word is greater than the comparing key
		else {
			return 1;
		}
	}

}
