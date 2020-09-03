class Solution:
    def twoSum(self, nums, target):
        for i,num in enumerate(nums):
            for j in range(i+1, len(nums)):
                if num+nums[j] == target:
                    return [i, j]

if __name__ == "__main__":
    a = Solution()
    b = a.twoSum([2,3,3], 5)
    for i in b:
        print(i)
