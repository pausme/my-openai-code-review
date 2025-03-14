package com.huang.middleware.sdk;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * @Description: openai代码评审执行类
 * @Version: 1.0
 * @Author: huang
 * @Date: 2025/3/13
 */
public class OpenAiCodeReview {
    public static void main(String[] args) throws Exception {
        System.out.println("测试执行");

        // 1. 代码检出
        ProcessBuilder processBuilder = new ProcessBuilder("git", "diff", "HEAD~1", "HEAD");
        processBuilder.directory(new File("."));

        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;

        StringBuilder diffCode = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            diffCode.append(line);
        }

        int exitCode = process.waitFor();
        System.out.println("Exited with code:" + exitCode);

        System.out.println("评审代码：" + diffCode.toString());
    }
}
