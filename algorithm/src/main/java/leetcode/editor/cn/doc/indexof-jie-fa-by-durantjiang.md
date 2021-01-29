### 解题思路
利用indexOf（） 与lastIndexOf（） 判断是否处于相同位置来判断是否只有一个字符

代码如下

### 代码

```java
class Solution {
   public boolean isUnique(String astr) {
        if (astr.length() == 1 || astr.length() == 0) {
            return true;
        }
        boolean flag = true;
        for (int i = 0, len = astr.length(); i < len -1; i++){
            if (astr.indexOf(astr.charAt(i)) != astr.lastIndexOf(astr.charAt(i))){
                flag =false;
            }
        }
        return flag;
    }
}
```