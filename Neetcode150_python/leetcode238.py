class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = [1] * len(nums)
        suffix = [1] * len(nums)
        for i in range(len(nums)):
            if i > 0:
                prefix[i] = prefix[i - 1] * nums[i - 1]
        i = len(nums) - 2
        while i >= 0:
            suffix[i] = suffix[i + 1] * nums[i + 1]
            i -= 1
        result = []
        for i in range(len(nums)):
            result.append(prefix[i] * suffix[i])
        return result
