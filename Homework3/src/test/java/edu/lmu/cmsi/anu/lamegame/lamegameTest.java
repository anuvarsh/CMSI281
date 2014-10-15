package edu.lmu.cmsi.anu.lamegame;

import edu.lmu.cmsi.anu.lamegame.engine.GameEngine;
import edu.lmu.cmsi.anu.lamegame.gameobjects.ActiveGameObjects;
import edu.lmu.cmsi.anu.lamegame.gameobjects.GameObjects;
import edu.lmu.cmsi.anu.lamegame.core.Coordinate;
import edu.lmu.cmsi.anu.lamegame.core.Displacement;

import org.junit.*;
import static org.junit.Assert.*;

public class lamegameTest {

	@Test(expected = IllegalArgumentException.class)
	public void gameEngineSize() {
		GameEngine engine = new GameEngine(10);
	}

	@Test
	public void encounterR() {
		GameObjects rock = new GameObjects(1, 2, 'r');
		ActiveGameObjects player = new ActiveGameObjects(1, 2, 'p');
		encounterRorT(rock, player); //WRONG
		assertEquals("failure - did not update player Hit Points by 1", 1, player.getHitPoints());
	}

	@Test
	public void encounterT() {
		GameObjects rock = new GameObjects(1, 2, 't');
		ActiveGameObjects player = new ActiveGameObjects(1, 2, 'p');
		encounterRorT(rock, player); //WRONG
		assertEquals("failure - did not update player Hit Points by 1", 1, player.getHitPoints());
	}

	@Test
	public void pEncounterO() {
		ActiveGameObjects player = new ActiveGameObjects(1, 2, 'p');
		ActiveGameObjects boss = new ActiveGameObjects(1, 2, 'o');
		pEncounterOorK(player, boss); //WRONG
		assertEquals("failure - did not update player Hit Points by 1", 1, player.getHitPoints());
	}

	@Test
	public void pEncounterK() {
		ActiveGameObjects player = new ActiveGameObjects(1, 2, 'p');
		ActiveGameObjects boss = new ActiveGameObjects(1, 2, 'k');
		pEncounterOorK(player, boss); //WRONG
		assertEquals("failure - did not update player Hit Points by 1", 1, player.getHitPoints());
	}

	@Test
	public void encounterWallTest() {
		GameObjects wall = new GameObjects(1, 2, 'w');
		ActiveGameObjects player = new ActiveGameObjects(1, 2, 'p');
		player.setDisplacement(1,1);
		encounterWall(wall, player);
		assertEquals("failure - did not invert active object's dx", -1, player.getDisplacement().getXDisplacement()); //probably WRONG
		assertEquals("failure - did not invert active object's dy", -1, player.getDisplacement().getYDisplacement()); //probably WRONG
	}

	@Test
	public void 
}


