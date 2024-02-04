/*
 Copyright 2019, OnBelay Consulting Ltd.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.  
 */
package com.onbelay.dealcapturetest.testharness.controller;

import com.onbelay.core.controller.BaseRestController;
import com.onbelay.core.entity.snapshot.TransactionResult;
import com.onbelay.core.exception.OBRuntimeException;
import com.onbelay.dealcapturetest.restclient.exception.ApplicationWebClientException;
import com.onbelay.dealcapturetest.testharness.adapter.TestHarnessRestAdapter;
import com.onbelay.dealcapturetest.testharness.snapshot.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Tag(name="testHarness", description="DealCapture TestHarness API")
@RequestMapping("/api")
public class TestHarnessRestController extends BaseRestController {
	private static Logger logger = LogManager.getLogger();
	private static final Marker userMarker = MarkerManager.getMarker("USER");
	
	@Autowired
	private TestHarnessRestAdapter testHarnessRestAdapter;
	
	
	@Operation(summary="Generate test deals")
	@PostMapping(
			value = "/deals/physical",
			produces="application/json",
			consumes="application/json"  )
	public ResponseEntity<TransactionResult> generatePhysicalDeals(
			@RequestHeader Map<String, String> headers,
			@RequestBody GeneratePhysicalDealsRequest request,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach( e -> {
				logger.error(userMarker, "Error on ", e.toString()); 
			});
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		TransactionResult result;
		try {
			  result = testHarnessRestAdapter.generatePhysicalDeals(request);
		} catch (OBRuntimeException r) {
			logger.error(userMarker,"Generate Physical Deals failed ", r.getErrorCode(), r);
			result = new TransactionResult(r.getErrorCode(), r.getParms());
			result.setErrorMessage(errorMessageService.getErrorMessage(r.getErrorCode()));
		} catch (RuntimeException e) {
			result = new TransactionResult(e.getMessage());
		}

		return processResponse(result);
	}


	@Operation(summary="Generate test deals")
	@PostMapping(
			value = "/organizations",
			produces="application/json",
			consumes="application/json"  )
	public ResponseEntity<TransactionResult> generateOrganizations(
			@RequestHeader Map<String, String> headers,
			@RequestBody GenerateOrganizationsRequest request,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach( e -> {
				logger.error(userMarker, "Error on ", e.toString());
			});
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		TransactionResult result;
		try {
			result = testHarnessRestAdapter.generateOrganizationsRequest(request);
		} catch (OBRuntimeException r) {
			logger.error(userMarker,"Generate Organizations failed ", r.getErrorCode(), r);
			result = new TransactionResult(r.getErrorCode(), r.getParms());
			result.setErrorMessage(errorMessageService.getErrorMessage(r.getErrorCode()));
		} catch (RuntimeException e) {
			result = new TransactionResult(e.getMessage());
		}

		return processResponse(result);
	}

	@Operation(summary="Generate test companies")
	@PostMapping(
			value = "/companies",
			produces="application/json",
			consumes="application/json"  )
	public ResponseEntity<TransactionResult> generateCompanies(
			@RequestHeader Map<String, String> headers,
			@RequestBody GenerateCompaniesRequest request,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach( e -> {
				logger.error(userMarker, "Error on ", e.toString());
			});
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		TransactionResult result;
		try {
			result = testHarnessRestAdapter.generateCompaniesRequest(request);
		} catch (OBRuntimeException r) {
			logger.error(userMarker,"Generate Companies failed ", r.getErrorCode(), r);
			result = new TransactionResult(r.getErrorCode(), r.getParms());
			result.setErrorMessage(errorMessageService.getErrorMessage(r.getErrorCode()));
		} catch (ApplicationWebClientException e) {
			result = new TransactionResult("Connection failed: " + e.getHttpStatus().toString());
		} catch (RuntimeException e) {
			result = new TransactionResult("Unknown error");
		}

		return processResponse(result);
	}


	@Operation(summary="Generate test counterparties")
	@PostMapping(
			value = "/counterparties",
			produces="application/json",
			consumes="application/json"  )
	public ResponseEntity<TransactionResult> generateCounterparties(
			@RequestHeader Map<String, String> headers,
			@RequestBody GenerateCounterpartiesRequest request,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach( e -> {
				logger.error(userMarker, "Error on ", e.toString());
			});
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		TransactionResult result;
		try {
			result = testHarnessRestAdapter.generateCounterpartiesRequest(request);
		} catch (OBRuntimeException r) {
			logger.error(userMarker,"Generate Counterparties failed ", r.getErrorCode(), r);
			result = new TransactionResult(r.getErrorCode(), r.getParms());
			result.setErrorMessage(errorMessageService.getErrorMessage(r.getErrorCode()));
		} catch (RuntimeException e) {
			result = new TransactionResult(e.getMessage());
		}

		return processResponse(result);
	}


