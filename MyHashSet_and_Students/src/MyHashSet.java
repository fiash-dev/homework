import java.util.Arrays;
import java.util.LinkedList;

    public class MyHashSet<E> {
        private static final int DEFAULT_CAPACITY = 16;
        private LinkedList<E>[] buckets;
        private int size;

        public MyHashSet() {
            buckets = new LinkedList[DEFAULT_CAPACITY];
            for (int i = 0; i < DEFAULT_CAPACITY; i++) {
                buckets[i] = new LinkedList<>();
            }
            size = 0;
        }

        public boolean add(E element) {
            if (contains(element)) {
                return false;
            }

            int bucketIndex = getBucketIndex(element);
            buckets[bucketIndex].add(element);
            size++;

            if ((double)size / buckets.length > 0.75) {
                rehash();
            }

            return true;
        }

        public boolean remove(E element) {
            int bucketIndex = getBucketIndex(element);
            boolean removed = buckets[bucketIndex].remove(element);
            if (removed) {
                size--;
            }
            return removed;
        }

        public boolean contains(E element) {
            int bucketIndex = getBucketIndex(element);
            return buckets[bucketIndex].contains(element);
        }

        private int getBucketIndex(E element) {
            return Math.abs(element.hashCode()) % buckets.length;
        }

        private void rehash() {
            LinkedList<E>[] oldBuckets = buckets;
            buckets = new LinkedList[oldBuckets.length * 2];

            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            size = 0;
            for (LinkedList<E> bucket : oldBuckets) {
                for (E element : bucket) {
                    add(element);
                }
            }
        }

        public int size() {
            return size;
        }

        @Override
        public String toString() {
            return Arrays.toString(buckets);
        }
    }
