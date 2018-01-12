package controllers;

import java.util.*;
import java.util.List;
import static play.libs.Json.toJson;
import models.City;
import models.State;
import play.mvc.Controller;
import play.mvc.Result;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Application extends Controller {

	public static Result index() {
		return ok(views.html.dashboard.render());
	}
	
	public static Result locations() {
		Map data = new HashMap();
		try {
			List<State> state_list = State.find.all();
			List<City> city_list= City.find.all();
			data.put("state_list", state_list);
			data.put("city_list", city_list);
		}catch(Exception e) {
			
		}
		return ok(toJson(data));
	}
	
	public static Result saveLocation(String location) {
		try {
			session("re_user_location",location);
		}catch(Exception e) {
			
		}
		return ok();
	}

}