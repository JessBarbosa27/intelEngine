package com.jesslabs.intelEngine.openaiGpt_v3_5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GPT3_5ChatRequest {
    private String model;
    private List<Message> messages;
    private int n;
    private double temperature;


    public GPT3_5ChatRequest(String model, String prompt) {
        this.model = model;

        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt));
    }
}
