package org.example.dao;

import org.example.domain.Goods;

import java.util.List;

public interface GoodsDao {
    List<Goods> selectGood(Goods good);

    int insertGood(Goods good);

    int deleteGood(Goods good);
}
