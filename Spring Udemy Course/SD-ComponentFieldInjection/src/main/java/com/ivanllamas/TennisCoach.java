package com.ivanllamas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*This class will implement the Field Injection method, by injecting dependencies via the field method*/

/*This creates a bean in the spring container with the default bean id(tennisCoach)*/

//-removed ("thatCoolCoach")
@Component
public class TennisCoach implements Coach {
    
    /*Spring will construct the class using the default constructor, and it will inject a FortuneService implementation
    making use of Java Technology called Reflection*/
    
    /*Behind the scenes: fortuneService = new HappyFortuneService();*/
    @Autowired
    private FortuneService fortuneService;
    
    public TennisCoach(){
        System.out.println("Default Constructor for TennisCoach");
    }
    
    
 

    @Override
    public String getDailyWorkout() {
        return "Practice your swings!";
    }

    @Override
    public String getDailyFortune() {
       return fortuneService.getFortune();
    }
    
}

/*   See: SD-ComponentSetterInjection project for information/example of setter injection
    @Autowired
    public void setFortuneService(FortuneService fortuneService){
        System.out.println("inside the setFortuneService() method in class: TennisCoach");
        this.fortuneService = fortuneService;
    }

*/


/* See: SD-ComponentConstructorInjection project for more information/example of constructor injection
    @Autowired
    public TennisCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }
*/

