package com.github.stiangao.cache;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

public class LFUCacheTest {

    @Test
    public void get() {
        //["LRUCache","put","put","get","put","get","put","get","get","get"]
        //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        LFUCache2 cache = new LFUCache2(2);
        cache.put(1,1);
        cache.put(2,2);
        Assert.assertEquals(1, cache.get(1));
        cache.put(3,3);
        Assert.assertEquals(-1, cache.get(2));
        Assert.assertEquals(3, cache.get(3));
        cache.put(4,4);
        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(3, cache.get(3));
        Assert.assertEquals(4, cache.get(4));

    }



    @Test
    public void test2() {
        LFUCache2 cache = new LFUCache2(10);

        String fun = "put,put,put,put,put,get,put,get,get,put,get,put,put,put,get,put,get,get,get,get,put,put,get,get,get,put,put,get,put,get,put,get,get,get,put,put,put,get,put,get,get,put,put,get,put,put,put,put,get,put,put,get,put,put,get,put,put,put,put,put,get,put,put,get,put,get,get,get,put,get,get,put,put,put,put,get,put,put,put,put,get,get,get,put,put,put,get,put,put,put,get,put,put,put,get,get,get,put,put,put,put,get,put,put,put,put,put,put,put";
        String param = "10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26";
        String result = "null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,14,null,null,18,null,null,11,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,11,null,null,null,null,29,null,null,null,null,17,-1,18,null,null,null,-1,null,null,null,20,null,null,null,29,18,18,null,null,null,null,20,null,null,null,null,null,null,null";
        String[] funArr = fun.split(",");
        String[] paramArr = param.split("],\\[");
        String[] resultArr = result.split(",");
        for (int i = 0; i < funArr.length; i++) {
            String funName = funArr[i];
            System.out.println(funName + "   " + paramArr[i] + "   " + resultArr[i]);
            switch (funName) {
                case "put":
                    int[] kv = Stream.of(paramArr[i].split(",")).mapToInt(Integer::parseInt).toArray();
                    cache.put(kv[0], kv[1]);
                    break;
                case "get":
                    int expected = Integer.parseInt(resultArr[i]);
                    int actual = cache.get(Integer.parseInt(paramArr[i]));
                    Assert.assertEquals(expected, actual);
                    break;
            }
        }
    }
}
