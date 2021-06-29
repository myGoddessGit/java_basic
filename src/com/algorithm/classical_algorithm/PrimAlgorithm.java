package com.algorithm.classical_algorithm;

import java.util.Arrays;

/**
 * @Author by chenYl on 2021/4/14 15:14
 * @Description :
 * @VERSION :
 * @TITLE :
 */
public class PrimAlgorithm {

    static class MinTree {

        /**
         *
         * @param graph 图对象
         * @param verxs 图对应的顶点个数
         * @param data  图的各个顶点的值
         * @param weight 图的邻接矩阵
         */
        public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight){
            int i, j;
            for (i = 0; i < verxs; i++){
                graph.data[i] = data[i];
                for (j = 0; j < verxs; j++){
                    graph.weight[i][j] = weight[i][j];
                }
            }
        }

        // 显示图的邻接矩阵
        public void showGraph(MGraph graph){
            for (int[] link : graph.weight){
                System.out.println(Arrays.toString(link));
            }
        }

        /**
         *
         * @param graph 图
         * @param v
         */
        public void prim(MGraph graph, int v){
            int[] visited = new int[graph.verxs];
            visited[v] = 1; // 将当前结点标记为已访问
            // h1和h2记录两个顶点的下标
            int h1 = -1;
            int h2 = -2;
            // 将minWeight 初始化一个较大的数  后面的遍历过程中 会被替换掉
            int minWeight = 10000;
            for (int k = 1; k < graph.verxs; k++){

            }
        }
    }

    static class MGraph {
        int verxs; // 表示图的节点个数
        char[] data; // 存放节点数据
        int[][] weight; // 存放边 -> 邻接矩阵
        public MGraph(int verxs){
            this.verxs = verxs;
            data = new char[verxs];
            weight  = new int[verxs][verxs];
        }
    }
}
