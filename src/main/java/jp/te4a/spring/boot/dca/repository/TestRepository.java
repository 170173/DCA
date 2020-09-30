package jp.te4a.spring.boot.dca.repository;

import org.springframework.stereotype.Repository;
import jp.te4a.spring.boot.dca.bean.TestBean;

import org.springframework.data.jpa.repository.JpaRepository;
public interface TestRepository extends JpaRepository<TestBean, Integer>{
	
}
