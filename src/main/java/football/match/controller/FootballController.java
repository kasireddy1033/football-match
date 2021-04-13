package football.match.controller;

import java.io.IOException;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/getTeamDetails")
public class FootballController {
	
	 @Autowired
	 private RestTemplate restTemplate;
	 
	 ResponseEntity<ArrayNode> response;
	 
	 @RequestMapping(path="/{countryName}/{leagueName}/{teamName}",method= RequestMethod.GET)
	 public ArrayNode getStanding(@PathVariable("countryName")  String countryName, @PathVariable("leagueName") String leagueName, @PathVariable("teamName") String teamName) throws IOException {
//		 	if(response==null)
		    ResponseEntity<ArrayNode> response= restTemplate.getForEntity("https://apiv2.apifootball.com/?action=get_standings&league_id=148&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978",ArrayNode.class);
	        ObjectMapper mapper = new ObjectMapper();
	        ArrayNode payload = response.getBody();
	        Iterator<JsonNode> payloadIterator = payload.elements();
	        ArrayNode result = mapper.createArrayNode();
	        while(payloadIterator.hasNext()) {
	        	JsonNode node = payloadIterator.next();
	        	if(node.get("country_name").asText().equals(countryName) && node.get("league_name").asText().equals(leagueName) && node.get("team_name").asText().equals(teamName)) {
	        		ObjectNode n = mapper.createObjectNode();
	        		n.put("Country ID & Name:", "(" + node.get("country_name").asText() + ") - " + node.get("country_name").asText());
	        		n.put("League ID & Name:", "(" + node.get("league_id").asText() + ") - " + node.get("league_name").asText());
	        		n.put("Team ID & Name:", "(" + node.get("team_id").asText() + ") - " + node.get("team_name").asText());
	        		n.put("Overall League Position:", "");
	        		result.add(n);
	        	}
	        }
	        return result;
	    }

}
