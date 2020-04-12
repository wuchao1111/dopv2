package com.clsaa.dop.server.alert.dao;

import com.clsaa.dop.server.alert.model.po.Strategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reactor.util.annotation.NonNull;

import java.util.ArrayList;

/**
 * @ClassName StrategyDao
 * @Author
 * @Version 1.0
 * @Describtion TODO
 * @return
 * @since 2020-03-12
 **/

@Repository
public interface StrategyDao extends JpaRepository<Strategy , Long>{
//	Strategy getStrategiesByUserId(int userId);
	ArrayList<Strategy> getStrategiesByUserId(Long userId);
	void deleteById(@NonNull Long Id);

}
