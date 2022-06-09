package ch.nag.tamenkessho.server;

import ch.nag.tamenkessho.data.NagWorker;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

@RestController
@CrossOrigin
public class SeparateRestController {

    private static final String key0 = "FECOI()*&<MNCXZPKL";
    private static final Charset charset = Charset.forName("UTF-8");
    private static byte[] keyBytes = key0.getBytes(charset);

    @PostMapping("/authorize")
    public String loginRequest(
            @RequestBody()
            String requestBody) {
        System.out.println(requestBody);
        String result;
        if(requestBody.contains("artur.semenenko@nag.ch")&&requestBody.contains("o2m4utv=9")){
            result = "ojwgi10yt349cm1=0ry9n249vnb94wu04w[nb";
        } else {result = "wrongo";}
        System.out.println(result);
        String jsonResult = "{\"token\": \""+result+"\"}";

        System.out.println(jsonResult);
        return jsonResult;
    }

    @PostMapping("/dishes")
    public String dishesRequest(
            @RequestBody()
            String requestBody) {
        String result = "null :))";

        if(requestBody.contains("artur.semenenko@nag.ch")&&requestBody.contains("o2m4utv=9")){
            result = "{\"code\":\"Success\"}";
            System.out.println(result);
        } else {
            result = "{\"code\":\"Failure\"}";
            System.out.println(result);
        }
        return result;
    }

    @GetMapping("/nag/data")
    public String workersRequest(
            @RequestParam("token")
            String token){
        String resultingString;
        System.out.println(token);
        if(token.equalsIgnoreCase("armane")){
            resultingString = NagWorker.getGson( new NagWorker[]{
                    new NagWorker("Alex", "Softwareentwicklung", 24),
                    new NagWorker("Christophe", "Softwareentwicklung", 35),
                    new NagWorker("Artur", "Software Engineering Intern", 17),
                    new NagWorker("Sandrine", "Softwareentwicklung", 25),
                    new NagWorker("Christoph", "Softwareentwicklung", 27),
                    new NagWorker("Martin", "Client Team", 44)});
            System.out.println(resultingString);
        }else{
            resultingString = NagWorker.getGson( new NagWorker[]{
                    new NagWorker("Wrongo", "I wont give you data)", 401)});
        System.out.println(resultingString);
        }
        return resultingString;
    }
}
