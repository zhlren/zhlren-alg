package zhlren.ltcd.alg.model;

/**
 * 最小堆
 * Created by bjrenzhili on 17/3/23.
 */
public abstract class MinHeap<T> {

    /**
     * 最大容量
     */
    private final int maxSize;

    /**
     * 当前大小
     */
    private int curSize;

    /**
     * 存储数组
     */
    private final T[] heap;

    public MinHeap(int maxSize) {
        curSize = 0;
        int heapSize;
        if (0 == maxSize) {
            heapSize = 2;
        }
        else {
            heapSize = maxSize + 1;
        }
        heap = (T[]) new Object[heapSize];
        this.maxSize = maxSize;
    }

    /**
     * 子类需要复写的比较方法
     * @param a
     * @param b
     * @return a<b 返回 true
     */
    protected abstract boolean lessThan(T a, T b);

    /**
     * 获取堆顶元素
     * @return
     */
    public final T top() {
        return heap[1];
    }

    /**
     * 获取并移除堆顶元素
     * 然后将堆尾元素放到堆顶 并 整理
     * @return
     */
    public final T pop() {
        if (curSize > 0) {
            T result = heap[1];
            heap[1] = heap[curSize];
            heap[curSize] = null;
            curSize--;
            downHeap();
            return result;
        }
        else {
            return null;
        }
    }

    /**
     * 向对中添加元素 并重新排序
     * @return
     */
    public final T add(T element) {
        curSize++;
        heap[curSize] = element;
        upHeap();
        return heap[1];
    }

    /**
     * 作用 在有序的堆中 新加元素至堆尾 并整理排序
     * 新加的元素在数组末端
     * 依次比较元素与其父节点
     * 若比父节点小 则交换 然后继续向上遍历
     * 否则终止循环
     */
    private final void upHeap() {
        int i = curSize;
        T node = heap[i]; //保存bottom节点
        int j = i >>> 1;
        while (j > 0 && lessThan(node, heap[j])) {
            heap[i] = heap[j];
            i = j;
            j = j >>> 1;
        }
        heap[i] = node;
    }

    /**
     * 作用 删除堆顶元素后 重新整理
     * 找出子节点中最小的 与 父节点比较
     * 若父节点大则将子节点上移
     * 直至两个子节点都比node小
     */
    private final void downHeap() {
        int i = 1;
        T node = heap[1];
        int j = i << 1;
        int k = j + 1;
        if (k <= curSize && lessThan(heap[k], heap[j])) {
            j = k;
        }
        while (j <= curSize && lessThan(heap[j], node)) {
            heap[i] = heap[j];
            i = j;
            j = i << 1;
            k = j + 1;
            if (k <= curSize && lessThan(heap[k], heap[j])) {
                j = k;
            }
        }
        heap[i] = node;
    }

    /**
     * 清空堆
     */
    public final void clear() {
        for (int i = 0; i <= curSize; i++) {
            heap[i] = null;
        }
        curSize = 0;
    }

    /**
     * 返回堆当前大小
     * @return
     */
    public final int size() {
        return curSize;
    }

}
