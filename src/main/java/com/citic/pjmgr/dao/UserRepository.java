package com.citic.pjmgr.dao;

import com.citic.pjmgr.domain.Project;
import com.citic.pjmgr.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lan on 6/9/18.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<Project> findByProjectName(String projectName);
}
