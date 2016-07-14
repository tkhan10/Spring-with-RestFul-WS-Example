/**
 * 
 */
package com.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import ws.HelloRestClient;

/**
 * @author tofek.khan
 *
 */

@Controller
@RequestMapping(value = "hello")
public class HelloController {	
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value = "hellows", method = RequestMethod.GET)
	public String hellows(ModelMap model){
		HelloRestClient helloRestClient = new HelloRestClient();
		model.put("result", helloRestClient.hello());
		return "hellows";
	}
	
	@RequestMapping(value = "hiws", method = RequestMethod.GET)
	public String hiws(ModelMap model){
		HelloRestClient helloRestClient = new HelloRestClient();
		model.put("result", helloRestClient.hi("Tofek"));
		return "hiws";
	}
	
	@RequestMapping(value = "sumws", method = RequestMethod.GET)
	public String sum(ModelMap model){
		HelloRestClient helloRestClient = new HelloRestClient();
		model.put("result", helloRestClient.sum("1","2"));
		return "sumws";
	}

}
