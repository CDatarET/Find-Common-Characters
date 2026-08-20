class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        ret = []
        ref = Counter(words[0])
        counters = [Counter(word) for word in words[1:]]

        for x in ref:
            count = ref[x]
            for c in counters:
                count = min(count, c[x])

            for i in range(count):
                ret.append(x)

        return ret
