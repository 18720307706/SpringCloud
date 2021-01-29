package leetcode.editor.cn;

//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 
//
// 示例 1： 
//
// 输入: s = "leetcode"
//输出: false 
// 
//
// 示例 2： 
//
// 输入: s = "abc"
//输出: true
// 
//
// 限制： 
// 
// 0 <= len(s) <= 100 
// 如果你不使用额外的数据结构，会很加分。 
// 
// Related Topics 数组 
// 👍 68 👎 0

import java.util.HashMap;
import java.util.Map;

public class IsUniqueLcci{
    public static void main(String[] args) {
        Solution solution = new IsUniqueLcci().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isUnique(String astr) {
//        Map<Character, Integer> map = new HashMap<>();
//        for (char aChar : astr.toCharArray()) {
//            if (map.containsKey(aChar)) {
//                map.put(aChar, 2);
//            } else {
//                map.put(aChar, 1);
//            }
//        }
//        return  !map.containsValue(2);
        for (int i=0;i<astr.length();i++){
            String s=astr;
            s=s.replace(String.valueOf(s.charAt(i)),"");
            if (s.length()!=astr.length()-1)
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}