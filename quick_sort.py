"""这里的特别之处在于不用交换两个节点就可以实现partition功能
   秘密就是val = nums[start]，先将待比较值取出来，再直接移动位置不对的值。当i == j，partition完成"""

def quick_sort(nums, start, end):
    if start >= end:
        return
    index = partition(nums, start, end)
    quick_sort(nums, start, index - 1)
    quick_sort(nums, index + 1, end)

def partition(nums, start, end):
    val = nums[start]
    while True:
        while nums[end] >= val and start < end:
            end -= 1
        if start == end:
            break
        nums[start] = nums[end]
        while nums[start] <= val and start < end:
            start += 1
        if start == end:
            break
        nums[end] = nums[start]
    nums[start] = val
    return start
