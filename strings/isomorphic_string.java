package strings;

import java.util.HashMap;

public class isomorphic_string {
    public boolean isIsomorphic(String s, String t) {
        HashMap <Character,Integer> mapS = new HashMap<>();
        HashMap<Character,Integer> mapT = new HashMap<> ();
        for(int i =0;i<s.length();i++){
            if(!mapS.containsKey(s.charAt(i))){
            mapS.put(s.charAt(i),i);
            }
            if(!mapT.containsKey(t.charAt(i))){
            mapT.put(t.charAt(i),i);
            }
            if(!mapS.get(s.charAt(i)).equals(mapT.get(t.charAt(i)))){
            return false;
            }
        }
        return true;
    }
    public boolean is_Isomorphic(String s, String t) {
        HashMap <Character,Character> map = new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if(map.containsKey(charS)){//if charS is already mapped
                //check if the mapped value is equal to charT
                if(map.get(charS) != charT){
                    return false;
                }
            } else { //if charS is not mapped yet
                //check if charT is already mapped to some other character#
                if(map.containsValue(charT)){
                    return false;
                }
                map.put(charS, charT);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        isomorphic_string obj = new isomorphic_string();
        String s = "egg";
        String t = "add";
        boolean result = obj.isIsomorphic(s, t);
        System.out.println(result); // Output: true
    }
}