	@Operation(summary="generate test prices")
	@PostMapping(
			value = "/prices",
			produces="application/json",
			consumes="application/json"  )
	public ResponseEntity<TransactionResult> generatePrices(
			@RequestHeader Map<String, String> headers,
			@RequestBody GenerateCurvesRequest request,
			BindingResult bindingResult) {


		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach( e -> {
				logger.error(userMarker, "Error on ", e.toString());
			});
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		TransactionResult result;
		try {
			result = testHarnessRestAdapter.generatePrices(request);
		} catch (OBRuntimeException r) {
			logger.error(userMarker,"Generate prices failed ", r.getErrorCode(), r);
			result = new TransactionResult(r.getErrorCode(), r.getParms());
			result.setErrorMessage(errorMessageService.getErrorMessage(r.getErrorCode()));
		} catch (RuntimeException e) {
			result = new TransactionResult(e.getMessage());
		}

		return processResponse(result);
	}


	@Operation(summary="generate test Fx Rates")
	@PostMapping(
			value = "/rates",
			produces="application/json",
			consumes="application/json"  )
	public ResponseEntity<TransactionResult> generateFxRates(
			@RequestHeader Map<String, String> headers,
			@RequestBody GenerateCurvesRequest request,
			BindingResult bindingResult) {


		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach( e -> {
				logger.error(userMarker, "Error on ", e.toString());
			});
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		TransactionResult result;
		try {
			result = testHarnessRestAdapter.generateFxRates(request);
		} catch (OBRuntimeException r) {
			logger.error(userMarker,"Generate prices failed ", r.getErrorCode(), r);
			result = new TransactionResult(r.getErrorCode(), r.getParms());
			result.setErrorMessage(errorMessageService.getErrorMessage(r.getErrorCode()));
		} catch (RuntimeException e) {
			result = new TransactionResult(e.getMessage());
		}

		return processResponse(result);
	}


	@Operation(summary="generate test price indices")
	@PostMapping(
			value = "/priceIndices",
			produces="application/json",
			consumes="application/json"  )
	public ResponseEntity<TransactionResult> generatePriceIndices(
			@RequestHeader Map<String, String> headers,
			@RequestBody GeneratePriceIndicesRequest request,
			BindingResult bindingResult) {


		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach( e -> {
				logger.error(userMarker, "Error on ", e.toString());
			});
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		TransactionResult result;
		try {
			result = testHarnessRestAdapter.generatePriceIndices(request);
		} catch (OBRuntimeException r) {
			logger.error(userMarker,"Generate Price Indices failed ", r.getErrorCode(), r);
			result = new TransactionResult(r.getErrorCode(), r.getParms());
			result.setErrorMessage(errorMessageService.getErrorMessage(r.getErrorCode()));
		} catch (RuntimeException e) {
			result = new TransactionResult(e.getMessage());
		}

		return processResponse(result);
	}


	@Operation(summary="generate test fx indices")
	@PostMapping(
			value = "/fxIndices",
			produces="application/json",
			consumes="application/json"  )
	public ResponseEntity<TransactionResult> generateFxIndices(
			@RequestHeader Map<String, String> headers,
			@RequestBody GenerateFxIndicesRequest request,
			BindingResult bindingResult) {


		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach( e -> {
				logger.error(userMarker, "Error on ", e.toString());
			});
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		TransactionResult result;
		try {
			result = testHarnessRestAdapter.generateFxIndices(request);
		} catch (OBRuntimeException r) {
			logger.error(userMarker,"Generate Fx Indices failed ", r.getErrorCode(), r);
			result = new TransactionResult(r.getErrorCode(), r.getParms());
			result.setErrorMessage(errorMessageService.getErrorMessage(r.getErrorCode()));
		} catch (RuntimeException e) {
			result = new TransactionResult(e.getMessage());
		}

		return processResponse(result);
	}



