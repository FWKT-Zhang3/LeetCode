class TwoSum(object):
    def twoSum(self, nums, target):
        for i, num in enumrate(nums):
            for j in range(i+1, len(nums)):
                if num + nums[j] == target:
                    return [i, j]