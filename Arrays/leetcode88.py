class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        nums3 = nums1.copy()
        nums1.clear()

        for i in range(m):
            nums1.append(nums3[i])
        
        for i in range(n):
            nums1.append(nums2[i])

        nums1.sort()