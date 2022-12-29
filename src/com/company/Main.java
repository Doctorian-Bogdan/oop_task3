package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Artikl> artikliSupermarket = new ArrayList<>();
        List<Artikl> artikliKorpa = new ArrayList<>();

        artikliSupermarket.add(new Artikl("Велосипед", 10000, "1"));
        artikliSupermarket.add(new Artikl("Сахар", 50, "2"));
        artikliSupermarket.add(new Artikl("Сникерс", 54, "3"));
        artikliSupermarket.add(new Artikl("Елка", 2000, "4"));
        artikliSupermarket.add(new Artikl("Хлеб", 40, "5"));
        artikliSupermarket.add(new Artikl("Iphone 12", 43000, "6"));
        artikliSupermarket.add(new Artikl("Coca-Cola", 100, "7"));
        artikliSupermarket.add(new Artikl("Fanta", 100, "8"));
        artikliSupermarket.add(new Artikl("Sprite", 100, "9"));
        artikliSupermarket.add(new Artikl("Макароны", 50, "10"));
        artikliSupermarket.add(new Artikl("Творог", 120, "11"));
        artikliSupermarket.add(new Artikl("Тюбинг", 1500, "12"));
        artikliSupermarket.add(new Artikl("Печенье", 30, "13"));
        artikliSupermarket.add(new Artikl("Пряники", 80, "14"));
        artikliSupermarket.add(new Artikl("Вода 5л", 65, "15"));
        artikliSupermarket.add(new Artikl("Санки", 2000, "16"));
        artikliSupermarket.add(new Artikl("Мягкий олень", 500, "17"));
        artikliSupermarket.add(new Artikl("Колбаса", 200, "18"));
        artikliSupermarket.add(new Artikl("Сыр", 200, "19"));
        artikliSupermarket.add(new Artikl("Хлопья", 150, "20"));

        Scanner scanner = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        Scanner scannerString1 = new Scanner(System.in);
        int clientChoose1;
        int clientChoose2;
        String codEject;
        Scanner moneyTaker = new Scanner(System.in);
        List<String> codeSell = new ArrayList<>();

        System.out.println("Выберите опцию: 0 - отказаться от покупки, 1 - добавить в корзину, 2 - удалить из корзины, 3 - перейти к оформлению заказа");
        clientChoose1 = scanner.nextInt();
        clientChoose2 = 1;
        if(clientChoose1 == 1) {
                while(clientChoose2 == clientChoose1) {
                    System.out.println("Какой продукт вы выбираете? (введите артикул 1-20): ");
                    String codeEntry = scannerString.nextLine();
                    codeSell.add(codeEntry);
                    System.out.println("Если хотите продолжить покупки введите 1 ");
                    clientChoose2=scanner.nextInt();
                }
            for(Artikl artikl : artikliSupermarket) {
                for(String kod : codeSell) {
                    if (kod.equals(artikl.getKod()) && !artikliKorpa.contains(artikl)) {
                        artikliKorpa.add(artikl);
                    }} }

            for(int i=0; i<artikliSupermarket.size(); i++) {
                for(int j=0; j<artikliKorpa.size(); j++)
                if(artikliSupermarket.get(i).getKod().equals(artikliKorpa.get(j).getKod())) {
                   artikliSupermarket.remove(artikliSupermarket.get(i));
                } } }

        System.out.println("Выберите опцию: 0 - отказаться от покупки, 2 - удалить из корзины, 3 - перейти к оформлению заказа");
        clientChoose1 = scanner.nextInt();

        if (clientChoose1 == 2) {
            Artikl izbaceniArtikl;
            int clientChoose3 = 2;
            while(clientChoose3 == clientChoose1) {
            System.out.println("Какой продукт вы хотите удалить: ");
                codEject = scannerString1.nextLine();
                for(int j=0; j<artikliKorpa.size(); j++) {
                    if(artikliKorpa.get(j).getKod().equals(codEject)) {
                        izbaceniArtikl = artikliKorpa.get(j);
                        artikliKorpa.remove(artikliKorpa.get(j));
                        artikliSupermarket.add(izbaceniArtikl);
                    } }
                System.out.println("Если вы хотите продолжить удаление продукта, введите 2:");
                clientChoose3=scanner.nextInt();}
            System.out.println("Выберите опцию: 0 - отказаться от покупки, 3 - перейти к оформлению заказа");
            clientChoose1 = scanner.nextInt();}

       if(clientChoose1 == 3) {
           System.out.println("Перейти к оформлению заказа");
           double amount = 0;
           double buyerMon;
           for (int i=0; i<artikliKorpa.size(); i++) {
               amount += artikliKorpa.get(i).getPrice();
           }
           System.out.println("Ваш счет составляет: " +amount +" Руб");
           if(amount == 0) System.out.println("Спасибо за визит.");
           System.out.println("Введите деньги");
           buyerMon = moneyTaker.nextDouble();
           while(buyerMon < amount) {
               System.out.println("Недостаточно средств! \nВаш счет составляет: " +amount +" Руб");
               buyerMon = moneyTaker.nextDouble();
           }
           if(buyerMon > amount) {
               System.out.println("Ваша сдача: " +(buyerMon - amount) +" Руб");
           }
           else {
               System.out.println("Спасибо за покупку. Хорошего дня.");
           }
       }
       else if(clientChoose1 == 0) {
           System.out.println("Вы отказались от покупки");
           Artikl izbaceniArtikl;
           for(int j=0; j<artikliKorpa.size(); j++) {
                   izbaceniArtikl = artikliKorpa.get(j);
                   artikliSupermarket.add(izbaceniArtikl);
               }
           artikliKorpa.clear();
       }

        System.out.println("\nТовары в корзине ");
        for(Artikl artikl : artikliKorpa) {
            System.out.println("Название: " +artikl.getName() + "  Цена: " +artikl.getPrice() + "  Артикул: " +artikl.getKod());
        }
        System.out.println("\nТовар в супермаркете:0");

        for(Artikl artikl : artikliSupermarket) {
            System.out.println("Название: " +artikl.getName() + "  Цена: " +artikl.getPrice() + "  Артикул:" +artikl.getKod());
        }}}





