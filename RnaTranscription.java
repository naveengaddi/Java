import java.util.HashMap;
import java.util.Map;
class RnaTranscription {

    String transcribe(String dnaStrand) {
    	Map<Character,Character> map = new HashMap<>();
        map.put('G','C');
        map.put('C','G');
        map.put('T','A');
        map.put('A','U');

        String rna = "";
        for (int i = 0 ; i < dnaStrand.length() ; i++ ) {
            rna += map.get(dnaStrand.charAt(i));
        }
        return rna;
        
    }
    public static void main(String[] args) {
        RnaTranscription rna = new  RnaTranscription();
        System.out.println(rna.transcribe("ACGTGGTCTTAA"));
    }
}
