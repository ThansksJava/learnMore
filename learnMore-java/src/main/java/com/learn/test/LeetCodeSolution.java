package com.learn.test;


import java.util.*;
import java.util.stream.IntStream;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    Node random;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int _val, TreeNode _left, TreeNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
public class LeetCodeSolution {

    public static void main(String[] args) {
       String s = "123";


    }
    public static int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示i个0和j个1时的最大子集
        int[][] dp = new int[m + 1][n + 1];
        int oneNum, zeroNum;
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            //倒序遍历
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
    public static TreeNode deserialize(String data) {
        if("[]".equals(data) ){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        String [] s = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        q.offer(root);
        int i = 0;
        int len = s.length;
        while(2 * i + 1 < len && !q.isEmpty()){
            if(s[i].equals("null")){
                i++;
                continue;
            }
            TreeNode cur = q.poll();
            String leftVal = s[2 * i + 1];
            String rightVal = s[2 * i + 2];
            if("null".equals(leftVal)){
                cur.left = null;
            }else{
                cur.left = new TreeNode(Integer.valueOf(leftVal));
                q.offer(cur.left);
            }
            if("null".equals(rightVal)){
                cur.right = null;
            }else{
                cur.right = new TreeNode(Integer.valueOf(rightVal));
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    public static int strToInt(String str) {
        if(str == null){
            return 0;
        }
        str = str.trim();
        if("".equals(str)){
            return 0;
        }
        boolean isNegative = false;
        double ret = 0;
        if(str.charAt(0) == '+'){
            str = str.substring(1);
        }else if(str.charAt(0) == '-'){
            isNegative = true;
            str = str.substring(1);
        }
        if("".equals(str)){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        if(str.charAt(0) == 0 || str.charAt(0) < '0' || str.charAt(0) > '9'){
            return 0;
        }
        Map<Character, Integer> m = new HashMap<>();
        m.put('0',0);
        m.put('1',1);
        m.put('2',2);
        m.put('3',3);
        m.put('4',4);
        m.put('5',5);
        m.put('6',6);
        m.put('7',7);
        m.put('8',8);
        m.put('9',9);
        int idx = 0;
        while(idx < str.length()) {
            char c = str.charAt(idx);
            if (c >= '0' && c <= '9') {
                list.add(m.get(c));
            } else {
                break;
            }
            idx++;
        }
        double sum = 0;

        for(int i = list.size() - 1; i >= 0; i--){
            double cur = list.get(list.size() - 1 - i);
            int j = i;
            while(j > 0){
                cur *= 10;
                j--;
            }
            sum += cur;
        }


        ret = sum;

        if(isNegative){
            ret = -ret;
        }

        if(ret > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(ret < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else{
            return (int)ret;
        }
    }


    public static int[][] findContinuousSequence(int target) {
        List<List<Integer>> list = new ArrayList<>();
        int end = target / 2 + 1;
        for(int i = 1;i <= end; i++ ){
            int tmp = 0;
            List<Integer> ele = new ArrayList<>();
            for(int j = i; j <= end; j++){
                tmp += j;
                ele.add(j);
                if(tmp == target ){
                    list.add(ele);
                }else if(tmp > target){
                    break;
                }
            }
        }
        return list.toArray(new int[0][]);
    }
    public static int[] singleNumbers(int[] nums) {
        int x = 0;
        int y = 0;
        // 得到的n是两个不同的数的异或值
        int n = 0;
        for(int num : nums){
            n = n ^ num;
        }

        int m = 1;
        // 找第一个为1的位数，也就是x^y的第一个为1的位数，也就是x和y二进制不同的第一个位数
        while((n & m) == 0){
            m = m << 1;
        }
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int num : nums){
            if((num & m ) != 0){
                l1.add(num);
                x = x ^ num;
            }else{
                l2.add(num);
                y = y ^ num;
            }
        }

        return new int[]{x, y};
    }



    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight){
        int wLen = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < wLen; i++){
            for (int j = bagWeight; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
//            for (int j = weight[i]; j <= bagWeight; j++){
//                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
//            }
        }
        //打印dp数组
        for (int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + " ");
        }
    }



    public static int hammingWeight(int n) {
        n = Integer.parseInt("11111111111111111111111111111101");
        int count = 0;
        while(n > 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int translateNum(int num) {
        if(num == 0){
            return 1;
        }
        int length = Integer.toString(num).length();

        int idx = length - 1;

        int [] nums = new int[length];

        int [] dp = new int[length + 1];

        while(num > 0){
            nums[idx--] = num % 10;
            num = num / 10;
        }
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= length; i++){
            dp[i] = (nums[i - 2] * 10 + nums[i - 1] > 25) ? dp[i - 1] : dp[i - 2] + dp[i - 1];
        }
        return dp[length];
    }




    public static char firstUniqChar(String s) {

        char ret = ' ';
        int [][] arr = new int[26][2];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(arr[c - 'a'][0] == 0){
                arr[c - 'a'][1] = i;
            }
            arr[c - 'a'][0]++;
        }
        int idx = 26;
        for(int i = 0; i < arr.length; i++){
            if(arr[i][0] == 1){
                idx = Math.min(idx, arr[i][1]);
                ret = s.charAt(idx);
            }
        }
        return ret;

    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        // 表示节点的位置
        int index = 0;
        Map<Node, Integer> map = new HashMap<>();
        Node pre = new Node(0);
        Node cur = head;
        Node ret = pre;
        while(cur != null){
            map.put(cur, index++);
            pre.next = new Node(cur.val);
            pre = pre.next;
            cur = cur.next;
        }
        // 将被拷贝的链表的指针重新置于头结点，进行random指针的操作
        cur = head;
        //
        Node node = ret.next;
        while(cur != null){
            if(cur.random != null){
                int idx = map.get(cur.random);
                Node tmp = ret.next;
                while(idx-- > 0){
                    tmp = tmp.next;
                }
                node.random = tmp;
            }
            node = node.next;
        }
        return ret.next;
    }


    public static int largestSumAfterKNegations(int[] nums, int k) {
        // 按照绝对值大小进行排序
        nums = IntStream.of(nums).boxed().sorted((a,b) -> Math.abs(b) - Math.abs(a)).mapToInt(Integer::intValue).toArray();
        int length = k;
        for(int i = 0; i < length; i++){
            if(nums[i] < 0 && k > 0){
                nums[i] = -nums[i];
                k--;
            }
        }
        // 不断的反转最小的元素
        while(k-- > 0){
            nums[0] = -nums[0];
        }

        return Arrays.stream(nums).sum();
    }



    static List<List<Integer>> ret2 = new ArrayList<>();
    static List<Integer> ele2 = new ArrayList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ret2.add(new ArrayList(ele2));
        backtracing(nums, 0);
        return ret2;
    }


    public static void backtracing(int [] nums, int startIdx){
        if(startIdx >= nums.length){
            return;
        }
        for(int i = startIdx; startIdx < nums.length; i++){
            if(i > startIdx && nums[i] == nums[i - 1]){
                continue;
            }
            ele2.add(nums[i]);
            ret2.add(new ArrayList(ele2));
            backtracing(nums, i + 1);
            ele2.remove(ele2.size() - 1);
        }

    }



    List<String> ret1 = new ArrayList<>();
    //有效的IP地址
    StringBuilder str = new StringBuilder();
    //上一个分隔符的位置
    int dotIdx = -1;
    public List<String> restoreIpAddresses(String s) {
        // 根本组不成有效IP
        if(s.length() > 12 || s.length() < 4){
            return ret1;
        }
        restoreIpAddresses(s, 0);
        return ret1;
    }

    public void restoreIpAddresses(String s, int startIdx){
        for(int i = 0; i < s.length(); i++){

        }
    }
















    private static List<List<Integer>> ret = new ArrayList<>();
    private static List<Integer> ele = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum1(candidates, target);
        return ret;
    }


    public static void combinationSum1(int [] candidates, int target){
        if(ret.size() >= 150){
            return;
        }
        if(target == 0){
            if(ret.size() == 0 || !ele.retainAll(ret.get(ret.size() - 1))){
                ret.add(new ArrayList(ele));
            }
            return;
        }else if(target < 0){
            return;
        }
        for(int i = 0; i < candidates.length; i++){
            ele.add(candidates[i]);
            combinationSum1(candidates, target - candidates[i]);
            if(ele.size() != 0){
                ele.remove(ele.size() - 1);
            }
        }
    }





    public  static TreeNode convertBST(TreeNode root) {
        if(root == null){
            return root;
        }
        ArrayList a = new ArrayList(new ArrayList());
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !s.isEmpty()){
            if(cur != null){
                s.push(cur);
                cur = cur.left;
            }else{
                cur = s.pop();
                list.add(cur);
                cur = cur.right;
            }
        }
        for(int i = 0; i < list.size(); i++){
            TreeNode c = list.get(i);
            for(int j = i + 1; j < list.size(); j++){
                c.val += list.get(j).val;
            }
        }
        return root;
    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        if(left != null && right == null){
            return left;
        }

        if(left == null && right != null){
            return right;
        }

        return null;
    }
    private static TreeNode previousRoot = null;
    private static int diff = Integer.MAX_VALUE;
    public static int getMinimumDifference(TreeNode root) {
        if(root == null){
            return 0;
        }
        getDiff(root);
        return diff;
    }

    public static void  getDiff(TreeNode root){
        if(root == null) {
            return;
        }
        System.out.print("root = " + root.val + " ");
        getDiff(root.left);
        if(previousRoot != null){
            System.out.println("previousRoot="+previousRoot.val + " ");
            diff = Math.min(diff, root.val - previousRoot.val);
        }else{
            System.out.println("previousRoot="+"null" + " ");
        }
        previousRoot = root;

        getDiff(root.right);
    }



    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode nodeInleft = q.poll();
            TreeNode nodeInright = q.poll();
            if(nodeInleft == null && nodeInright == null){
                continue;
            }
            if((nodeInleft == null && nodeInright != null) || (nodeInleft != null && nodeInright == null) || (nodeInleft.val != nodeInright.val)){
                return false;
            }
            //把左右子树需要比较的节点成对放进去，然后下一次循环一次取出来
            q.add(nodeInleft.left);
            q.add(nodeInright.right);
            q.add(nodeInleft.right);
            q.add(nodeInright.left);

        }
        return true;

    }



    public static Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node leftNodeInLevel = null;
        if(root.left != null){
            root.left.next = root.right;
            leftNodeInLevel = root.left;
        }else{
            leftNodeInLevel = root.right;
        }
        while(leftNodeInLevel != null){
            // 保留当前的left node
            Node cur = leftNodeInLevel;
            // 更新为下一层的left node
            while(cur.left != null || cur.right != null){
                if(cur.left != null){
                    leftNodeInLevel = cur.left;
                }else{
                    leftNodeInLevel = cur.right;
                }
                cur = cur.next;
            }

            while(cur != null){
                if(cur.right != null){
                    cur.left.next = cur.right;
                    cur.right.next = cur.next == null?null:(cur.next.left == null?cur.next.left:cur.next.right);
                }else{
                    cur.left = cur.next == null?null:(cur.next.left == null?cur.next.left:cur.next.right);
                }
                cur = cur.next;
            }
        }

        return root;
    }
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();

        if(root != null){
            ArrayDeque<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            while(!q.isEmpty()) {
                int size = q.size();
                double sum = 0.0;
                for(int i = 0; i < size; i++){
                    root = q.poll();
                    if(root.left != null){
                        q.add(root.left);
                    }
                    if(root.right != null){
                        q.add(root.right);
                    }
                    sum += root.val;
                    if(i == size - 1){
                        ret.add(sum / size);
                    }
                }
            }
        }
        return  ret;
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root != null){
            ArrayDeque<TreeNode> q = new ArrayDeque<>();
            q.push(root);
            while(!q.isEmpty()){
                int curLevelCount = q.size();
                List<Integer> curLevel = new ArrayList<>();
                for(int i = 0; i < curLevelCount; i++){
                    root = q.pop();
                    curLevel.add(root.val);
                    if(root.left != null){
                        q.push(root.left);
                    }
                    if(root.right != null){
                        q.push(root.right);
                    }
                }
                ret.add(0, curLevel);
            }
        }

        return ret;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        res.add(0,1);
        Stack<TreeNode> curNodes = new Stack<>();
        curNodes.push(root);
        while(!curNodes.empty()){
            TreeNode p = curNodes.pop();
            res.add(p.val);
            if(p.left != null){
                curNodes.push(p.left);
            }
            if(p.right != null){
                curNodes.push(p.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int [] ret = new int[k];
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = m.entrySet();


        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> e : entries) {
            priorityQueue.add(e);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }

        int i = 0;
        while(priorityQueue.size() > 0){
            ret[i++] = priorityQueue.poll().getKey();
        }
        return ret;
    }
    static class Q{
        Deque<Integer> deque = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        void add(int val){
            // 比较当前插入值与队尾元素的大小，大于当前队尾元素就将队尾元素剔除
            while( !deque.isEmpty() && val > deque.getLast()){
                deque.removeLast();
            }
            deque.add(val);
            new ArrayList<>(ele);
            ele.clear();
        }

        void poll(int val){
            // 如果刚走过的窗口的最大值是当前出窗口的值，那就弹出，窗口最大值已经变了
            if(!deque.isEmpty() && val == deque.peek()){
                deque.poll();
            }
        }

        int peek(){
            return deque.peek();
        }

    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k > nums.length || k <= 0){
            return new int[]{};
        }
        int len = nums.length - k + 1;
        int [] ret = new int[len];
        Q q = new Q();
        // 把第一个窗口的值放进去
        int i = 0;
        while(i < k){
            q.add(nums[i]);
        }
        i = 0;
        ret[i++] = q.peek();
        for(int j = k; j < nums.length; j++){
            // 移除出窗口的值
            q.poll(nums[j - k]);
            q.add(nums[j]);
            ret[i++] = q.peek();
        }
        return ret;
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if("+-*/".contains(tokens[i])){
                int cal = 0;
                if("*".equals(tokens[i])){
                    cal = s.pop()*s.pop();
                }else if("/".equals(tokens[i])){
                    Integer pop1 = s.pop();
                    Integer pop2 = s.pop();
                    cal = pop1 / pop2;
                }else if("+".equals(tokens[i])){
                    cal = s.pop() + s.pop();
                }else if("-".equals(tokens[i])){
                    cal = s.pop() - s.pop();
                }
                s.push(cal);
            }else{
                s.push(Integer.valueOf(tokens[i]));
            }
        }

        return s.pop();
    }
    public String removeDuplicates(String s) {
        Stack<Character> q = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!q.isEmpty() ){
                if(q.peek() != c ){
                    q.push(c);
                }else{
                    q.pop();
                }
            }else{
                q.push(c);
            }

        }
        StringBuffer sql = new StringBuffer();
        while(!q.isEmpty()){
            sql.append(q.pop());
        }
        return sql.reverse().toString();
    }
    /**
     *
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        //定义出数组
        int[][] matrix = new int[n][n];
        //开始画矩阵
        int i = 0;
        int j = 0;
        int cal = 1;
        int circle = 0;
        while (i < n && j < n && matrix[i][j] == 0 ) {
            // 首先第一行填充起来
            matrix[i][j++] = cal++;
            //说明到行尾部了
            if (j == n) {
                j--;
                i++;
                while (i < n && matrix[i][j] == 0) {
                    matrix[i++][j] = cal++;
                }
                if (i == n) {
                    i--;
                    j--;
                    while (j >= circle && matrix[i][j] == 0) {
                        matrix[i][j--] = cal++;
                    }
                     if (j < circle  ) {
                         j++;
                         i--;
                         while (i >= circle && matrix[i][j] == 0) {
                             matrix[i--][j] = cal++;
                         }
                     }
                }
                 n--;
                 circle++;
                 i = circle;
                 j = circle;
            }

        }
        return matrix;
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowL = matrix.length - 1;
        int colL = matrix[0].length - 1;
        int rowIdx = 0;
        int colIdx = 0;

        while(rowIdx <= rowL && colIdx <= colL){
            //打印第一行
            res.add(matrix[rowIdx][colIdx++]);
            // 第一行打印完了colStart经过加一之后肯定大于列长度索引colL
            if(colIdx > colL){
                // 将列索引恢复为有效索引
                colIdx = colIdx - 1;
                rowIdx = rowIdx + 1;
                // 开始打印右侧列
                while(rowIdx <= rowL){
                    res.add(matrix[rowIdx][colIdx]);
                    rowIdx++;
                }
                // 行 触底了
                if(rowIdx > rowIdx){
                    //恢复正常索引
                    rowIdx = rowIdx - 1;
                    colIdx = colIdx - 1;
                }
            }

        }




        return res;
    }


    static class MyStack {

        private Queue<Integer> q;
        private int last = 0;
        public MyStack() {
            q = new LinkedList<>();
        }
        public void push(int x) {
            q.offer(x);
            last = x;
        }

        public int pop() {
            int size = q.size();
            while(size-- > 1){
                q.offer(q.poll());
                last = q.peek();
            }
            return q.poll();
        }

        public int top() {
            return last;
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

}