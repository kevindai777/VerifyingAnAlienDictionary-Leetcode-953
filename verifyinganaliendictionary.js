//Objective is to see whether words in a list are in valid lexicographic order
//based on an alien dictionary.

let words = ["hello","leetcode"]
let order = "hlabcdefgijkmnopqrstuvwxyz"


//O(n) solution that uses a hashmap to store the indexes of each character
//in the order.

let map = {}

//Map the order of the alien dictionary
for (let i = 0; i < order.length; i++) {
    map[order.charAt(i)] = i
}

for (let i = 1; i < words.length; i++) {
    let word1 = words[i - 1]
    let word2 = words[i]

    if (map[word1[0]] > map[word2[0]]) {
        return false
    } else if (map[word1[0]] == map[word2[0]]) {
        let index = 1

        //Skip all of the same characters
        while (word1[index] == word2[index]) {
            index++
        }

        //If word1 and word2 share the same characters but
        //word1 is longer, return false
        if (!word2[index]) {
            return false
        }

        if (map[word1[index]] > map[word2[index]]) {
            return false
        }
    }
}

return true