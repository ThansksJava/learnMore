package com.learn.test;


import java.util.*;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

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

        combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println(ret);

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
        void add(int val){
            // 比较当前插入值与队尾元素的大小，大于当前队尾元素就将队尾元素剔除
            while( !deque.isEmpty() && val > deque.getLast()){
                deque.removeLast();
            }
            deque.add(val);
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