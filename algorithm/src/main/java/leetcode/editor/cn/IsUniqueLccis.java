package leetcode.editor.cn;

/**
 * 验证
 *
 * @author Lch on 2020/12/25
 */
public class IsUniqueLccis {
    public static void main(String[] args) {
        IsUniqueLccis.unique("leetcode");
    }
    public  static boolean unique(String astr) {
        for (int i=0;i<astr.length();i++){
            String s=astr;
            s=s.replace(String.valueOf(s.charAt(i)),"");
            if (s.length()!=astr.length()-1)
                return false;
        }
        return true;
    }
}