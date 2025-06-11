package Laboratory08.Problem85;

public class MyTable {
	private Entry[] entries;

	//constructor
	public MyTable(){
		entries = new Entry[26]; //26 characters (a-z)
	}
	//returns the String that is matched with char c in the table
	public String get(char c){
		int index = c - 'a';
		//if index is 0, it's a, 1 is b etc.
		if( index >= 0 ) return entries[index].str;

		return null;
	}
	//adds to the table a pair (c, s) so that s can be looked up using c 
	public void add(char c, String s) {
		int index = c - 'a';
		//if index is 0, it's a, 1 is b etc.
		if( index >= 0 ) {
			entries[index] = new Entry(s,c);
		}
	}
	//returns a String consisting of nicely formatted display
	//of the contents of the table
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for( Entry e : entries ){
			if(e != null)
				sb.append(e.toString()).append("\n");
		}
		return sb.toString();
	}
	
	
	private class Entry {
		String str;
		char c;
		Entry(String str, char ch){
			this.str = str;
			this.c = ch;
		}
		//returns a String of the form "ch->str" 
		public String toString() {
			//implement
			return c + "->" + str;
		}
	}

	public static void main(String[] args){
		MyTable t = new MyTable();
		t.add('a',"Andrew");
		t.add('b',"Billy");
		t.add('w',"Willie");
		System.out.println(t);
	}

}