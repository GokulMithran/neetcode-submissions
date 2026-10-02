impl Solution {
    pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
        let set: HashSet<i32> = nums.iter().copied().collect();

        let mut res = 0;

        for &num in &nums {
            // Start counting only if `num` is the beginning
            // of a consecutive sequence.
            if !set.contains(&(num - 1)) {
                let mut max = 1;
                let mut cur = num;

                while set.contains(&(cur + 1)) {
                    max += 1;
                    cur += 1;
                }

                res = res.max(max);
            }
        }

        res
    }
}