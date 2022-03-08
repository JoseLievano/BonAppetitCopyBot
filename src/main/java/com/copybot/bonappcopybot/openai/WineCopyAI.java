package com.copybot.bonappcopybot.openai;
import com.copybot.bonappcopybot.model.entity.drinks.wine.Wine;
import com.copybot.bonappcopybot.model.entity.drinks.wine.WineCopy;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

public class WineCopyAI {

    static WineCopyAI obj = new WineCopyAI();

    private WineCopyAI(){}

    public static WineCopyAI getInstance(){
        return obj;
    }

    public String getWineCopy(Wine wine, WineCopy copy){
        String APIKey = "APIKEY";
        OpenAiService service = new OpenAiService(APIKey);

        String prompt = createPrompt(wine, copy);

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


    private String createPrompt(Wine wine, WineCopy copy){
        String prompt = "Write an engaging and joyfull text add for " + copy.getOccasion() + ", with 30 words for the following product: ";
        prompt += " Type: Wine,";
        prompt += " Name : " + wine.getName() + ", ";
        prompt += " Product: " + wine.getProduct() + ", ";
        prompt += " Brand: " + wine.getBrand() + ", ";
        prompt += " Date: " + wine.getDate() + ", ";
        prompt += " Color: " + wine.getColor() + ", ";
        prompt += " Ingredients: " + wine.getIngredients() + ", ";
        prompt += " Description: " + wine.getDescription() + "->";
        return prompt;
    }


    private String translateCopy(String originalCopy, String lang){

        String APIKey = "APIKEY";
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


