curl --location --request POST 'https://open.bigmodel.cn/api/paas/v4/chat/completions' \
--header 'Authorization: Bearer 777ac5c6570b419a8e8af9333912445a.buWLc7hT8ywhk8Qd' \
--header 'Content-Type: application/json' \
--header 'User-Agent: Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)' \
--header 'Cookie: acw_tc=0a472f8217419571975374257e0043d5dd8938ba222ebda0c03bc81d16d683' \
--data-raw '{
    "model": "glm-4",
    "messages": [
        {
            "role": "user",
            "content": "你好"
        }
    ]
}'