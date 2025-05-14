package com.github.tiagolofi.domain;

import com.github.tiagolofi.adapters.Attack;
import com.github.tiagolofi.adapters.Creature;
import com.github.tiagolofi.adapters.Location;
import com.github.tiagolofi.adapters.computable.Damage;
import com.github.tiagolofi.adapters.computable.Stats;
import com.github.tiagolofi.adapters.targetable.Condition;
import com.github.tiagolofi.adapters.targetable.Target;
import com.github.tiagolofi.adapters.triggerable.Ability;
import com.github.tiagolofi.adapters.triggerable.Rule;
import com.github.tiagolofi.adapters.valuable.Value;
import com.github.tiagolofi.domain.engine.Board;
import com.github.tiagolofi.domain.engine.Burst;
import com.github.tiagolofi.domain.engine.Deck;
import com.github.tiagolofi.domain.engine.Engaged;
import com.github.tiagolofi.domain.engine.Player;
import com.github.tiagolofi.domain.engine.Turn;

public class Main {

    public static void main(String[] args) {
        // Arrumando duas criaturas

        Ability ability1 = Ability.builder()
            .name("Energy Cost for Mugic Counters")
            .isToggleable(true)
            .target(Target.builder().type("creature").side("self").build())
            .value(Value.builder().attribute("energy").attributeType("discipline").value(5).build())
            .build();

        Creature creature1 = Creature.builder()
            .name("Strikto")
            .tribe("Underwold")
            .addSubtype("Warrior")
            .addAbility(ability1)
            .stats(Stats.builder().courage(50).power(45).wisdom(75).speed(40).energy(40).build())
            .build();

        Ability ability2 = Ability.builder()
            .name("Intimidate: Courage 10")
            .isToggleable(false)
            .target(Target.builder().type("creature").side("enemy").build())
            .build();

        Creature creature2 = Creature.builder()
            .name("Dardemus")
            .tribe("Underwold")
            .addSubtype("Taskmaster")
            .addAbility(ability2)
            .addElement("fire")
            .stats(Stats.builder().courage(60).power(75).wisdom(20).speed(65).energy(50).build())
            .build();

        Rule rule1 = Rule.builder()
            .target(Target.builder().type("creature").side("enemy").condition(Condition.builder().discipline("wisdom").operator(">").build()).build())
            .effect(Value.builder().attribute("energy").attributeType("discipline").value(5).build())
            .build();

        Attack attack1 = Attack.builder()
            .name("Sudden Flare")
            .addRule(rule1)
            .damage(Damage.builder().basic(10).fire(5).build())
            .build();

        // Criando o deck
        Deck deck1 = new Deck();
        deck1.addCreature(creature1);
        deck1.addAttack(attack1);

        System.out.println(deck1);

        Deck deck2 = new Deck();
        deck2.addCreature(creature2);
        deck2.addAttack(attack1);

        // Criando os players
        Player player1 = new Player(deck1);
        Player player2 = new Player(deck2);

        player1.getDeck().getCreatures().forEach(creature -> System.out.println((Creature) creature));

        Burst burst = new Burst();

        Board board = new Board();
        board.setBurst(burst);
        board.setPlayer1(player1);
        board.setPlayer2(player2);

        burst.setBoard(board);
        
        board.setLocation(Location.builder().name("Crystal Cave").initiative("speed").build());

        burst.applyTriggers("player1", "player2");
        burst.applyTriggers("player2", "player1");

        board.startBoard();

        System.out.println(burst);
        
        player1.getDeck().getCreatures().forEach(creature -> System.out.println(creature));

        Engaged engaged1 = new Engaged(player1, creature1, null);
        Engaged engaged2 = new Engaged(player2, creature2, null);

        Turn turn = new Turn();
        turn.setBoard(board);
        turn.setBurst(burst);
        turn.setEngagedPlayer1(engaged1);
        turn.setEngagedPlayer2(engaged2);

        turn.startTurn();

        player1.getDeck().getCreatures().forEach(creature -> System.out.println(creature));

        turn.eventAttack();

        player1.getDeck().getCreatures().forEach(creature -> System.out.println(creature));
        player2.getDeck().getCreatures().forEach(creature -> System.out.println(creature));

    }
}
