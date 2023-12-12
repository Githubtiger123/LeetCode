package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

public class L567 {

    @Test
    public void test() {

        System.out.println(checkInclusion("hello", "ooolleoooleh"));
        System.out.println(checkInclusion("adc", "dcda"));
        System.out.println(checkInclusion("jqowgtqdokaxwlqdhfvyxnaflcxinzmwptndasfcllrucjvixufbcdrwcxbjmvwmjzjcqnugddugkaqbirmthedbfidisueqruimmvetezyzjvyqzucdlrlicqldmtsrluhphqrwejqbcgafhqxfxceibvshmvdjubdinoeqlitgnhvjvbqwcvdhncxognwoaeyojayyrzbokaxsihhkzbkvaczlmepzhlwnyzdzborlwbhicmdyieiwarxwpzgukknkplhmkciolicttdsbesbkysnpwhhqmpdctfqyawxxbrjmgbefhuajwedaingmrwfdptobbkfxgupczsahmxngmupbolysndbgswzlxldjynxrooiszcfyhixupcgudalteszwwkrhipqmxckzxydftkoxsmemggcedizgqihcjnbnjaduhucwoxarpachkqmnhafddyhaoqkeskodukkgnnejjskykgwfnoyspcjgvnbjmxdnpvxjbwqkokzchcvddbuzgtbackxevisusequrqwrsmeqbffcfzzzdqvreeydfygkmkzftzgbkjznqqdpzanpojqhrrghmnmmjsgxnozjnieuffbsvtxzizwhhtcrszyjwlmbxklakzhymzvpuuywpqksiuifkshzsdsnsgdbpmgvinihwykzzpoojukgltdcvncerrmxkrnqrmslchvlarghbnqgdtyfrwsuhhodymsrpxgqptjlvhmlcazvvybuljbpaqqqqdcufkqgcknrlrwzbdtqqykdwrqputjxortexovmtpmeyogxxcykxpbknbrjvwgfdrjmrwxutbwzcialjnbokhddaonxfoqaxarkzslcwqorlhdpsbryswboxftjjbmvlvstzfgmvvltbziyflrddkyxslifvcunyxrmbhadolsebrumwcjlkzfpncweynspxpftcbahdwjlmaxyvigxubjgoimyqtxqiajidfmajgpkqpcznuafehnkznydfxuvfucngrxksggapliibymejxzcmbdrfbzdjxyzblphmkhqluqtviuzixhgwqqueeckurttbsssykhsexmqqtfeicpjckvsgrmcwayjpshkltnqapjbbhhihlalzeuddrmodkeofemhzgqwiyoygpajbqpscuzpzsprkyobbtypegbqbnodpiuwptxgvmizxcgcocqymcranquqnwggwjbcskwjvvnpfmhaohrhuzmfgskufilqstxinwdockopciyuaaeoqdappvlfzklqlpjrkaeigtlfvjcfuxlazrxnqupcnlkyqwfkyhpvnirltoxrckanedkezyekbiolscaqltwxpoybxrspmamjmdmjfflxeokelpsavsdvhqqbwtopsfkijdzsygkoinqwhufwnbgauiprsitlapkllaipwbdbzettoxmfddynxhrujwcouxgtrjemrxmceaatfxomyqyqjpiwducxpuyailvgiuxrzoonydokcymdgqzbuanzdxufcftqremdcrbyspoylvcqvyoyxhsbvlpamysyqltiwnsicvatgmztrmicpsedldlhylellpmqvhymryfhkbkdytdqlonsuzyqsimlsfxbdffpcziviwxfiraaoepadarqpldxecydtcogbpnuugbendyvxgpybhqzwgussybomxzdmmrvysqimxxyjqrvjwjjivwywdqmsgkgdzhpaahpanxkzqbhtjqdgjcybnufpwutuafdzegslokejhfwrrdmlyitegckpzyipmyhsdpukrgbduoifxqikvlahjkicjhtofiufnjdanzhtomtxswwcljezreipjlpkzmpkisklxanpdzzetfzecdjinacsuilnejspdqihzlbshvqfnycfwgcgzbmmpiwrwtrpnmkiegdahhttlqvxqbnqpbqyxkaslgxvwsyjyuahenadpmfinwdzcudgkjfwkahjs", "deasvrgsdxhdbemwpenmbhjbnykuygxvmfkjagxnjoywjdgmjewtofmbpfehbfgauiihajsdbarllcmoqkqvebwvtitjqscqnantzpqtifwvmzlnkyuxoruhqlvvoqqdwzccprqmsrllrzfyvqgiyrbqlmskrqjdfdvygtsmijcqdhmpuqhrmsrwzsnnxpynjtechsxvlwhurtqbieshuragietmcokwxrlvehihspodjkkpweqekrjemnsimexuktmoqiowiyifqjsylmmejuhltwjfqfyyujuwdivyzctvrkefdzpwqrzpembtrcamzubewkanmgnmfjyatgnkxtmimnqsodgvnbkowvjebslcfdrqjkpjhfqojwtdfunhctckgipwgmtlzialllhcnarbbrtxgzddmryuohmjtsnpkkpvtipqjkucuqnqgdvvsquedghikbayosxjfwrvlnjpukbxhzruatdiwemwjnjpkwancvdniwiefcstdgyhycntmgroneylurnehnhjqjqomcgcwprwdoejlvaponqhyaultpxqvykydofkpurzqhygxmieyjotxhiqtvlnmffxurxhmrhvdkkgwaekojxocoofvznjynlzhbojbkljzhihfepmhuirqxsxjslbaoilykltzpqzjzvoqenjuayqmktpsoedxnwwibotpjgpmpfsnbipuammzlaogvekhzftqxrbmiwuhynpaznoqsxfiuacwogolvqvzbqlmunaemsvhlmtkavbzvhdignnhdziydpqaizjlytqjrhgtbdaxmgepysvtnampnldgpgtrbhtzhfbvclwustztaerkzggiekheckfquleawilaexocaggnxeygovsfzkjkeizfkfcffdrgzcftjlaluooqkgceoahlhwvfmwwkgqiqxstlzahtyzicnyboeqstdskkidqcseyrjfsucvyefbkikfjzesdpoxkhstiapcidwxaantpxzjxuipkzcrybgftemljmdaeisvfrnlrzlbbxukiggchmpriytsdqlzbjsgrfffwiwdupgjkudtemkncffcxxdeqepqcbmcfurwbjhsyvjxlzittwsodkgnfsklbzdclcsireusuzfraqmjrhbtyrnogsfllnjbxwicpsshhgiqgdnlvzybzdkgpngyylznhxaktgmiriqrfsigowybnrdfhwbknjpwqwrvcmvxpfqpburfglokymmwjshsjrdzlcxzmpwefyqwgjvvjlejhpcfvdfnlbyuvwdsoihailxypsoswpfauxdbaqukclmqikmimiryeptmygvkvmcjkkswthokvksoibotyrsprajrjucvukekiuyjnydiwaqpelrxadrhruhqoxhowbabtfwaxlvqbzpghijvbkxqqgmdksecjymvtrqqgycvmqjbdypphvfkhrfbnkxyyxkguxpdjvndwpihdtlvarfxveltnvmmdufihhqttmbpoyzwhieoblwjaoxbhmvmbklpuprlvqthmdskyixgcspiawdeoopxhzpsdtxsfjzrkdvnbtmbehjqowgtqdokaxwlqdhfvyxnaflcxinzmwptndasfclnrucjvixufbcdrwcxbjmvwmjzjcqnhgddugkaqqirmthedbfidisueqruimmvetezyzjvyqzucdlrlfaqldmtsrluhphqrwejqbcgafhqxfxceibvshmvdjubdinoeqlitgnhvjvbqwcvdhncxognwoaeyojayyrzmokpxsihhkzbkvaczlmepzhlwnyzdzborlwbhicmduieiwarxwpzgukknkplhmkcioficttdsbesbkysnpwhhqmpdctfqyawxxbrjmgbefhuajwedaingmrwfdptobbkfxgupczsahmxngmupbolysndbgswzlxldjynxrooiszcfyhixupcgudalteszwwkrhipqmxckzxydftkoxsmemggcxhizgqihcjnbnjaduhucwoxarpachkqmnhafddyhaoqkeskodukkgnnejjskykgwfnoyspcjgvnbjmxdnpvxjbwqkokzchcvddbuzgtbackxevisusequrqwrsmeqbffcfzzzdqvreeydfygkmkzftzgbkjznqqdpzanpojqhrrghmnmmjsgxnozjnieuffbsvtxzizwhhtcrszyjwlmbxklakzhymzvpuuywpqksauifkshzsdsnsgdbpmgvinihwykzzpoojukgltdcvncerrmxkrnqrmslchvlarghbnqgdtyfrwsuhhodymsrpxgqptjlvhmlcazvvybuljbpaqqqqdculkqgckdrlrwzbdtqqykdwrqputjxortexovmtpmeyogxxcykxpbknbrjvwgfdrjmrwxutbwzcijnjnbokhddaonxfoqaxarkzslcwqorlhdvsbryswboxftjjbmvlvstzfgmvvltbziyflrddkyxslifvcunyxrmbradolsebrumwcjlkzfpncweynspxpftcbahdwjlmaxyvigxubjgoimyqtxqiajidfmajgpkqpcznuafetnkznydfxuvfucngrxksggapliibymejxzcmbdrfbzdjxyzblphmkhqlubtviuzixhgwqqueeckurttbsssykhsexmqqtfeicpjckvsgrbcwayjpshkltnqapjbbhhinlalzeuddrmodkeofemhzgqweyoygpajbqpscuzpzsprkyobbtypegbqbnodpiuwptxgvmizxcgcocqymcranquqnwggwjbcskwjvvnpfmhaohhhuzmfgskufilqstxinwdockopciyuaaeoqdappvlfzklqlpjrkaeigdlfvjcfuxlazrxnqupcnlkyqwfkyhpvnirltoxrckanedkezyekbiolscaqltwxpoybxrspmamjmdmafflxeokelpsavsdvhqqbwtopsfkijdzsygkoihqwhyfwnbgauiprsitlapkllaipwbdbzettoxmfddynxhrujwcouxgtrjemrxmciaatfxomyqyqjpiwducepuyailvgiuxrzoonydokcymdgqzbuanzdxufcftqremdcrbyspoylvcqvyoyxhsbvlpamysyqltiwnsicvatgmztrmicpsedldlhylellpmqvhymryfhkbkdytdqlonsuzyqsimlsfxbdffpcziviwxfiraaoepadarqpldxecydtcogbpnuugbendyvxgpybhqzwgussybomxzdmmrvysqimxxyjqrpjwjjivwywdqmsgkgdzhpaahpalxkzqbhtjqdgjcybnufpwutuafdzegslokejhfwrrdmlyitegckpzyipmyhsdpukrgbduoiixqikvlahjkicjutofiufnjdanzhtomtxswwcljezreipjlpkzmpkisklxanidzzetfzecljinacsuilnejspdqihzlbshvqfnycfwgcgzbmmpiwrwtrpnmkiegdchhttlqvxqbnqpbqyxkaslgxvwsyjyuahenadpmfinwdzcudgkjfwkahjsyerluvhlmudkshnvhqygjxpfvblelciwbkiflnutrihyffamtmtnklexvvelsoyjypppvflbeoxorlfmhryxcvyeypxdtailsnfiuqapwhrovfrhkeqpzeysxhqyjpihbdnqpshyemgpxcnscfzgydmemuffryevsjxdcbynebxnhvfwpnhmmxzubjkmqkecmoqtugbxdwowcawjmqlmwjlwmaxftpdnprgxekkusmzuythqmqtacbyepvoickldankkssjyfpxqmabqorvtpgztuqyjgqjhmzmqnuyrfgjkrgoimnbhkzhoefscczbejgkjtztwwcsmalbezdtxihbyimigmotxuftbszrnquyvuxacdrwnzmstkxujwjcmmqmbennupqzvjgxgyrbttudkpprljznpjhadlavgzisehircbdnxmltfsmbffppszjtekdfeagpquf"));
//        System.out.println("hello".contains("o"));
//        System.out.println("hello".replaceFirst("l","*"));
    }

