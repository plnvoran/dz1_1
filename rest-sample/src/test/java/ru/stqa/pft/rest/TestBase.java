package ru.stqa.pft.rest;

import com.google.gson.*;

import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;


/**
 * Created by Denis on 08.05.2017.
 */
public class TestBase {


    protected static final ApplicationManager app
            = new ApplicationManager();


    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    public  boolean isIssueOpen(int issueId) throws IOException {
        Set<Issue> oldIssues = getIssueState(issueId);

        System.out.println("Bug #"+issueId+" is "+oldIssues.iterator().next().getState_name());

        if (oldIssues.iterator().next().getState_name().equals("Resolved"))
            return false;
        else
            return true;
    }

    private Set<Issue> getIssueState(int issueId) throws IOException {

        String json= getExecutor().execute (Request.Get("http://demo.bugify.com/api/issues/"+issueId+".json"))
                .returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
    }




    private Executor getExecutor() {
        return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==", "");
    }




}

