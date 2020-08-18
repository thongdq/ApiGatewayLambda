package ta.lambda;

import java.io.*;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ta.dao.ProjectDaoImp;
import ta.dao.Projectdao;

/**
 * Handler for requests to Lambda function.
 */
public class ProjectLambda implements RequestStreamHandler {

    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        JSONParser parser = new JSONParser();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        JSONObject responseJson = new JSONObject();

        try {
            JSONObject event = (JSONObject) parser.parse(reader);
            System.out.println(event.toString());
            if(event.get("body") != null) {
                System.out.println("Begin insert project");
                ta.model.Project project = new ta.model.Project((String)event.get("body"));
                Projectdao projectdao = new ProjectDaoImp();
                projectdao.save(project);
            }

            JSONObject responseBody = new JSONObject();
            responseBody.put("message", "project created");

            JSONObject headerJson = new JSONObject();
            headerJson.put("x-custom-header", "my custom header value");

            responseBody.put("statusCode", 200);
            responseBody.put("headers", headerJson);
            responseJson.put("body", responseBody.toString());
        } catch (ParseException pex) {
            responseJson.put("statusCode", 400);
            responseJson.put("exception", pex);
        }

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseJson.toString());
        writer.close();
    }

    public void handleRequestUpdate(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        JSONParser parser = new JSONParser();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        JSONObject responseJson = new JSONObject();

        try {
            JSONObject event = (JSONObject) parser.parse(reader);
            System.out.println(event.toString());
            if(event.get("body") != null) {
                System.out.println("Begin update project");
                ta.model.Project project = new ta.model.Project((String)event.get("body"));
                Projectdao projectdao = new ProjectDaoImp();
                projectdao.update(project);
            }

            JSONObject responseBody = new JSONObject();
            responseBody.put("message", "project updated");

            JSONObject headerJson = new JSONObject();
            headerJson.put("x-custom-header", "my custom header value");

            responseBody.put("statusCode", 200);
            responseBody.put("headers", headerJson);
            responseJson.put("body", responseBody.toString());
        } catch (ParseException pex) {
            responseJson.put("statusCode", 400);
            responseJson.put("exception", pex);
        }

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseJson.toString());
        writer.close();
    }

    public void handleRequestDelete(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        JSONParser parser = new JSONParser();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        JSONObject responseJson = new JSONObject();

        try {
            JSONObject event = (JSONObject) parser.parse(reader);
            System.out.println(event.toString());
            if(event.get("body") != null) {
                System.out.println("Begin delete project");
                ta.model.Project project = new ta.model.Project((String)event.get("body"));
                Projectdao projectdao = new ProjectDaoImp();
                projectdao.delete(project);
            }

            JSONObject responseBody = new JSONObject();
            responseBody.put("message", "project deleted");

            JSONObject headerJson = new JSONObject();
            headerJson.put("x-custom-header", "my custom header value");

            responseBody.put("statusCode", 200);
            responseBody.put("headers", headerJson);
            responseJson.put("body", responseBody.toString());
        } catch (ParseException pex) {
            responseJson.put("statusCode", 400);
            responseJson.put("exception", pex);
        }

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseJson.toString());
        writer.close();
    }
}
