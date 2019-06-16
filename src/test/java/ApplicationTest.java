import com.github.tomakehurst.wiremock.junit.WireMockRule;
import model.DownStreamApiResponse;
import org.junit.Rule;
import org.junit.Test;
import service.Service;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089); // No-args constructor defaults to port 8080

    private Service service;

    @Test
    public void shouldBeSuccessfull() {
        // Given
        stubFor(any(anyUrl()).willReturn(okJson("" +
                "{" +
                    "  \"name\": \"Daniel\"," +
                    "  \"age\": 33 " +
                "}")));

        // When
        final DownStreamApiResponse downStreamApiResponse = service.executeService("Joder!");


        // Then
        assertThat(downStreamApiResponse)
                .isEqualTo(new DownStreamApiResponse("Daniel", 33));
    }

}
