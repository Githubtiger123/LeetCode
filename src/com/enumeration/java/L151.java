package com.enumeration.java;

import org.junit.Test;

//151. 反转字符串中的单词
public class L151 {

    @Test
    public void test() {

        System.out.println(reverseWords("In the vast expanse of the universe time stretches out like an endless road winding its way through the fabric of existence It holds within it the stories of countless lives each one a unique thread woven into the tapestry of history Imagine for a moment a world without the constraints of time A place where moments blend seamlessly into one another where the past present and future coexist in perfect harmony It is a realm where memories and dreams intertwine shaping our understanding of who we are and what we can become As we embark on this journey through time let us pause and reflect on the wonders that lie before us The ancient civilizations that once thrived leaving behind magnificent monuments and artifacts that stand as silent witnesses to their existence The rise and fall of empires the triumphs and tragedies that have shaped the course of humanity In the realm of literature time becomes a malleable concept allowing us to traverse different eras and immerse ourselves in the stories of characters long gone From the poetic verses of Shakespeare to the dystopian worlds of Orwell each word written transports us to a different time and place awakening our imagination and expanding our horizons Music too holds the power to transcend time The melodies of Mozart the soulful tunes of the blues and the energetic beats of rock and roll resonate across generations evoking emotions and memories that connect us to the past With every note we are reminded that music is a universal language that knows no boundaries As we navigate the twists and turns of the present it is important to remember that time is a gift a precious resource that should be cherished It is all too easy to get caught up in the hustle and bustle of daily life constantly chasing after the next deadline or goal But in doing so we risk losing sight of what truly matters Time allows us to form deep connections with others to forge meaningful relationships that withstand the test of time It gives us the opportunity to explore our passions to pursue our dreams and to make a difference in the world It is a reminder that every moment no matter how fleeting holds the potential for greatness As we reach the end of our journey through time let us not mourn its passing but celebrate its existence For in the tapestry of life every thread is interconnected every moment significant The past has shaped us the present defines us and the future awaits us with infinite possibilities So as we bid farewell to this exploration of time let us carry with us the lessons it has taught us Let us cherish each passing second savoring the beauty that surrounds us And above all let us remember that time is not merely a product of the ticking clock but a reflection of the moments we choose to create In the end it is not the quantity of time that matters but the quality of the moments we experience So let us make every second count and live our lives to the fullest for time like life itself is a precious gift that should never be taken for granted"));
//        System.out.println("012345".substring(0,1+1));
    }


    public String reverseWords(String s) {

        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                continue;
            }
            int end = i;
            while (i >= 0 && str[i] != ' ') {
                i--;
            }
            int start = i + 1;
//            System.out.println("start:" + start + ",end:" + end + 1);
            sb.append(s.substring(start, end + 1));
            sb.append(' ');
        }
        return sb.toString().trim();
    }
}
