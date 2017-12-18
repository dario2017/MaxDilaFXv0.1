package game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;

public class ShopController {
	@FXML
    private Button Kup;

    @FXML
    private Button Hnadluj;
    
    @FXML
    private Slider slider;

    @FXML
    private Spinner<Integer> splitMenu;
    
    
    public void initialize() {
    	System.out.println("sklep otwarty");
    	
    	Kup.setOnAction((event) -> {
    		System.out.println("KUpiono");
    		int cash2 = GamePlay.cash;
    		System.out.println(cash2);
    	});
    }
}
