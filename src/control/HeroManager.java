package control;

import control.Constants.Const;
import control.Constants.HeroConst;
import model.Position;
import model.gameObject.Hero;
import model.item.Inventory;

public class HeroManager {

    private Hero[] heroes = null;

    private HeroManager() {
        this.heroes = initHeroes();
    }

    private Hero[] initHeroes() {
        Hero[] heroes = new Hero[Const.HERO_AMOUNT];

        heroes[0] = new Hero(HeroConst.PALADIN_RES_PATH,
                new Position(0, 0),
                HeroConst.PALADIN_DEFAULT_ARMOR,
                null,
                HeroConst.PALADIN_NAME,
                HeroConst.PALADIN_DEFAULT_HEALTH_POINTS,
                HeroConst.PALADIN_DEFAULT_MAX_HEALTH_POINTS,
                HeroConst.PALADIN_DEFAULT_AGILITY,
                null,
                null,
                new Inventory(HeroConst.PALADIN_DEFAULT_INVENTORY_CAPACITY));

        heroes[1] = new Hero(HeroConst.MAGE_RES_PATH,
                new Position(0, 0),
                HeroConst.MAGE_DEFAULT_ARMOR,
                null,
                HeroConst.MAGE_NAME,
                HeroConst.MAGE_DEFAULT_HEALTH_POINTS,
                HeroConst.MAGE_DEFAULT_MAX_HEALTH_POINTS,
                HeroConst.MAGE_DEFAULT_AGILITY,
                null,
                null,
                new Inventory(HeroConst.MAGE_DEFAULT_INVENTORY_CAPACITY));

        heroes[2] = new Hero(HeroConst.ROGUE_RES_PATH,
                new Position(0, 0),
                HeroConst.ROGUE_DEFAULT_ARMOR,
                null,
                HeroConst.ROGUE_NAME,
                HeroConst.ROGUE_DEFAULT_HEALTH_POINTS,
                HeroConst.ROGUE_DEFAULT_MAX_HEALTH_POINTS,
                HeroConst.ROGUE_DEFAULT_AGILITY,
                null,
                null,
                new Inventory(HeroConst.ROGUE_DEFAULT_INVENTORY_CAPACITY));

        heroes[3] = new Hero(HeroConst.RANGER_RES_PATH,
                new Position(0, 0),
                HeroConst.RANGER_DEFAULT_ARMOR,
                null,
                HeroConst.RANGER_NAME,
                HeroConst.RANGER_DEFAULT_HEALTH_POINTS,
                HeroConst.RANGER_DEFAULT_MAX_HEALTH_POINTS,
                HeroConst.RANGER_DEFAULT_AGILITY,
                null,
                null,
                new Inventory(HeroConst.RANGER_DEFAULT_INVENTORY_CAPACITY));

        return heroes;
    }

    public Hero[] getHeroes() {
        return heroes;
    }

    public void setHeroes(Hero[] heroes) {
        this.heroes = heroes;
    }

    public static HeroManager getInstance() {
        return HeroManager_Holder.INSTANCE;
    }

    private static class HeroManager_Holder {

        private static final HeroManager INSTANCE = new HeroManager();
    }
}
