package leetcode;

import java.util.*;

/**
 * Created by ykp on 9/22/16.
 */
public class TopKFrequentElements347 {

    class ValueNode implements Comparable<ValueNode>{
        int value;
        int count;

        public ValueNode(int value, int count){
            this.value = value;
            this.count = count;
        }

        public int compareTo(ValueNode other){
            if(this.count > other.count){
                return 1;
            }else if(this.count < other.count){
                return -1;
            }else{
                return 0;
            }
        }
    }


    private List<Integer> topKFrequent(int[] array, int k) {

        List<Integer> result = new ArrayList();

        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0; i < array.length; i++){
            if(map.get(array[i]) == null){
                map.put(array[i],1);
            }else{
                int currentCount = map.get(array[i]);
                map.put(array[i], currentCount+1);
            }
        }


        PriorityQueue<ValueNode> pq = new PriorityQueue<>(k);

        for(Integer in : map.keySet()){
            int count = map.get(in);
            ValueNode node = new ValueNode(in,count);
            pq.offer(node);
            if(pq.size() > k){
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            ValueNode current = pq.poll();
            result.add(current.value);
        }

        Collections.reverse(result);

        return result;

    }

    public static void main(String[] args){
        TopKFrequentElements347 topk = new TopKFrequentElements347();
        int[] array = {1,1,1,2,2,3};
        List<Integer> result = topk.topKFrequent(array, 2);
        for(Integer i : result){
            System.out.println(i);
        }
    }


}
