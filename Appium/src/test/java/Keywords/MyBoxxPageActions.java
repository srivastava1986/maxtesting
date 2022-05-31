package Keywords;

import com.PageObjects.GetPage;
import io.appium.java_client.android.AndroidDriver;

public class MyBoxxPageActions extends GetPage {

    public MyBoxxPageActions(AndroidDriver driver){
        super(driver,"MyBoxxPageTest");

    }

    public void upload_single_image_file(){
        element("addbutton").click();
        element("uploadfilebutton").click();
        String s=element("selectimagefile").getText();
        if(s.equalsIgnoreCase("StatueofLiberty.jpg")){
            element("selectimagefile").click();
        }
    }

    public boolean check_add_button_isclickable(){
       if( element("addbutton").isEnabled()){
           return true;
       }
        return false;
    }

    public void kebab_icon(){
        element("kebab").click();
    }

    public void recycle(){
        element("recycle").click();
    }
}
