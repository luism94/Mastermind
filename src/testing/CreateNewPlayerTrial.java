package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import codes.*;
import static codes.GameMode.*;
import static codes.Colors.*;

class CreateNewPlayerTrial {

	@Test
	@DisplayName("CalcularPagoCuota: SocioIndividual - Actividades mayor a 20")
	void calcularPagoCuota_SocioIndividual_moreThan20() {
		Player player = new User(EASY);
		GamePiece p1 = new GamePiece(RED);
		GamePiece p2 = new GamePiece(RED);
		GamePiece p3 = new GamePiece(RED);
		GamePiece p4 = new GamePiece(RED);
		GamePiece[] array = {p1, p2, p3, p4};
		Combination comb = new Combination(EASY);
		comb.setPieceCombination(array);
		player.createNewPlayerTrial();
		assertEquals(player.createNewPlayerTrial(), comb);
	}

}
