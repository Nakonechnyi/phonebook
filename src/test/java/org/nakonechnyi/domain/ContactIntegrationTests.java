package org.nakonechnyi.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nakonechnyi.domain.my_sql.Contact;
import org.nakonechnyi.domain.my_sql.User;
import org.nakonechnyi.repository.MySqlContactRepository;
import org.nakonechnyi.repository.MySqlUserRepository;
import org.nakonechnyi.service.ISecurityService;
import org.nakonechnyi.service.MySqlUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContactIntegrationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MySqlContactRepository contactRepository;

	@Autowired
	private MySqlUserRepository userRepository;

	@Autowired
	private MySqlUserDetailsService userDetailsService;

	@Autowired
	private ISecurityService securityService;

	private User referenceUser;

	@Before
	public void setup() {
		referenceUser = userRepository.findByLogin("user");
		securityService.autoLogin("usere", "passworde");
	}

	@Test
	public void createContact() throws Exception {
		BaseContact contact = contact();
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
				.get("/contacts/create") //TODO POST
				.accept(MediaTypes.HAL_JSON)
				.params(getParams(contact))
				.contentType(MediaType.APPLICATION_JSON)
				.with(user(userDetailsService.loadUserByUsername("usere"))));

		final Contact created = findCreatedContact();
		resultActions.andExpect(status().is(200));
	}

	private Contact findCreatedContact() {
		return contactRepository.findByPhone("(68)3502453").get(0);
	}

	private BaseContact contact() {
		BaseContact result = new BaseContact();
		result.setFirstName("Anton");
		result.setLastName("Nakonechnyi");
		result.setSurname("Oleksiyovych");
		result.setPhone("+380(68)3502453");
		result.setEmail("anton.nak@gmail.com");
		return result;
	}

	public MultiValueMap<String,String> getParams(BaseContact contact) {
		MultiValueMap<String,String> result = new LinkedMultiValueMap();
		result.add("firstName", contact.getFirstName());
		result.add("lastName", contact.getLastName());
		result.add("surname", contact.getSurname());
		result.add("phone", contact.getPhone());
		result.add("homePhone", "");
		result.add("email", contact.getEmail());
		return result;
	}
}
