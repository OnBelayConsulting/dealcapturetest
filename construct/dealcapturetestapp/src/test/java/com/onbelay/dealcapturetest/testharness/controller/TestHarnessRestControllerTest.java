package com.onbelay.dealcapturetest.testharness.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.dealcapturetest.testharness.snapshot.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WithMockUser
@ComponentScan("com.onbelay")
@SpringBootTest()
@TestPropertySource( locations="classpath:application-integrationtest.properties")
public class TestHarnessRestControllerTest {
	private static final Logger logger = LogManager.getLogger();
	
	@Autowired
	private TestHarnessRestController testHarnessRestController;

	
	@Autowired
	private ObjectMapper objectMapper;


	@Test
	public void generateOrganizationsRequestWithPost() throws Exception {
		
		MockMvc mvc = MockMvcBuilders.standaloneSetup(testHarnessRestController)
				.build();

		String jsonString = "{ \"organizationNamePrefix\": \"coo\", \"total\": 1  }";
		
		ResultActions result = mvc.perform(
				post("/api/organizations")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonString));
		
		MvcResult mvcResult = result.andReturn();
		
		String jsonStringResponse = mvcResult.getResponse().getContentAsString();
		
		logger.error(jsonStringResponse);
	
		ObjectMapper mapper = new ObjectMapper();
		
