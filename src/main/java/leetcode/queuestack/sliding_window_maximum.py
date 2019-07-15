# -*- coding:utf-8 -*-


def max_sliding_window(nums, k):
    if not nums:
        return []

    # window存放的是nums的索引, result存放结果
    window, result = [], []
    for i, x in enumerate(nums):
        # 输入是nums = [1, -1], k = 1
        if i >= k and window[0] <= i - k:
            window.pop(0)  # 移除并返回索引为0的元素

        while window and nums[window[-1]] <= x:
            window.pop()  # 移除并返回队尾元素

        window.append(i)

        if i >= k - 1:
            result.append(nums[window[0]])

    return result


# print(max_sliding_window([1, -1, 3, -3, 5, 4, 6], 3))
print(max_sliding_window([1, -1], 1))