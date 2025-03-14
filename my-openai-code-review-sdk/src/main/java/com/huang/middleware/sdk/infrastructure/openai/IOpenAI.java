package com.huang.middleware.sdk.infrastructure.openai;

import com.huang.middleware.sdk.infrastructure.openai.dto.ChatCompletionRequestDTO;
import com.huang.middleware.sdk.infrastructure.openai.dto.ChatCompletionSyncResponseDTO;

public interface IOpenAI {
    ChatCompletionSyncResponseDTO completions(ChatCompletionRequestDTO requestDTO) throws Exception;
}
