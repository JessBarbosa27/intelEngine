package com.jesslabs.intelEngine.openaiGpt_v3_5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GPT3_5ChatResponse {
    private List<Choice> choices;

}
