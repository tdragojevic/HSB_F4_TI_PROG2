package control.Enums;

import model.Quest;
import model.Reward;

public enum Quests {
    //    QUEST1(new Quest(new Reward(5, 5, Materials.BRONZE.getMaterial(), Materials.AMETHYST.getMaterial()), new Objective(Villains.ZOMBIE.getVillain() , 3))),
//    QUEST2(new Quest(new Reward(10, 10, Materials.CLOTH.getMaterial(), Materials.LEATHER.getMaterial()), new Objective(Villains.SUCCUBUS.getVillain(), 4))),
//    QUEST3(new Quest(new Reward(10, 10, Materials.GOLD.getMaterial(), Materials.BRONZE.getMaterial()), new Objective(Villains.ORK.getVillain(), 5)));
    
    QUEST_1(new Quest(Rewards.REWARD_1, Objectives.OBJECTIVE_1.getObjective())),
    QUEST_2(new Quest(Rewards.REWARD_2, Objectives.OBJECTIVE_2.getObjective())),
    QUEST_2(new Quest(Rewards.REWARD_3, Objectives.OBJECTIVE_3.getObjective()));
    
    private final Quest quest;
    private Quests(Quest quest){
        this.quest = quest;
    }
    
    public Quest getQuest(){
        return this.quest;
    }
}
