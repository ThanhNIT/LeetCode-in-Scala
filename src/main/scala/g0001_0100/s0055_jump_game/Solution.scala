package g0001_0100.s0055_jump_game

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Dynamic_Programming #Greedy
// #Algorithm_II_Day_12_Dynamic_Programming #Dynamic_Programming_I_Day_4 #Udemy_Arrays
// #Big_O_Time_O(n)_Space_O(1) #2023_10_31_Time_622_ms_(88.31%)_Space_56.9_MB_(44.16%)

object Solution {
    def canJump(nums: Array[Int]): Boolean = {
        var sz = nums.length
        // We set tmp to 1 so it won't break on the first iteration
        var tmp = 1

        for (i <- 0 until sz) {
            // We always deduct tmp for every iteration
            tmp -= 1
            if (tmp < 0) {
                // If from the previous iteration tmp is already 0, it will be < 0 here,
                // leading to a false value
                return false
            }
            // We get the maximum value because this value is supposed to be our iterator. If both values are 0,
            // then the next iteration will return false.
            // We can stop the whole iteration with this condition. Without this condition, the code runs in 2ms (79.6%).
            // Adding this condition improves the performance to 1ms (100%)
            // because if the test case jump value is quite large, instead of just iterating, we can
            // just check using this condition.
            // Example: [10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0] -> we can just jump to the end without iterating the whole array.
            tmp = math.max(tmp, nums(i))
            if (i + tmp >= sz - 1) {
                return true
            }
        }
        // We can just return true at the end because if tmp is 0 on the previous
        // iteration,
        // even though the next iteration's index is the last one, it will return false under the
        // tmp < 0 condition.
        true
    }
}