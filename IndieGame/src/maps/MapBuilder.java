package maps;

import java.util.ArrayList;

import engine.Loot;
import engine.RectArea;
import npc.SecurityGuard;

public interface MapBuilder {

	public ArrayList<RectArea> createArea();
	public ArrayList<SecurityGuard> createNpc();
	public ArrayList<Loot> createLoot(int lootCount);
	public Map build();
}
