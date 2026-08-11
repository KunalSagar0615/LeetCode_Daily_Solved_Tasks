/**
 * @param {number[]} nums
 * @return {number}
 */
var missingInteger = function(nums) {
    let sum = nums[0];

    // Find the sum of the longest sequential prefix
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] === nums[i - 1] + 1) {
            sum += nums[i];
        } else {
            break;
        }
    }

    // Find the smallest integer >= sum that is not in nums
    const set = new Set(nums);

    while (set.has(sum)) {
        sum++;
    }

    return sum;
};