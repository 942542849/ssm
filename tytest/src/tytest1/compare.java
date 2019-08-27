package tytest1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class compare {
	public static boolean compared(String a, String b) {
        if (a.length()==0) return true;
        if (b.length()==0) return false;
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        List<Character> aList = new ArrayList<>();
        for (char aChar : aChars) {
            aList.add(aChar);
        }
        List<Character> bList = new ArrayList<>();
        for (char bChar : bChars) {
            bList.add(bChar);
        }
        int index;
        for (int i = aList.size() - 1; i >= 0; i--) {
            index = bList.indexOf(aList.get(i));
            if (index != -1) {
                aList.remove(i);
                bList.remove(index);
            } else {
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		 String stra = null;
		 String strb = null;
		 System.out.println("请输入a的字符串：");
		 stra = s.next();
		 System.out.println("请输入b的字符串：");
		 strb = s.next();
        System.out.println("匹配结果是：");
		System.out.println(compared(stra,strb));
		
	}
}
