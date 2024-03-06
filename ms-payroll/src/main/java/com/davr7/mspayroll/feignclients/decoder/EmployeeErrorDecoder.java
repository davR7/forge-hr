package com.davr7.mspayroll.feignclients.decoder;

import com.davr7.mspayroll.feignclients.exceptions.ExceptionMessage;
import com.davr7.mspayroll.feignclients.exceptions.EmployeeNotFoundException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.charset.Charset;

@Slf4j
public class EmployeeErrorDecoder implements ErrorDecoder {
    private static final Logger LOG =  LoggerFactory.getLogger(EmployeeErrorDecoder.class);
    private final ErrorDecoder defaultDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        Response.Body responseBody = response.body();
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());
        Exception defaultException = defaultDecoder.decode(methodKey, response);

        try {
            String jsonStr = IOUtils.toString(responseBody.asReader(Charset.defaultCharset()));
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            ExceptionMessage message = mapper.readValue(jsonStr, ExceptionMessage.class);

            log.error(
                    "Got {} response from {}, error message: {}",
                    response.status(),
                    methodKey,
                    message.getMessage()
            );
        }
        catch (IOException e){
            log.error(
                    "Got {} response from {}, response body could not be read",
                    response.status(),
                    methodKey
            );
        }

        if (response.status() == 404) {
            return new EmployeeNotFoundException("Employee not found", defaultException);
        }

        if (responseStatus.is5xxServerError()) {
            return new RetryableException(
                    responseStatus.value(),
                    "Server error",
                    response.request().httpMethod(),
                    0L,
                    response.request()
            );
        }

        return defaultException;
    }
}

