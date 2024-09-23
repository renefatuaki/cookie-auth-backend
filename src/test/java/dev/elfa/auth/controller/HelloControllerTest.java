package dev.elfa.auth.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

	@Autowired
	MockMvc mvc;

	@Test
	@WithMockUser
	void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/hello").content("Test").with(csrf()))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}