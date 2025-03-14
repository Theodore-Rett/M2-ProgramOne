# Algorithm to benchmark
import random

def get_kth_lowest(k, arr):
    if len(arr) == 0:
        raise ValueError("Array is empty")

    pivot = arr[random.randint(0, len(arr) - 1)]

    lower = []
    higher = []
    pivot_count = 0

    for num in arr:
        if num < pivot:
            lower.append(num)
        elif num > pivot:
            higher.append(num)
        else:
            pivot_count += 1

    lower_length = len(lower)

    if lower_length >= k:
        return get_kth_lowest(k, lower)
    elif lower_length + pivot_count >= k:
        return pivot
    else:
        return get_kth_lowest(k - lower_length - pivot_count, higher)

# Algorithm to compare against
def get_kth_lowest_simple(k, arr):
    if len(arr) == 0:
        raise ValueError("Array is empty")

    if k < 1 or k > len(arr):
        raise ValueError("k must be between 1 and the length of the array")

    sorted_arr = sorted(arr)

    return sorted_arr[k - 1]

import time
import matplotlib.pyplot as plt
import pandas as pd
def benchmark_algorithms(sizes):
    results = []

    for size in sizes:
        arr = [random.randint(1, 10000000) for _ in range(size)]
        k = random.randint(1, size)

        start_time = time.time()
        get_kth_lowest(k, arr.copy())
        custom_algo_time = time.time() - start_time

        start_time = time.time()
        get_kth_lowest_simple(k, arr.copy())
        sorting_time = time.time() - start_time

        results.append({
            'Size': size,
            'Custom Algorithm Time (s)': custom_algo_time,
            'Sorting Time (s)': sorting_time
        })

    return pd.DataFrame(results)

sizes = [5000, 10000, 50000, 100000, 500000, 1000000, 5000000, 10000000]

results_df = benchmark_algorithms(sizes)

print(results_df)

plt.figure(figsize=(12, 10))

plt.subplot(2, 1, 1)
plt.plot(results_df['Size'], results_df['Custom Algorithm Time (s)'], 'o-', label='Custom Algorithm')
plt.plot(results_df['Size'], results_df['Sorting Time (s)'], 's-', label='Sorting')
plt.xlabel('Input Size')
plt.ylabel('Time (seconds)')
plt.title('Performance Comparison: Custom Algorithm vs Sorting')
plt.legend()
plt.grid(True)
plt.tight_layout()
plt.savefig('algorithm_benchmark.png')
plt.show()