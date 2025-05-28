package com.example.demo2.collaborativefiltering;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @Author: Liujiang
 * @Date: 2020/4/5 14:23
 */

public class CollaborativeFiltering {

    /**
     * 基于最近邻用户产生协同过滤的推荐结果
     * @param userIdList
     * 用户Id列表
     * @param userKNNMatrix
     * 用户KNN矩阵
     * @param user2songRatingMatrix
     * 用户戏曲“评分”矩阵
     * @param songIdList
     * 戏曲Id列表
     * @param n
     * 推荐的前n首戏曲
     * @return
     * 用户戏曲推荐结果矩阵.userId,[recSongId1,recSongId2...recSongIdn]
     */
    public static Map<Integer, Integer[]> userKNNBasedCF(List<Integer> userIdList,
                                                         final Map<Integer, Integer[]> userKNNMatrix, final Map<Integer, float[]> user2songRatingMatrix,
                                                         final List<Integer> songIdList, final int n) {
        final Map<Integer,Integer[]> usersongRecMatrix=new HashMap<Integer, Integer[]>();
        userIdList.forEach(new Consumer<Integer>() {
            public void accept(Integer curUserId) {
                Integer[] knnIdArray=userKNNMatrix.get(curUserId);
                float[] curUserRatings=user2songRatingMatrix.get(curUserId);
                MininumHeap mininumHeap=new MininumHeap(n);
                for(int i=0;i<curUserRatings.length;i++) {
                    if(curUserRatings[i]<0.01f) {
                        for(int knnIndex=0;knnIndex<knnIdArray.length;knnIndex++) {
                            int knnId=knnIdArray[knnIndex];
                            float[] knnUserRatings=user2songRatingMatrix.get(knnId);
                            curUserRatings[i]+=knnUserRatings[i];
                        }
                        curUserRatings[i]/=knnIdArray.length;
                        int curSongId=songIdList.get(i);
                        mininumHeap.addElement(new TreeNode(curSongId,curUserRatings[i]));
                    }
                }
                int trueNumber=n;
                if(mininumHeap.getCurHeapSize()<n) {
                    trueNumber=mininumHeap.getCurHeapSize();
                }
                Integer[] curUserRecSongId=new Integer[trueNumber];
                for(int i=0;i<trueNumber;i++) {
                    int recSongId=mininumHeap.getArray()[i].id;
                    curUserRecSongId[i]=recSongId;
                }
                usersongRecMatrix.put(curUserId, curUserRecSongId);

            }

        });
        return usersongRecMatrix;
    }

}

