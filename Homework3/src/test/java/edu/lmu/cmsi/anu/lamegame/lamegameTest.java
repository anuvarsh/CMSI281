package edu.lmu.cmsi.anu.lamegame;

import edu.lmu.cmsi.anu.lamegame.gameobjects.Wall;
import edu.lmu.cmsi.anu.lamegame.gameobjects.Rock;
import edu.lmu.cmsi.anu.lamegame.gameobjects.Tree;
import edu.lmu.cmsi.anu.lamegame.gameobjects.Player;
import edu.lmu.cmsi.anu.lamegame.gameobjects.MonsterA;
import edu.lmu.cmsi.anu.lamegame.gameobjects.MonsterS;
import edu.lmu.cmsi.anu.lamegame.gameobjects.MonsterZ;
import edu.lmu.cmsi.anu.lamegame.gameobjects.MonsterX;
import edu.lmu.cmsi.anu.lamegame.gameobjects.BossO;
import edu.lmu.cmsi.anu.lamegame.gameobjects.BossK;
import edu.lmu.cmsi.anu.lamegame.core.Coordinate;
import edu.lmu.cmsi.anu.lamegame.core.Displacement;
import edu.lmu.cmsi.anu.lamegame.engine.GameEngine1;

import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;

public class lamegameTest {

	private Player p;
	private MonsterA a;
	private MonsterS s;
	private MonsterZ z;
	private MonsterX x;
	private BossO o;
	private BossK k;

	private Wall w;
	private Rock r;
	private Tree t;

	@Test(expected = IllegalArgumentException.class)
	public void gameEngineSize() {
		GameEngine1 engine = new GameEngine1(10);
	}

	@Test
	public void pEncountersW() {
		p = new Player(1,1);
		p.setDisplacement(1,2);
		Wall w = new Wall (1,1);
		p.checkCollision(w);
		assertEquals("failure - player didn't invert x-val", -1, p.getDisplacement().getXDisplacement());
		assertEquals("failure - player didn't invert y-val", -2, p.getDisplacement().getYDisplacement());
	}

	@Test
	public void aEncountersW() {
		a = new MonsterA(1,1);
		a.setDisplacement(1,2);
		Wall w = new Wall (1,1);
		a.checkCollision(w);
		assertEquals("failure - monster a didn't invert x-val", -1, a.getDisplacement().getXDisplacement());
		assertEquals("failure - monster a didn't invert y-val", -2, a.getDisplacement().getYDisplacement());
	}

	@Test
	public void sEncountersW() {
		s = new MonsterS(1,1);
		s.setDisplacement(1,2);
		Wall w = new Wall (1,1);
		s.checkCollision(w);
		assertEquals("failure - monster s didn't invert x-val", -1, s.getDisplacement().getXDisplacement());
		assertEquals("failure - monster s didn't invert y-val", -2, s.getDisplacement().getYDisplacement());
	}

	@Test
	public void zEncountersW() {
		z = new MonsterZ(1,1);
		z.setDisplacement(1,2);
		Wall w = new Wall (1,1);
		z.checkCollision(w);
		assertEquals("failure - monster z didn't invert x-val", -1, z.getDisplacement().getXDisplacement());
		assertEquals("failure - monster z didn't invert y-val", -2, z.getDisplacement().getYDisplacement());
	}

	@Test
	public void xEncountersW() {
		x = new MonsterX(1,1);
		x.setDisplacement(1,2);
		Wall w = new Wall (1,1);
		x.checkCollision(w);
		assertEquals("failure - monster x didn't invert x-val", -1, x.getDisplacement().getXDisplacement());
		assertEquals("failure - monster x didn't invert y-val", -2, x.getDisplacement().getYDisplacement());
	}

	@Test
	public void oEncountersW() {
		o = new BossO(1,1);
		o.setDisplacement(1,2);
		Wall w = new Wall (1,1);
		o.checkCollision(w);
		assertEquals("failure - boss o didn't invert x-val", -1, o.getDisplacement().getXDisplacement());
		assertEquals("failure - boss o didn't invert y-val", -2, o.getDisplacement().getYDisplacement());
	}

