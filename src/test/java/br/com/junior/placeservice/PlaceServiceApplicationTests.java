package br.com.junior.placeservice;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.junior.placeservice.api.PlaceRequest;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PlaceServiceApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Test
	public void testCreatedPlaceSuccess(){
		var name = "Valid Name";
		var state = "Valid State";
		var slug = "valid-name";

		webTestClient
		.post()
		.uri("/places")
		.bodyValue(new PlaceRequest(name, state))
		.exchange()
		.expectBody()
		.jsonPath("name").isEqualTo(name)
		.jsonPath("slug").isEqualTo(slug)
		.jsonPath("state").isEqualTo(state)
		.jsonPath("createdAt").isNotEmpty()
		.jsonPath("updatedAt").isNotEmpty();
	}

	@Test
	public void testCreatedPlaceFail(){
		var name = "";
		var state = "";

		webTestClient
		.post()
		.uri("/places")
		.bodyValue(new PlaceRequest(name, state))
		.exchange()
		.expectStatus().isBadRequest();
	}
}
