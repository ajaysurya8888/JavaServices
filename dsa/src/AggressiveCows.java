import java.util.Arrays;

public class AggressiveCows {
    public int check() {
        return 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDistance(new int[]{0, 3, 4, 7, 10, 9}, 4));
    }


    static class Solution {
        boolean canWePlace(int[] position, int mid, int m) {
            int count = 1;
            int last = position[0];
            for (int i = 0; i < position.length; i++) {
                if (position[i] - last >= mid) {
                    count++;
                    last = position[i];
                }
                if (count >= m) {
                    return true;
                }
            }

            return false;
        }

        public int maxDistance(int[] position, int m) {
            int n = position.length;
            Arrays.sort(position);
            int low = 1;
            int high = (position[n - 1] - position[0]) / (m - 1);
            while (low <= high) {
                int mid = (high + low) / 2;
                if (canWePlace(position, mid, m)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return high;
        }
    }
}