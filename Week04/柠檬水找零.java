import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean lemonadeChange(int[] bills) {
        return method1(bills);
    }

    /**
     * 1.暴力法
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    private boolean method1(int[] bills) {
        int[] billAndCountCache = new int[2];
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    billAndCountCache[0]++;
                    break;
                case 10:
                    int count = billAndCountCache[0];
                    if (count == 0) {
                        return false;
                    } else {
                        billAndCountCache[0]--;
                        billAndCountCache[1]++;
                    }
                    break;
                case 20:
                    int countOfFive = billAndCountCache[0];
                    int countOfTen = billAndCountCache[1];

                    if (countOfTen >= 1 && countOfFive >= 1) {
                        billAndCountCache[0]--;
                        billAndCountCache[1]--;
                    } else if (countOfFive >= 3) {
                        billAndCountCache[0] -= 3;
                    } else {
                        return false;
                    }

            }
        }
        return true;
    }

    /**
     * 2.标记法
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    private boolean method2(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    five++;
                    break;
                case 10:

                    if (five == 0) {
                        return false;
                    } else {
                        five--;
                        ten++;
                    }
                    break;
                case 20:
                    if (five >= 1 && ten >= 1) {
                        five--;
                        ten--;
                    } else if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }

            }
        }
        return true;
    }
}
