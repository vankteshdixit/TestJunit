package com.vanktesh.ApplicationTesting;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@SpringBootTest
class ApplicationTestingApplicationTests {

	@BeforeEach
	void setUp(){
		log.info("Starting the method, setting up the config");
	}

	@BeforeAll
	static void setUpOnce(){
		log.info("it is start once at starting of application and we use static because it is the for the whole class");
	}
	@AfterAll
	static void detUpOnce(){
		log.info("tearing the method, setting up the config");
	}

	@AfterEach
	void detUp(){
		log.info("Deboard the method, discard the config");
	}

	@Test
	@DisplayName("Test number 1")
	void contextLoads() {
		log.info("Test one is run");
	}

	@Test
	@DisplayName("Test number 2")
	void testNumberTwo(){
		log.info("Test 2 is run");
	}

	@Test
	@DisplayName("Add two number")
	void additionOfNumber(){
		int a = 5;
		int b = 3;

		int result = addTwoNo(a, b);

//		Assertions.assertEquals(8, result);

		assertThat(result)
				.isEqualTo(8)
				.isCloseTo(9, Offset
						.offset(1));

		assertThat("Apple")
				.isEqualTo("Apple")
				.startsWith("App")
				.endsWith("le")
		 		.hasSize(5);
	}

	int addTwoNo(int a, int b){
		return a+b;
	}

}
