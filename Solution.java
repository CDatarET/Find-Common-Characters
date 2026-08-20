class Solution {
    private HashMap<Character, Integer> counter(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        return map;
    }

    public List<String> commonChars(String[] words) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<Character, Integer> ref = counter(words[0]);
        ArrayList<HashMap<Character, Integer>> counters = new ArrayList<>();
        for(int i = 1; i < words.length; i++){
            counters.add(counter(words[i]));
        }

        for(char x : ref.keySet()){
            int count = ref.get(x);
            for(int i = 0; i < counters.size(); i++){
                count = Math.min(count, counters.get(i).getOrDefault(x, 0));
            }

            for(int i = 0; i < count; i++){
                list.add("" + x);
            }
        }

        return list;
    }
}
