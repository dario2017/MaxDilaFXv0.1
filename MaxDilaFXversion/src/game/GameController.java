package game;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameController {
	@FXML private Button startBtn, loadBtn, saveBtn, clearPocketBtn;
	@FXML private Button hallOfFameBtn;
	@FXML private Button buyBtn;
	@FXML private Button sellBtn;
	@FXML private Button shopBtn;
	@FXML private Button bankBtn;
	@FXML private Button hireBtn;
	@FXML private Button endGameBtn;
	@FXML private Button cityABtn;
	@FXML private Button cityBBtn;
	@FXML private Button cityCBtn;
	@FXML private Button cityDBtn;
	@FXML private Button cityEBtn;
	@FXML private Button cityFBtn;
	@FXML private Label nickNameLabel;
	@FXML private Label dayLabel;
	@FXML private Label cashLabel;
	@FXML private Label depositLabel;
	@FXML private Label debtLabel;
	@FXML private Label crewLabel;
	@FXML private Label pricesOnMarketLabel;
	@FXML private Label pocketCapacityLabel;
	@FXML private TextArea infoArea;
	
//	isGameActive sets game for active mode. if you click startBtn during the active game it should ask you if you want to save it
	private boolean isGameActive = false;
	
	GamePlay play;
	City cityA, cityB, cityC, cityD, cityE, cityF;
	
	public void initialize() {
		System.out.println("dziala");
		
//		Starts new game
		startBtn.setOnAction((event) -> {
			TextInputDialog dialogStart = new TextInputDialog("Pablo Escobar");
			dialogStart.setContentText("Podaj swoj¹ ksywê: ");
			dialogStart.setTitle("Zaczynasz now¹ grê");
			dialogStart.setHeaderText("Zostajesz dilerem. Get rich or die trying!!!");
			Optional<String> string = dialogStart.showAndWait();
			String nickName;
			if (string.isPresent()) {
				nickName = string.get();
				play = new GamePlay(nickName);
				System.out.println(nickName);
				nickNameLabel.setText(nickName);
				dayLabel.setText("" + play.getDay());
				cashLabel.setText("" + play.getCash());
				depositLabel.setText("" + play.getDeposit());
				debtLabel.setText("" + play.getDebt());
				crewLabel.setText("" + play.getCrew());
				cityA = new City("Katowice");
				cityB = new City("Mys³owice");
				cityC = new City("Warszawa");
				cityD = new City("Kraków");
				cityE = new City("Szczecin");
				cityF = new City("Zakopane");
				cityABtn.setText("" + cityA);
				cityBBtn.setText("" + cityB);
				cityCBtn.setText("" + cityC);
				cityDBtn.setText("" + cityD);
				cityEBtn.setText("" + cityE);
				cityFBtn.setText("" + cityF);
			}
		});
		
//		Loads game (nickName, day, cash etc) from .txt file
		loadBtn.setOnAction((event) -> {
			System.out.println("Wczytywanie gry");
		});
		
//		Saves game data to txt. file (name, day, cash etc)
		saveBtn.setOnAction((event) -> {
			System.out.println("zapisz dziala tez");
		});
		
//		Shows hall of fame (list of players who finished game and their score) in new window
		hallOfFameBtn.setOnAction((event) -> {
			System.out.println("Hala s³aw");
		});
		
//		Change city (minus 1$ for ticket)
		cityABtn.setOnAction((event) -> {
//			if you are in the same city it wont charge you 1$ and new shows new window with information
			if (pricesOnMarketLabel.getText().equals("" + cityA)) {
				sameCity();
			} else {
				pricesOnMarketLabel.setText("" + cityA);
				infoArea.setText("Przyjecha³eœ do " + cityA);
				otherCity();
			}
		});
		
		cityBBtn.setOnAction((event) -> {
			if (pricesOnMarketLabel.getText().equals("" + cityB)) {
				sameCity();
			} else {
				pricesOnMarketLabel.setText("" + cityB);
				infoArea.setText("Przyjecha³eœ do " + cityB);
				otherCity();
			}
		});
		
		cityCBtn.setOnAction((event) -> {
			if (pricesOnMarketLabel.getText().equals("" + cityC)) {
				sameCity();
			} else {
				pricesOnMarketLabel.setText("" + cityC);
				infoArea.setText("Przyjecha³eœ do " + cityC);
				otherCity();
			}
		});
		
		cityDBtn.setOnAction((event) -> {
			if (pricesOnMarketLabel.getText().equals("" + cityD)) {
				sameCity();
			} else {
				pricesOnMarketLabel.setText("" + cityD);
				infoArea.setText("Przyjecha³eœ do " + cityD);
				otherCity();
			}
		});
		
		cityEBtn.setOnAction((event) -> {
			if (pricesOnMarketLabel.getText().equals("" + cityE)) {
				sameCity();
			} else {
				pricesOnMarketLabel.setText("" + cityE);
				infoArea.setText("Przyjecha³eœ do " + cityE);
				otherCity();
			}
		});
		
		cityFBtn.setOnAction((event) -> {
			if (pricesOnMarketLabel.getText().equals("" + cityF)) {
				sameCity();
			} else {
				pricesOnMarketLabel.setText("" + cityF);
				infoArea.setText("Przyjecha³eœ do " + cityF);
				otherCity();
			}
		});
		
//		buyBtn - Opens dialog window where you can buy things from market
		buyBtn.setOnAction((event) -> {		
			
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Shop.fxml"));
				AnchorPane root1 = (AnchorPane) loader.load();
				Stage stage2 = new Stage();
				stage2.setScene(new Scene(root1));
				stage2.showAndWait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
//		sellBtn - Opens dialog window where you can sell things from you pocket
		
//		shopBtn - opens dialog window where you can buy things(cars, guns etc)
		
//		bankBtn - opens dialog window where you can put cash to deposit or pay your debt
		
//		hireBtn - you can hire more guys to your crew - it will increase your pocket size
		
//		endGameBtn - you finish game. shows dialog window with statistics and save it to hall of fame
		
	}
	
//	if you are in the same city it wont charge you 1$ and new shows new window with information
	public void sameCity() {
		infoArea.setText("Nie zmieni³eœ miasta");
	}
	
//	when you change city it charges you 1$ and add 1 day
	public void otherCity() {
		play.changeCity();
		cashLabel.setText("" + play.getCash());
		dayLabel.setText("" + play.getDay());
	}
	
//	public void Kupno(ActionEvent event) throws Exception{
//		System.out.println("dziala kupno");
//		try {
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("Shop.fxml"));
//			AnchorPane root1 = (AnchorPane) loader.load();
//			Stage stage = new Stage();
//			stage.setScene(new Scene(root1));
//			stage.show();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
