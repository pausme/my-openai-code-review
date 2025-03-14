package com.huang.middleware.sdk;

import com.huang.middleware.sdk.domain.service.impl.ChatGLMCodeReviewService;
import com.huang.middleware.sdk.infrastructure.git.GitCommand;
import com.huang.middleware.sdk.infrastructure.openai.IOpenAI;
import com.huang.middleware.sdk.infrastructure.openai.impl.ChatGLM;
import com.huang.middleware.sdk.infrastructure.weixin.WeiXin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Description: openai代码评审执行类
 * @Version: 1.0
 * @Author: huang
 * @Date: 2025/3/13
 */
public class OpenAiCodeReview {
    private static final Logger logger = LoggerFactory.getLogger(OpenAiCodeReview.class);

    // 配置配置
    private String weixin_appid = "wxfbe61d4b8e5acb08";
    private String weixin_secret = "3dd7bacfb036a18c714eb483a48cbbef";
    private String weixin_touser = "ole_r6MiK3pHCz0-t9sSL_qrI1g4";
    private String weixin_template_id = "FX1Rag0580i2BOWie9n_QQ5Gae01l1gX7gJ6FJPGXFE";

    // ChatGLM 配置
    private String chatglm_apiHost = "https://open.bigmodel.cn/api/paas/v4/chat/completions";
    private String chatglm_apiKeySecret = "";

    // Github 配置
    private String github_review_log_uri;
    private String github_token;

    // 工程配置 - 自动获取
    private String github_project;
    private String github_branch;
    private String github_author;

    public static void main(String[] args) throws Exception {
        GitCommand gitCommand = new GitCommand(
                getEnv("CODE_REVIEW_LOG_URI"),
                getEnv("CODE_TOKEN"),
                getEnv("COMMIT_PROJECT"),
                getEnv("COMMIT_BRANCH"),
                getEnv("COMMIT_AUTHOR"),
                getEnv("COMMIT_MESSAGE")
        );

        /**
         * 项目：{{repo_name.DATA}} 分支：{{branch_name.DATA}} 作者：{{commit_author.DATA}} 说明：{{commit_message.DATA}}
         */
        WeiXin weiXin = new WeiXin(
                getEnv("WEIXIN_APPID"),
                getEnv("WEIXIN_SECRET"),
                getEnv("WEIXIN_TOUSER"),
                getEnv("WEIXIN_TEMPLATE_ID")
        );



        IOpenAI openAI = new ChatGLM(getEnv("CHATGLM_APIHOST"), getEnv("CHATGLM_APIKEYSECRET"));

        ChatGLMCodeReviewService openAiCodeReviewService = new ChatGLMCodeReviewService(gitCommand, openAI, weiXin);
        openAiCodeReviewService.exec();

        logger.info("openai-code-review done!");
    }

    private static String getEnv(String key) {
        String value = System.getenv(key);
        if (null == value || value.isEmpty()) {
            throw new RuntimeException("value is null");
        }
        return value;
    }
}
