/**
 * @author GuoYangYang
 * @date 2021/5/18
 */
public class Sort {

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1, 3, 5};
        Sort s = new Sort();
        s.heapSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    /**
     * 交换元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = getMid(nums, left, right);
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }
    }

    int getMid(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot)
                right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public void heapSort(int[] arr) {
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * @param arr
     * @param start
     * @param end
     */
    public void adjustHeap(int[] arr, int start, int end) {
        int temp = arr[start];  //先取出当前元素i
        for (int i = start * 2 + 1; i < end; i = i * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            if (i + 1 < end && arr[i] < arr[i + 1]) {//如果左子结点小于右子结点，i指向右子结点
                i++;
            }
            if (arr[i] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[start] = arr[i];
                start = i;
            } else {
                break;
            }
        }
        arr[start] = temp;//将temp值放到最终的位置
    }

    public void heapSort1(int[] num) {
        int length = num.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjust(num, i, length);
        }
        for (int j = length - 1; j > 0; j--) {
            swap(num, 0, j);
            adjust(num, 0, j);
        }
    }

    public void adjust(int[] num, int start, int end) {
        int temp = num[start];
        for (int k = start * 2 + 1; k < end; k = k * 2 + 1) {
            if (k + 1 < end && num[k] < num[k + 1])
                k++;
            if (num[k] > temp) {
                num[start] = num[k];
                start = k;
            } else
                break;
        }
        num[start] = temp;
    }

}