    public boolean checkInclusion(String s1, String s2) {

        char[] str1 = new char[26];
        char[] str2 = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            str1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (i >= s1.length()) {
                str2[s2.charAt(i - s1.length()) - 'a']--;
            }
            str2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(str1, str2)) {
                return true;
            }
        }
        return false;
    }


    //方法二:速度很慢
    public boolean checkInclusion2(String s1, String s2) {

        StringBuilder stringBuilder2 = new StringBuilder(s2);
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {

            if (isEquals(s1, stringBuilder2.substring(i, i + s1.length()))) {
                return true;
            }
        }
        return false;
    }

    public boolean isEquals(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    //方法1:时间超出限制
    public boolean checkInclusion1(String s1, String s2) {

        char[] str = s2.toCharArray();
        int j = 0, count = 0;
        String s1_copy = new String(s1);
        while (j <= s2.length() - s1.length()) {
            int i = j;
            while (i < s2.length()) {
                if (s1_copy.contains(String.valueOf(str[i]))) {
                    s1_copy = s1_copy.replaceFirst(String.valueOf(str[i]), "*");
                    count++;
                    if (count == s1.length()) {
                        return true;
                    }
                } else {
                    count = 0;
                    s1_copy = new String(s1);
                    j++;
                    break;
                }
                i++;
            }
        }
        return false;
    }

}
