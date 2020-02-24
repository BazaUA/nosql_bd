package com.bazalytskyi.hw2_distribured;


import com.bazalytskyi.hw2_distribured.entity.sql.BaseRegion;
import com.bazalytskyi.hw2_distribured.repository.sql.BaseRegionRepository;
import com.bazalytskyi.hw2_distribured.service.FulfillDnaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw2DistriburedApplication implements CommandLineRunner {

	@Autowired
	private BaseRegionRepository baseRegionRepository;
	@Autowired
	private FulfillDnaDataService fulfillDnaDataService;

	public static void main(String[] args) {
		SpringApplication.run(Hw2DistriburedApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
//		CurriculumVitae curriculumVitae = new CurriculumVitae();
//		curriculumVitae.setData("Data");
//
//		User userSaveToSql = new User();
//		userSaveToSql.setLogin("Login");
//		userSaveToSql.setPassword("Password");
//		userSaveToSql.setCv(curriculumVitae);
//
//		userRepository.save(userSaveToSql);
//		System.out.println(userRepository.findAll());
		fulfillDnaDataService.seedData();
		BaseRegion baseRegion = new BaseRegion();
		baseRegion.setName("A");
		baseRegionRepository.save(baseRegion);
	}
}
