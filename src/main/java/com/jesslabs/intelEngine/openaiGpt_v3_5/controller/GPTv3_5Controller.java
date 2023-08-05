package com.jesslabs.intelEngine.openaiGpt_v3_5.controller;

import com.jesslabs.intelEngine.openaiGpt_v3_5.dto.GPT3_5ChatRequest;
import com.jesslabs.intelEngine.openaiGpt_v3_5.dto.GPT3_5ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GPTv3_5Controller {
    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @GetMapping("/chat")
    public String chat(@RequestParam String prompt) {
        // create a request
        GPT3_5ChatRequest request = new GPT3_5ChatRequest(model, prompt);

        // call the API
        GPT3_5ChatResponse response = restTemplate.postForObject(apiUrl, request, GPT3_5ChatResponse.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }

        return response.getChoices().get(0).getMessage().getContent();
    }
}
