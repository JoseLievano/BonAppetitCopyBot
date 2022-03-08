package com.copybot.bonappcopybot.openai;

import com.copybot.bonappcopybot.model.entity.topic.Topic;
import com.copybot.bonappcopybot.model.entity.topic.TopicCopy;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

public class TopicCopyAI {

    static TopicCopyAI obj = new TopicCopyAI();

    private TopicCopyAI(){}

    public static TopicCopyAI getInstance(){return obj;}

    public String getCopy(Topic topic, TopicCopy copy){
        String APIKey = "APIKEY";
        OpenAiService service = new OpenAiService(APIKey);

        String prompt = createPrompt(topic, copy);

        System.out.println(prompt);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .temperature(0.9)
                .maxTokens(150)
                .topP(1.0)
                .frequencyPenalty(1.0)
                .presencePenalty(0.3)
                .echo(false)
                .build();


        String copyResult = service.createCompletion("text-davinci-001", completionRequest).getChoices().get(0).getText();
        System.out.println(copyResult);
        copyResult = copyResult.replaceFirst("\\n\\n", "");

        String lang = copy.getLang();

        if (lang.equals("English") || lang.equals("english") || lang.equals("en") || lang.equals("EN")){
            return copyResult;
        }else {
            String translated = translateCopy(copyResult, lang);
            return translated;
        }

    }

    private String createPrompt(Topic topic, TopicCopy copy){
        String prompt = "Write an engaging add for " + topic.getTopic() + " food for the occassion of " + copy.getOccasion() + " in "+ copy.getLang() +"->";
        return prompt;
    }

    private String translateCopy(String originalCopy, String lang){

        String APIKey = "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";
        OpenAiService service = new OpenAiService(APIKey);

        String prompt = "Translate the following text to " + lang + ": " + originalCopy;

        System.out.println(prompt);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .temperature(0.9)
                .maxTokens(150)
                .topP(1.0)
                .frequencyPenalty(1.0)
                .presencePenalty(0.3)
                .echo(false)
                .build();
        String copyResult = service.createCompletion("text-davinci-001", completionRequest).getChoices().get(0).getText();
        copyResult = copyResult.replaceFirst("\\n\\n", "");

        return copyResult;
    }


}
