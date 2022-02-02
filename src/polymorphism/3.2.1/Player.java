import weapon.*;

import java.util.Scanner;

public class Player {
    private final Weapon[] weaponSlots;

    public Player() {
        weaponSlots = new Weapon[]{
                new Pistol(),
                new Kalash(),
                new RPG(),
                new Slingshot(),
                new WaterPistol(),
        };
    }

    public int getSlotsCount(){
        return weaponSlots.length;
    }

    public void shotWithWeapon(int slot){
        if (slot > weaponSlots.length - 1) {
            System.out.println("Вы ввели неверный слот");
            return;
        }
        Weapon weapon = weaponSlots[slot];
        weapon.shot();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();

        System.out.format("У игрока %d слотов с оружием,"
                        + " введите номер, чтобы выстрелить,"
                        + " -1 чтобы выйти%n",
                player.getSlotsCount()
        );
        int slot = 0;

        while(true){
             slot = scanner.nextInt();
             if (slot == -1) break;
             player.shotWithWeapon(slot);
        }

        System.out.println("Game over!");
    }
}
