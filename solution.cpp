class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        vector<string> v;
        unordered_map<char, int> map;
        for(char c : words[0]) map[c]++;
        vector<unordered_map<char, int>> counters;
        for(int i = 1; i < words.size(); i++){
            unordered_map<char, int> t;
            for(char c : words[i]) t[c]++;
            counters.push_back(t);
        }

        for(auto [x, count] : map){
            count = map[x];
            for(unordered_map<char, int> c : counters){
                count = min(count, c[x]);
            }

            for(int i = 0; i < count; i++){
                v.push_back(string(1, x));
            }
        }

        return v;
    }
};
