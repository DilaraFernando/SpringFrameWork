package lk.ijse.controller;

import com.sun.net.httpserver.Request;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/request")
@RestController
public class RequestController {
    @PostMapping
    public String post(@RequestHeader("Authorization") String authorization,
                       @RequestHeader("token")String token){
        return "Hello World ! 6" + authorization +":Token :" +token ;

    }
   @PostMapping("querystring")
    public String getQueryStringParameters(@RequestParam ("name")String name,
                                           @RequestParam ("address")String address,
                                           @RequestParam ("id")String id){
        return "Hello World ! 7" + name +":" + address +":"+id;
   }
   @PostMapping("pathvariable/{name}/{address}")
    public String getPathVariable(@PathVariable("name")String name,
                                  @PathVariable("address")String address){
        return "Hello World ! 8" +name +":"+address;
   }
   @PostMapping("body/from")
    public String getRequest(@RequestParam("id")String id,
                             @RequestParam("name")String name){
        return"Hello World ! 9"+ id +":"+name;
   }
   @PostMapping("body/from-url-encoded")
    public String getRequestBodyXWWWFromUrlEncoded(@RequestParam("id")String id,
                                                   @RequestParam("name")String name){
        return "Hello World ! 9"+id+":"+name;
   }
   @PostMapping("body/json")
    public String getRequestBodyJson(){
        return "Hello World! 9";
   }
}
