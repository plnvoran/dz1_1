package ru.stqa.pft.rest;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;

import org.testng.annotations.Test;

import java.io.IOException;


/**
 * Created by Denis on 08.05.2017.
 */
public class TestBase {

    @Test
    public void setUp() throws Exception {

        System.out.println(getIssueState());

    }

    private Executor getExecutor() {
        return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==", "");
    }

    private String getIssueState() throws IOException {
        String json = getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues/1.json"))
                .returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        return parsed.getAsJsonObject().get("state_name").getAsString();

    }


}

