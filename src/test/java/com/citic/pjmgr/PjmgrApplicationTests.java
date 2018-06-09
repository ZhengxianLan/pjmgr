package com.citic.pjmgr;

import com.citic.pjmgr.dao.ProjectRepository;
import com.citic.pjmgr.domain.Project;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PjmgrApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	private ProjectRepository  projectRepository;

	@Test
	public void testSaveProject(){
		Project project = new Project();
		project.setProjectName("aabbb");
//		project.setCreateDate(new Date());
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		project.setDesc("desc");
		project.setSubmitter("whoami");
		project.setStageList(new int[]{1,3});
		Project save = projectRepository.save(project);
		System.out.println("save = " + save);

	}
	@Test
	public void testFindOneProject(){
		Project project = new Project();
		project.setProjectName("aabbb");
//		Optional<Project> save = projectRepository.findById(Long.valueOf(1));
//		System.out.println("save = " + save);
		projectRepository.getOne(1l);

	}

	@Test
	public void testFindByProjectName(){

		Project project = new Project();
		project.setProjectName("aabbb");
//		project.setCreateDate(new Date());
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		project.setDesc("desc");
		project.setSubmitter("whoami");
		project.setStageList(new int[]{1,3});
		Project save = projectRepository.save(project);
//		Optional<Project> save = projectRepository.findById(Long.valueOf(1));
//		System.out.println("save = " + save);
		List<Project> aabbb = projectRepository.findByProjectName("aabbb");
		log.info(String.valueOf(aabbb));

	}
}
