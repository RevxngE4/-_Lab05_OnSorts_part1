import java.util.*;
public class Part3 {
    //a.
        public static void bucketSort1(double[] arr) {
            int n = arr.length;
            List<Double>[] buckets = new List[n];

            for (int i = 0; i < n; i++) {
                buckets[i] = new ArrayList<>();
            }

            for (int i = 0; i < n; i++) {
                int bucketIndex = (int) (n * arr[i]);
                buckets[bucketIndex].add(arr[i]);
            }

            for (int i = 0; i < n; i++) {
                Collections.sort(buckets[i]);
            }

            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    arr[index++] = buckets[i].get(j);
                }
            }
        }
        //b
      public class BucketSort2 {
        private static class Node {
            double value;
            Node next;

            public Node(double value) {
                this.value = value;
                this.next = null;
            }
        }

        private static class LinkedList {
            Node head;

            public LinkedList() {
                this.head = null;
            }

            public void add(double value) {
                Node newNode = new Node(value);
                if (head == null) {
                    head = newNode;
                } else {
                    Node current = head;
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = newNode;
                }
            }

            public void sort() {
                Node current = head;
                while (current != null) {
                    Node innerCurrent = current.next;
                    while (innerCurrent != null) {
                        if (innerCurrent.value < current.value) {
                            double temp = current.value;
                            current.value = innerCurrent.value;
                            innerCurrent.value = temp;
                        }
                        innerCurrent = innerCurrent.next;
                    }
                    current = current.next;
                }
            }

            public void addAll(double[] arr) {
                for (double value : arr) {
                    add(value);
                }
            }

            public double[] toArray() {
                int size = size();
                double[] arr = new double[size];
                Node current = head;
                int i = 0;
                while (current != null) {
                    arr[i] = current.value;
                    current = current.next;
                    i++;
                }
                return arr;
            }

            public int size() {
                int size = 0;
                Node current = head;
                while (current != null) {
                    size++;
                    current = current.next;
                }
                return size;
            }
        }

        public static void bucketSort(double[] arr) {
            int n = arr.length;
            LinkedList[] buckets = new LinkedList[n];

            for (int i = 0; i < n; i++) {
                buckets[i] = new LinkedList();
            }

            for (int i = 0; i < n; i++) {
                int bucketIndex = (int) (n * arr[i]);
                buckets[bucketIndex].add(arr[i]);
            }

            for (int i = 0; i < n; i++) {
                buckets[i].sort();
            }

            int index = 0;
            for (int i = 0; i < n; i++) {
                double[] bucketArray = buckets[i].toArray();
                for (int j = 0; j < bucketArray.length; j++) {
                    arr[index++] = bucketArray[j];
                }
            }
        }
    }
    //c.
    public static void bucketSort3(double[] arr) {
        int n = arr.length;
        LinkedList<Double>[] buckets = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * arr[i]);
            buckets[bucketIndex].add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            int size = buckets[i].size();
            double[] temp = new double[size];
            for (int j = 0; j < size; j++) {
                temp[j] = buckets[i].get(j);
            }
            for (int j = 1; j < size; j++) {
                double key = temp[j];
                int k = j - 1;
                while (k >= 0 && temp[k] > key) {
                    temp[k + 1] = temp[k];
                    k--;
                }
                temp[k + 1] = key;
            }

            for (int j = 0; j < size; j++) {
                arr[j + i * size] = temp[j];
            }
        }
    }


}
