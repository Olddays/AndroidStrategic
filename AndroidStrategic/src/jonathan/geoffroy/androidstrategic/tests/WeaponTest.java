package jonathan.geoffroy.androidstrategic.tests;

import static org.junit.Assert.*;
import jonathan.geoffroy.androidstrategic.model.fighters.Archer;
import jonathan.geoffroy.androidstrategic.model.fighters.Axman;
import jonathan.geoffroy.androidstrategic.model.fighters.Human;
import jonathan.geoffroy.androidstrategic.model.fighters.Priest;
import jonathan.geoffroy.androidstrategic.model.fighters.Soldier;
import jonathan.geoffroy.androidstrategic.model.fighters.Ranger;
import jonathan.geoffroy.androidstrategic.model.fighters.Thief;
import jonathan.geoffroy.androidstrategic.model.items.weapons.Ax;
import jonathan.geoffroy.androidstrategic.model.items.weapons.Bow;
import jonathan.geoffroy.androidstrategic.model.items.weapons.Knife;
import jonathan.geoffroy.androidstrategic.model.items.weapons.Scepter;
import jonathan.geoffroy.androidstrategic.model.items.weapons.Spire;
import jonathan.geoffroy.androidstrategic.model.items.weapons.Sword;
import jonathan.geoffroy.androidstrategic.model.items.weapons.Weapon;

import org.junit.Test;

public class WeaponTest {

	@Test
	public void equipableTypeTest() {
		Human[] fighters = {
				new Archer(),
				new Axman(),
				new Priest(),
				new Soldier(),
				new Ranger(),
				new Thief()
		};

		Weapon[] weapons = {
				new Bow(),
				new Ax(),
				new Scepter(),
				new Spire(),
				new Sword(),
				new Knife()
		};

		for(int i = 0; i < fighters.length; i++) {
			for(int j = 0; j < weapons.length; j++) {
				if(i == j) {
					assertTrue(fighters[i].getName() + " should can equip " + weapons[j].getName(), weapons[j].canEquip(fighters[i]));
				}
				else {
					assertFalse(fighters[i].getName() + " should not can equip " + weapons[j].getName(), weapons[j].canEquip(fighters[i]));
				}
			}
		}
	}

	@Test
	public void equipableLvlTest() {
		Human[] fighters = {
				new Archer(),
				new Axman(),
				new Priest(),
				new Soldier(),
				new Ranger(),
				new Thief()
		};
		fighters[0].setBowClass((short) 2);
		fighters[1].setAxClass((short) 2);
		fighters[2].setScepterClass((short) 2);
		fighters[3].setSpearClass((short) 2);
		fighters[4].setSwordClass((short) 2);
		fighters[5].setKnifeClass((short) 2);

		Weapon[] weapons = {
				new Bow(),
				new Ax(),
				new Scepter(),
				new Spire(),
				new Sword(),
				new Knife()
		};

		for(int i = 0; i < fighters.length; i++) {
			assertTrue(fighters[i].getName() + "should can equip " + weapons[i].getName(), weapons[i].canEquip(fighters[i]));
			weapons[i].setWeaponClass(2);
			assertTrue(fighters[i].getName() + "should can equip " + weapons[i].getName(), weapons[i].canEquip(fighters[i]));
			weapons[i].setWeaponClass(3);
			assertFalse(fighters[i].getName() + "should can equip " + weapons[i].getName(), weapons[i].canEquip(fighters[i]));
		}
	}
}
	