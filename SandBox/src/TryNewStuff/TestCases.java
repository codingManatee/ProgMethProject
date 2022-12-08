package TryNewStuff;

public class TestCases {
	public static void main(String[] args) {
		Hero hero1 = new Hero();
		Hero hero2 = new Hero();
		
		hero1.attack(hero2);
		
		System.out.println(hero2.getHP());
	}
}
