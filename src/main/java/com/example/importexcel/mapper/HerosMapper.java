package com.example.importexcel.mapper;

import com.example.importexcel.dao.Heros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HerosMapper extends JpaRepository<Heros, Long> {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Heros record);
//
//    int insertSelective(Heros record);
//
//    Heros selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(Heros record);
//
//    int updateByPrimaryKey(Heros record);

//    int batchInsert(List<Heros> heros);
}