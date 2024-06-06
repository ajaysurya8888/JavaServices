public class Median {
     static class Solution {

         public static double median(int[] a, int[] b) {
             int n1 = a.length, n2 = b.length;
             //if n1 is bigger swap the arrays:
             if (n1 > n2) return median(b, a);

             int n = n1 + n2; //total length
             int left = (n1 + n2 + 1) / 2; //lets say you have size 10. 10 + 1 / 2 = 5
             //lets say you have size 7. 7 + 1 / 2 = 4 . either you have to divide 4 3 or 3 2. it works to find both odd and even . thats why this left is made
             //apply binary search:
             int low = 0, high = n1;
             while (low <= high) {
                 int mid1 = (low + high) / 2; // you are picking lets say 2 elements from array 1. array1+array 2 = 10 .
                 // then you must pick 5 elements totally. so you have to pick 3 elements from array 2. that calculation is reffered here as mid2
                 int mid2 = left - mid1;
                 //calculate l1, l2, r1 and r2;
                 int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
                 int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
                 int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
                 int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

                 if (l1 <= r2 && l2 <= r1) {
                     if (n % 2 == 1) return Math.max(l1, l2); // if total number of elements in both the array is odd , then return the max of l1 and l2
                     else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0; // if total element is  is even select the max from the left half and min from the right half divide by 2
                 } else if (l1 > r2) high = mid1 - 1; // lets say you have 1 ,2 3, 7(l1),8. If l1 in the left is greater than r2 which is on the right you have to reduce the high
                 else low = mid1 + 1; // lets say you have l2 greater than r1 , then you have to take more from the frirst array
             }
             return 0; //dummy statement
         }
    }
}
