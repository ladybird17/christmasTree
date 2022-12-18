package com.demo.christmasTree.repository;

import com.demo.christmasTree.entity.Tree;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author : yjseo
 * date : 2022-12-14
 */
public interface TreeRepository extends JpaRepository<Tree, Long>{

}
