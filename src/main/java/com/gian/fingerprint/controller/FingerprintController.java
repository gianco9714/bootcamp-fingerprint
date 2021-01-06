package com.gian.fingerprint.controller;

import com.gian.fingerprint.model.request.FingerprintRequest;
import com.gian.fingerprint.model.response.FingerprintResponse;
import com.gian.fingerprint.service.IFingerprintService;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@Validated
@RestController
@RequestMapping("/core")
@Api(value = "FingerprintController", produces = "application/json", tags = { "Fingerprint Controller" })
public class FingerprintController {

    @Autowired
    private IFingerprintService fingerprintService;

    @ApiOperation(value = "Validar Fingerprint", tags = { "Fingerprint Controller" })
    @PostMapping(value = "/fingerprints/validate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta Éxitosa", response = FingerprintResponse.class),
            @ApiResponse(code= 500, message = "500 Error Internal.")})
    public Single<FingerprintResponse> validateFingerPrint(@RequestBody FingerprintRequest fingerprintRequest){

        log.info("Controller: Post FingerPrints with Document Number: " + fingerprintRequest.getDocument());
        return fingerprintService.validateFingerPrint(fingerprintRequest);
    }

}
