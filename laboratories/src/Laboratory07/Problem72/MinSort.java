package Laboratory07.Problem72;

public class MinSort {
    public static String sort(String s){
        StringBuilder sb = new StringBuilder(s);
        int minChar = 27;
        int minpos = 0; // consider the char count will have total 26 (1 to 26)
        //s = abcge
        if( s == null || s == "") return "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) - 'a' < minChar) {
                minChar = s.charAt(i) - 'a';
                minpos = i;
            }

        }
        // System.out.println("minps "+minpos);
        sb.deleteCharAt(minpos);
        return s.charAt(minpos) + sort(sb.toString());
    }
    public static void main(String[] args){
        MinSort ms = new MinSort();
        String result = ms.sort("zwxuabfkafutbbbb");
        System.out.println(result);
    }


}