	@Operation(summary="generate test pricing locations")
	@PostMapping(
			value = "/pricingLocations",
			produces="application/json",
			consumes="application/json"  )
	public ResponseEntity<TransactionResult> generatePricingLocations(
			@RequestHeader Map<String, String> headers,
			@RequestBody GeneratePricingLocationsRequest request,
			BindingResult bindingResult) {


		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach( e -> {
				logger.error(userMarker, "Error on ", e.toString());
			});
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		TransactionResult result;
		try {
			result = testHarnessRestAdapter.generatePricingLocations(request);
		} catch (OBRuntimeException r) {
			logger.error(userMarker,"Generate Locations failed ", r.getErrorCode(), r);
			result = new TransactionResult(r.getErrorCode(), r.getParms());
			result.setErrorMessage(errorMessageService.getErrorMessage(r.getErrorCode()));
		} catch (RuntimeException e) {
			result = new TransactionResult(e.getMessage());
		}

		return processResponse(result);
	}


	@Operation(summary="generate positions")
	@PostMapping(
			value = "/positions/generated",
			produces="application/json",
			consumes="application/json"  )
	public ResponseEntity<TransactionResult> generatePositions(
			@RequestHeader Map<String, String> headers,
			@RequestBody GeneratePositionsRequest request,
			BindingResult bindingResult) {


		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach( e -> {
				logger.error(userMarker, "Error on ", e.toString());
			});
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		TransactionResult result;
		try {
			result = testHarnessRestAdapter.generatePositions(request);
		} catch (OBRuntimeException r) {
			logger.error(userMarker,"Generate positions failed ", r.getErrorCode(), r);
			result = new TransactionResult(r.getErrorCode(), r.getParms());
			result.setErrorMessage(errorMessageService.getErrorMessage(r.getErrorCode()));
		} catch (RuntimeException e) {
			result = new TransactionResult(e.getMessage());
		}

		return processResponse(result);
	}


	@Operation(summary="Value Fx Risk Factors")
	@PostMapping(
			value = "/fxIndices/riskFactors/valued",
			produces="application/json",
			consumes="application/json"  )
	public ResponseEntity<TransactionResult> valueFxRiskFactors(
			@RequestHeader Map<String, String> headers,
			@RequestParam(value = "query", defaultValue="default") String queryText) {

		TransactionResult result;
		try {
			result = testHarnessRestAdapter.valueFxRiskFactors(queryText);
		} catch (OBRuntimeException r) {
			logger.error(userMarker,"Value Fx risk factors failed ", r.getErrorCode(), r);
			result = new TransactionResult(r.getErrorCode(), r.getParms());
			result.setErrorMessage(errorMessageService.getErrorMessage(r.getErrorCode()));
		} catch (RuntimeException e) {
			result = new TransactionResult(e.getMessage());
		}

		return processResponse(result);
	}

	@Operation(summary="Value Price Risk Factors")
	@PostMapping(
			value = "/priceIndices/riskFactors/valued",
			produces="application/json",
			consumes="application/json"  )
	public ResponseEntity<TransactionResult> valuePriceRiskFactors(
			@RequestHeader Map<String, String> headers,
			@RequestParam(value = "query", defaultValue="default") String queryText) {

		TransactionResult result;
		try {
			result = testHarnessRestAdapter.valuePriceRiskFactors(queryText);
		} catch (OBRuntimeException r) {
			logger.error(userMarker,"Value Price risk factors failed ", r.getErrorCode(), r);
			result = new TransactionResult(r.getErrorCode(), r.getParms());
			result.setErrorMessage(errorMessageService.getErrorMessage(r.getErrorCode()));
		} catch (RuntimeException e) {
			result = new TransactionResult(e.getMessage());
		}

		return processResponse(result);
	}


	@Operation(summary="value positions")
	@PostMapping(
			value = "/positions/valued",
			produces="application/json",
			consumes="application/json"  )
	public ResponseEntity<TransactionResult> valuePositions(
			@RequestHeader Map<String, String> headers,
			@RequestParam(value = "query", defaultValue="default") String queryText) {

		TransactionResult result;
		try {
			result = testHarnessRestAdapter.valuePositions(queryText);
		} catch (OBRuntimeException r) {
			logger.error(userMarker,"Value positions failed ", r.getErrorCode(), r);
			result = new TransactionResult(r.getErrorCode(), r.getParms());
			result.setErrorMessage(errorMessageService.getErrorMessage(r.getErrorCode()));
		} catch (RuntimeException e) {
			result = new TransactionResult(e.getMessage());
		}

		return processResponse(result);
	}

}