		TransactionResult transactionResult = mapper.readValue(jsonStringResponse, TransactionResult.class);
		assertEquals(true, transactionResult.isSuccessful());

	}


	@Test
	public void generateCompaniesRequestWithPost() throws Exception {

		MockMvc mvc = MockMvcBuilders.standaloneSetup(testHarnessRestController)
				.build();
		GenerateCompaniesRequest request = new GenerateCompaniesRequest();
		request.setQuery("WHERE name eq 'CO_1");
		String jsonString = objectMapper.writeValueAsString(request);

		ResultActions result = mvc.perform(
				post("/api/companies")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonString));

		MvcResult mvcResult = result.andReturn();

		String jsonStringResponse = mvcResult.getResponse().getContentAsString();

		logger.error(jsonStringResponse);

		ObjectMapper mapper = new ObjectMapper();

		TransactionResult transactionResult = mapper.readValue(jsonStringResponse, TransactionResult.class);
		assertEquals(true, transactionResult.isSuccessful());

	}


	@Test
	public void generateCounterpartiesRequestWithPost() throws Exception {

		MockMvc mvc = MockMvcBuilders.standaloneSetup(testHarnessRestController)
				.build();
		GenerateCounterpartiesRequest request = new GenerateCounterpartiesRequest();
		request.setSettlementCurrency("CAD");
		request.setQuery("WHERE name eq 'CO_1");
		String jsonString = objectMapper.writeValueAsString(request);

		ResultActions result = mvc.perform(
				post("/api/counterparties")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonString));

		MvcResult mvcResult = result.andReturn();

		String jsonStringResponse = mvcResult.getResponse().getContentAsString();

		logger.error(jsonStringResponse);

		ObjectMapper mapper = new ObjectMapper();

		TransactionResult transactionResult = mapper.readValue(jsonStringResponse, TransactionResult.class);
		assertEquals(true, transactionResult.isSuccessful());

	}


	@Test
	public void generatePriceIndicesRequestWithPost() throws Exception {

		MockMvc mvc = MockMvcBuilders.standaloneSetup(testHarnessRestController)
				.build();
		GeneratePriceIndicesRequest request = new GeneratePriceIndicesRequest();
		request.setTotal(5);
		request.setCurrencyCode("CAD");
		request.setUnitOfMeasureCode("GJ");
		request.setIndexNamePrefix("PI");
		request.setLocationName("Location");
		request.setHubName("BASE");
		String jsonString = objectMapper.writeValueAsString(request);
		ResultActions result = mvc.perform(
				post("/api/priceIndices")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonString));

		MvcResult mvcResult = result.andReturn();

		String jsonStringResponse = mvcResult.getResponse().getContentAsString();

		logger.error(jsonStringResponse);

		ObjectMapper mapper = new ObjectMapper();

		TransactionResult transactionResult = mapper.readValue(jsonStringResponse, TransactionResult.class);
		assertEquals(true, transactionResult.isSuccessful());

	}


	@Test
	public void generatePricesRequestWithPost() throws Exception {

		MockMvc mvc = MockMvcBuilders.standaloneSetup(testHarnessRestController)
				.build();
		GenerateCurvesRequest request = new GenerateCurvesRequest();
		request.setQuery("WHERE ");
		request.setStartDate(LocalDate.of(2023,  1, 1));
		request.setEndDate(LocalDate.of(2023,  1, 31));
		request.setObservedDateTime(LocalDateTime.now());
		request.setValue(BigDecimal.ONE);

		String jsonString = objectMapper.writeValueAsString(request);

		ResultActions result = mvc.perform(
				post("/api/prices")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonString));

		MvcResult mvcResult = result.andReturn();

		String jsonStringResponse = mvcResult.getResponse().getContentAsString();

		logger.error(jsonStringResponse);

		ObjectMapper mapper = new ObjectMapper();

		TransactionResult transactionResult = mapper.readValue(jsonStringResponse, TransactionResult.class);
		assertEquals(true, transactionResult.isSuccessful());

	}


	@Test
	public void generateFxRatesRequestWithPost() throws Exception {

		MockMvc mvc = MockMvcBuilders.standaloneSetup(testHarnessRestController)
				.build();
		GenerateCurvesRequest request = new GenerateCurvesRequest();
		request.setQuery("WHERE");
		request.setStartDate(LocalDate.of(2023,  1, 1));
		request.setEndDate(LocalDate.of(2023,  1, 31));
		request.setObservedDateTime(LocalDateTime.now());

		String jsonString = objectMapper.writeValueAsString(request);

		ResultActions result = mvc.perform(
				post("/api/rates")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonString));

		MvcResult mvcResult = result.andReturn();

		String jsonStringResponse = mvcResult.getResponse().getContentAsString();

		logger.error(jsonStringResponse);

		ObjectMapper mapper = new ObjectMapper();

		TransactionResult transactionResult = mapper.readValue(jsonStringResponse, TransactionResult.class);
		assertEquals(true, transactionResult.isSuccessful());

	}


	@Test
	public void testGenerateLocationsRequestWithPost() throws Exception {

		MockMvc mvc = MockMvcBuilders.standaloneSetup(testHarnessRestController)
				.build();
		GeneratePricingLocationsRequest request = new GeneratePricingLocationsRequest();
		request.setLocationNamePrefix("LO");
		String jsonString =  objectMapper.writeValueAsString(request);

		ResultActions result = mvc.perform(
				post("/api/pricingLocations")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonString));

		MvcResult mvcResult = result.andReturn();

		String jsonStringResponse = mvcResult.getResponse().getContentAsString();

		logger.error(jsonStringResponse);

		ObjectMapper mapper = new ObjectMapper();

		TransactionResult transactionResult = mapper.readValue(jsonStringResponse, TransactionResult.class);
		assertEquals(true, transactionResult.isSuccessful());

	}


	@Test
	public void testGeneratePhysicalDealsRequestWithPost() throws Exception {

		MockMvc mvc = MockMvcBuilders.standaloneSetup(testHarnessRestController)
				.build();
		GeneratePhysicalDealsRequest request = new GeneratePhysicalDealsRequest();
		request.setMarketIndexName("Index");
		request.setCompanyName("CO");
		request.setCounterpartyName("CP");
		request.setDealStatus("V");
		request.setDealPrice(BigDecimal.valueOf(1.45));
		request.setDealPriceCurrency("CAD");
		request.setDealPriceUnitOfMeasure("GJ");
		request.setStartDate(LocalDate.of(2023,  1, 1));
		request.setEndDate(LocalDate.of(2023,  1, 31));
		request.setReportingCurrency("USD");
		request.setTicketNoPrefix("ticket2");
		request.setVolumeQuantity(BigDecimal.valueOf(100));
		String jsonString =  objectMapper.writeValueAsString(request);

		ResultActions result = mvc.perform(
				post("/api/deals/physical")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonString));

		MvcResult mvcResult = result.andReturn();

		String jsonStringResponse = mvcResult.getResponse().getContentAsString();

		logger.error(jsonStringResponse);

		ObjectMapper mapper = new ObjectMapper();

		TransactionResult transactionResult = mapper.readValue(jsonStringResponse, TransactionResult.class);
		assertEquals(true, transactionResult.isSuccessful());

	}


	@Test
	public void generatePositionsWithPost() throws Exception {

		MockMvc mvc = MockMvcBuilders.standaloneSetup(testHarnessRestController)
				.build();
		GeneratePositionsRequest request = new GeneratePositionsRequest();
		request.setQuery("WHERE ");
		request.setCurrencyCode("CAD");
		request.setStartDate(LocalDate.of(2023,  1, 1));
		request.setEndDate(LocalDate.of(2023,  1, 31));
		request.setObservedDateTime(LocalDateTime.now());

		String jsonString = objectMapper.writeValueAsString(request);

		ResultActions result = mvc.perform(
				post("/api/positions/generated")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonString));

		MvcResult mvcResult = result.andReturn();

		String jsonStringResponse = mvcResult.getResponse().getContentAsString();

		logger.error(jsonStringResponse);

		ObjectMapper mapper = new ObjectMapper();

		TransactionResult transactionResult = mapper.readValue(jsonStringResponse, TransactionResult.class);
		assertEquals(true, transactionResult.isSuccessful());

	}


	@Test
	public void valuePositionsWithPost() throws Exception {

		MockMvc mvc = MockMvcBuilders.standaloneSetup(testHarnessRestController)
				.build();

		ResultActions result = mvc.perform(
				post("/api/positions/valued?query=WHERE name eq 'HJ'")
						.contentType(MediaType.APPLICATION_JSON));

		MvcResult mvcResult = result.andReturn();

		String jsonStringResponse = mvcResult.getResponse().getContentAsString();

		logger.error(jsonStringResponse);

		ObjectMapper mapper = new ObjectMapper();

		TransactionResult transactionResult = mapper.readValue(jsonStringResponse, TransactionResult.class);
		assertEquals(true, transactionResult.isSuccessful());

	}


	@Test
	public void valuePriceRiskFactorssWithPost() throws Exception {

		MockMvc mvc = MockMvcBuilders.standaloneSetup(testHarnessRestController)
				.build();

		ResultActions result = mvc.perform(
				post("/api/priceIndices/riskFactors/valued?query=WHERE name eq 'HJ'")
						.contentType(MediaType.APPLICATION_JSON));

		MvcResult mvcResult = result.andReturn();

		String jsonStringResponse = mvcResult.getResponse().getContentAsString();

		logger.error(jsonStringResponse);

		ObjectMapper mapper = new ObjectMapper();

		TransactionResult transactionResult = mapper.readValue(jsonStringResponse, TransactionResult.class);
		assertEquals(true, transactionResult.isSuccessful());

	}

}
