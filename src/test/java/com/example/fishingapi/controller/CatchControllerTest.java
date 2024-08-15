package com.example.fishingapi.controller;

import com.example.fishingapi.dto.CatchResponseDTO;
import com.example.fishingapi.entity.Catch;
import com.example.fishingapi.mapper.EntityMapper;
import com.example.fishingapi.service.CatchService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CatchControllerTest {

    @Mock
    CatchService catchService;// Mocking the service layer

    @Mock
    EntityMapper entityMapper;  // Mocking the mapper layer

    @InjectMocks
    CatchController catchController;  // Injecting the mocked service into the controller

    @Test
    void getAllCatches() {
        // Sample data setup
        Catch catch1 = new Catch(1, "Salmon", 1000, 50, "Uljua");  // Weight in grams
        Catch catch2 = new Catch(2, "Trout", 800, 45, "Oulu");
        List<Catch> expectedCatches = Arrays.asList(catch1, catch2);

        // Mocking service method to return the sample data
        Mockito.when(catchService.getAllCatches()).thenReturn(expectedCatches);

        // Mocking mapper behavior to convert Catch entities to CatchResponseDTOs
        Mockito.when(entityMapper.toCatchResponseDTO(catch1)).thenReturn(new CatchResponseDTO(1, "Salmon", 1000, 50, "Uljua"));
        Mockito.when(entityMapper.toCatchResponseDTO(catch2)).thenReturn(new CatchResponseDTO(2, "Trout", 800, 45, "Oulu"));

        // Invoking the controller method
        ResponseEntity<List<CatchResponseDTO>> responseEntity = catchController.getAllCatches();

        // Asserting response status and body content
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());  // Ensure status is 200 OK
        assertEquals(expectedCatches.size(), Objects.requireNonNull(responseEntity.getBody()).size());  // Verify list size

        // Validating specific content in the response body
        List<CatchResponseDTO> actualCatches = responseEntity.getBody();
        assertEquals("Salmon", actualCatches.get(0).getFish());
        assertEquals(1000, actualCatches.get(0).getWeight());
        assertEquals("Trout", actualCatches.get(1).getFish());
    }
}
