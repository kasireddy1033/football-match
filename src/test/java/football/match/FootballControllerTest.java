package football.match;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@SpringBootTest
public class FootballControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void getFootballDetails() throws Exception {
		assertEquals(mockMvc.perform(MockMvcRequestBuilders.get("/getTeamDetails/A/B/C").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn().getResponse().getContentAsString(), "[]");
	}
	
	@Test
	public void getFootballDetails2() throws Exception {
		assertEquals(mockMvc.perform(MockMvcRequestBuilders.get("/getTeamDetails/England/Premier League/Liverpool").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn().getResponse().getContentAsString(), "[{\"Country ID & Name:\":\"(England) - England\",\"League ID & Name:\":\"(148) - Premier League\",\"Team ID & Name:\":\"(2621) - Liverpool\",\"Overall League Position:\":\"\"}]");
	}

}
