package com.enumeration.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//524. 通过删除字母匹配到字典里最长单词
public class L524 {

    @Test
    public void test() {
//["apple", "banana", "orange", "cherry", "grape", "lemon", "kiwi", "melon", "peach", "plum", "berry", "mango", "apricot", "papaya", "pear", "lime", "fig", "avocado", "coconut", "guava", "lychee", "tangerine", "pineapple", "strawberry", "blueberry", "blackberry", "raspberry", "watermelon", "cantaloupe", "honeydew", "pomegranate", "passionfruit", "dragonfruit", "kiwifruit", "starfruit", "persimmon", "apricot", "nectarine", "cranberry", "boysenberry", "gooseberry", "rhubarb", "elderberry", "uglifruit", "plantain", "quince", "kumquat", "mulberry", "medlar", "durian", "jackfruit", "lychee", "longan", "rambutan", "soursop", "tamarind", "salak", "custardapple", "cherimoya", "pawpaw", "feijoa", "guanabana", "jabuticaba", "cupuacu", "ackee", "breadfruit", "soursop", "bilimbi", "salak", "tamarillo", "santol", "sapodilla", "sweetsop", "yuzu", "carambola", "hornedmelon", "jujube", "lovagefruit", "mangosteen", "monstera", "pomelo", "quandong", "salalberry", "surinamcherry", "waxjambu", "uglifruit", "yamamomo", "zalacca", "barbadine", "carambola", "durian", "entawak", "feijoa", "genip", "hogplum", "indianprune", "jaboticaba", "kiwano", "longkong", "marula", "nance", "orangelo", "pindaiba", "quararibea", "raimi", "salak", "tamarind", "utsukushii", "vanilla", "wampee", "ximenia", "yali", "zalacca", "ackee", "bloodorange", "clementine", "damson", "elderberry", "fingerlime", "gooseberry", "honeyberry", "ilama", "jujube", "kumquat", "loquat", "mandarin", "nectarine", "olallieberry", "papaya", "quince", "redcurrant", "satsuma", "tamarind", "ugli", "vanilla", "whitecurrant", "xigua", "yangmei", "ziziphus", "apple", "banana", "orange", "cherry", "grape", "lemon", "kiwi", "melon", "peach", "plum", "berry", "mango", "apricot", "papaya", "pear", "lime", "fig", "avocado", "coconut", "guava", "lychee", "tangerine", "pineapple", "strawberry", "blueberry", "blackberry", "raspberry", "watermelon", "cantaloupe", "honeydew", "pomegranate", "passionfruit", "dragonfruit", "kiwifruit", "starfruit", "persimmon", "apricot", "nectarine", "cranberry", "boysenberry", "gooseberry", "rhubarb", "elderberry", "uglifruit", "plantain", "quince", "kumquat", "mulberry", "medlar", "durian", "jackfruit", "lychee", "longan", "rambutan", "soursop", "tamarind", "salak", "custardapple", "cherimoya", "pawpaw", "feijoa", "guanabana", "jabuticaba", "cupuacu", "ackee", "breadfruit", "soursop", "bilimbi", "salak", "tamarillo", "santol", "sapodilla", "sweetsop", "yuzu", "carambola", "hornedmelon", "jujube", "lovagefruit", "mangosteen", "monstera", "pomelo", "quandong", "salalberry", "surinamcherry", "waxjambu", "uglifruit", "yamamomo", "zalacca", "barbadine", "carambola", "durian", "entawak", "feijoa", "genip", "hogplum", "indianprune", "jaboticaba", "kiwano", "longkong", "marula", "nance", "orangelo", "pindaiba", "quararibea", "raimi", "salak", "tamarind", "utsukushii", "vanilla", "wampee", "ximenia", "yali", "zalacca", "ackee", "bloodorange", "clementine", "damson", "elderberry", "fingerlime", "gooseberry", "honeyberry", "ilama", "jujube", "kumquat", "loquat", "mandarin", "nectarine", "olallieberry", "papaya", "quince", "redcurrant", "satsuma", "tamarind", "ugli", "vanilla", "whitecurrant", "xigua", "yangmei", "ziziphus"]
        ArrayList<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        System.out.println(findLongestWord1("abpcplea", list));
    }

    //优化后
    public String findLongestWord1(String s, List<String> dictionary) {
        String result = "";
        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                if (word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
    }

    public String findLongestWord(String s, List<String> dictionary) {

        String[] array = dictionary.toArray(new String[0]);
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {

                    return -(o1.length() - o2.length());
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
//        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (isSubsequence(array[i], s)) {
                return array[i];
            }
        }
        return "";
    }

    public boolean isSubsequence(String s, String t) {

        if (s.length() == 0) return true;

        int i = 0, j = 0;
        while (j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
            if (i == s.length()) {
                return true;
            }
        }
        return false;
    }
}
