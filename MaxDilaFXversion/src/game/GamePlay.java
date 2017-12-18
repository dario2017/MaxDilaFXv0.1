package game;

public class GamePlay {
	String nickName;
	static int day, cash, deposit, debt, crew;
	
	public GamePlay(){};
	public GamePlay(String nickName) {
		this.nickName = nickName;
		setInitialStats();
	}
	
//	sets initial data 
	public void setInitialStats() {
		setDay(1);
		setCash(100043);
		setDeposit(0);
		setDebt(1000);
		setCrew(0);
	}
	
//	this funcion subtackt -1 from cash
	public void changeCity() {
		cash -= 1;
		day += 1;
	}
	
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public int getCash() {
		return cash;
	}
	
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	public int getDeposit() {
		return deposit;
	}
	
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	
	public int getDebt() {
		return debt;
	}
	
	public void setDebt(int debt) {
		this.debt = debt;
	}
	
	public int getCrew() {
		return crew;
	}
	
	public void setCrew(int crew) {
		this.crew = crew;
	}
}
