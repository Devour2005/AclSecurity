package com.cookie.rest;

import com.cookie.dao.UserFilter;
import com.cookie.domain.User;
import com.cookie.service.CookieUserService;
import com.spring.DbManagerServiceSpringConfig;
import com.spring.RestServiceSpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = RestServiceSpringConfig.class)
@EnableWebMvc
//@WebAppConfiguration
public class Test {
    private static final String REST_SERVICE_URI = "http://localhost:8080/SpringGradleRest/user";

//    private MockMvc mockMvc;


    @Autowired
    private WebApplicationContext webApplicationContext;

    //    @org.junit.Test
    public void getUser() throws Exception {
   /*     this.mockMvc = webAppContextSetup(webApplicationContext).build();

        mockMvc.perform(get(REST_SERVICE_URI, 1))
                .andExpect(status().isOk()) ;*/

//                .andExpect(content().contentType(contentType))


//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RestServiceSpringConfig.class, DbManagerServiceSpringConfig.class);
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(RestServiceSpringConfig.class, DbManagerServiceSpringConfig.class);


        CookieUserService service = applicationContext.getBean(CookieUserService.class);

        UserFilter filter = new UserFilter();
        filter.setFirstName("admin");
        User byCriteria = service.findByCriteria(filter);
        System.out.println(byCriteria);
//        User byCriteria = service.findByCriteria(filter);
        RestTemplate restTemplate = new RestTemplate();
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
     /*   AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(RestServiceSpringConfig.class);
//        applicationContext.register(RestServiceSpringConfig.class);
        applicationContext.refresh();
        applicationContext.getBean(RestServiceSpringConfig.class);
        System.out.println("Testing listAllUsers API-----------");

        RestTemplate restTemplate = new RestTemplate();
//        User user = restTemplate.getForObject(REST_SERVICE_URI + "/users/1", User.class);
        User user = restTemplate.getForObject(REST_SERVICE_URI , User.class);
        System.out.println(user);*/

/*        ApplicationContext context = new AnnotationConfigApplicationContext(RestServiceSpringConfig.class);
        HelloWorld obj = (HelloWorld) context.getBean("CookieUserRestController");

        obj.printHelloWorld("Spring3 Java Config");*/

    }

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        test.getUser();
    }
}
