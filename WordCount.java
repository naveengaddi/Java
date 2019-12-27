/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/
import java.util.Map;
import java.util.*;
import java.util.regex.*;
public class WordCount{
	public Map<String,Integer> phrase(String str){
		Map<String,Integer> map = new HashMap<String,Integer>();
		List<String> s_array = new ArrayList<>();
		Pattern p = Pattern.compile("[a-zA-Z']+");
		Matcher m = p.matcher(str);
		while(m.find()){
			String s1 = m.group();
			if( s1.charAt(0) == '\''){
				s1 = s1.replaceAll("\'","");
			}
			s_array.add(s1);
		}
		//System.out.println(s_array);
		for(String s:s_array){
			if(map.containsKey(s)){
				map.put(s,map.get(s)+1);
			}else{
				map.put(s,1);
			}
		}

		return map;
	}
	public static void main(String[] args) {
		WordCount wc = new WordCount();
		System.out.println(wc.phrase("Joe can't tell between 'large' and large."));
	}
}
