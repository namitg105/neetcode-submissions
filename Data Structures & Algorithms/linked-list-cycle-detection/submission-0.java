/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// class Solution {
//     public boolean hasCycle(ListNode head) {
//         ListNode temp = head;
//         HashMap<Integer, Integer> map = new HashMap<>();
//         while (temp.next!=null) {
//             if(map.get(temp.next.value)>0){
//          return true;
//              }
//             temp=temp.next;
//               int count = 0;
//            map.put(temp.next.value) = count++;
//             }

//         return false;
//         }
//     }

class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode temp = head;

        while (temp != null) {
            if (visited.contains(temp)) {
                return true;
            }
            visited.add(temp);
            temp = temp.next;
        }

        return false;
    }
}

