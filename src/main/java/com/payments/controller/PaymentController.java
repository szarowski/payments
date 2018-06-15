package com.payments.controller;

import com.payments.model.DataJson;
import com.payments.model.PaymentsJson;
import com.payments.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * Payments Controller to handle CRUD operations and fetching the data from an external source.
 * Javadoc is missing here intentionally as all important information is published by Swagger2.
 */
@Api(tags = "Payments", protocols = "http")
@RestController
@RequestMapping("/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(final PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @ApiOperation(value = "Fetch payments")
    @ApiResponses({ @ApiResponse(code = 200, message = "Successfully fetched external payments", response = PaymentsJson.class),
            @ApiResponse(code = 404, message = "Payment data with provided ID not found") })
    @GetMapping(path = "/fetch/{dataId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PaymentsJson> fetchPayments(@ApiParam(name = "dataId", required = true, value = "ID of the payment")
                                                      @PathVariable("dataId") final UUID dataId) {
        try {
            return new ResponseEntity<>(paymentService.fetchMockbinData(dataId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Create payment")
    @ApiResponses({ @ApiResponse(code = 201, message = "Successfully created new payment", response = DataJson.class),
            @ApiResponse(code = 409, message = "Error creating new payment, payment ID exists") })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DataJson> createPayment(@ApiParam(name = "Payment", value = "The payment data")
                                                  @Valid @RequestBody final DataJson data) {
        final DataJson dataCreated = paymentService.createPayment(data);
        if (dataCreated == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(dataCreated, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get payment")
    @ApiResponses({ @ApiResponse(code = 200, message = "Successfully retrieved payment", response = DataJson.class),
            @ApiResponse(code = 404, message = "Payment data with provided ID not found") })
    @GetMapping(path = "/{dataId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<DataJson> getPayment(@ApiParam(name = "dataId", required = true, value = "ID of the payment data")
                                               @PathVariable("dataId") final UUID dataId) {
        final DataJson dataCreated = paymentService.getPayment(dataId);
        if (dataCreated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dataCreated, HttpStatus.OK);
    }

    @ApiOperation(value = "Update payment")
    @ApiResponses({ @ApiResponse(code = 200, message = "Successfully updated payment data"),
            @ApiResponse(code = 404, message = "Payment data with provided ID not found") })
    @PutMapping(path = "/{dataId}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> updatePayment(@ApiParam(name = "dataId", required = true, value = "ID of the payment data")
                                              @PathVariable("dataId") final UUID dataId,
                                              @ApiParam(name = "Payment", value = "The payment data")
                                              @Valid @RequestBody final DataJson data) {
        final boolean dataUpdated = paymentService.updatePayment(dataId, data);
        if (!dataUpdated) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete payment")
    @ApiResponses({ @ApiResponse(code = 204, message = "Successfully deleted payment data"),
            @ApiResponse(code = 404, message = "Payment data with provided ID not found") })
    @DeleteMapping(path = "/{dataId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletePayment(@ApiParam(name = "dataId", required = true, value = "ID of the payment data")
                                              @PathVariable("dataId") final UUID dataId) {
        final boolean dataDeleted = paymentService.deletePayment(dataId);
        if (!dataDeleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Get all payments data")
    @ApiResponses(@ApiResponse(code = 200, message = "Successfully retrieved payment data"))
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<DataJson> listPayments() {
        return paymentService.listPayments();
    }
}