	@Test
	public void kEncountersW() {
		k = new BossK(1,1);
		k.setDisplacement(1,2);
		Wall w = new Wall (1,1);
		k.checkCollision(w);
		assertEquals("failure - boss k didn't invert x-val", -1, k.getDisplacement().getXDisplacement());
		assertEquals("failure - boss k didn't invert y-val", -2, k.getDisplacement().getYDisplacement());
	}

	@Test
	public void pEncountersR() {
		p = new Player(1,1);
		r = new Rock(1,1);
		p.checkCollision(r);
		assertEquals("failure - player didn't update hit points - rock", 1, p.getHitPoints());
	}

	@Test
	public void aEncountersR() {
		a = new MonsterA(1,1);
		r = new Rock(1,1);
		a.checkCollision(r);
		assertEquals("failure - monster a didn't update hit points - rock", 1, a.getHitPoints());
	}

	@Test
	public void sEncountersR() {
		s = new MonsterS(1,1);
		r = new Rock(1,1);
		s.checkCollision(r);
		assertEquals("failure - monster s didn't update hit points - rock", 1, s.getHitPoints());
	}

	@Test
	public void zEncountersR() {
		z = new MonsterZ(1,1);
		r = new Rock(1,1);
		z.checkCollision(r);
		assertEquals("failure - monster z didn't update hit points - rock", 1, z.getHitPoints());
	}

	@Test
	public void xEncountersR() {
		x = new MonsterX(1,1);
		r = new Rock(1,1);
		x.checkCollision(r);
		assertEquals("failure - monster x didn't update hit points - rock", 1, x.getHitPoints());
	}

	@Test
	public void oEncountersR() {
		o = new BossO(1,1);
		r = new Rock(1,1);
		o.checkCollision(r);
		assertEquals("failure - boss o didn't update hit points - rock", 1, o.getHitPoints());
	}

	@Test
	public void kEncountersR() {
		k = new BossK(1,1);
		r = new Rock(1,1);
		k.checkCollision(r);
		assertEquals("failure - boss k didn't update hit points - rock", 1, k.getHitPoints());
	}

	@Test
	public void pEncountersT() {
		p = new Player(1,1);
		t = new Tree(1,1);
		p.checkCollision(t);
		assertEquals("failure - player didn't update hit points - tree", 1, p.getHitPoints());
	}

	@Test
	public void aEncountersT() {
		a = new MonsterA(1,1);
		t = new Tree(1,1);
		a.checkCollision(t);
		assertEquals("failure - monster a didn't update hit points - tree", 1, a.getHitPoints());
	}

	@Test
	public void sEncountersT() {
		s = new MonsterS(1,1);
		t = new Tree(1,1);
		s.checkCollision(t);
		assertEquals("failure - monster s didn't update hit points - tree", 1, s.getHitPoints());
	}	

	@Test
	public void zEncountersT() {
		z = new MonsterZ(1,1);
		t = new Tree(1,1);
		z.checkCollision(t);
		assertEquals("failure - monster z didn't update hit points - tree", 1, z.getHitPoints());
	}

	@Test
	public void xEncountersT() {
		x = new MonsterX(1,1);
		t = new Tree(1,1);
		x.checkCollision(t);
		assertEquals("failure - monster x didn't update hit points - tree", 1, x.getHitPoints());
	}

	@Test
	public void oEncountersT() {
		o = new BossO(1,1);
		t = new Tree(1,1);
		o.checkCollision(t);
		assertEquals("failure - boss o didn't update hit points - tree", 1, o.getHitPoints());
	}

	@Test
	public void kEncountersT() {
		k = new BossK(1,1);
		t = new Tree(1,1);
		k.checkCollision(t);
		assertEquals("failure - boss k didn't update hit points - tree", 1, k.getHitPoints());
	}
}