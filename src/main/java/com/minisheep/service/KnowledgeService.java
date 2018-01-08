package com.minisheep.service;

import com.minisheep.model.Knowledge;

import java.util.List;

/**
 * Created by minisheep on 18/1/8.
 */
public interface KnowledgeService {
    public List<Knowledge> findAllKnowLedge();  // 查找所有的知识库

    public String getKnowledgeSub(int knowledgeId);  // 获取子表数据

    public void addKnowledge(Knowledge item);  // 添加知识
}
