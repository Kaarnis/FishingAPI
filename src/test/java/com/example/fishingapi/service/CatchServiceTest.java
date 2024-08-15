package com.example.fishingapi.service;

import com.example.fishingapi.entity.Catch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CatchServiceTest {

    @Mock
    CatchService catchService;  // Mocking the CatchService for testing

    @Test
    void getAllCatches() {
        // Setting up sample data
        Catch catch1 = new Catch(1, "Salmon", 10, 5, "Uljua");
        Catch catch2 = new Catch(2, "Trout", 8, 4, "Oulu");
        List<Catch> expectedCatches = Arrays.asList(catch1, catch2);

        // Mocking service method to return the sample data
        Mockito.when(catchService.getAllCatches()).thenReturn(expectedCatches);

        // Executing the service method
        List<Catch> actualCatches = catchService.getAllCatches();

        // Verifying the results
        assertEquals(expectedCatches, actualCatches);  // Asserts that the returned list matches the expected list
    }
}
